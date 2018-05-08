package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.easycond.model.Funcionario;
import br.com.easycond.model.Pessoa;
import br.com.easycond.rn.FuncionarioRN;

@ManagedBean(name="funcionarioBean")
@RequestScoped
public class FuncionarioBean {

	private Funcionario funcionario;
	private Pessoa pessoa;
	
	private List<Funcionario> listaFuncionario;
	
	@PostConstruct
	public String novo() {
		
		this.funcionario = new Funcionario();
		this.pessoa = new Pessoa();
		
		return "/restrito/cadastro/funcionario/cadastro_funcionario";
	}
	
	public String salvar() {
		
		FuncionarioRN funcionarioRN = new FuncionarioRN();
		
		funcionarioRN.salvar(this.funcionario, this.pessoa);		
		
		return "restrito/home";
	}

	
	
	public List<Funcionario> getListaFuncionario() {
		if (this.listaFuncionario == null) {
			FuncionarioRN funcionarioRN = new FuncionarioRN();
			this.listaFuncionario = funcionarioRN.listar();
		}
		
		return this.listaFuncionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
