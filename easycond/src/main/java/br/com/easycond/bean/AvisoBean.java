package br.com.easycond.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import br.com.easycond.model.Aviso;
import br.com.easycond.rn.AvisoRN;

@ManagedBean(name = "avisoBean")
@RequestScoped
public class AvisoBean {

	private Aviso aviso = new Aviso();
	private List<Aviso> lista;
	private List<Aviso> quadroAvisos;
	
	private Boolean modoVisualizar;
	
	@PostConstruct
	public String novo() {
		modoVisualizar = Boolean.FALSE;
		this.aviso = new Aviso();
		return "/adm/aviso/cadastrar";
	}
	
	public String salvar() {
 		AvisoRN avisoRN = new AvisoRN();
		
		if (aviso.getDescricao().length() <= 500) {
			avisoRN.salvar(this.aviso);
			
			return "/adm/aviso/lista";
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Limite máximo da descrição excedido", "A descrição ultrapassa o "
					+ "limite de 500 caracteres. Diminua o seu conteúdo para salvar");
			RequestContext.getCurrentInstance().showMessageInDialog(message);			
			
			return "";
		}
		
	}
	
	public String visualizar() {
		modoVisualizar = Boolean.TRUE;	
		return "/adm/aviso/cadastrar";
	}
	
	public String editar() {
		modoVisualizar = Boolean.FALSE;	
		return "/adm/aviso/cadastrar";
	}
	
	public String excluir() {
		AvisoRN avisoRN = new AvisoRN();
		avisoRN.excluir(this.aviso);
		this.lista = null;
		return null;
	}

	public Aviso getAviso() {
		return aviso;
	}

	public void setAviso(Aviso aviso) {
		this.aviso = aviso;
	}
	
	public List<Aviso> getQuadroAvisos() {
		if (this.quadroAvisos == null) {
			AvisoRN avisoRN = new AvisoRN();
			this.quadroAvisos = avisoRN.carregarAvisoPorOrdemId();
		}
		return this.quadroAvisos;
	}

	public List<Aviso> getLista() {
		if (this.lista == null) {
			AvisoRN avisoRN = new AvisoRN();
			this.lista = avisoRN.listar();
		}
		return this.lista;
	}

	public Boolean getModoVisualizar() {
		return modoVisualizar;
	}

	public void setModoVisualizar(Boolean modoVisualizar) {
		this.modoVisualizar = modoVisualizar;
	}

}
