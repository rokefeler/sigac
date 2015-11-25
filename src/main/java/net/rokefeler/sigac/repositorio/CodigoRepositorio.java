package net.rokefeler.sigac.repositorio;

import net.rokefeler.sigac.modelo.Codigo;
import net.rokefeler.sigac.service.NegocioExcepciones;
import net.rokefeler.sigac.util.jpa.Transaccion;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class CodigoRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public Codigo getbyId(String idCodigo) {

		return this.entityManager.find(Codigo.class, idCodigo);
	}

    public Codigo getbyId(Codigo codigo) {

        return this.entityManager.find(Codigo.class, codigo.getId());
    }

	public List<Codigo> getAllbyTipo(String cTipo) {
        List<Codigo> codigos;
		//String cTipo = tipo.getId();
		try{
			codigos =  this.entityManager
					.createQuery("select c from tcodigo as c where c.codigoNumero.id=:keyword order by c.nombre", Codigo.class)
					.setParameter("keyword",cTipo)
					.getResultList();
		}catch(NoResultException e){
			codigos=null;
		}
		return codigos;
	}
	
	@Transaccion
	public void eliminar(Codigo codigo) {
		
		try{
			codigo = getbyId(codigo);
			entityManager.remove(codigo);
			entityManager.flush();
		}catch(PersistenceException e){
			throw new NegocioExcepciones("El Código no puede ser eliminado.");
		}
	}

    @Transaccion
    public Codigo add(Codigo codigo) {
		return entityManager.merge(codigo);
	}
	
}
