package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.RegistroEntradaDAOInterf;
import br.com.easycond.model.RegistroEntrada;
import br.com.easycond.util.DAOFactory;

public class RegistroEntradaRN {

	private RegistroEntradaDAOInterf registroEntradaDAO;

	public RegistroEntradaRN() {

		this.registroEntradaDAO = DAOFactory.criarRegistroEntradaDAO();
	}

	public RegistroEntrada carregar(Integer id) {

		return this.registroEntradaDAO.carregar(id);
	}

	public List<RegistroEntrada> listar() {

		return this.registroEntradaDAO.listar();
	}

	public void salvar(RegistroEntrada registroEntrada) {

		Integer id = registroEntrada.getId();

		if (id == null || id == 0) {
			
			this.registroEntradaDAO.salvar(registroEntrada);
		} else {
			
			this.registroEntradaDAO.atualizar(registroEntrada);
		}
	}

	public void excluir(RegistroEntrada registroEntrada) {

		this.registroEntradaDAO.excluir(registroEntrada);
	}		
}
