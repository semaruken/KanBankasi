package com.kanbankasi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ISTEM")
public class Istem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8022630902897978469L;
	private Long id;
	private String istem_no;
	private String kan_grubu;
	private Date istem_tarihi;
	private int istem_adedi;
	private Hastane hastane;

	@Id
	@SequenceGenerator(name = "SEQ_ISTEM_ID", sequenceName = "SEQ_ISTEM_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ISTEM_ID")
	@Column(name = "ISTEM_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ISTEM_NO", length = 255)
	public String getIstem_no() {
		return istem_no;
	}

	public void setIstem_no(String istem_no) {
		this.istem_no = istem_no;
	}

	@Column(name = "ISTEM_KANGRUBU")
	public String getKan_grubu() {
		return kan_grubu;
	}

	public void setKan_grubu(String kan_grubu) {
		this.kan_grubu = kan_grubu;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ISTEM_TARIH")
	public Date getIstem_tarihi() {
		return istem_tarihi;
	}

	public void setIstem_tarihi(Date istem_tarihi) {
		this.istem_tarihi = istem_tarihi;
	}

	@Column(name = "ISTEM_ADET")
	public int getIstem_adedi() {
		return istem_adedi;
	}

	public void setIstem_adedi(int istem_adedi) {
		this.istem_adedi = istem_adedi;
	}

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_ISTEM_HASTANE_ID"), name = "HASTANE_ID")
	public Hastane getHastane() {
		return hastane;
	}

	public void setHastane(Hastane hastane) {
		this.hastane = hastane;
	}

}
