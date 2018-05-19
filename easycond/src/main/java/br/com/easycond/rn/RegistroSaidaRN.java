package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.RegistroSaidaDAOInterf;
import br.com.easycond.model.RegistroSaida;
import br.com.easycond.util.DAOFactory;

public class RegistroSaidaRN {

	private RegistroSaidaDAOInterf registroSaidaDAO;

	public RegistroSaidaRN() {

		this.registroSaidaDAO = DAOFactory.criarRegistroSaidaDAO();
	}

	public RegistroSaida carregar(Integer id) {

		return this.registroSaidaDAO.carregar(id);
	}

	public List<RegistroSaida> listar() {

		return this.registroSaidaDAO.listar();
	}

	public void salvar(RegistroSaida registroSaida) {

		Integer id = registroSaida.getId();

		if (id == null || id == 0) {
			
			this.registroSaidaDAO.salvar(registroSaida);
		} else {
			
			this.registroSaidaDAO.atualizar(registroSaida);
		}
	}

	public void excluir(RegistroSaida registroSaida) {

		this.registroSaidaDAO.excluir(registroSaida);
	}		
}
