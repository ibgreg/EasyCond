package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.CasaDAOInterf;
import br.com.easycond.model.Casa;
import br.com.easycond.util.DAOFactory;

public class CasaRN {

	private CasaDAOInterf casaDAO;

	public CasaRN() {

		this.casaDAO = DAOFactory.criarCasaDAO();
	}

	public Casa carregar(Integer id) {

		return this.casaDAO.carregar(id);
	}

	public List<Casa> listar() {

		return this.casaDAO.listar();
	}

	public void salvar(Casa casa) {

		Integer id = casa.getId();

		if (id == null || id == 0) {
			
			this.casaDAO.salvar(casa);
		} else {
			
			this.casaDAO.atualizar(casa);
		}
	}

	public void excluir(Casa casa) {

		this.casaDAO.excluir(casa);
	}
	
}
