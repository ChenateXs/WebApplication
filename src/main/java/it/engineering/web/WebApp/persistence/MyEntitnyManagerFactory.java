package it.engineering.web.WebApp.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntitnyManagerFactory {
	private static MyEntitnyManagerFactory instance;
	private static EntityManagerFactory emf;
	
	private MyEntitnyManagerFactory() {
		System.out.println("+");
		emf = Persistence.createEntityManagerFactory("WebApp");
		System.out.println("-");
		
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(instance ==null) {
			instance = new MyEntitnyManagerFactory();
		}
		return instance.getEmf();
	}

	private static EntityManagerFactory getEmf() {
		return emf;
	}
	
	public static void closeEntityManagerFactory() {
		if(instance!=null)	instance.getEmf().close();
	}
	
}
