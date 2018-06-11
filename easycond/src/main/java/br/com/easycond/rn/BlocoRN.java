package br.com.easycond.rn;

import java.util.List;

import br.com.easycond.dao.ApartamentoDAO;
import br.com.easycond.daointerf.BlocoDAOInterf;
import br.com.easycond.daointerf.ImovelDAOInterf;
import br.com.easycond.model.Bloco;
import br.com.easycond.model.Imovel;
import br.com.easycond.util.DAOFactory;

public class BlocoRN {

	private final static char TIPO_IMOVEL = 'A';
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

		//bloco.setApartamento(new ApartamentoRN().listar());

		Integer id = bloco.getId();

		if (id == null || id == 0) {

			this.blocoDAO.salvar(bloco);

			ImovelRN imovelRN = new ImovelRN();

			Imovel imovel;

			List<Imovel> imoveis = imovelRN.listarDistinctAp(TIPO_IMOVEL);

			for (Imovel imv : imoveis){

				imovel = new Imovel();
				
				imovel.setTipoImovel(TIPO_IMOVEL);

				imovel.setNumImovel(imv.getNumImovel());
				
				imovel.setBloco(bloco);

				imovelRN.salvar(imovel);
			}
		}

		else {

			this.blocoDAO.atualizar(bloco);
		}
	}

	public void excluir(Bloco bloco) {

		this.blocoDAO.excluir(bloco);
	}

}
