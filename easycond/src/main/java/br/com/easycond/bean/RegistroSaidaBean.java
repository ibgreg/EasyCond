package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Pessoa;
import br.com.easycond.model.RegistroSaida;
import br.com.easycond.rn.PessoaRN;
import br.com.easycond.rn.RegistroEntradaRN;
import br.com.easycond.rn.RegistroSaidaRN;

@ManagedBean(name = "registroSaidaBean")
@RequestScoped
public class RegistroSaidaBean {

	private RegistroSaida registroSaida = new RegistroSaida();

	private List<RegistroSaida> listaRegistroSaida;

	private List<Pessoa> listaCondomino;

	private Integer pessoaCombo;

	private Pessoa pessoa;

	@PostConstruct
	public String novo() {

		this.registroSaida = new RegistroSaida();

		return "/restrito/registro/registro_saida/form_registro_saida";
	}

	public String salvar() {

		this.pessoa = new PessoaRN().carregar(pessoaCombo);

		if (pessoa != null) {

			this.registroSaida.setPessoa(pessoa);

			RegistroSaidaRN registroSaidaRN = new RegistroSaidaRN();

			registroSaidaRN.salvar(this.registroSaida);

		}

		return "/restrito/registro/registro_saida/grid_registro_saida";
	}

	public String editar() {
		return "/restrito/registro/registro_saida/form_registro_saida";
	}

	public String excluir() {

		RegistroSaidaRN registroSaidaRN = new RegistroSaidaRN();
		registroSaidaRN.excluir(this.registroSaida);
		this.listaRegistroSaida = null;
		return null;
	}

	public List<RegistroSaida> getListaRegistroSaida() {
		if (this.listaRegistroSaida == null) {

			RegistroSaidaRN registroSaidaRN = new RegistroSaidaRN();
			this.listaRegistroSaida = registroSaidaRN.listar();
		}

		return this.listaRegistroSaida;
	}

	public RegistroSaida getRegistroSaida() {
		return registroSaida;
	}

	public void setRegistroSaida(RegistroSaida registroSaida) {
		this.registroSaida = registroSaida;
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

	public void setListaRegistroSaida(List<RegistroSaida> listaRegistroSaida) {
		this.listaRegistroSaida = listaRegistroSaida;
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
}
