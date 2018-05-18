package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.daointerf.EventoDAOInterf;
import br.com.easycond.model.Evento;
import br.com.easycond.util.DAOFactory;

public class EventoRN {

	private EventoDAOInterf eventoDAO;
	
	public EventoRN() {
		this.eventoDAO = DAOFactory.criarEventoDAO();
	}
	
	public Evento carregar(Integer id) {
		return this.eventoDAO.carregar(id);
	}
	
	public List<Evento> listar() {
		return this.eventoDAO.listar();
	}
	
	public void salvar(Evento evento) {
		Integer id =  evento.getId();
		
		if (id == null || id == 0) {
			this.eventoDAO.salvar(evento);
		} else {
			this.eventoDAO.atualizar(evento);
		}
	}
	
	public void excluir(Evento evento) {
		this.eventoDAO.excluir(evento);
	}
	
}
