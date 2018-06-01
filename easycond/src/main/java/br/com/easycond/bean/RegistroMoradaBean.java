package br.com.easycond.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.easycond.model.Pessoa;
import br.com.easycond.model.RegistroMorada;
import br.com.easycond.rn.PessoaRN;
import br.com.easycond.rn.RegistroMoradaRN;

@ManagedBean(name = "registroMoradaBean")
@RequestScoped
public class RegistroMoradaBean {

	private RegistroMorada registroMorada = new RegistroMorada();

	private List<RegistroMorada> listaRegistroMorada;

	private List<Pessoa> listaCondomino;

	private Integer pessoaCombo;

	private Pessoa pessoa;

	@PostConstruct
	public String novo() {

		this.registroMorada = new RegistroMorada();

		return "/restrito/registro/registro_morada/form_registro_morada";
	}

	public String salvar() {

		if (!validarCondomino())
			return null;

		this.pessoa = new PessoaRN().carregar(pessoaCombo);

		if (!validarData())
			return null;

		if (pessoa != null) {

			this.registroMorada.setPessoa(pessoa);

			RegistroMoradaRN registroMoradaRN = new RegistroMoradaRN();

			String msgRN = registroMoradaRN.salvar(this.registroMorada);

			if (msgRN != null) {

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(msgRN));
				
				return null;
			}
		}

		return "/restrito/registro/registro_morada/grid_registro_morada";
	}

	public String editar() {

		this.pessoaCombo = this.registroMorada.getPessoa().getIdPessoa();

		return "/restrito/registro/registro_morada/form_registro_morada";
	}

	public String excluir() {

		RegistroMoradaRN registroMoradaRN = new RegistroMoradaRN();
		registroMoradaRN.excluir(this.registroMorada);
		this.listaRegistroMorada = null;
		return null;
	}

	public List<RegistroMorada> getListaRegistroMorada() {
		if (this.listaRegistroMorada == null) {

			RegistroMoradaRN registroMoradaRN = new RegistroMoradaRN();
			this.listaRegistroMorada = registroMoradaRN.listar();
		}

		return this.listaRegistroMorada;
	}

	public RegistroMorada getRegistroMorada() {
		return registroMorada;
	}

	public void setRegistroMorada(RegistroMorada registroMorada) {
		this.registroMorada = registroMorada;
	}

	public List<Pessoa> getListaCondominos() {

		if (this.listaCondomino == null) {

			PessoaRN pessoaRN = new PessoaRN();
			this.listaCondomino = pessoaRN.listar('C');
		}

		return this.listaCondomino;
	}

	public void setCondominos(List<Pessoa> condominos) {
		this.listaCondomino = condominos;
	}

	public void setListaRegistroMorada(List<RegistroMorada> listaRegistroMorada) {
		this.listaRegistroMorada = listaRegistroMorada;
	}

	public List<Pessoa> getListaCondomino() {
		return listaCondomino;
	}

	public void setListaCondomino(List<Pessoa> listaCondomino) {
		this.listaCondomino = listaCondomino;
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

	// Validacoes de campos

	private boolean validarData() {

		Date dtEntrada = this.registroMorada.getDataIngresso();
		Date dtSaida = this.registroMorada.getDataEgresso();

		if (dtEntrada == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					"Para que um registro de morada seja feito, deve ser informada ao menos a data de entrada do condômino."));
			return false;
		}

		if (dtSaida != null) {
			if (dtEntrada.compareTo(dtSaida) > 0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("A data de entrada não pode ser maior do que a data de saída."));
				return false;
			}

			if (dtEntrada.compareTo(dtSaida) == 0) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Um condômino não pode entrar e sair no mesmo dia."));
				return false;
			}
		}

		return true;
	}

	private boolean validarCondomino() {

		if (pessoaCombo == null) {
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage("Por favor, selecione um condômino."));

			return false;
		}

		return true;
	}
}
