package br.com.easycond.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Ocorrencia;
import br.com.easycond.model.Usuario;
import br.com.easycond.rn.OcorrenciaRN;
import br.com.easycond.rn.UsuarioRN;

@ManagedBean(name = "ocorrenciaBean")
@RequestScoped
public class OcorrenciaBean {
	
	private Ocorrencia ocorrencia = new Ocorrencia();
	private Usuario usuario = new Usuario();
	
	private List<Ocorrencia> lista;
	private List<Usuario> listaUsuario;
	
	private Integer usuarioSelecionado;
	
	@PostConstruct
	public String novo() {
		this.ocorrencia = new Ocorrencia();
		return "/adm/ocorrencia/cadastrar";
	}
	
	public String salvar() {
		
		this.usuario = new UsuarioRN().carregar(usuarioSelecionado);
		Date dataAtual = new Date();
		OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
		ocorrencia.setUsuarioOcorrencia(usuario);
		ocorrencia.setDataOcorrencia(dataAtual);
		ocorrenciaRN.salvar(this.ocorrencia);
		
		return "/adm/ocorrencia/lista";
	}
	
	public String editar() {
		usuarioSelecionado = ocorrencia.getUsuarioOcorrencia().getCodigo();
		return "/adm/ocorrencia/cadastrar";
	}
	
	public String excluir() {
		OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
		ocorrenciaRN.excluir(this.ocorrencia);
		this.lista = null;
		return null;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public List<Ocorrencia> getLista() {
		if (this.lista == null) {
			OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
			this.lista = ocorrenciaRN.listar();
		}
		
		return this.lista;
	}

	public List<Usuario> getListaUsuario() {
		if (this.listaUsuario == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.listaUsuario = usuarioRN.listar();
		}
		return this.listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Integer getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Integer usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	
}
