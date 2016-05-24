package com.kanbankasi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "KULLANICI_TIPI")
public class Kullanici_Tipi implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4210913762828089502L;
	private Long id;
	private String kullanici_tip_adi;


	@Id
	@SequenceGenerator(name = "SEQ_TIP_ID", sequenceName = "SEQ_TIP_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIP_ID")
	@Column(name = "TIP_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TIP_AD")
	public String getKullanici_tip_adi() {
		return kullanici_tip_adi;
	}

	public void setKullanici_tip_adi(String kullanici_tip_adi) {
		this.kullanici_tip_adi = kullanici_tip_adi;
	}


}
