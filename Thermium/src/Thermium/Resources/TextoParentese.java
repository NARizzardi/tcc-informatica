package Thermium.Resources;

import java.util.ArrayList;
import java.util.Iterator;

public class TextoParentese {

	private ArrayList<String> elementos = new ArrayList<String>();
	private ArrayList<Integer> quantidadesElementos = new ArrayList<Integer>();
	private int posicaoFechamento = 0;

	public TextoParentese() {
		super();
	}

	public ArrayList<String> getElementos() {
		return elementos;
	}

	public void setElementosQuantidades(ArrayList<String> elementos, ArrayList<Integer> quantidadesElementos) {
		for (int i = 0; i < elementos.size(); i++) {
			if (this.elementos.contains(elementos.get(i))) {
				for (int j = 0; j < this.elementos.size(); j++) {
					if (this.elementos.get(j).equals(elementos.get(i))) {
						this.quantidadesElementos.set(j, this.quantidadesElementos.get(j) + quantidadesElementos.get(i));
						elementos.remove(i);
						quantidadesElementos.remove(i);
						i--;
						break;
					}
				}
			}
		}
		this.elementos.addAll(elementos);
		this.quantidadesElementos.addAll(quantidadesElementos);
	}
	
	public void setElementosQuantidades(String elemento, int quantidadeElemento) {
		
			if (this.elementos.contains(elemento)) {
				for (int j = 0; j < this.elementos.size(); j++) {
					if (this.elementos.get(j).equals(elemento)) {
						this.quantidadesElementos.set(j, this.quantidadesElementos.get(j) + quantidadeElemento);
						break;
					}
				}
			} else {
				this.elementos.add(elemento);
				this.quantidadesElementos.add(quantidadeElemento);
			}
	}
	
	

	public ArrayList<Integer> getQuantidadesElementos() {
		return quantidadesElementos;
	}



	public void multiplicarQuantidadesElementos(int mult) {
		for (int i = 0; i < quantidadesElementos.size(); i++) {
			quantidadesElementos.set(i, quantidadesElementos.get(i) * mult);
		}
	}

	public int getPosicaoFechamento() {
		return posicaoFechamento;
	}

	public void setPosicaoFechamento(int posicaoFechamento) {
		this.posicaoFechamento = posicaoFechamento;
	}

}
