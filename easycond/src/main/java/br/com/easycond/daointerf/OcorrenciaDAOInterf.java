package br.com.easycond.daointerf;

import java.util.List;

import br.com.easycond.model.Ocorrencia;

public interface OcorrenciaDAOInterf {
	
	public void salvar(Ocorrencia ocorrencia);
	
	public void atualizar(Ocorrencia ocorrencia);
	
	public void excluir(Ocorrencia ocorrencia);
	
	public Ocorrencia carregar(Integer id);
	
	public List<Ocorrencia> listar();
	
	public List<Ocorrencia> obterOcorrenciaPorUsuario(Integer id);
}