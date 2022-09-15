package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Thermium.ENTITY.Elemento;
import Thermium.DAO.ElementoDAO;
import Thermium.DAO.EntityManagerUtil;
import Thermium.VIEW.MainFrameVIEW;
import Thermium.ENTITY.Substancia;
import Thermium.DAO.SubstanciaDAO;
import Thermium.ENTITY.SubstanciaElemento;
import Thermium.DAO.SubstanciaElementoDAO;
import Thermium.VIEW.SubstanciaVIEW;

public class Programa {

//	SubstanciaDAO sDAO = new SubstanciaDAO();

	public static void main(String[] args) {
		Programa p = new Programa();
		p.iniciar();
		
	}

	public void iniciar() {
		/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameVIEW().setVisible(true);
            }
        });
//		LeituraSubstancia.main(null);
//		inserirElemento();
		
//		ElementoDAO eDAO = new ElementoDAO();
//		SubstanciaDAO sDAO = new SubstanciaDAO();
//		Elemento e = new Elemento("Hidrog�nio", 1, "H");
//		eDAO.salvar(e);
		
//		eDAO.remover(eDAO.pesquisarSimbolo("H"));
		
//		List<Elemento> elementos = s.getElementos();
//		
//		for(Elemento e : elementos) {
//			System.out.println(e.getSimbolo() + " -> " + e.getNumeroAtomico());
//		}
//		
//		sDAO.remover(s);
	}

//	private void inserirElemento() {
//		
//		SubstanciaDAO sDAO = new SubstanciaDAO();
//		EstadoFisico ef = EstadoFisico.G;
//		Substancia s = new Substancia(0.0, "Hidrogênio", "H2", ef);
//		sDAO.salvar(s);
//
//		
//		ElementoDAO eDAO = new ElementoDAO();
//		Elemento e = eDAO.encontrar(1);
//		SubstanciaElementoDAO seDAO = new SubstanciaElementoDAO();
//		SubstanciaElemento se = new SubstanciaElemento(2, s, e);
//		s.addSubstanciaElemento(se);
//		
//		sDAO.atualizar(s);
//		seDAO.salvar(se);
//		
//		
//		
//		
//		System.out.println(s.getId());
//		
//		
//		Substancia s2 = sDAO.encontrar(40);
//		System.out.println(s2.getSubstanciaElemento().size());
//		System.out.println(s2.getElementos().size());
//	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void adicionarSubstancia() {
		SubstanciaDAO sb = new SubstanciaDAO();

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
						posicaoEstado = dado.indexOf(" c ");/* verificar se pega a posi��o correta */
						substancia = dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 3) + " ";
						estado = "c";
						entalpia = resto.substring(0, resto.indexOf(' '));
					} else if (dado.indexOf(" aq ") != -1) {

						posicaoEstado = dado.indexOf(" aq ");/*
																 * verificar se pega a posi��o correta
																 */
						substancia = dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 4) + " ";
						estado = "aq";
						entalpia = resto.substring(0, resto.indexOf(' '));

					} else if (dado.indexOf(" lq ") != -1) {

						posicaoEstado = dado.indexOf(" lq ");/*
																 * verificar se pega a posi��o correta
																 */
						substancia = dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 4) + " ";
						estado = "lq";
						entalpia = resto.substring(0, resto.indexOf(' '));

					} else if (dado.indexOf(" g ") != -1) {

						posicaoEstado = dado.indexOf(" g ");/* verificar se pega a posi��o correta */
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
						posicaoEstado = dado.indexOf(" c ");/* verificar se pega a posi��o correta */
						// substancia = substancia + " std. state";
						substancia = substancia + " ";
						substancia = substancia.substring(0, substancia.indexOf(' ')) + " "
								+ dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 3) + " ";
						estado = "c";
						entalpia = resto.substring(0, resto.indexOf(' '));
					} else if (dado.indexOf(" aq ") != -1) {

						posicaoEstado = dado.indexOf(" aq ");/*
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

						posicaoEstado = dado.indexOf(" lq ");/*
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

						posicaoEstado = dado.indexOf(" g ");/* verificar se pega a posi��o correta */
						// substancia = dado.substring(0, posicaoEstado);
						substancia = substancia + " ";
						substancia = substancia.substring(0, substancia.indexOf(' ')) + " "
								+ dado.substring(0, posicaoEstado);
						resto = dado.substring(posicaoEstado + 3) + " ";
						estado = "g";
						entalpia = resto.substring(0, resto.indexOf(' '));

					}
				}
				/*
				 * double e = Double.parseDouble(entalpia); Substancia subs = new Substancia(e,
				 * estado, substancia); sb.salvar(subs);
				 */
			}
		}
		s.close();

	}

}
