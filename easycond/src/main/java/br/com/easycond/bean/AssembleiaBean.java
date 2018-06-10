package br.com.easycond.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.model.chart.PieChartModel;

import br.com.easycond.model.Assembleia;
import br.com.easycond.model.Enquete;
import br.com.easycond.model.Votos;
import br.com.easycond.rn.AssembleiaRN;
import br.com.easycond.rn.VotosRN;
import br.com.easycond.util.SpringUtil;

@ManagedBean(name = "assembleiaBean")
@RequestScoped
public class AssembleiaBean {
	
	private Assembleia assembleia = new Assembleia();
	private Enquete enquete = new Enquete();
	private Votos votos = new Votos();
	
	private String perguntaEnquete;
	private Date dataAtual = new Date();
	
	private List<Assembleia> lista;
	private List<Votos> listaVotosContra;
	private List<Votos> listaVotosFavor;
	
	private PieChartModel graficoVotos;
	
	private Boolean modoVisualizar;
	
	@PostConstruct
	public String novo() {
		modoVisualizar = Boolean.FALSE;
		this.assembleia = new Assembleia();
		this.enquete = new Enquete();
		perguntaEnquete = null;
		return "/adm/assembleia/cadastrar";
	}
	
	public String carregarEnquete() {
		this.assembleia = new Assembleia();
		this.votos = new Votos();
		AssembleiaRN assembleiaRN = new AssembleiaRN();
		assembleia = assembleiaRN.carregarAssembleia();
		return "/restrito/assembleia/votacao";
	}
	
	public String carregarListaVotos() {
		this.assembleia = new Assembleia();
		this.votos =  new Votos();
		AssembleiaRN assembleiaRN = new AssembleiaRN();
		VotosRN votosRN = new VotosRN();
		assembleia = assembleiaRN.carregarAssembleia();
		
		if (assembleia != null) {
			if (this.listaVotosContra == null) {
				this.listaVotosContra = votosRN.carregarVotosContraEnquete(assembleia.getEnquete().getId());
			}
			
			if (this.listaVotosFavor == null) {
				this.listaVotosFavor = votosRN.carregarVotosFavorEnquete(assembleia.getEnquete().getId());
			}
			
			carregarGrafico();
		}
		
		return "/restrito/assembleia/resultado";
		
	}
	
	public PieChartModel carregarGrafico() {
		graficoVotos = new PieChartModel();
		
		graficoVotos.getData().put("A Favor", listaVotosFavor.size());
		graficoVotos.getData().put("Contra", listaVotosContra.size());
		
		graficoVotos.setTitle("Resultado");
		graficoVotos.setLegendPosition("w");
		
		return graficoVotos;
	}
	
	public String salvar() {
		AssembleiaRN assembleiaRN = new AssembleiaRN();
		
		if (!assembleiaRN.verificaAssembleiaExistente(assembleia.getId(), assembleia.getDataInicio(), assembleia.getDataFim())) {
			
			if (enquete != null) {

				enquete.setAssembleia(assembleia);
				assembleia.setEnquete(this.enquete);
			}
			
			
			assembleiaRN.salvar(this.assembleia);
			
			return "/adm/assembleia/lista";
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar", "Existe uma assembleia registrada nesse periodo!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);			
			
			return "";
		}
		
	}
	
	public String enviarVoto() {
		AssembleiaRN assembleiaRN = new AssembleiaRN();
		assembleia = assembleiaRN.carregarAssembleia();
		votos.setIdEnquete(assembleia.getEnquete());
		votos.setUsuario(SpringUtil.obterUsuarioLogado());
		VotosRN votosRN = new VotosRN();
		
		if (!votosRN.verificaVotoExistente(votos.getIdEnquete().getId(), votos.getUsuario())) {
			votosRN.salvar(this.votos);
			carregarListaVotos();
		
			return "/restrito/assembleia/resultado";
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao enviar o voto", "Você já votou nesta enquete!");
			RequestContext.getCurrentInstance().showMessageInDialog(message);			
			
			return "";
		}
		
	}
	
	public String visualizar() {
		enquete = assembleia.getEnquete();
		modoVisualizar = Boolean.TRUE;
		return "/adm/assembleia/cadastrar";
	}
	
	public String editar() {
		enquete = assembleia.getEnquete();
		modoVisualizar = Boolean.FALSE;
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
	
	public Votos getVotos() {
		return votos;
	}

	public void setVotos(Votos votos) {
		this.votos = votos;
	}

	public String getPerguntaEnquete() {
		return perguntaEnquete;
	}

	public void setPerguntaEnquete(String perguntaEnquete) {
		this.perguntaEnquete = perguntaEnquete;
	}

	public PieChartModel getGraficoVotos() {
		return graficoVotos;
	}

	public void setGraficoVotos(PieChartModel graficoVotos) {
		this.graficoVotos = graficoVotos;
	}

	public List<Assembleia> getLista() {
		if (this.lista == null) {
			AssembleiaRN assembleiaRN = new AssembleiaRN();
			this.lista = assembleiaRN.listar();
		}
		return this.lista;
	}

	public List<Votos> getListaVotosContra() {
		return listaVotosContra;
	}

	public void setListaVotosContra(List<Votos> listaVotosContra) {
		this.listaVotosContra = listaVotosContra;
	}

	public List<Votos> getListaVotosFavor() {
		return listaVotosFavor;
	}

	public void setListaVotosFavor(List<Votos> listaVotosFavor) {
		this.listaVotosFavor = listaVotosFavor;
	}

	public Boolean getModoVisualizar() {
		return modoVisualizar;
	}

	public void setModoVisualizar(Boolean modoVisualizar) {
		this.modoVisualizar = modoVisualizar;
	}

	public Date getDataAtual() {
		return dataAtual;
	}
	
}
