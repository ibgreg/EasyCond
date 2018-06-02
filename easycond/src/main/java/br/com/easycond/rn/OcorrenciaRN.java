package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.OcorrenciaDAOInterf;
import br.com.easycond.model.Ocorrencia;
import br.com.easycond.util.DAOFactory;

public class OcorrenciaRN {
	
	private OcorrenciaDAOInterf ocorrenciaDAO;
	
	public OcorrenciaRN() {
		this.ocorrenciaDAO = DAOFactory.criarOcorrenciaDAO();
	}
	
	public Ocorrencia carregar(Integer id) {
		return this.ocorrenciaDAO.carregar(id);
	}
	
	public List<Ocorrencia> obterOcorrenciaPorUsuario(Integer id) {
		return this.ocorrenciaDAO.obterOcorrenciaPorUsuario(id);
	}
	
	public List<Ocorrencia> listar() {
		return this.ocorrenciaDAO.listar();
	}
	
	public void salvar(Ocorrencia ocorrencia) {
		Integer id = ocorrencia.getIdOcorrencia();
		
		if (id == null || id == 0) {
			this.ocorrenciaDAO.salvar(ocorrencia);
		} else {
			this.ocorrenciaDAO.atualizar(ocorrencia);
		}
	}
	
	public void excluir(Ocorrencia ocorrencia) {
		this.ocorrenciaDAO.excluir(ocorrencia);
	}

}
