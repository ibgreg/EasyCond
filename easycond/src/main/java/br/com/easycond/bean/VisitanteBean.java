package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Pessoa;
import br.com.easycond.rn.PessoaRN;

@ManagedBean(name="visitanteBean")
@RequestScoped
public class VisitanteBean {

	private Pessoa pessoa = new Pessoa();
	
	private List<Pessoa> listaPessoa;
	
	private static final char TIPO_PESSOA_VISITANTE = 'V';
	
	@PostConstruct
	public String novo() {
		
		this.pessoa = new Pessoa();
		
		return "/restrito/cadastro/visita/form_visitante";
	}
	
	public String salvar() {
		
		PessoaRN pessoaRN = new PessoaRN();
		
		this.pessoa.setTipoPessoa(TIPO_PESSOA_VISITANTE);
		
		pessoaRN.salvar(this.pessoa);	
		
		return "/restrito/cadastro/visita/grid_visitante";
	}	
	
	public String editar() {
		return "/restrito/cadastro/visita/form_visitante";
	}

	public String excluir() {
		
		PessoaRN pessoaRN = new PessoaRN();
		pessoaRN.excluir(this.pessoa);
		this.listaPessoa = null;
		return null;
	}
	
	public List<Pessoa> getListaPessoa() {
		if (this.listaPessoa == null) {
			PessoaRN pessoaRN = new PessoaRN();
			this.listaPessoa = pessoaRN.listar(TIPO_PESSOA_VISITANTE);
		}
		
		return this.listaPessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}	
	
}
