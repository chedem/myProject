package com.yrkj.extract.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.common.dao.BaseDao;
import com.common.dao.DynamicDataSourceGlobal;
import com.common.dao.DynamicDataSourceHolder;
import com.yrkj.code.bean.CodeBean;
import com.yrkj.extract.bean.Profit;

@Repository
public class ExtractDataDao extends BaseDao{

	public void departmentData(){
		
	    DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.SYBASE);
		Session session = getSession();
		StringBuffer sql = new StringBuffer();
		sql.append("  	SELECT	  ");
		sql.append("  	LNGDEPARTMENTID as lngdepartmentid	,  ");
//		sql.append("  	STRDEPARTMENTCODE as strdepartmentcode	,  ");
		sql.append("  	STRDEPARTMENTNAME as strdepartmentname	  ");
		sql.append("  	FROM DEPARTMENT t 	  ");

		SQLQuery query = session.createSQLQuery(sql.toString());
		List<Object[]> goodsBeans = query.list();
		wridBuMen(goodsBeans);
			
	}
	
	public void wridBuMen(List<Object[]> list ){
	    DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.MYSQL);
	    Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("delete from  s_code where type='bu_men' ");
		query.executeUpdate();
		
		for (Object[] object : list) {
			CodeBean cb = new CodeBean();
			cb.setCode(object[0].toString());
			cb.setName(object[1].toString());
			cb.setIs_valid("1");
			cb.setType("bu_men");
			session.save(cb);
		}
		t.commit();
		session.close();
	}
	
	
	public boolean setProfitData(List list){
	    DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.SYBASE);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Profit pf = null;
		for (Object object : list) {
			pf = new Profit();
			
			
			session.save(pf);
		}
		t.commit();
		session.close();
		
		return true;
	}
}
