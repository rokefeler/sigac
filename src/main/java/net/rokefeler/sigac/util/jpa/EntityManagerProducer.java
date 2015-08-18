package net.rokefeler.sigac.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Crea un Productor de EntityManager a Nivel de toda la Aplicación
 */
@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;
	
	public EntityManagerProducer(){
		factory = Persistence.createEntityManagerFactory("sigacPU");
	}
	@Produces @RequestScoped
	public EntityManager createEntityManager(){
		return factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager entityManager){
		entityManager.close();
	}
}
