package Thermium.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public abstract class GenericDAO<T, I extends Serializable> {

	@Inject
	private Class<T> persistedClass; 

	protected GenericDAO() {
	}

	protected GenericDAO(Class<T> persistedClass) {	
		this();
		this.persistedClass = persistedClass;
	}

	public T salvar(T entity) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(entity);
		em.flush();
		t.commit();
		em.close();

		return entity;
	}

	public T atualizar(T entity) {
		EntityManager em = EntityManagerUtil.getEntityManager();

		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(entity);
		em.flush();
		t.commit();
		em.close();

		return entity;
	}

	public void remover(T entity) {
		EntityManager em = EntityManagerUtil.getEntityManager();

		EntityTransaction t = em.getTransaction();
		t.begin();
		T mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.flush();
		t.commit();
		em.close();

	}

	public List<T> getList() {
		EntityManager em = EntityManagerUtil.getEntityManager();

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		List list = new ArrayList();
		list = em.createQuery(query).getResultList();
		em.close();

		return list;

	}

	public T encontrar(I id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		T t;
		t = em.find(persistedClass, id);
		em.close();

		return t;
	}

	protected List<T> getPureList(String campo, String valor) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> qr = builder.createQuery(persistedClass);
		Root<T> c = qr.from(persistedClass);
		qr.select(c);
		ParameterExpression<String> p = builder.parameter(String.class);

		qr.where(builder.like(c.get(campo), p));
		TypedQuery<T> query = em.createQuery(qr);
		query.setParameter(p, valor);
		List<T> results = query.getResultList();
		em.close();

		return results;
	}

}