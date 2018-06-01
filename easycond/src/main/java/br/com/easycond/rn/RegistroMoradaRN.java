package br.com.easycond.rn;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import br.com.easycond.dao.RegistroMoradaDAO;
import br.com.easycond.daointerf.RegistroMoradaDAOInterf;
import br.com.easycond.model.RegistroMorada;
import br.com.easycond.util.DAOFactory;

public class RegistroMoradaRN {

	private RegistroMoradaDAOInterf registroMoradaDAO;

	public RegistroMoradaRN() {

		this.registroMoradaDAO = DAOFactory.criarRegistroMoradaDAO();
	}

	public RegistroMorada carregar(Integer id) {

		return this.registroMoradaDAO.carregar(id);
	}

	public List<RegistroMorada> listar() {

		return this.registroMoradaDAO.listar();
	}

	public String salvar(RegistroMorada registroMorada) {

		Integer id = registroMorada.getId();

		if (!verificarRegistroAbertoCondomino(registroMorada))
			return "O condômino " + registroMorada.getPessoa().getNomePessoa()
					+ " não pode ter mais um registro de morada, pois ele ainda não saiu do condomínio.";

		if (id == null || id == 0) {

			this.registroMoradaDAO.salvar(registroMorada);
		} else {

			this.registroMoradaDAO.atualizar(registroMorada);
		}

		return null;
	}

	public void excluir(RegistroMorada registroMorada) {

		this.registroMoradaDAO.excluir(registroMorada);
	}

	// Verificacoes de Regra de Negócio

	// Verifica se o condômino possui registro de morada sem data de saída
	private boolean verificarRegistroAbertoCondomino(RegistroMorada registroMorada) {

		Criterion criterionData = Restrictions.isNull("dataEgresso");
		Criterion criterionId = Restrictions.eq("pessoa", registroMorada.getPessoa());

		LogicalExpression lgcExpr = Restrictions.and(criterionData, criterionId);

		int quantReg = this.registroMoradaDAO.listar(criterionId).size();

		if (quantReg > 0)
			return false;

		return true;
	}
}
