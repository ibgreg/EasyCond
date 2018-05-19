package br.com.easycond.rn;

import java.util.Date;
import java.util.List;

import br.com.easycond.daointerf.ReservaDAOInterf;
import br.com.easycond.model.Reserva;
import br.com.easycond.util.DAOFactory;

public class ReservaRN {
	
	private ReservaDAOInterf reservaDAO;
	
	public ReservaRN() {
		this.reservaDAO = DAOFactory.criarReservaDAO();
	}
	
	public Reserva carregar(Integer id) {
		return this.reservaDAO.carregar(id);
	}
	
	public List<Reserva> listar() {
		return this.reservaDAO.listar();
	}
	
	public void salvar(Reserva reserva) {
		Integer id = reserva.getId();
		
		if (id == null || id == 0) {
			this.reservaDAO.salvar(reserva);
		} else {
			this.reservaDAO.atualizar(reserva);
		}
	}
	
	public void excluir(Reserva reserva) {
		this.reservaDAO.excluir(reserva);
	}

	public boolean verificaReservaExistente(Integer idEspacoFisico, Date dataInicio, Date dataFim) {
		Reserva reservaExistente = this.reservaDAO.verificaReservaExistente(idEspacoFisico, dataInicio, dataFim);
		
		if (reservaExistente != null) {
			return true;
		} else {
			return false;
		}
	}
}
