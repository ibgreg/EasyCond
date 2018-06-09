package br.com.easycond.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.easycond.model.Pessoa;
import br.com.easycond.model.RegistroVisita;
import br.com.easycond.rn.PessoaRN;
import br.com.easycond.rn.RegistroVisitaRN;
import br.com.easycond.rn.RegistroVisitaRN;

@ManagedBean(name = "registroVisitaBean")
@RequestScoped
public class RegistroVisitaBean {

	private RegistroVisita registroVisita = new RegistroVisita();

	private List<RegistroVisita> listaRegistroVisita;

	private List<Pessoa> listaVisitante;

	private Integer pessoaCombo;

	private Pessoa pessoa;

	@PostConstruct
	public String novo() {

		this.registroVisita = new RegistroVisita();

		return "/restrito/registro/registro_visita/form_registro_visita";
	}

	public String salvar() {
		
		if (!verificarVisitante())
			return null;

		this.pessoa = new PessoaRN().carregar(pessoaCombo);		

		if (!verificarData())
			return null;

		if (pessoa != null) {

			this.registroVisita.setPessoa(pessoa);

			RegistroVisitaRN registroVisitaRN = new RegistroVisitaRN();

			registroVisitaRN.salvar(this.registroVisita);
		}

		return "/restrito/registro/registro_visita/grid_registro_visita";
	}

	public String editar() {
		
		this.pessoaCombo = this.registroVisita.getPessoa().getIdPessoa();
		
		return "/restrito/registro/registro_visita/form_registro_visita";
	}

	public String excluir() {

		RegistroVisitaRN registroVisitaRN = new RegistroVisitaRN();
		registroVisitaRN.excluir(this.registroVisita);
		this.listaRegistroVisita = null;
		return null;
	}

	public List<RegistroVisita> getListaRegistroVisita() {
		if (this.listaRegistroVisita == null) {

			RegistroVisitaRN registroVisitaRN = new RegistroVisitaRN();
			this.listaRegistroVisita = registroVisitaRN.listar();
		}

		return this.listaRegistroVisita;
	}

	public RegistroVisita getRegistroVisita() {
		return registroVisita;
	}

	public void setRegistroVisita(RegistroVisita registroVisita) {
		this.registroVisita = registroVisita;
	}

	public List<Pessoa> getListaVisitantes() {

		if (this.listaVisitante == null) {

			PessoaRN pessoaRN = new PessoaRN();
			this.listaVisitante = pessoaRN.listar('V');
		}

		return this.listaVisitante;
	}

	public void setVisitantes(List<Pessoa> visitantes) {
		this.listaVisitante = visitantes;
	}

	public void setListaRegistroVisita(List<RegistroVisita> listaRegistroVisita) {
		this.listaRegistroVisita = listaRegistroVisita;
	}

	public List<Pessoa> getListaVisitante() {
		return listaVisitante;
	}

	public void setListaVisitante(List<Pessoa> listaVisitante) {
		this.listaVisitante = listaVisitante;
	}

	public Integer getPessoaCombo() {
		return pessoaCombo;
	}

	public void setPessoaCombo(Integer pessoaCombo) {
		this.pessoaCombo = pessoaCombo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	// Validacoes

	private boolean verificarData() {

		Date dtInicio = registroVisita.getDataInicioVisita();
		Date dtFim = registroVisita.getDataFimVisita();

		if (dtInicio.compareTo(dtFim) > 0) {
			FacesContext.getCurrentInstance().addMessage("msg",
					new FacesMessage("A data inicial não pode ser maior do que a data final."));

			return false;
		}

		return true;
	}

	private boolean verificarVisitante() {

		if (pessoaCombo == null) {
			FacesContext.getCurrentInstance().addMessage("msg",
					new FacesMessage("Por favor, selecione um visitante."));

			return false;
		}
		
		return true;
	}
}
