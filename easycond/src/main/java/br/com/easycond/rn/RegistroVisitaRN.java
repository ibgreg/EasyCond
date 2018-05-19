package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.RegistroVisitaDAOInterf;
import br.com.easycond.model.RegistroVisita;
import br.com.easycond.util.DAOFactory;

public class RegistroVisitaRN {

	private RegistroVisitaDAOInterf registroVisitaDAO;

	public RegistroVisitaRN() {

		this.registroVisitaDAO = DAOFactory.criarRegistroVisitaDAO();
	}

	public RegistroVisita carregar(Integer id) {

		return this.registroVisitaDAO.carregar(id);
	}

	public List<RegistroVisita> listar() {

		return this.registroVisitaDAO.listar();
	}

	public void salvar(RegistroVisita registroVisita) {

		Integer id = registroVisita.getId();

		if (id == null || id == 0) {
			
			this.registroVisitaDAO.salvar(registroVisita);
		} else {
			
			this.registroVisitaDAO.atualizar(registroVisita);
		}
	}

	public void excluir(RegistroVisita registroVisita) {

		this.registroVisitaDAO.excluir(registroVisita);
	}
	
}
