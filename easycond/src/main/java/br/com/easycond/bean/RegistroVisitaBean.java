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

	private List<Pessoa> listaCondomino;

	private Integer visitanteCombo;

	private Integer condominoCombo;

	private Pessoa pessoa;

	private Pessoa pessoa2;

	@PostConstruct
	public String novo() {

		this.registroVisita = new RegistroVisita();

		return "/restrito/registro/registro_visita/form_registro_visita";
	}

	public String salvar() {

		if (!verificarCombos())
			return null;

		this.pessoa = new PessoaRN().carregar(visitanteCombo);
		this.pessoa2 = new PessoaRN().carregar(condominoCombo);

		if (!verificarData())
			return null;

		if (pessoa != null) {

			this.registroVisita.setPessoa(pessoa);

			this.registroVisita.setPessoa2(pessoa2);

			RegistroVisitaRN registroVisitaRN = new RegistroVisitaRN();

			registroVisitaRN.salvar(this.registroVisita);
		}
		
		// Seria legal exibir uma mensagem confirmando o salvamento do registro no banco
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro salvo com sucesso."));

		return "/restrito/registro/registro_visita/grid_registro_visita";
	}

	public String editar() {

		this.visitanteCombo = this.registroVisita.getPessoa().getIdPessoa();

		this.condominoCombo = this.registroVisita.getPessoa2().getIdPessoa();

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

	public Integer getVisitanteCombo() {
		return visitanteCombo;
	}

	public void setVisitanteCombo(Integer visitanteCombo) {
		this.visitanteCombo = visitanteCombo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListaCondomino() {
		return listaCondomino;
	}

	public void setListaCondomino(List<Pessoa> listaCondomino) {
		this.listaCondomino = listaCondomino;
	}

	public Pessoa getPessoa2() {
		return pessoa2;
	}

	public void setPessoa2(Pessoa pessoa2) {
		this.pessoa2 = pessoa2;
	}

	public List<Pessoa> getListaCondominos() {

		if (this.listaCondomino == null) {

			PessoaRN pessoaRN = new PessoaRN();
			this.listaCondomino = pessoaRN.listar('C');
		}

		return this.listaCondomino;
	}

	// Validacoes

	public Integer getCondominoCombo() {
		return condominoCombo;
	}

	public void setCondominoCombo(Integer condominoCombo) {
		this.condominoCombo = condominoCombo;
	}

	private boolean verificarData() {

		Date dtInicio = registroVisita.getDataInicioVisita();
		Date dtFim = registroVisita.getDataFimVisita();

		if (dtInicio.compareTo(dtFim) > 0) {
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"A data inicial não pode ser maior do que a data final.", null));

			return false;
		}

		return true;
	}

	private boolean verificarCombos() {

		if (visitanteCombo == null) {
			FacesContext.getCurrentInstance().addMessage("msg",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, selecione um visitante.", null));

			return false;
		}

		if (condominoCombo == null) {
			FacesContext.getCurrentInstance().addMessage("msg",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, selecione um condômino.", null));

			return false;
		}

		return true;
	}
}
