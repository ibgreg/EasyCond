package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.dao.ApartamentoDAO;
import br.com.easycond.daointerf.BlocoDAOInterf;
import br.com.easycond.model.Bloco;
import br.com.easycond.util.DAOFactory;

public class BlocoRN {

	private BlocoDAOInterf blocoDAO;

	public BlocoRN() {

		this.blocoDAO = DAOFactory.criarBlocoDAO();
	}

	public Bloco carregar(Integer id) {

		return this.blocoDAO.carregar(id);
	}

	public List<Bloco> listar() {

		return this.blocoDAO.listar();
	}

	public void salvar(Bloco bloco) {

		bloco.setApartamento(new ApartamentoRN().listar());
		
		Integer id = bloco.getId();

		if (id == null || id == 0) {
			
			this.blocoDAO.salvar(bloco);
		} else {
			
			this.blocoDAO.atualizar(bloco);
		}
	}

	public void excluir(Bloco bloco) {

		this.blocoDAO.excluir(bloco);
	}
	
}
