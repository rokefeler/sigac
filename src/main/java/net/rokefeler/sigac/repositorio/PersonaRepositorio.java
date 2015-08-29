package net.rokefeler.sigac.repositorio;

import net.rokefeler.sigac.modelo.Persona;
import net.rokefeler.sigac.repositorio.filtros.PersonaFiltros;
import net.rokefeler.sigac.service.NegocioExcepciones;
import net.rokefeler.sigac.util.jpa.Transaccion;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class PersonaRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public Persona buscarporId(String idPersona) {

		return this.entityManager.find(Persona.class, idPersona);
	}

	public Persona buscarPorEmail(String email) {

        Persona per= null;
		try{
			per =  this.entityManager.createQuery("select p from tpersona  as p where lower(p.email) = :email",
					Persona.class)
					.setParameter("email",email).getSingleResult();
		}catch(NoResultException e){
			per=null;
		}
		return per;
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> listarPersonasFiltrados(PersonaFiltros personaFiltros) {

		
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria =  session.createCriteria(Persona.class);


		if(StringUtils.isNotBlank(personaFiltros.getIdPersona())) {
            criteria.add(Restrictions.eq("id", personaFiltros.getIdPersona()));
		}

		if(StringUtils.isNotBlank(personaFiltros.getEmail())){
			criteria.add(Restrictions.ilike("email", personaFiltros.getEmail(), MatchMode.ANYWHERE));
        }
        if(StringUtils.isNotBlank(personaFiltros.getNombres())){
            criteria.add(Restrictions.ilike("nombres", personaFiltros.getNombres(), MatchMode.ANYWHERE));
		}
        if(StringUtils.isNotBlank(personaFiltros.getApellidos())){
            criteria.add(Restrictions.ilike("apellidos", personaFiltros.getApellidos(), MatchMode.ANYWHERE));
        }

         criteria.addOrder(Order.asc("apellidos"))
                .addOrder(Order.asc("nombres")).list();
        return criteria.list();
	}

	@Transaccion
	public void removerPersona(Persona persona) {
		
		try{
			persona = obtenerPersona(persona.getId());
			entityManager.remove(persona);
			entityManager.flush();
		}catch(PersistenceException e){
			throw new NegocioExcepciones("El usuario no puede ser eliminado.");
		}
	}
	
	public Persona obtenerPersona(String idPersona){

		return entityManager.find(Persona.class, idPersona);
	}	
	
	public Persona adicionarPersona(Persona persona) {
		return entityManager.merge(persona);
	}
	
}
