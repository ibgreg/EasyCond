package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Pessoa;
import br.com.easycond.rn.PessoaRN;

@ManagedBean(name="condominoBean")
@RequestScoped
public class CondominoBean {

	private Pessoa pessoa = new Pessoa();
	
	private List<Pessoa> listaCondomino;
	
	@PostConstruct
	public String novo() {
		
		this.pessoa = new Pessoa();
		
		return "/restrito/cadastro/condomino/form_condomino";
	}
	
	public String salvar() {
		
		PessoaRN pessoaRN = new PessoaRN();
		
		this.pessoa.setTipoPessoa('C');
		
		pessoaRN.salvar(this.pessoa);	
		
		return "/restrito/cadastro/condomino/grid_condomino";
	}	
	
	public String editar() {
		return "/restrito/cadastro/condomino/form_condomino";
	}

	public String excluir() {
		
		PessoaRN pessoaRN = new PessoaRN();
		pessoaRN.excluir(this.pessoa);
		this.listaCondomino = null;
		return null;
	}
	
	public List<Pessoa> getListaCondomino() {
		if (this.listaCondomino == null) {
			PessoaRN pessoaRN = new PessoaRN();
			this.listaCondomino = pessoaRN.listar();
		}
		
		return this.listaCondomino;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setListaCondomino(List<Pessoa> listaCondomino) {
		this.listaCondomino = listaCondomino;
	}	
}
