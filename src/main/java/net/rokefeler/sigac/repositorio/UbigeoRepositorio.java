package net.rokefeler.sigac.repositorio;

import net.rokefeler.sigac.modelo.UbigeoDepartamento;
import net.rokefeler.sigac.modelo.UbigeoDistrito;
import net.rokefeler.sigac.modelo.UbigeoProvincia;
import net.rokefeler.sigac.service.NegocioExcepciones;
import net.rokefeler.sigac.util.jpa.Transaccion;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

public class UbigeoRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

    private UbigeoDepartamento departamento;
    private UbigeoProvincia provincia;
    private UbigeoDistrito distrito;

    private List<UbigeoDepartamento> departamentos;
    private List<UbigeoProvincia> provincias;
    private List<UbigeoDistrito> distritos;

	public UbigeoDepartamento obtenerDepartamento(String idDepartamento) {
        this.departamento = this.entityManager.find(UbigeoDepartamento.class, idDepartamento);
		return departamento;
	}
	public UbigeoProvincia obtenerProvincia(String idProvincia) {

		this.provincia =this.entityManager.find(UbigeoProvincia.class, idProvincia);
        return this.provincia;
	}
	public UbigeoDistrito obtenerDistrito(String idDistrito) {

		this.distrito =this.entityManager.find(UbigeoDistrito.class, idDistrito);
        return this.distrito;
	}

    public List<UbigeoDepartamento> listarDepartamentos() {

        try{
            this.departamentos =  this.entityManager
                    .createQuery("from TUbigeoDepartamento as d order by d.nombre", UbigeoDepartamento.class)
                    .getResultList();
        }catch(NoResultException e){
            departamentos=null;
        }
        return departamentos;
    }

    public List<UbigeoProvincia> listarProvincias(String idDepartamento) {
        //List<UbigeoProvincia> provincias;
        try{
            this.provincias =  this.entityManager
                    .createQuery("from TUbigeoProvincia as p where substring(p.id,1,2)=:idDepartamento order by p.nombre", UbigeoProvincia.class)
                    .setParameter("idDepartamento",idDepartamento)
                    .getResultList();
        }catch(NoResultException e){
            this.provincias=null;
        }
        return this.provincias;
    }

    public List<UbigeoDistrito> listarDistritos(String idProvincia) {
        //List<UbigeoDistrito> distritos;
        try{
            this.distritos =  this.entityManager
                    .createQuery("from TUbigeoDistrito as d where substring(d.id,1,4)=:idProvincia order by d.nombre", UbigeoDistrito.class)
                    .setParameter("idProvincia",idProvincia)
                    .getResultList();
        }catch(NoResultException e){
            this.distritos=null;
        }
        return this.distritos;
    }

    public List<UbigeoDepartamento> sugerirDepartamentos(String nombre) {
		nombre = StringUtils.upperCase(nombre).concat("%");
        List<UbigeoDepartamento> departamentos;
		try{
			departamentos =  this.entityManager
					.createQuery("select p from TUbigeoDepartamento  as p where p.nombre LIKE :keyword", UbigeoDepartamento.class)
					.setParameter("keyword",nombre)
					.getResultList();
		}catch(NoResultException e){
			departamentos=null;
		}
		return departamentos;
	}

	public List<UbigeoProvincia> sugerirProvincias(String nombre, String idDepartamento) {
		nombre = StringUtils.upperCase(nombre).concat("%");
		List<UbigeoProvincia> provincias;
		try{
			provincias =  this.entityManager
					.createQuery("from TUbigeoProvincia as p inner join p.ubigeoDepartamento as d " +
                                 "where d.id=:idDepartamento AND p.nombre LIKE :keyword",
                            UbigeoProvincia.class)
					.setParameter("idDepartamento", idDepartamento)
					.setParameter("keyword",nombre)
					.getResultList();
		}catch(NoResultException e){
			provincias=null;
		}
		return provincias;
	}

    public List<UbigeoDistrito> sugerirDistritos(String nombre, String idProvincia) {
        nombre = StringUtils.upperCase(nombre).concat("%");
        List<UbigeoDistrito> distritos;
        try{
            distritos =  this.entityManager
                    .createQuery("from TUbigeoDistrito as d inner join d.ubigeoProvincia as p " +
                                    "where p.id=:idProvincia AND d.nombre LIKE :keyword",
                            UbigeoDistrito.class)
                    .setParameter("idProvincia", idProvincia)
                    .setParameter("keyword",nombre)
                    .getResultList();
        }catch(NoResultException e){
            distritos=null;
        }
        return distritos;
    }


	@Transaccion
	public void removerDepartamento(UbigeoDepartamento departamento) {
		
		try{
            departamento = obtenerDepartamento(departamento.getId());
			entityManager.remove(departamento);
			entityManager.flush();
		}catch(PersistenceException e){
			throw new NegocioExcepciones("El Departamento no puede ser eliminado.");
		}
	}

    @Transaccion
    public void removerProvincia(UbigeoProvincia provincia) {

        try{
            provincia = obtenerProvincia(provincia.getId());
            entityManager.remove(provincia);
            entityManager.flush();
        }catch(PersistenceException e){
            throw new NegocioExcepciones("La provincia no puede ser eliminada.");
        }
    }

    @Transaccion
    public void removerDistrito(UbigeoDistrito distrito) {

        try{
            distrito = obtenerDistrito(distrito.getId());
            entityManager.remove(distrito);
            entityManager.flush();
        }catch(PersistenceException e){
            throw new NegocioExcepciones("El distrito no puede ser eliminado.");
        }
    }

    @Transaccion
    public UbigeoDepartamento adicionarDepartamento(UbigeoDepartamento departamento) {
		return entityManager.merge(departamento);
	}

    @Transaccion
    public UbigeoProvincia adicionarProvincia(UbigeoProvincia provincia) {
        return entityManager.merge(provincia);
    }

    @Transaccion
    public UbigeoDistrito adicionarDistrito(UbigeoDistrito distrito) {
        return entityManager.merge(distrito);
    }




    /*
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
	*/
}
