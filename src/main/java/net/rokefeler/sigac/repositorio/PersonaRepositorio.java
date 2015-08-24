package net.rokefeler.sigac.repositorio;

import net.rokefeler.sigac.modelo.Login;
import net.rokefeler.sigac.repositorio.filtros.LoginFiltros;
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

	public Login buscarporId(String idLogin) {

		return this.entityManager.find(Login.class, idLogin);
	}

	/*
	public List<Persona> listarVendedores() {
		return this.entityManager.createQuery("from tsecuritylogin ", Login.class)
				.getResultList();
	}*/
	
	public Login buscarPorId(String id) {
		email = email.toLowerCase();
        Login login = null;
		try{
			login =  this.entityManager.createQuery("select l from tsecuritylogin as l join l.idPersona as p where lower(p.email) = :email and l.estado = net.rokefeler.sigac.modelo.tipos.TipoEstado.VIGENTE",
                    Login.class)
					.setParameter("email",email).getSingleResult();

		}catch(NoResultException e){

		}
		return login;
	}
	
	@SuppressWarnings("unchecked")
	public List<Login> listarLoginsFiltrados(LoginFiltros loginFiltros) {

		
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria =  session.createCriteria(Login.class);
        criteria.createCriteria("idPersona","ip");

		if(StringUtils.isNotBlank(loginFiltros.getEmail())) {
            criteria.add(Restrictions.eq("ip.email", loginFiltros.getEmail()));
		}

		if(StringUtils.isNotBlank(loginFiltros.getApellidos())){
			criteria.add(Restrictions.ilike("ip.apellidos", loginFiltros.getApellidos(), MatchMode.ANYWHERE));
        }
        if(StringUtils.isNotBlank(loginFiltros.getNombres())){
            criteria.add(Restrictions.ilike("ip.nombres", loginFiltros.getNombres(), MatchMode.ANYWHERE));
		}

		//criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        if(StringUtils.isNotBlank(loginFiltros.getNombres()) ||
                StringUtils.isNotBlank(loginFiltros.getApellidos()) )
            criteria.addOrder(Order.asc("ip.apellidos"))
                .addOrder(Order.asc("ip.nombres")).list();

        return criteria.list();
	}
	
	@Transaccion
	public void removerLogin(Login login) {
		
		try{
			login = obtenerLogin(login.getIdLogin());
			entityManager.remove(login);
			entityManager.flush();
		}catch(PersistenceException e){
			throw new NegocioExcepciones("El usuario no puede ser eliminado.");
		}
	}
	
	public Login obtenerLogin(String idLogin){

		return entityManager.find(Login.class, idLogin);
	}	
	
	public Login adicionarLogin(Login login) {
		return entityManager.merge(login);
	}
	
}
