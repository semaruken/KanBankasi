package com.kanbankasi.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kanbankasi.entity.Kullanici_Tipi;
import com.kanbankasi.util.HibernateUtil;

public class Kullanici_TipiService {

	public Kullanici_Tipi save(Kullanici_Tipi entity) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
		return entity;

	}

	public Kullanici_Tipi update(Kullanici_Tipi entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		return entity;
	}

	public boolean delete(Kullanici_Tipi entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(entity);
		t.commit();
		session.close();
		return true;
	}

	public List<Kullanici_Tipi> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kullanici_Tipi.class);
		return criteria.list();
	}

	public Kullanici_Tipi getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kullanici_Tipi.class);
		criteria.add(Restrictions.eq("id", id));
		return (Kullanici_Tipi) criteria.uniqueResult();
	}

	public Kullanici_Tipi getUserByUsernameAndPwd(String username, String pwd) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kullanici_Tipi.class);
		return (Kullanici_Tipi) criteria.uniqueResult();
	}
}