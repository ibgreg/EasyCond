package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.CondominoDAOInterf;
import br.com.easycond.model.Condomino;
import br.com.easycond.util.DAOFactory;

public class CondominoRN {

	private CondominoDAOInterf condominoDAO;
	
	public CondominoRN() {
		
		this.condominoDAO = DAOFactory.criarCondominoDAO();
	}
	
	public Condomino carregar(Integer id) {
		
		return this.condominoDAO.carregar(id);
	}
	
	public List<Condomino> listar(){
		
		return this.condominoDAO.listar();
	}
	
	public void salvar(Condomino condomino) {
		
		Integer id = condomino.getIdCondomino();
		
		if(id == null || id == 0) 			
			this.condominoDAO.salvar(condomino);		
		else 		
			this.condominoDAO.atualizar(condomino);
	}
	
	public void excluir(Condomino condomino) {
		
		this.condominoDAO.excluir(condomino);
	}
}
