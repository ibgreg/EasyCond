package br.com.easycond.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.easycond.model.EspacoFisico;
import br.com.easycond.rn.EspacoFisicoRN;

@FacesConverter(forClass = EspacoFisico.class)
public class EspacoFisicoConverter implements Converter {

	private static EspacoFisicoRN espacoFisicoRN = new EspacoFisicoRN();
	
	@Override
	public EspacoFisico getAsObject(FacesContext fc, UIComponent uic, String value) {
		EspacoFisico espacoFisico = new EspacoFisico();
		Integer id =  Integer.parseInt(value);
		if (id == 0) {
			return null;
		} else {
			espacoFisico = espacoFisicoRN.carregar(id);
			return espacoFisico;
		}
		
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object value) {
		return null;
	}
	
	

}
