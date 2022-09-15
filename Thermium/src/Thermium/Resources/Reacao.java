package Thermium.Resources;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import Thermium.ENTITY.Elemento;
import Thermium.ENTITY.Substancia;
import Thermium.ENTITY.SubstanciaElemento;

public class Reacao {

	List<Substancia> listaReagentes;
	List<Substancia> listaProdutos;

	public Reacao(List<Substancia> listaReagentes, List<Substancia> listaProdutos) {
		super();
		this.listaReagentes = listaReagentes;
		this.listaProdutos = listaProdutos;
	}

	public List<Substancia> getListaReagentes() {
		return listaReagentes;
	}

	public void setListaReagentes(ArrayList<Substancia> listaReagentes) {
		this.listaReagentes = listaReagentes;
	}

	public List<Substancia> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Substancia> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public double[] pegarCoeficientesBalanceados() {
		List<Substancia> listaTotal = new ArrayList<>();
		listaTotal.addAll(listaReagentes);
		listaTotal.addAll(listaProdutos);
		int numeroSubstancias = listaTotal.size();

		List<Elemento> listaElementos = getListaElementos(listaTotal);
		int numeroElementos = listaElementos.size();
		double[][] matriz = new double[numeroElementos + 1][numeroSubstancias];

		int contM = 0;
		for (Elemento e : listaElementos) {
			int contN = 0;
			for (Substancia s : listaReagentes) {
				matriz[contM][contN] = getQtdElemento(e, s);
				contN++;
			}
			for (Substancia s : listaProdutos) {
				matriz[contM][contN] = getQtdElemento(e, s) * -1;
				contN++;
			}
			contM++;
		}

		int posicaoBase = 0;
		
		Substancia sBase = listaTotal.get(0);
		for (int i = 1; i < listaTotal.size(); i++) {
			if (sBase.getSubstanciaElemento().size() < listaTotal.get(i).getSubstanciaElemento().size()) {
				posicaoBase = i;
				sBase = listaTotal.get(i);
			} else if (sBase.getSubstanciaElemento().size() == listaTotal.get(i).getSubstanciaElemento().size()) {
				if(sBase.getNumAtomos() < listaTotal.get(i).getNumAtomos()) {
					posicaoBase = i;
					sBase = listaTotal.get(i);
				}
			}
		}

	
		matriz[numeroElementos][posicaoBase] = 1;
		
		
		return resolverMatriz(matriz);
	}

	private double[] resolverMatriz(double[][] matriz) {
		RealMatrix coefficients = new Array2DRowRealMatrix(matriz, false);
		DecompositionSolver solver;

		if (coefficients.isSquare()) {
			solver = new LUDecomposition(coefficients).getSolver();
		} else {
			solver = new QRDecomposition(coefficients).getSolver();
		}

		double[] constantes = new double[matriz.length];
		constantes[matriz.length - 1] = 1;

		RealVector constants = new ArrayRealVector(constantes, false);
		// RealVector constants = new ArrayRealVector(new double[] { 1, 0, 0, 0, 0, 0, 0
		// }, false);
                
                RealVector solution;
                try{
                    solution = solver.solve(constants);
                }catch(org.apache.commons.math3.linear.SingularMatrixException e){
                    return null;
                }

		double[] result = solution.toArray();

		for (int i = 0; i < result.length; i++) { 
			if(result[i] == 0) return null; // acontece quando um reagente reaparece nos produtos
			result[i] = converterDoubleCincoDecimais(result[i]); // necess�rio pois os valores de 'solution' v�m sempre com um quebrado no final
		}

		for (int i = 0; i < result.length; i++) {
			double num = result[i];
			if ((num % 1) != 0) { // se o número for quebrado
				/*
				 * procura-se agora por qual inteiro é necessário multiplicá-lo para que ele
				 * vire inteiro (n�o queremos n�mero quebrados como coeficiente
				 */
				if ((num % 1) == 0.5) {
					for (int j = 0; j < result.length; j++) {
						result[j] = result[j] * 2;
					}
				} else if ((num % 1) == 0.25) {
					for (int j = 0; j < result.length; j++) {
						result[j] = result[j] * 4;
					}
				} else if ((num % 1) == 0.125) {
					for (int j = 0; j < result.length; j++) {
						result[j] = result[j] * 8;
					}
				} else if ((num % 1) <= 0.2 && (num % 1) > 0.1999) {
					for (int j = 0; j < result.length; j++) {
						result[j] = result[j] * 5;
					}
				} else if ((num % 1) <= 0.1 && (num % 1) > 0.0999) {
					for (int j = 0; j < result.length; j++) {
						result[j] = result[j] * 10;
					}
				} else if (((num % 1) > 0.333 && (num % 1) < 0.4) || (num % 1) > 0.666 && (num % 1) < 0.7) {
					for (int j = 0; j < result.length; j++) {
							result[j] = result[j] * 3;

					}
				} else { /*
							 * depois de procurar pelos multiplicadores mais usuais, tenta-se achar
							 * procurando um por um
							 */
					for (int k = 7; k < 10000; k++) {
						if ((num * k) % 1 > 0.9999 || (num * k) % 1 < 0.0001) {
							for (int l = 0; l < result.length; l++) {
								result[l] = result[l] * k;
							}
							break;
						}
					}
				}

			}
		}

		for (int i = 0; i < result.length; i++) {
			result[i] = Math.round(result[i]);
		}
                
                if(conferirResult(result, matriz)){
                    return result;
                }
                else{
                    return null;
                }
	}

	public List<Elemento> getListaElementos(List<Substancia> listaTotal) {

		List<Elemento> listaElementos = new ArrayList<Elemento>();
		for (Substancia s : listaTotal) {
			List<Elemento> sElementos = s.getElementos();
			Boolean estaContido;
			for (Elemento se : sElementos) {
				estaContido = false;
				for (Elemento e : listaElementos) {
					if (se.getNumeroAtomico() == e.getNumeroAtomico()) {
						estaContido = true;
						break;
					}
				}
				if (!estaContido) {
					listaElementos.add(se);
				}
			}
		}
		return listaElementos;
	}

	private double getQtdElemento(Elemento e, Substancia s) {
		double qtd = 0;
		for (SubstanciaElemento se : s.getSubstanciaElemento()) {
			if (se.getElemento().getNumeroAtomico() == e.getNumeroAtomico()) {
				qtd = se.getQuantidade();
				break;
			}
		}

		return qtd;
	}

	public static double converterDoubleCincoDecimais(double doubleInicial) {
		DecimalFormat fmt = new DecimalFormat("0.00000");
		String string = fmt.format(doubleInicial);
		String[] part = string.split("[,]");
		String string2 = part[0] + "." + part[1];
		double doubleFinal = Double.parseDouble(string2);
		return doubleFinal;
	}

    private boolean conferirResult(double[] result, double[][] matriz) {
        for(int i = 0; i <matriz.length-1; i++){
           
            double soma = 0;
            for(int j = 0; j < result.length; j++){
                soma = soma + (result[j] * matriz[i][j]);
            }
            if(soma != 0){
                return false;
            }
        }
            return true;
    }
}
