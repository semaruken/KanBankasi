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
@Table(name = "KISI")
public class Kisi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5347281945242865971L;
	private Long id;
	private String kisi_adi;
	private String kisi_soyadi;
	private String kisi_tc_no;
	private int kisi_yasi;
	private String kisi_kangrubu;
	private String kisi_cinsiyet;
	private String kisi_ili;
	private String kisi_ilcesi;
	private String kisi_adresi;
	private String kisi_email_adresi;
	private String kisi_gsmno;
	private Date kisi_dogumtarihi;
	private Kullanici_Tipi kullanici_Tipi;

	@Id
	@SequenceGenerator(name = "SEQ_KISI_ID", sequenceName = "SEQ_KISI_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_KISI_ID")
	@Column(name = "KISI_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "KISI_AD")
	public String getKisi_adi() {
		return kisi_adi;
	}

	public void setKisi_adi(String kisi_adi) {
		this.kisi_adi = kisi_adi;
	}

	@Column(name = "KISI_SOYAD")
	public String getKisi_soyadi() {
		return kisi_soyadi;
	}

	public void setKisi_soyadi(String kisi_soyadi) {
		this.kisi_soyadi = kisi_soyadi;
	}

	@Column(name = "KISI_TC")
	public String getKisi_tc_no() {
		return kisi_tc_no;
	}

	public void setKisi_tc_no(String kisi_tc_no) {
		this.kisi_tc_no = kisi_tc_no;
	}

	@Column(name = "YAS")
	public int getKisi_yasi() {
		return kisi_yasi;
	}

	public void setKisi_yasi(int kisi_yasi) {
		this.kisi_yasi = kisi_yasi;
	}

	@Column(name = "KISI_KANGRUBU")
	public String getKisi_kangrubu() {
		return kisi_kangrubu;
	}

	public void setKisi_kangrubu(String kisi_kangrubu) {
		this.kisi_kangrubu = kisi_kangrubu;
	}

	@Column(name = "KISI_CINSIYET")
	public String getKisi_cinsiyet() {
		return kisi_cinsiyet;
	}

	public void setKisi_cinsiyet(String kisi_cinsiyet) {
		this.kisi_cinsiyet = kisi_cinsiyet;
	}

	@Column(name = "KISI_ILI")
	public String getKisi_ili() {
		return kisi_ili;
	}

	public void setKisi_ili(String kisi_ili) {
		this.kisi_ili = kisi_ili;
	}

	@Column(name = "KISI_ILCESI")
	public String getKisi_ilcesi() {
		return kisi_ilcesi;
	}

	public void setKisi_ilcesi(String kisi_ilcesi) {
		this.kisi_ilcesi = kisi_ilcesi;
	}

	@Column(name = "KISI_ADRES")
	public String getKisi_adresi() {
		return kisi_adresi;
	}

	public void setKisi_adresi(String kisi_adresi) {
		this.kisi_adresi = kisi_adresi;
	}

	@Column(name = "KISI_MAIL")
	public String getKisi_email_adresi() {
		return kisi_email_adresi;
	}

	public void setKisi_email_adresi(String kisi_email_adresi) {
		this.kisi_email_adresi = kisi_email_adresi;
	}

	@Column(name = "KISI_TLFN")
	public String getKisi_gsmno() {
		return kisi_gsmno;
	}

	public void setKisi_gsmno(String kisi_gsmno) {
		this.kisi_gsmno = kisi_gsmno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "KISI_DTARIHI")
	public Date getKisi_dogumtarihi() {
		return kisi_dogumtarihi;
	}

	public void setKisi_dogumtarihi(Date kisi_dogumtarihi) {
		this.kisi_dogumtarihi = kisi_dogumtarihi;
	}

	@ManyToOne(optional=true,fetch=FetchType.EAGER)
	@JoinColumn(foreignKey=@ForeignKey(name="FK_KISI_TIP_ID"), name="TIP_ID")
	public Kullanici_Tipi getKullanici_Tipi() {
		return kullanici_Tipi;
	}

	public void setKullanici_Tipi(Kullanici_Tipi kullanici_Tipi) {
		this.kullanici_Tipi = kullanici_Tipi;
	}

}