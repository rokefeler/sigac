package net.rokefeler.sigac.repositorio;

import net.rokefeler.sigac.modelo.Permiso;
import net.rokefeler.sigac.modelo.Persona;
import net.rokefeler.sigac.repositorio.filtros.PersonaFiltros;
import net.rokefeler.sigac.service.NegocioExcepciones;
import net.rokefeler.sigac.util.jpa.Transaccion;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;

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

	public Persona getbyIdPersona(String idPersona) {

		return this.entityManager.find(Persona.class, idPersona);
	}
    public Persona getbyIdPersonaWithDistrito(String idPersona) {
        //Persona per;
        //this.entityManager.
        return this.entityManager.createQuery("FROM tpersona p inner join fetch p.idDistritoNacimiento" +
                " left join fetch p.direccion.idDistritoDomicilio where p.id=:id", Persona.class)
                .setParameter("id",idPersona).getSingleResult();
        /*try{
            per = (Persona)obj;
        }catch {
            per=null;
        }
        return per;*/
    }

	public Boolean ExisteIdPersona(String idPersona) {
		Object ret=this.entityManager.createQuery("select count(*) from tpersona where id=:id")
				.setParameter("id", idPersona)
				.getSingleResult();
			return Integer.parseInt(ret.toString())>0 ? true : false;
	}

	public Persona getbyEmailPersona(String email) {

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
        if(StringUtils.isNotBlank(personaFiltros.getApepat())){
            criteria.add(Restrictions.ilike("apepat", personaFiltros.getApepat(), MatchMode.ANYWHERE));
        }
        if(StringUtils.isNotBlank(personaFiltros.getApemat())){
            criteria.add(Restrictions.ilike("apemat", personaFiltros.getApemat(), MatchMode.ANYWHERE));
        }
         criteria.addOrder(Order.asc("apepat"))
				 .addOrder(Order.asc("apemat"))
                 .addOrder(Order.asc("nombres")).list();
        return criteria.list();
	}

	@Transaccion
	public void deletePersona(Persona persona) {
		
		try{
			persona = this.getbyIdPersona(persona.getId());
			entityManager.remove(persona);
			entityManager.flush();
		}catch(PersistenceException e){
			throw new NegocioExcepciones("La Persona no puede ser eliminado.");
		}
	}

	
	public Persona addPersona(Persona persona) {
		return entityManager.merge(persona);
	}
	
}
