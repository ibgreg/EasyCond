package br.com.easycond.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.easycond.model.Usuario;
import br.com.easycond.rn.UsuarioRN;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	
	@PostConstruct
	public String novo() {
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/public/cadastro";
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		String senha = this.usuario.getSenha();
		
		if(!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("Senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		
		return "/public/login";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	
}
