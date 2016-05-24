package com.kanbankasi.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.kanbankasi.entity.Kullanici;
import com.kanbankasi.service.HastaneService;
import com.kanbankasi.service.KisiService;
import com.kanbankasi.service.KullaniciService;

@ManagedBean(name = "kullaniciController")
@ViewScoped
public class KullaniciController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	KullaniciService kullaniciService;
	KisiService kisiService;
	HastaneService hastaneService;
	private Kullanici kullanici;
	private String mesaj;
	List<Kullanici> kullaniciList;

	@PostConstruct
	public void init() {
		System.out.println("kullaniciBean construct");
		kullaniciService = new KullaniciService();
		kullaniciList = kullaniciService.getAll();
	}

	public void kaydet() {
		System.out.println(kullanici.toString());

		if (this.kullanici != null && this.kullanici.getId() != null) {
			kullaniciService.update(kullanici);
		} else {
			kullaniciService.save(kullanici);
		}
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Kullanýcý Kaydedildi"));
		kullaniciList = kullaniciService.getAll();
		mesaj = "Kullanýcý Kaydedildi";
		kullanici = new Kullanici();
	}

	public void duzenle(Long id) {
		Kullanici entity = kullaniciService.getById(id);
		this.kullanici = entity;
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Kullanýcý güncellendi"));
	}

	public void sil(Long id) {
		Kullanici entity = kullaniciService.getById(id);
		kullaniciService.delete(entity);
		kullaniciList = kullaniciService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Kullanýcý Silindi"));
	}

	public void yeni() {
		this.kullanici = new Kullanici();
	}

	public Kullanici getKullanici() {
		if (kullanici == null) {
			kullanici = new Kullanici();
		}
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public String getMesaj() {
		return mesaj;
	}

	public List<Kullanici> getKullaniciList() {
		return kullaniciList;
	}


}
