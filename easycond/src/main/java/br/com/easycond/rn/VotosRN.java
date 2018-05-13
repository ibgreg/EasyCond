package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.VotosDAOInterf;
import br.com.easycond.model.Votos;
import br.com.easycond.util.DAOFactory;

public class VotosRN {

	private VotosDAOInterf votosDAO;
	
	public VotosRN() {
		this.votosDAO = DAOFactory.criarVotosDAO();
	}
	
	public Votos carregar(Integer id) {
		return this.votosDAO.carregar(id);
	}
	
	public List<Votos> carregarVotosContraEnquete(Integer id) {
		return this.votosDAO.listarVotosContra(id);
	}
	
	public List<Votos> carregarVotosFavorEnquete(Integer id) {
		return this.votosDAO.listarVotosFavor(id);
	}
	
	public List<Votos> listar() {
		return this.votosDAO.listar();
	}
	
	public void salvar(Votos votos) {
		Integer id = votos.getId();
		
		if (id == null || id == 0) {
			this.votosDAO.salvar(votos);
		} else {
			this.votosDAO.atualizar(votos);
		}
	}
}
