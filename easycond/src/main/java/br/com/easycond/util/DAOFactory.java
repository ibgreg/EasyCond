package br.com.easycond.util;

import br.com.easycond.dao.ApartamentoDAO;
import br.com.easycond.dao.AssembleiaDAO;
import br.com.easycond.dao.AvisoDAO;
import br.com.easycond.dao.BlocoDAO;
import br.com.easycond.dao.CasaDAO;
import br.com.easycond.dao.CondominoDAO;
import br.com.easycond.dao.EspacoFisicoDAO;
import br.com.easycond.dao.EventoDAO;
import br.com.easycond.dao.FuncionarioDAO;
import br.com.easycond.dao.PessoaDAO;
import br.com.easycond.dao.RegistroEntradaDAO;
import br.com.easycond.dao.ReservaDAO;
import br.com.easycond.dao.SolicitacaoAvisoDAO;
import br.com.easycond.dao.UsuarioDAO;
import br.com.easycond.dao.VotosDAO;
import br.com.easycond.daointerf.ApartamentoDAOInterf;
import br.com.easycond.daointerf.AssembleiaDAOInterf;
import br.com.easycond.daointerf.AvisoDAOInterf;
import br.com.easycond.daointerf.BlocoDAOInterf;
import br.com.easycond.daointerf.CasaDAOInterf;
import br.com.easycond.daointerf.CondominoDAOInterf;
import br.com.easycond.daointerf.EspacoFisicoDAOInterf;
import br.com.easycond.daointerf.EventoDAOInterf;
import br.com.easycond.daointerf.FuncionarioDAOInterf;
import br.com.easycond.daointerf.PessoaDAOInterf;
import br.com.easycond.daointerf.RegistroEntradaDAOInterf;
import br.com.easycond.daointerf.ReservaDAOInterf;
import br.com.easycond.daointerf.SolicitacaoAvisoDAOInterf;
import br.com.easycond.daointerf.UsuarioDAOInterf;
import br.com.easycond.daointerf.VotosDAOInterf;

public class DAOFactory {

	public static UsuarioDAOInterf criarUsuarioDAO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

	public static AvisoDAOInterf criarAvisoDAO() {
		AvisoDAO avisoDAO = new AvisoDAO();
		avisoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return avisoDAO;
	}

	public static AssembleiaDAOInterf criarAssembleiaDAO() {
		AssembleiaDAO assembleiaDAO = new AssembleiaDAO();
		assembleiaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return assembleiaDAO;
	}

	public static CondominoDAOInterf criarCondominoDAO() {

		CondominoDAO condominoDAO = new CondominoDAO();
		condominoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return condominoDAO;
	}

	public static FuncionarioDAOInterf criarFuncionarioDAO() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return funcionarioDAO;
	}

	public static PessoaDAOInterf criarPessoaDAO() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return pessoaDAO;
	}

	public static SolicitacaoAvisoDAOInterf criarSolicitacaoAvisoDAO() {

		SolicitacaoAvisoDAO solicitacaoAvisoDAO = new SolicitacaoAvisoDAO();
		solicitacaoAvisoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return solicitacaoAvisoDAO;
	}

	public static CasaDAOInterf criarCasaDAO() {

		CasaDAO casaDAO = new CasaDAO();
		casaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return casaDAO;
	}

	public static BlocoDAOInterf criarBlocoDAO() {

		BlocoDAO blocoDAO = new BlocoDAO();
		blocoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return blocoDAO;
	}

	public static ApartamentoDAOInterf criarApartamentoDAO() {

		ApartamentoDAO apartamentoDAO = new ApartamentoDAO();
		apartamentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return apartamentoDAO;
	}

	public static VotosDAOInterf criarVotosDAO() {
		VotosDAO votosDAO = new VotosDAO();
		votosDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());

		return votosDAO;
	}

	public static ReservaDAOInterf criarReservaDAO() {
		ReservaDAO reservaDAO = new ReservaDAO();
		reservaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return reservaDAO;
	}

	public static EspacoFisicoDAOInterf criarEspacoFisicoDAO() {
		EspacoFisicoDAO espacoFisicoDAO = new EspacoFisicoDAO();
		espacoFisicoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return espacoFisicoDAO;
	}

	public static RegistroEntradaDAOInterf criarRegistroEntradaDAO() {
		RegistroEntradaDAO registroEntradaDAO = new RegistroEntradaDAO();
		registroEntradaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return registroEntradaDAO;
	}

	public static EventoDAOInterf criarEventoDAO() {
		EventoDAO eventoDAO = new EventoDAO();
		eventoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return eventoDAO;
	}

    public static RegistroSaidaDAOInterf criarRegistroSaidaDAO() {
    	RegistroSaidaDAO registroSaidaDAO = new RegistroSaidaDAO();
    	registroSaidaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
    	return registroSaidaDAO;
    }
    
}
