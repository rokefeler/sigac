package net.rokefeler.sigac.repositorio;

import net.rokefeler.sigac.modelo.CodigoNumero;
import net.rokefeler.sigac.service.NegocioExcepciones;
import net.rokefeler.sigac.util.jpa.Transaccion;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class CodigoNumeroRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public CodigoNumero getbyIdCodigoNumero(String tipo) {

		return this.entityManager.find(CodigoNumero.class, tipo);
	}

	public List<CodigoNumero> getAllCodigoNumero() {
        List<CodigoNumero> codigos;
		try{
			codigos =  this.entityManager
					.createQuery("from tcodigonumero as c order by c.id", CodigoNumero.class)
					.getResultList();
		}catch(NoResultException e){
			codigos=null;
		}
		return codigos;
	}
	
	@Transaccion
	public void deleteCodigoNumero(CodigoNumero codigoNumero) {
		
		try{
			codigoNumero = this.getbyIdCodigoNumero(codigoNumero.getId());
			entityManager.remove(codigoNumero);
			entityManager.flush();

		}catch(PersistenceException e){
			throw new NegocioExcepciones("El tipo Código no puede ser eliminado.");
		}
	}

	@Transaccion
	public CodigoNumero addCodigoNumero(CodigoNumero codigoNumero) {
		return entityManager.merge(codigoNumero);
	}
	
}
