package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.ApartamentoDAOInterf;
import br.com.easycond.model.Apartamento;
import br.com.easycond.util.DAOFactory;

public class ApartamentoRN {

	private ApartamentoDAOInterf apartamentoDAO;

	public ApartamentoRN() {

		this.apartamentoDAO = DAOFactory.criarApartamentoDAO();
	}

	public Apartamento carregar(Integer id) {

		return this.apartamentoDAO.carregar(id);
	}

	public List<Apartamento> listar() {

		return this.apartamentoDAO.listar();
	}

	public void salvar(Apartamento apartamento) {

		Integer id = apartamento.getId();

		if (id == null || id == 0) {
			
			this.apartamentoDAO.salvar(apartamento);
		} else {
			
			this.apartamentoDAO.atualizar(apartamento);
		}
	}

	public void excluir(Apartamento apartamento) {

		this.apartamentoDAO.excluir(apartamento);
	}
	
}
