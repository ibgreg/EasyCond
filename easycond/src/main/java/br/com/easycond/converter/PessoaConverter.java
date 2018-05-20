package br.com.easycond.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.easycond.model.Pessoa;
import br.com.easycond.rn.PessoaRN;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter{

	private static PessoaRN pessoaRN = new PessoaRN();
	
	@Override
	public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Pessoa pessoa = new Pessoa();
		Integer id =  Integer.parseInt(value);
		if (id == 0) {
			return null;
		} else {
			pessoa = pessoaRN.carregar(id);
			return pessoa;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
