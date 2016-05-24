package com.kanbankasi.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.kanbankasi.entity.Kisi;
import com.kanbankasi.util.HibernateUtil;

public class KisiService {

	public Kisi save(Kisi entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
		return entity;

	}

	public Kisi update(Kisi entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		return entity;
	}

	public Boolean delete(Kisi entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(entity);
		t.commit();
		session.close();
		return true;
	}

	public List<Kisi> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kisi.class);
		return criteria.list();
	}

	public Kisi getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kisi.class);
		criteria.add(Restrictions.eq("id", id));
		return (Kisi) criteria.uniqueResult();
	}

	public Kisi getByName(String kisi_adi) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Kisi.class);
		criteria.add(Restrictions.eq("adi", kisi_adi));
		return (Kisi) criteria.uniqueResult();
	}

}
