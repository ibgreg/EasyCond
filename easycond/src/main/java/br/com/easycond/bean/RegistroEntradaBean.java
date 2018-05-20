package br.com.easycond.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.com.easycond.model.Pessoa;
import br.com.easycond.model.RegistroEntrada;
import br.com.easycond.rn.PessoaRN;
import br.com.easycond.rn.RegistroEntradaRN;

@ManagedBean(name = "registroEntradaBean")
@RequestScoped
public class RegistroEntradaBean {

	private RegistroEntrada registroEntrada = new RegistroEntrada();

	private List<RegistroEntrada> listaRegistroEntrada;

	private List<Pessoa> listaCondomino;

	private Integer pessoaCombo;

	private Pessoa pessoa;

	@PostConstruct
	public String novo() {

		this.registroEntrada = new RegistroEntrada();

		return "/restrito/registro/registro_entrada/form_registro_entrada";
	}

	public String salvar() {

		this.pessoa = new PessoaRN().carregar(pessoaCombo);

		if (pessoa != null) {

			this.registroEntrada.setPessoa(pessoa);

			RegistroEntradaRN registroEntradaRN = new RegistroEntradaRN();

			registroEntradaRN.salvar(this.registroEntrada);
		}

		return "/restrito/registro/registro_entrada/grid_registro_entrada";
	}

	public String editar() {
		return "/restrito/registro/registro_entrada/form_registro_entrada";
	}

	public String excluir() {

		RegistroEntradaRN registroEntradaRN = new RegistroEntradaRN();
		registroEntradaRN.excluir(this.registroEntrada);
		this.listaRegistroEntrada = null;
		return null;
	}

	public List<RegistroEntrada> getListaRegistroEntrada() {
		if (this.listaRegistroEntrada == null) {

			RegistroEntradaRN registroEntradaRN = new RegistroEntradaRN();
			this.listaRegistroEntrada = registroEntradaRN.listar();
		}

		return this.listaRegistroEntrada;
	}

	public RegistroEntrada getRegistroEntrada() {
		return registroEntrada;
	}

	public void setRegistroEntrada(RegistroEntrada registroEntrada) {
		this.registroEntrada = registroEntrada;
	}

	public List<Pessoa> getListaCondominos() {
		
		if(this.listaCondomino == null) {
			
			PessoaRN pessoaRN = new PessoaRN();			
			this.listaCondomino = pessoaRN.listar('C');
		}
		
		return this.listaCondomino;
	}

	public void setCondominos(List<Pessoa> condominos) {
		this.listaCondomino = condominos;
	}

	public void setListaRegistroEntrada(List<RegistroEntrada> listaRegistroEntrada) {
		this.listaRegistroEntrada = listaRegistroEntrada;
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
