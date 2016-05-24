package com.kanbankasi.entity;

import java.io.Serializable;

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


@Entity
@Table(name = "HASTANE")
public class Hastane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -301002539741921435L;
	private Long hastane_id;
	private String hastane_adi;
	private String hastane_ili;
	private String hastane_ilcesi;
	private String hastane_iletisimadresi;
	private String hastane_tlfnno;
	

	@Id
	@SequenceGenerator(name = "SEQ_HASTANE_ID", sequenceName = "SEQ_HASTANE_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HASTANE_ID")
	@Column(name = "HASTANE_ID")
	public Long getHastane_id() {
		return hastane_id;
	}

	public void setHastane_id(Long hastane_id) {
		this.hastane_id = hastane_id;
	}

	@Column(name = "HASTANE_ADI", length = 250)
	public String getHastane_adi() {
		return hastane_adi;
	}

	public void setHastane_adi(String hastane_adi) {
		this.hastane_adi = hastane_adi;
	}

	@Column(name = "HASTANE_ILI", length = 100)
	public String getHastane_ili() {
		return hastane_ili;
	}

	public void setHastane_ili(String hastane_ili) {
		this.hastane_ili = hastane_ili;
	}

	@Column(name = "HASTANE_ILCESI", length = 100)
	public String getHastane_ilcesi() {
		return hastane_ilcesi;
	}

	public void setHastane_ilcesi(String hastane_ilcesi) {
		this.hastane_ilcesi = hastane_ilcesi;
	}

	@Column(name = "HASTANE_ADRES", length = 200)
	public String getHastane_iletisimadresi() {
		return hastane_iletisimadresi;
	}

	public void setHastane_iletisimadresi(String hastane_iletisimadresi) {
		this.hastane_iletisimadresi = hastane_iletisimadresi;
	}

	@Column(name = "HASTANE_TELEFON", length = 13)
	public String getHastane_tlfnno() {
		return hastane_tlfnno;
	}

	public void setHastane_tlfnno(String hastane_tlfnno) {
		this.hastane_tlfnno = hastane_tlfnno;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Hastane) {
			Hastane t = (Hastane) arg0;
			if (t.getHastane_id().equals(this.hastane_id)) {
				return true;
			}
		}
		return false;
	}
 


}
