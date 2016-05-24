package com.kanbankasi.converter;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.kanbankasi.entity.Hastane;
import com.kanbankasi.service.HastaneService;


@FacesConverter("hastaneConverter")
public class HastaneConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		try {
			HastaneService service=new HastaneService();
			//Il il = (Il) value;
			Hastane hastane = (Hastane) service.getById(Long.parseLong(value));
			return hastane;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		try {
			return value.toString();
		} catch (Exception e) {
		}
		return null;
	}

}
