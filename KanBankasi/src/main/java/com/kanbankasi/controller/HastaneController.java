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
import com.kanbankasi.service.HastaneService;

@ManagedBean(name = "hastaneController")
@ViewScoped
public class HastaneController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -130874442527176453L;

	HastaneService hastaneService;
	private Hastane hastane;
	private String mesaj;
	private Boolean skip;
	List<Hastane> hastaneList;
	List<Hastane> filteredList;

	@PostConstruct
	private void init() {
		System.out.println("hastaneController construct");
		hastaneService = new HastaneService();
		hastaneList = hastaneService.getAll();

	}

	public void kaydet() {
		System.out.println(hastane.toString());

		if (this.hastane != null && this.hastane.getHastane_id() != null) {
			hastaneService.update(hastane);
		} else {
			hastaneService.save(hastane);
		}
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Hastane Kaydedildi"));
		hastaneList = hastaneService.getAll();
		setMesaj("Hastane Kaydedildi");
		hastane= new Hastane();
	}

	public void duzenle(Long id) {
		Hastane entity = hastaneService.getById(id);
		this.hastane = entity;
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Hastane güncellendi"));
	}

	public void sil(Long id) {
		Hastane entity = hastaneService.getById(id);
		hastaneService.delete(entity);
		hastaneList = hastaneService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage(" Silindi"));

	}

	public Hastane getHastane() {
		if (hastane == null) {
			hastane = new Hastane();
		}
		return hastane;
	}

	public void setHastane(Hastane hastane) {
		this.hastane = hastane;
	}

	public List<Hastane> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Hastane> filteredList) {
		this.filteredList = filteredList;
	}

	public Boolean getSkip() {
		return skip;
	}

	public void setSkip(Boolean skip) {
		this.skip = skip;
	}

	public List<Hastane> getHastaneList() {
		return hastaneList;
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
