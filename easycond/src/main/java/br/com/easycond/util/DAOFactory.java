package br.com.easycond.util;

import br.com.easycond.dao.UsuarioDAO;
import br.com.easycond.daointerf.UsuarioDAOInterf;

public class DAOFactory {

	public static UsuarioDAOInterf criarUsuarioDAO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
}
