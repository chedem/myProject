package com.yrkj.login.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.common.dao.BaseDao;
import com.yrkj.login.bean.SUserInof;
import com.yrkj.login.bean.UserInfo;

@Repository
public class LoginDao extends BaseDao{

	/**
	 * 获取单挑信息updateAA()
	 * Object o = session.get(SUserInof.class, 1);
	System.out.println(((SUserInof)o).getId());
	
		SQLQuery query = session.createSQLQuery("delete from  s_user_inof where id='33'");
		query.executeUpdate();
		
	 */
	
	public List login(String user,String pass){
		//换数据源
//	    DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.SYBASE);

		Session session = getSession();
		StringBuffer sql = new StringBuffer();
		sql.append("  SELECT ");
		sql.append("  	ID,	  ");
		sql.append("  	NAME,	  ");
		sql.append("  	PASSWORD,	  ");
		sql.append("  	EFFECT_TIME,  ");
		sql.append("  	FAIL_TIME,	  ");
		sql.append("  	IS_VALID,	  ");
		sql.append("  	gender,  ");
		sql.append("  	phone,	  ");
		sql.append("  	email	  ");
		sql.append("  	FROM s_user_inof WHERE	  ");
		sql.append("  	NAME = ?	  ");
		sql.append("  	and PASSWORD = ?	  ");

		SQLQuery query = session.createSQLQuery(sql.toString());
		query.setString(0, user);
		query.setString(1, pass);
//		query.setFirstResult(begin);
//		query.setMaxResults(size);
		List goodsBeans = query.list();
		
		List rlist = new ArrayList();
		UserInfo ui = null;
		
		for (Object  userInfo : goodsBeans) {
			Object[] u = (Object[]) userInfo;
			ui = new UserInfo();
			
			ui.setId(u[0]==null?"":u[0].toString());
			ui.setName(u[1]==null?"":u[1].toString());
//			ui.setPassWord(u[2]==null?"":u[2].toString());
			ui.setEffectTime(u[3]==null?"":u[3].toString());
			ui.setFailTime(u[4]==null?"":u[4].toString());
			ui.setIsValid(u[5]==null?"":u[5].toString());
			ui.setGender(u[6]==null?"":u[6].toString());
			ui.setPhone(u[7]==null?"":u[7].toString());
			ui.setEmail(u[8]==null?"":u[8].toString());
			
			rlist.add(ui);
		}
		return rlist;
	}
	
	public boolean saveAA(SUserInof si){
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.saveOrUpdate(si);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void updateAA(SUserInof si){
		
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.update(si);
		t.commit();
		session.close();
	}

	public void delete(SUserInof si) {
		
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("delete from s_user_menu where user_id = ?");
		query.setLong(0, si.getId());
		query.executeUpdate();
		session.delete(si);
		t.commit();
		if(session.isOpen()){
			session.close();
		}
	}
	
	public List selUserInfo(String id) {
		String queryString = "from SUserInof";
		Query queryObject = getSession().createQuery(queryString);
		return queryObject.list();
	}
}
