package Thermium.DAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import Thermium.ENTITY.Elemento;
import Thermium.DAO.GenericDAO;
import java.util.ArrayList;
import javax.persistence.criteria.Predicate;
import Thermium.ENTITY.Substancia;

public class SubstanciaDAO extends GenericDAO<Substancia, Integer>{
	public SubstanciaDAO() {
	       super(Substancia.class);
	    }  
	
	public List<Substancia> pesquisarNome (String nome){
        return getPureList("nome", nome);
     }
	
	
	public List<Substancia> pesquisarNomeFragmentoInicio (String nome){
        return getPureList("nome", nome+"%");
     }
	
	public List<Substancia> pesquisarNomeFragmento (String nome){
        return getPureList("nome", "%"+nome+"%");
     }
	
    public Boolean verificarSubstancia(String nome, String formula, String ef) {
            EntityManager em = EntityManagerUtil.getEntityManager();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Substancia> qr = builder.createQuery(Substancia.class);
            Root<Substancia> c = qr.from(Substancia.class);

            List<Predicate> predicates = new ArrayList<Predicate>();


            predicates.add(builder.equal(c.get("nome"), nome));                
            predicates.add(builder.equal(c.get("formula"), formula));
            predicates.add(builder.equal(c.get("estado"), ef));

            qr.select(c).where(predicates.toArray(new Predicate[]{}));

            TypedQuery<Substancia> query = em.createQuery(qr);

            List<Substancia> results = query.getResultList();
            em.close();

            return results.isEmpty();
    }
    
    public Substancia pegarSubstanciaPelaFormula(String formula, String ef) {
            EntityManager em = EntityManagerUtil.getEntityManager();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Substancia> qr = builder.createQuery(Substancia.class);
            Root<Substancia> c = qr.from(Substancia.class);

            List<Predicate> predicates = new ArrayList<Predicate>();
               
            predicates.add(builder.equal(c.get("formula"), formula));
            predicates.add(builder.equal(c.get("estado"), ef));

            qr.select(c).where(predicates.toArray(new Predicate[]{}));

            TypedQuery<Substancia> query = em.createQuery(qr);
            
            List<Substancia> list = query.getResultList();
            if(!list.isEmpty()){
            Substancia result = list.get(0);
            em.close();
            return result;
            } else {
                return null;
            }

            
    }
    
    public Substancia pegarSubstanciaPeloNome(String nome, String ef) {
            EntityManager em = EntityManagerUtil.getEntityManager();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Substancia> qr = builder.createQuery(Substancia.class);
            Root<Substancia> c = qr.from(Substancia.class);

            List<Predicate> predicates = new ArrayList<Predicate>();
               
            predicates.add(builder.equal(c.get("nome"), nome));
            predicates.add(builder.equal(c.get("estado"), ef));

            qr.select(c).where(predicates.toArray(new Predicate[]{}));

            TypedQuery<Substancia> query = em.createQuery(qr);
            
            List<Substancia> list = query.getResultList();
            if(!list.isEmpty()){
            Substancia result = list.get(0);
            em.close();
            return result;
            } else {
                return null;
            }
    }

    public List<Substancia> pesquisarFormulaFragmentoInicio(String formula) {
        return getPureList("formula", formula+"%");
    }
    
    public List<Substancia> pesquisarFormulaFragmento(String formula) {
        return getPureList("formula", "%"+formula+"%");
    }
}


