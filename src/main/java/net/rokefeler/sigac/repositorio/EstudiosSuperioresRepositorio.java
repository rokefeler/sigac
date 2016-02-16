package net.rokefeler.sigac.repositorio;

import net.rokefeler.sigac.modelo.EstudiosSuperiores;
import net.rokefeler.sigac.modelo.Pais;
import net.rokefeler.sigac.service.NegocioExcepciones;
import net.rokefeler.sigac.util.jpa.Transaccion;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class EstudiosSuperioresRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public EstudiosSuperiores getbyIdEstudios(Long idEstudios) {

		return this.entityManager.find(EstudiosSuperiores.class, idEstudios);
	}
    public List<EstudiosSuperiores> getbyIdPersona(String idPersona) {
        return this.entityManager
				.createQuery("FROM tEstudiosSuperiores e where " +
						"e.persona.id =:idpersona", EstudiosSuperiores.class)
                .setParameter("idpersona",idPersona).getResultList();
    }

	public Boolean ExisteEstudiosPersonalesPorPersona(String idPersona) {
		Object ret=this.entityManager.createQuery("select count(*) from tEstudiosSuperiores e where e.persona.id=:id")
				.setParameter("id", idPersona)
				.getSingleResult();
			return Integer.parseInt(ret.toString())>0 ? true : false;
	}

	@Transaccion
	public void deleteEstudiosSuperiores(long id) {
		EstudiosSuperiores estudiosSuperiores;
		try{
			estudiosSuperiores = this.getbyIdEstudios(id);
			entityManager.remove(estudiosSuperiores);
			entityManager.flush();
		}catch(PersistenceException e){
			throw new NegocioExcepciones("El Registro de estudios Superiores no pudo ser eliminado.");
		}
	}

	
	public EstudiosSuperiores addEstudiosPersonales(EstudiosSuperiores estudiosSuperiores) {
		return entityManager.merge(estudiosSuperiores);
	}
	
}
