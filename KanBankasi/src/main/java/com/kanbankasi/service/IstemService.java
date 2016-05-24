package com.kanbankasi.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.kanbankasi.entity.Istem;
import com.kanbankasi.util.HibernateUtil;

public class IstemService {
	public Istem save(Istem entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
		return entity;

	}

	public Istem update(Istem entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		return entity;
	}

	public Boolean delete(Istem entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(entity);
		t.commit();
		session.close();
		return true;
	}

	public List<Istem> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Istem.class);
		return criteria.list();
	}

	public Istem getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Istem.class);
		criteria.add(Restrictions.eq("id", id));
		return (Istem) criteria.uniqueResult();
	}

}
