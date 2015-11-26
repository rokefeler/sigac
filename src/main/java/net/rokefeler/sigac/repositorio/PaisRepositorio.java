package net.rokefeler.sigac.repositorio;

import net.rokefeler.sigac.modelo.Pais;
import net.rokefeler.sigac.modelo.Persona;
import net.rokefeler.sigac.repositorio.filtros.PaisFiltros;
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

public class PaisRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public Pais getbyIdPais(String idPais) {

		return this.entityManager.find(Pais.class, idPais);
	}

	public List<Pais> sugerirPaises(String nombre) {
		nombre = StringUtils.upperCase(nombre).concat("%");
        List<Pais> paises;
		try{
			paises =  this.entityManager
					.createQuery("select p from tpaisiso  as p where p.countryNameES LIKE :keyword", Pais.class)
					.setParameter("keyword",nombre)
					.getResultList();
		}catch(NoResultException e){
			paises=null;
		}
		return paises;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pais> listarPaisFiltrados(PaisFiltros paisFiltros) {

		Session session = entityManager.unwrap(Session.class);
		Criteria criteria =  session.createCriteria(Persona.class);

		if(StringUtils.isNotBlank(paisFiltros.getId())) {
            criteria.add(Restrictions.eq("id", paisFiltros.getId()));
		}
		if(StringUtils.isNotBlank(paisFiltros.getNombre())){
			criteria.add(Restrictions.ilike("countryNameES_PaisIso", paisFiltros.getNombre(), MatchMode.ANYWHERE));
        }
        if(StringUtils.isNotBlank(paisFiltros.getCode())){
            criteria.add(Restrictions.eq("languageCode_PaisIso", paisFiltros.getCode()));
		}

         criteria.addOrder(Order.asc("countryNameES_PaisIso")).list();
        return criteria.list();
	}

	@Transaccion
	public void deletePais(Pais pais) {
		
		try{
			pais = getbyIdPais(pais.getId());
			entityManager.remove(pais);
			entityManager.flush();
		}catch(PersistenceException e){
			throw new NegocioExcepciones("El Pais no puede ser eliminado.");
		}
	}
	

	
	public Pais addPais(Pais pais) {
		return entityManager.merge(pais);
	}
	
}
