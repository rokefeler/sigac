package net.rokefeler.sigac.repositorio;

import net.rokefeler.sigac.modelo.RolLogin;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class RolLoginRepositorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public List<RolLogin> listarRolLogin() {
		return entityManager.createQuery("from RolLogin ", RolLogin.class)
				.getResultList();
	}

	public RolLogin obtenerGrupo(int id) {

		return entityManager.find(RolLogin.class, id);

	}
}
