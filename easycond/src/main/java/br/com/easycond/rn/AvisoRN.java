package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.AvisoDAOInterf;
import br.com.easycond.model.Aviso;
import br.com.easycond.util.DAOFactory;

public class AvisoRN {

	private AvisoDAOInterf avisoDAO;
	
	public AvisoRN() {
		this.avisoDAO = DAOFactory.criarAvisoDAO();
	}
	
	public Aviso carregar(Integer id) {
		return this.avisoDAO.carregar(id);
	}
	
	public List<Aviso> listar() {
		return this.avisoDAO.listar();
	}
	
	public List<Aviso> carregarAvisoPorOrdemId() {
		return this.avisoDAO.carregarAvisoPorOrdemId();
	}
	
	public void salvar(Aviso aviso) {
		Integer id = aviso.getId();
		
		if (id == null || id == 0) {
			this.avisoDAO.salvar(aviso);
		} else {
			this.avisoDAO.atualizar(aviso);
		}
	}
	
	public void excluir(Aviso aviso) {
		this.avisoDAO.excluir(aviso);
	}
}
