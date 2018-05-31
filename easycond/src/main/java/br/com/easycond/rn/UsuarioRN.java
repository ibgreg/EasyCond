package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.UsuarioDAOInterf;
import br.com.easycond.model.Usuario;
import br.com.easycond.util.DAOFactory;

public class UsuarioRN {
	
	private UsuarioDAOInterf usuarioDAO;
	
	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario carregarPorNomeLogin(String login) {
		return this.usuarioDAO.carregarPorNomeLogin(login);
	}
	
	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
	
	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		List<Usuario> listaUsuario = this.usuarioDAO.listar();
		
		if(codigo == null || codigo == 0) {
			usuario.getPermissao().add("ROLE_USUARIO");
			if (listaUsuario == null || listaUsuario.isEmpty()) {
				usuario.getPermissao().add("ROLE_ADMIN");
			}
			this.usuarioDAO.salvar(usuario);
		} 
		else {
			this.usuarioDAO.atualizar(usuario);
		}
	}
	
	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

}
