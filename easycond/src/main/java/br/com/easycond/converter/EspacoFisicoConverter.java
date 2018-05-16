package br.com.easycond.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.easycond.model.EspacoFisico;
import br.com.easycond.rn.EspacoFisicoRN;

@FacesConverter("espacoFisicoConverter")
public class EspacoFisicoConverter implements Converter {

	private static EspacoFisicoRN espacoFisicoRN = new EspacoFisicoRN();
	
	@Override
	public EspacoFisico getAsObject(FacesContext fc, UIComponent uic, String value) {
		EspacoFisico espacoFisico = new EspacoFisico();
		Integer id =  Integer.parseInt(value);
		if (id == 0) {
			return null;
		} else {
			espacoFisico = espacoFisicoRN.carregarItemCombo(id);
			return espacoFisico;
		}
		
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object value) {
		if (value instanceof EspacoFisico) {
			EspacoFisico entity = (EspacoFisico) value;
			if (entity != null && entity instanceof EspacoFisico && entity.getId() != null) {
				uic.getAttributes().put(entity.getId().toString(), entity);
				return entity.getId().toString();
			}
		}
		return "";
	}
	
	

}
