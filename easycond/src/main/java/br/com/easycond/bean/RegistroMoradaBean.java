package br.com.easycond.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.easycond.model.Imovel;
import br.com.easycond.model.Pessoa;
import br.com.easycond.model.RegistroMorada;
import br.com.easycond.rn.ImovelRN;
import br.com.easycond.rn.PessoaRN;
import br.com.easycond.rn.RegistroMoradaRN;

@ManagedBean(name = "registroMoradaBean")
@RequestScoped
public class RegistroMoradaBean {

	private RegistroMorada registroMorada = new RegistroMorada();

	private List<RegistroMorada> listaRegistroMorada;

	private List<Pessoa> listaCondomino;

	private List<Imovel> listaImovel;

	private Integer pessoaCombo;

	private Integer imovelCombo;

	private Integer imovelAntigo;
	
	private Pessoa pessoa;

	private Imovel imovel;

	@PostConstruct
	public String novo() {

		this.registroMorada = new RegistroMorada();

		return "/restrito/registro/registro_morada/form_registro_morada";
	}

	public String salvar() {

		if (!validarCondomino())
			return null;

		this.pessoa = new PessoaRN().carregar(pessoaCombo);

		if (!validarImovel())
			return null;

		this.imovel = new ImovelRN().carregar(imovelCombo);
		
		if (!validarData())
			return null;

		if (pessoa != null) {

			this.registroMorada.setPessoa(pessoa);
			
			this.imovel.setOcupante(pessoa);	
			
			this.registroMorada.setImovel(imovel);
			
			if(imovelAntigo != imovelCombo && registroMorada.getId() != null)
			{
				Imovel imv = new ImovelRN().carregar(imovelAntigo);
				
				imv.setOcupante(null);
				
				new ImovelRN().salvar(imv);
			}
			
			new ImovelRN().salvar(imovel);
			
			RegistroMoradaRN registroMoradaRN = new RegistroMoradaRN();

			String msgRN = registroMoradaRN.salvar(this.registroMorada);

			if (msgRN != null) {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgRN));

				return null;
			}
		}

		return "/restrito/registro/registro_morada/grid_registro_morada";
	}

	public String editar() {
		
		this.imovelAntigo = this.registroMorada.getImovel().getId();
		
		Integer idImovel = this.registroMorada.getImovel().getId();

		this.listaImovel = new ImovelRN().listarImoveisDesocupadosMaisODoCarinha(idImovel);
		
		this.pessoaCombo = this.registroMorada.getPessoa().getIdPessoa();
		this.imovelCombo = idImovel;
		
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

	public List<Imovel> getListaImoveis() {

		if (this.listaImovel == null) {

			ImovelRN imovelRN = new ImovelRN();
			this.listaImovel = imovelRN.listarImoveisDesocupados();
		}

		return this.listaImovel;
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

	public List<Imovel> getListaImovel() {
		return listaImovel;
	}

	public void setListaImovel(List<Imovel> listaImovel) {
		this.listaImovel = listaImovel;
	}

	public Integer getImovelCombo() {
		return imovelCombo;
	}

	public void setImovelCombo(Integer imovelCombo) {
		this.imovelCombo = imovelCombo;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}	
	
	// Validacoes de campos

	public Integer getImovelAntigo() {
		return imovelAntigo;
	}

	public void setImovelAntigo(Integer imovelAntigo) {
		this.imovelAntigo = imovelAntigo;
	}

	private boolean validarData() {

		Date dtEntrada = this.registroMorada.getDataIngresso();
		Date dtSaida = this.registroMorada.getDataEgresso();

		if (dtEntrada == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Para que um registro de morada seja feito, deve ser informada ao menos a data de entrada do condômino.",
					null));
			return false;
		}

		if (dtSaida != null) {
			if (dtEntrada.compareTo(dtSaida) > 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"A data de entrada não pode ser maior do que a data de saída.", null));
				return false;
			}

			if (dtEntrada.compareTo(dtSaida) == 0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Um condômino não pode entrar e sair no mesmo dia.", null));
				return false;
			}
		}

		return true;
	}

	private boolean validarCondomino() {

		if (pessoaCombo == null) {
			FacesContext.getCurrentInstance().addMessage("msg",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, selecione um condômino.", null));

			return false;
		}

		return true;
	}

	private boolean validarImovel() {

		if (imovelCombo == null) {
			FacesContext.getCurrentInstance().addMessage("msg",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Por favor, selecione um imóvel.", null));

			return false;
		}

		return true;
	}
}
