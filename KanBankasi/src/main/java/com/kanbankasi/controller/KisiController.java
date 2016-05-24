package com.kanbankasi.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import com.kanbankasi.entity.Kisi;
import com.kanbankasi.service.KisiService;
import com.kanbankasi.service.Kullanici_TipiService;

@ManagedBean(name = "kisiController")
@ViewScoped
public class KisiController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -130874442527176453L;

	KisiService kisiService = new KisiService();
	Kullanici_TipiService kullanici_TipiService=new Kullanici_TipiService();
	private Kisi kisi;
	List<Kisi> kisiList;
	private String mesaj;
	List<Kisi> filteredList;
	private Boolean skip;

	@PostConstruct
	private void init() {
		System.out.println("kisiController construct");
		kisiService = new KisiService();
		kisiList = kisiService.getAll();
	}

	public void kaydet() {
		System.out.println(kisi.toString());
		if (this.kisi != null && this.kisi.getId() != null) {
			kisiService.update(kisi);
		} else {
			kisiService.save(kisi);
		}

		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Kiþi Kaydedildi"));
		filteredList = kisiService.getAll();
		mesaj="Kiþi Kaydedildi";
		kisi = new Kisi();
	}

	public void duzenle(Long id) {
		Kisi entity= kisiService.getById(id);
		this.kisi=entity;
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Kiþi güncellendi"));
		
	}
	public void sil(Long id) {
		Kisi entity = kisiService.getById(id);
		kisiService.delete(entity);
		kisiList = kisiService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage(" Silindi"));
	}

	public Kisi getKisi() {
		if (kisi == null) {
			kisi = new Kisi();
		}
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

	public List<Kisi> getKisiList() {
		return kisiList;
	}

	public List<Kisi> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Kisi> filteredList) {
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
