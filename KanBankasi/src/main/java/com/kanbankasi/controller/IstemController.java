package com.kanbankasi.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import com.kanbankasi.entity.Hastane;
import com.kanbankasi.entity.Istem;
import com.kanbankasi.service.HastaneService;
import com.kanbankasi.service.IstemService;

@ManagedBean(name = "istemController")
@ViewScoped
public class IstemController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6362007315606477537L;

	IstemService istemService = new IstemService();

	HastaneService hastaneService = new HastaneService();
	private Istem istem;
	List<Istem> istemList;
	List<Istem> filteredList;
	private Boolean skip;
	private String mesaj;

	@PostConstruct
	private void init() {
		System.out.println("istemController construct");
		istemService = new IstemService();
		istemList = istemService.getAll();

	}

	public void kaydet() {
		System.out.println(istem.toString());
		if (this.istem != null && this.istem.getId() != null) {
			istemService.update(istem);
		} else {
			istemService.save(istem);
		}
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Ýstem Kaydedildi"));
		istemList = istemService.getAll();
		mesaj= "Ýstem Kaydedildi";
		istem = new Istem();
	}

	public void duzenle(Long id) {
		Istem entity = istemService.getById(id);
		this.istem = entity;
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Ýstem güncellendi"));

	}

	public void sil(Long id) {
		Istem entity = istemService.getById(id);
		istemService.delete(entity);
		istemList = istemService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage(" Silindi"));

	}

	public List<Hastane> hastaneAcomp(String key) {
		return hastaneService.getByName(key);
	}

	public Istem getIstem() {
		if (istem == null) {
			istem = new Istem();
		}
		return istem;
	}

	public void setIstem(Istem istem) {
		this.istem = istem;
	}

	public List<Istem> getIstemList() {
		return istemList;
	}

	public List<Istem> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Istem> filteredList) {
		this.filteredList = filteredList;
	}

	public Boolean getSkip() {
		return skip;
	}

	public void setSkip(Boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
}
