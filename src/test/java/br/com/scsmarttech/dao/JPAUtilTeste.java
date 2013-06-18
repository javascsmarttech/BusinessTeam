package br.com.scsmarttech.dao;

import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManager;
import org.junit.Test;

public class JPAUtilTeste {

	@Test
	public void conexao() {
		EntityManager em = JPAUtil.getEntityManager();
		assertTrue(em.isOpen());
	}
}
