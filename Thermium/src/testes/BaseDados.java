package testes;

import java.util.Scanner;

import javax.persistence.EntityTransaction;

public class BaseDados {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Entre com os dados e digite 'fim' quando acabar");
		String dado = " ", substancia = null, resto = null, resto2 = null, estado = null, entalpia = null;// deve
																											// ser
		int posicaoEstado; // double
		char c = '+';

		while (!dado.equals("fim")) {

			dado = s.nextLine();
			if (!dado.isEmpty()) {
				c = dado.charAt(0);

				if (((c >= 'A') && (c <= 'Z'))) {

					if (dado.indexOf(" c ") != -1) {
						posicaoEstado = dado.indexOf(
								" c ");/* verificar se pega a posi��o correta */
						substancia = dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 3) + " ";
						estado = "c";
						entalpia = resto.substring(0, resto.indexOf(' '));
					} else if (dado.indexOf(" aq ") != -1) {

						posicaoEstado = dado.indexOf(
								" aq ");/*
										 * verificar se pega a posi��o correta
										 */
						substancia = dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 4) + " ";
						estado = "aq";
						entalpia = resto.substring(0, resto.indexOf(' '));

					} else if (dado.indexOf(" lq ") != -1) {

						posicaoEstado = dado.indexOf(
								" lq ");/*
										 * verificar se pega a posi��o correta
										 */
						substancia = dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 4) + " ";
						estado = "lq";
						entalpia = resto.substring(0, resto.indexOf(' '));

					} else if (dado.indexOf(" g ") != -1) {

						posicaoEstado = dado.indexOf(
								" g ");/* verificar se pega a posi��o correta */
						substancia = dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 3) + " ";
						estado = "g";
						entalpia = resto.substring(0, resto.indexOf(' '));

					}

				} else if (dado.startsWith("c ") || dado.startsWith("aq ") || dado.startsWith("lq ")
						|| dado.startsWith("g ")) {
					substancia = substancia + " ";
					substancia = substancia.substring(0, substancia.indexOf(' '));
					estado = dado.substring(0, dado.indexOf(' '));
					resto2 = dado.substring(dado.indexOf(' ') + 1) + " ";
					entalpia = resto2.substring(0, resto2.indexOf(' '));
				} else {

					if (dado.indexOf(" c ") != -1) {
						posicaoEstado = dado.indexOf(
								" c ");/* verificar se pega a posi��o correta */
						// substancia = substancia + " std. state";
						substancia = substancia + " ";
						substancia = substancia.substring(0, substancia.indexOf(' ')) + " "
								+ dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 3) + " ";
						estado = "c";
						entalpia = resto.substring(0, resto.indexOf(' '));
					} else if (dado.indexOf(" aq ") != -1) {

						posicaoEstado = dado.indexOf(
								" aq ");/*
										 * verificar se pega a posi��o correta
										 */
						// substancia = dado.substring(0, posicaoEstado);
						substancia = substancia + " ";
						substancia = substancia.substring(0, substancia.indexOf(' ')) + " "
								+ dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 4) + " ";
						estado = "aq";
						entalpia = resto.substring(0, resto.indexOf(' '));

					} else if (dado.indexOf(" lq ") != -1) {

						posicaoEstado = dado.indexOf(
								" lq ");/*
										 * verificar se pega a posi��o correta
										 */
						// substancia = dado.substring(0, posicaoEstado);
						substancia = substancia + " ";
						substancia = substancia.substring(0, substancia.indexOf(' ')) + " "
								+ dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 4) + " ";
						estado = "lq";
						entalpia = resto.substring(0, resto.indexOf(' '));

					} else if (dado.indexOf(" g ") != -1) {

						posicaoEstado = dado.indexOf(
								" g ");/* verificar se pega a posi��o correta */
						// substancia = dado.substring(0, posicaoEstado);
						substancia = substancia + " ";
						substancia = substancia.substring(0, substancia.indexOf(' ')) + " "
								+ dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 3) + " ";
						estado = "g";
						entalpia = resto.substring(0, resto.indexOf(' '));

					}
				}
				double e = Double.parseDouble(entalpia);
			//	boolean p = persistir(substancia, estado, e);
			}
		}
		s.close();
	}

	
}
