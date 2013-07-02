package br.com.scsmarttech.util;


import br.com.scsmarttech.categoria.CategoriaDAO;
import br.com.scsmarttech.categoria.CategoriaDAOHibernate;
import br.com.scsmarttech.usuario.UsuarioDAO;
import br.com.scsmarttech.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

	public static CategoriaDAO criarCategoriaDAO() {
		CategoriaDAOHibernate categoriaDAO = new CategoriaDAOHibernate();
		categoriaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return categoriaDAO;
	}
}