package br.com.scsmarttech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.scsmarttech.bean.Cliente;

public class ClienteDAO {
	
	public void setContato(Cliente cliente) {
		EntityManager em = JPAUtil.getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(cliente);
		tx.commit();

		em.close();
	}

	public List<Cliente> getLista() {
		EntityManager em = JPAUtil.getEntityManager();
		String sql = "select p from pessoa p";
		Query q = em.createQuery(sql, Cliente.class);

		@SuppressWarnings("unchecked")
		List<Cliente> contatos = q.getResultList();
		em.close();

		return contatos;
		
	}

	public void removeContato(Cliente cliente) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.remove(cliente);
		tx.commit();
		
		em.close();
	}
	
	
	public void alteraContato(Cliente cliente) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.merge(cliente);
		tx.commit();
		
		em.close();
		
	}
}
