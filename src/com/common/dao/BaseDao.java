package com.common.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BaseDao {
	
	/** 从spring容器中 获取一个二级缓存sessionFactory   **/
	@Resource
	protected SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	public void save(Object object){
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		session.save(object);
		t.commit();
		session.close();

	}
	
	public void update(Object object){
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		t.commit();
		session.close();
	}
	
	public void saveOrUpdate(Object object){
		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(object);
		t.commit();
		session.close();
	}
	
	public void delete(Object object){
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.delete(object);
		t.commit();
		if(session.isOpen()){
			session.close();
		}
	}
	
	public Object find(Class clazz, Long id){
		return sessionFactory.getCurrentSession().get(clazz, id);
	}
	
	public List findList(String sql,String[] text){
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery(sql.toString());
		int num = text.length;
		for (int i = 0; i <num ; i++) {
			query.setString(i, text[i]);
		}
//		session.close();
		return query.list();
	}
	
	public List findList(String sql,String[] text,int begin, int size){
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery(sql.toString());
		int num = text.length;
		for (int i = 0; i <num ; i++) {
			query.setString(i, text[i]);
		}
		query.setFirstResult(begin);
		query.setMaxResults(size);
//		session.close();
		return query.list();
	}
}
