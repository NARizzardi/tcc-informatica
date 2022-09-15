package Thermium.DAO;

import Thermium.ENTITY.Elemento;
import Thermium.DAO.GenericDAO;
import Thermium.ENTITY.Substancia;
import Thermium.ENTITY.SubstanciaElemento;

public class SubstanciaElementoDAO extends GenericDAO<SubstanciaElemento, Integer> {
	
	public SubstanciaElementoDAO() {
	       super(SubstanciaElemento.class);
	    }  
	
	

//	public void relacionar(Substancia s, Elemento e, int quantidade) {
//		
//		
//		SubstanciaElemento se = new SubstanciaElemento(quantidade, s, e);
//		s.addSubstanciaElemento(se);
//		
//		super.salvar(se);
//	}
	
	
	
}
