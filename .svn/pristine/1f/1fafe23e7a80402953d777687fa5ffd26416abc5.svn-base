package com.yrkj.menu.dao;


import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.common.dao.BaseDao;
import com.yrkj.code.bean.CodeBean;
import com.yrkj.menu.bean.UserMenu;

@Repository
public class MenuDaoImpl extends BaseDao implements IMenuDao {

	public List selUserMenu(String id) {
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT b.id,b.name,b.remark_1 FROM s_user_menu a ,s_code b ");
		sql.append("SELECT {b.*} FROM s_user_menu a ,s_code b ");
		sql.append(" WHERE a.user_id = ? AND a.menu_id = b.id  ");
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery(sql.toString()).addEntity("b",CodeBean.class);
		query.setString(0, id);
		List<CodeBean> l =  query.list();
		session.close();
		return l;
	}

	public boolean delUserMenu(UserMenu userMenu) {
		Session session = sessionFactory.openSession();
//		Session session = sessionFactory.getCurrentSession();
		Transaction t = session.beginTransaction();
		session.delete(userMenu);
//		session.delete(userMenu.getId(),userMenu);
		t.commit();
		if(session.isOpen()){
			session.close();
		}
		return true;
	}

	public boolean saveUserMenu(UserMenu userMenu) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.saveOrUpdate(userMenu);
			t.commit();
			if(session.isOpen()){
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		return false;
		}
		return true;
	}
}
