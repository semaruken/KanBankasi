package com.kanbankasi.controller;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.kanbankasi.entity.Kullanici;
import com.kanbankasi.service.KullaniciService;



@ManagedBean(name="loginBean")
@SessionScoped
public class LoginController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7086865443029670565L;

	private String username;
	private String password;
	
	public void logIn() {

		KullaniciService kullaniciService=new KullaniciService();
		Kullanici kullanici = kullaniciService.getUserByUsernameAndPwd(username, password);
		if(kullanici!=null && kullanici.getId()!=null){			
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("user", Boolean.TRUE);
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/KanBankasi/menu.xhtml?faces-redirect=true");	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void logOut() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/KanBankasi/login.xhtml?faces-redirect=true");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
