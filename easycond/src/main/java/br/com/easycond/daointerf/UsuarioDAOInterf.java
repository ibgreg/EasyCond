package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Usuario;

public interface UsuarioDAOInterf {
	
	public void salvar(Usuario usuario);
	
	public void atualizar(Usuario usuario);
	
	public void excluir(Usuario usuario);
	
	public Usuario carregar(Integer codigo);
	
	public Usuario carregarPorNomeLogin(String login);
	
	public List<Usuario> listar();
}
