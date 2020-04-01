package com.javapuebla.utils;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import com.javapuebla.bd.domain.Producto;

@FacesConverter("converterProducto")
public class ConverterProducto implements Converter {
 
//	private static final Logger LOG = LoggerFactory.getLogger(TeamPickListConverter.class);
 
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
//		LOG.trace("String value: {}", value);
 
		return getObjectFromUIPickListComponent(component,value);
	}
 
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		String string;
//		LOG.trace("Object value: {}", object);
		if(object == null){
			string="";
		}else{
			try{
				string = String.valueOf(((Producto)object).getFiIdProducto());
			}catch(ClassCastException cce){
				throw new ConverterException();
			}
		}
		return string;
	}
 
	@SuppressWarnings("unchecked")
	private Producto getObjectFromUIPickListComponent(UIComponent component, String value) {
		final DualListModel<Producto>  dualList;
		try{
			dualList = (DualListModel<Producto> ) ((PickList)component).getValue();
			Producto team = getObjectFromList(dualList.getSource(),Integer.valueOf(value));
			if(team==null){
				team = getObjectFromList(dualList.getTarget(),Integer.valueOf(value));
			}
			
			return team;
		}catch(ClassCastException cce){
			throw new ConverterException();
		}catch(NumberFormatException nfe){
			throw new ConverterException();
		}
	}
 
	private Producto getObjectFromList(final List<?> list, final Integer identifier) {
		for(final Object object:list){
			final Producto team = (Producto) object;
			if(team.getFiIdProducto().equals(identifier)){
				return team;
			}
		}
		return null;
	}
}