package net.rokefeler.sigac.util.jpa;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

/**
 * INteceptor debe Matricularse en Beans.xml, sino no funciona
 * ver en resources/META-INF/beans.xml interceptor
 */
@Interceptor
@Transaccion
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject EntityManager manager; //Se inyecta un EntityManager, por eso es mejor Crear un Productor de Entity manager para toda la Aplicaciónen archivo EntityManagerProducer

	@AroundInvoke //Cuando se va ha Ejecutar un metodo, alrededor del Metodo abre la Transacción
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction trx = manager.getTransaction();
		boolean criador = false;

		try {
			if (!trx.isActive()) {
				trx.begin();
				trx.rollback();

				trx.begin();

				criador = true;
			}

			return context.proceed(); //Proceder o Ejecutar mEtodo
		} catch (Exception e) { //Si ocurre un Error se hace el RollBack
			if (trx != null && criador) {
				trx.rollback();
			}

			throw e;
		} finally {
			if (trx != null && trx.isActive() && criador) {
				trx.commit(); //Caso contrario se hace el Commit
			}
		}
	}
}
