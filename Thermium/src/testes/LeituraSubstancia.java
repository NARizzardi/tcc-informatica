package testes;

import java.util.ArrayList;
import java.util.InputMismatchException;

import Thermium.ENTITY.Elemento;
import Thermium.DAO.ElementoDAO;
import Thermium.Resources.TextoParentese;
import Thermium.ENTITY.Substancia;
import Thermium.DAO.SubstanciaDAO;
import Thermium.ENTITY.SubstanciaElemento;
import Thermium.DAO.SubstanciaElementoDAO;

public class LeituraSubstancia {

	/**
	 * @param args
	 */

	static ElementoDAO eDAO = new ElementoDAO();

	public static void main(String[] args) {

		String formula = "H2o2"; // String que vamos usar para o teste

		Double entalpia = 666.0;
		String nome = "subsTeste";
		String estado = "s";

		System.out.println("oi");
		TextoParentese tp = verificarFormula(formula);

		if (tp != null) {
			SubstanciaDAO sDAO = new SubstanciaDAO();
			SubstanciaElementoDAO seDAO = new SubstanciaElementoDAO();
			ArrayList<String> elementos = tp.getElementos();
			ArrayList<Integer> quantidadesElementos = tp.getQuantidadesElementos();

			// onde a inserção em si acontece
			Substancia s = new Substancia(entalpia, nome, formula, estado);
			sDAO.salvar(s);

			for (int i = 0; i < elementos.size(); i++) {

				Elemento e = eDAO.pesquisarSimbolo(elementos.get(i));
				SubstanciaElemento se = new SubstanciaElemento(quantidadesElementos.get(i), s, e);
				seDAO.salvar(se);
				s.addSubstanciaElemento(se);
				
			}
			sDAO.atualizar(s);

			// for(Elemento elm : s.getElementos()) {
			// System.out.println(elm.getSimbolo() + " -> " + elm.getNumeroAtomico());
			// }
		}

		// System.out.println(formula + "\n");
		//
		// for (int i = 0; i < elementos.size(); i++) {
		// System.out.println("Elemento: " + elementos.get(i) + " / Quantidade: " +
		// quantidadesElementos.get(i));
		// }

	}

	private static TextoParentese verificarFormula(String texto) {

		TextoParentese tp = pegarElementosQuantidade(texto);
		if(tp==null) {
			return tp;
		}
		ArrayList<String> elementos = tp.getElementos();

		for (int i = 0; i < elementos.size(); i++) {
			if (eDAO.pesquisarSimbolo(elementos.get(i)) == null) {
				System.out.println("O elemento " + elementos.get(i) + " não está cadastrado!");
				return null;
			}
		}

		return tp;
	}

	private static TextoParentese pegarElementosQuantidade(String texto) {
		TextoParentese textoOriginal = new TextoParentese(); // h2LC
		TextoParentese textoParentese = new TextoParentese();

		int tamanhotexto = texto.length();
		int qtdElementos = 0;
		char caracter = '#';
		String multString = "";
		int mult = 1;

		ArrayList<Integer> posicoesElementos = new ArrayList<Integer>();

		for (int i = 0; i < tamanhotexto; i++) {
			caracter = texto.charAt(i);
			if (Character.isUpperCase(caracter)) {

				posicoesElementos.add(i);
				qtdElementos++;

			} else if (caracter == '(') {
				textoParentese = pegarElementosQuantidade(texto.substring(i + 1));
				if (textoParentese == null) {
					return null;
				}
				textoOriginal.setElementosQuantidades(textoParentese.getElementos(),
						textoParentese.getQuantidadesElementos());
				textoOriginal.setPosicaoFechamento(textoParentese.getPosicaoFechamento());
				texto = texto.substring(0, i) + texto.substring(i + textoParentese.getPosicaoFechamento());
				tamanhotexto = texto.length();
				i--;
			} else if (caracter == ')') {
				int posicaoFechamento = 2;
				for (int j = i + 1; j < tamanhotexto; j++) {
					if (!Character.isDigit(texto.charAt(j))) {
						posicaoFechamento = j + 1;
						break;
					} else {
						multString = multString + texto.charAt(j);
						mult = Integer.parseInt(multString);
						posicaoFechamento = j + 2;
					}

				}
				textoOriginal.setPosicaoFechamento(posicaoFechamento + textoOriginal.getPosicaoFechamento());
				texto = texto.substring(0, i);
				tamanhotexto = texto.length();
			}
		}

		String[] elementosBrutos = new String[qtdElementos];

		for (int i = 0; i < qtdElementos; i++) {
			if (i != (qtdElementos - 1)) {

				elementosBrutos[i] = texto.substring(posicoesElementos.get(i), posicoesElementos.get(i + 1));

			} else {
				elementosBrutos[i] = texto.substring(posicoesElementos.get(i));

			}
		}

		ArrayList<Integer> quantidadesElementos = new ArrayList<Integer>();
		ArrayList<String> elementos = new ArrayList<String>();

		for (int i = 0; i < qtdElementos; i++) {
			elementos.add(elementosBrutos[i]);
			quantidadesElementos.add(1);
			for (int j = 0; j < elementosBrutos[i].length(); j++) {
				if (Character.isDigit(elementosBrutos[i].charAt(j))) {
					elementos.set(i, elementosBrutos[i].substring(0, j));
					try {
						quantidadesElementos.set(i, Integer.parseInt(elementosBrutos[i].substring(j)));
						break;
					} catch (java.lang.NumberFormatException e) {
						System.out.println("Os elementos devem estar em letra maiúscula!");
						return null;
					}

				}
			}

		}
		textoOriginal.setElementosQuantidades(elementos, quantidadesElementos);

		textoOriginal.multiplicarQuantidadesElementos(mult);

		return textoOriginal;
	}

}