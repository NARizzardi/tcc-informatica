package Thermium.DAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil {
	private static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager() {
		 if (emf == null){
			emf = Persistence.createEntityManagerFactory("teste");
		 }
		 return emf.createEntityManager();
	}
	
	
	
	public static EntityManagerFactory getEmf() {
		return emf;
	}



	public static void closeEntityFactory() {
		if (emf != null)
			emf.close();
	}
}