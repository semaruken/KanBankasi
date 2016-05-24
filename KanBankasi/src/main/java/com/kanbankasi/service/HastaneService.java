package com.kanbankasi.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.kanbankasi.entity.Hastane;
import com.kanbankasi.util.HibernateUtil;

public class HastaneService {
	public Hastane save(Hastane entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(entity);
		t.commit();
		session.close();
		return entity;
	}

	public Hastane update(Hastane entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(entity);
		t.commit();
		session.close();
		return entity;
	}

	public boolean delete(Hastane entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(entity);
		t.commit();
		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Hastane> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Hastane.class);
		return criteria.list();
	}

	public Hastane getById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Hastane.class);
		criteria.add(Restrictions.eq("id", id));
		return (Hastane) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Hastane> getByName(String key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Hastane.class);
		criteria.add(Restrictions.or(
				Restrictions.ilike("adi", key, MatchMode.ANYWHERE),
				Restrictions.ilike("ili", key, MatchMode.ANYWHERE)));
		return criteria.list();
	}

}
