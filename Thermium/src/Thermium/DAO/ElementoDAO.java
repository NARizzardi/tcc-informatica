package Thermium.DAO;

import Thermium.ENTITY.Elemento;
import java.util.List;

import Thermium.DAO.GenericDAO;

public class ElementoDAO extends GenericDAO<Elemento, Integer>{
	public ElementoDAO() {
	       super(Elemento.class);
	    }
	
	public List<Elemento> pesquisarNome (String nome){
        return getPureList("nome", nome);
     }
	
	public Elemento pesquisarSimbolo (String simbolo){
        List<Elemento> elementos = (List<Elemento>) getPureList("simbolo", simbolo);
        return elementos.isEmpty() ? null : elementos.get(0);
     }
}