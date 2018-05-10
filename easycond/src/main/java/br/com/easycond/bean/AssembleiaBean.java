package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Assembleia;
import br.com.easycond.model.Enquete;
import br.com.easycond.rn.AssembleiaRN;

@ManagedBean(name = "assembleiaBean")
@RequestScoped
public class AssembleiaBean {
	
	private Assembleia assembleia = new Assembleia();
	private Enquete enquete = new Enquete();
	
	private String perguntaEnquete;
	private List<Assembleia> lista;
	
	@PostConstruct
	public String novo() {
		this.assembleia = new Assembleia();
		this.enquete = new Enquete();
		perguntaEnquete = null;
		return "/adm/assembleia/cadastrar";
	}
	
	public String carregarEnquete() {
		this.assembleia = new Assembleia();
		AssembleiaRN assembleiaRN = new AssembleiaRN();
		assembleia = assembleiaRN.carregarAssembleia();
		return "/restrito/assembleia/votacao";
	}
	
	
	public String salvar() {
		
		if (enquete != null) {
			assembleia.setEnquete(enquete);
			enquete.setPergunta(perguntaEnquete);
			enquete.setAssembleia(assembleia);
			//enquete.setPergunta(pergunta);
		}
		
		AssembleiaRN assembleiaRN = new AssembleiaRN();
		assembleiaRN.salvar(this.assembleia);
		
		return "/adm/assembleia/lista";
	}
	
	public String editar() {
		return "/adm/assembleia/cadastrar";
	}
	
	public String excluir() {
		AssembleiaRN assembleiaRN = new AssembleiaRN();
		assembleiaRN.excluir(this.assembleia);
		this.lista = null;
		return null;
	}

	public Assembleia getAssembleia() {
		return assembleia;
	}

	public void setAssembleia(Assembleia assembleia) {
		this.assembleia = assembleia;
	}

	public Enquete getEnquete() {
		return enquete;
	}

	public void setEnquete(Enquete enquete) {
		this.enquete = enquete;
	}
	
	public String getPerguntaEnquete() {
		return perguntaEnquete;
	}

	public void setPerguntaEnquete(String perguntaEnquete) {
		this.perguntaEnquete = perguntaEnquete;
	}

	public List<Assembleia> getLista() {
		if (this.lista == null) {
			AssembleiaRN assembleiaRN = new AssembleiaRN();
			this.lista = assembleiaRN.listar();
		}
		return this.lista;
	}
	
	
}
