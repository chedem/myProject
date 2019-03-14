package com.yrkj.profit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.common.dao.BaseDao;
import com.common.dao.DynamicDataSourceGlobal;
import com.common.dao.DynamicDataSourceHolder;
import com.yrkj.code.bean.CodeBean;
import com.yrkj.profit.bean.CodeBeanList;

@Repository
public class ProfitDao extends BaseDao{

	public List<Object[]> getProfitData(String lngaccountId,String lngdepartmentId,String startDate,String endDate) {
	    DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.SYBASE);
			Session session = getSession();
			StringBuffer sql = new StringBuffer();
			String[] s={};
			if(lngaccountId!=null){
				s = lngaccountId.split("-");
			}
			sql.append(" 	SELECT Round (SUM(DBLPOSTEDCREDIT)/10000,2)	 ");
			sql.append(" 	FROM ACCOUNTDAILY	 ");
			sql.append(" 	where 	 ");
			sql.append(" 	LNGACCOUNTID in(	 "); //项目id
			for (String string : s) {
				sql.append(" '"+string+"', "); 
			}
			sql.append(" '') "); 
			sql.append(" 	and STRDATE between ? and ?	 "); //公司id
			sql.append(" 	and LNGDEPARTMENTID = ?	or LNGORGANIZATIONID= ? "); //公司id

			SQLQuery query = session.createSQLQuery(sql.toString());
//			query.setString(0, lngaccountId);
			query.setString(0, startDate);
			query.setString(1, endDate);
			query.setString(2, lngdepartmentId);
			query.setString(3, lngdepartmentId);

			List<Object[]> goodsBeans = query.list();
			DynamicDataSourceHolder.clearDataSourceType();
			return goodsBeans;
	}
	
	/**
	 *  成套
	 * @param xmid
	 * @param gsid
	 * @param startDate
	 * @param endDate
	 * @param danwei
	 * @return
	 */
	public Float getData(String xmid,String gsid,String startDate,String endDate,String danwei) {
	    DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.SYBASE);
			Session session = getSession();
			StringBuffer sql = new StringBuffer();
			String[] sjqf =xmid.split(",");
			
			sql.append(" 	SELECT Round (SUM(a.DBLUNPOSTEDDEBIT+a.DBLPOSTEDDEBIT)/10000,2)	 ");
//			sql.append(" 	SELECT Round (SUM(a.DBLUNPOSTEDCREDIT+a.DBLPOSTEDCREDIT)/10000,2)	 ");
//			sql.append(" 	SELECT Round (SUM(DBLPOSTEDCREDIT)/10000,2)	 ");
			sql.append(" 	FROM ACCOUNTDAILY a where	 ");
//			sql.append(" 	where 	a.LNGACCOUNTID= b.LNGACCOUNTID ");
//			sql.append(" 	and  a.LNGDEPARTMENTID = d.LNGDEPARTMENTID ");
//			sql.append(" 	and  a.LNGORGANIZATIONID = c.LNGORGANIZATIONID ");
			sql.append(" 	 a.STRDATE between ? and to_char(add_months(to_date(?,'YYYY-MM'),1),'YYYY-MM')	 "); //时间
			
			String[] s=sjqf[1].split(";");
			sql.append(" 	and a.LNGACCOUNTID in (select b.LNGACCOUNTID from account b where b.LNGACCOUNTID is null  "); //项目id
			for (String string : s) {
				sql.append(" or b.STRACCOUNTCODE like '"+string+"%'  "); 
			}
			sql.append(" ) "); 
			
			if("1".equals(sjqf[0])){
				String[] gsids = gsid.split(";");
				sql.append(" 	and a.LNGDEPARTMENTID  in(	select d.LNGDEPARTMENTID  from DEPARTMENT d where d.STRDEPARTMENTCODE in ("); //公司id
				for (String string : gsids) {
						sql.append(" '"+string+"', "); 
				}
				sql.append(" null ) "); 
				for (String string : gsids) {
					if("0".equals(string)){
						sql.append("   union all  select sum('0')  from DEPARTMENT d  "); 
					}
				}
				sql.append("  ) "); 
			}

			sql.append(" 	and a.LNGORGANIZATIONID in (select c.LNGORGANIZATIONID from organization c where c.STRORGANIZATIONCODE like '"+danwei+"%' ) "); //机构id

			
//			String[] danweis = danwei.split("-");
//			sql.append(" 	and c.STRORGANIZATIONCODE in ( "); //机构id
//			for (String string : danweis) {
//				sql.append(" '"+string+"', "); 
//			}
//			sql.append(" null) "); 

			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setString(0, startDate);
			query.setString(1, endDate);

			List goodsBeans = query.list();
			DynamicDataSourceHolder.clearDataSourceType();
			return goodsBeans.get(0)==null?0.00f:Float.valueOf((goodsBeans.get(0).toString()));
	}
	
	
	public Float getData4(String xmid,String gsid,String startDate,String endDate,String danwei) {
	    DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.ORACLE);
			Session session = getSession();
			StringBuffer sql = new StringBuffer();
			String[] sjqf =xmid.split(",");
			
			sql.append(" 	SELECT Round (SUM(DBLPOSTEDDEBIT+DBLUNPOSTEDDEBIT)/10000,2)	 ");
//			sql.append(" 	SELECT Round (SUM(DBLPOSTEDDEBIT)/10000,2)	 ");
			sql.append(" 	FROM ACCOUNTDAILY	 ");
			sql.append(" 	where 	 ");
			sql.append(" 	STRDATE between ? and to_char(add_months(to_date(?,'YYYY-MM'),1),'YYYY-MM')	 "); //时间
			
			String[] s=sjqf[1].split(";");
			sql.append(" and LNGACCOUNTID in(	 "); //项目id
			sql.append(" select LNGACCOUNTID  from account t where t.LNGACCOUNTID is null "); 
			for (String string : s) {
				sql.append(" or t.STRACCOUNTCODE like '"+string+"%' "); 
			}
			sql.append(" ) "); 
			
			if("1".equals(sjqf[0])){
				String[] gsids = gsid.split(";");
				sql.append(" 	and LNGDEPARTMENTID in(	"); //公司id
				sql.append(" 	 select LNGDEPARTMENTID  from DEPARTMENT t where t.STRDEPARTMENTCODE in ("); //公司id
				for (String string : gsids) {
					sql.append(" '"+string+"', "); 
				}
				sql.append(" null) )"); 
			}

//			String[] danweis = danwei.split("-");
//			sql.append(" 	and LNGORGANIZATIONID in ( "); //机构id
//			for (String string : danweis) {
//				sql.append(" '"+string+"', "); 
//			}
//			sql.append(" null) "); 
			

			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setString(0, startDate);
			query.setString(1, endDate);

			List goodsBeans = query.list();
			DynamicDataSourceHolder.clearDataSourceType();
			return goodsBeans.get(0)==null?0.00f:Float.valueOf((goodsBeans.get(0).toString()));
	}
	
	
	public List getData6(String startDate,String endDate) {
	    	DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.ORACLE);
			Session session = getSession();
			String sql = getSql6(startDate,endDate);
			SQLQuery query = session.createSQLQuery(sql.toString());
			List goodsBeans = query.list();
			DynamicDataSourceHolder.clearDataSourceType();
			return goodsBeans;
	}
	
	
	public List getData7(String startDate,String endDate) {
    	DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.ORACLE);
		Session session = getSession();
		String sql = getSql7(startDate,endDate);
		SQLQuery query = session.createSQLQuery(sql.toString());
		List goodsBeans = query.list();
		DynamicDataSourceHolder.clearDataSourceType();
		return goodsBeans;
}
	
	
	private String getSql7(String startDate, String endDate) {
		StringBuffer sql = new StringBuffer();
		sql.append("  	Select	  ");
		sql.append("  	class1.strclassname,	  ");
		sql.append("  	       customer.STRCUSTOMERNAME,	  ");
		sql.append("  	       SUM(DECODE(ACCOUNT.INTDIRECTION, 1, 1, 0) *	  ");
		sql.append("  	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+startDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  -1,	  ");
		sql.append("  	                  1,	  ");
		sql.append("  	                  0) * ((dblUnPostedDebit + dblPostedDebit) -	  ");
		sql.append("  	                        (dblUnPostedCredit + dblPostedCredit))) +	  ");
		sql.append("  	       SUM(DECODE(ACCOUNT.INTDIRECTION, -1, 1, 0) *	  ");
		sql.append("  	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+startDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  -1,	  ");
		sql.append("  	                  1,	  ");
		sql.append("  	                  0) * ((dblUnPostedCredit + dblPostedCredit) -	  ");
		sql.append("  	                        (dblUnPostedDebit + dblPostedDebit))) As 期初余额本币金额,	  ");
		sql.append("  	       SUM(DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+startDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  -1,	  ");
		sql.append("  	                  0,	  ");
		sql.append("  	                  1) *	  ");
		sql.append("  	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+startDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  1,	  ");
		sql.append("  	                  0,	  ");
		sql.append("  	                  1) * (dblUnPostedDebit + dblPostedDebit)) As 本期借方发生额本币金额,	  ");
		sql.append("  	       SUM(DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  -1,	  ");
		sql.append("  	                  0,	  ");
		sql.append("  	                  1) *	  ");
		sql.append("  	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  1,	  ");
		sql.append("  	                  0,	  ");
		sql.append("  	                  1) * (dblUnPostedCredit + dblPostedCredit)) As 本期贷方发生额本币金额,	  ");
		sql.append("  	       SUM(DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  1,	  ");
		sql.append("  	                  0,	  ");
		sql.append("  	                  DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                              TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                         -1,	  ");
		sql.append("  	                         0,	  ");
		sql.append("  	                         (dblUnPostedDebit + dblPostedDebit)))) As 借方累计本币金额,	  ");
		sql.append("  	       SUM(DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  1,	  ");
		sql.append("  	                  0,	  ");
		sql.append("  	                  DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                              TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                         -1,	  ");
		sql.append("  	                         0,	  ");
		sql.append("  	                         (dblUnPostedCredit + dblPostedCredit)))) As 贷方累计本币金额,	  ");
		sql.append("  	       SUM(DECODE(ACCOUNT.INTDIRECTION, 1, 1, 0) *	  ");
		sql.append("  	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  1,	  ");
		sql.append("  	                  0,	  ");
		sql.append("  	                  1) * ((dblUnPostedDebit + dblPostedDebit) -	  ");
		sql.append("  	                        (dblUnPostedCredit + dblPostedCredit))) +	  ");
		sql.append("  	       SUM(DECODE(ACCOUNT.INTDIRECTION, -1, 1, 0) *	  ");
		sql.append("  	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append("  	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append("  	                  1,	  ");
		sql.append("  	                  0,	  ");
		sql.append("  	                  1) * ((dblUnPostedCredit + dblPostedCredit) -	  ");
		sql.append("  	                        (dblUnPostedDebit + dblPostedDebit))) As 期末余额本币金额	  ");
		sql.append("  	  From Account,	  ");
		sql.append("  	       AccountDaily,	  ");
		sql.append("  	       Currencys,	  ");
		sql.append("  	       Customer,	  ");
		sql.append("  	       class1,	  ");
		sql.append("  	       CustomerType,	  ");
		sql.append("  	       Employee,	  ");
		sql.append("  	       (SELECT ORGANIZATION.*	  ");
		sql.append("  	          FROM ORGANIZATION,	  ");
		sql.append("  	               (SELECT * FROM ORGANIZATION WHERE lngOrganizationID = 1) OrgCond	  ");
		sql.append("  	         WHERE ORGANIZATION.strOrganizationCode =	  ");
		sql.append("  	               OrgCond.strOrganizationCode	  ");
		sql.append("  	            OR ORGANIZATION.strOrganizationCode LIKE	  ");
		sql.append("  	               OrgCond.strOrganizationCode || '-%') Organization,	  ");
		sql.append("  	       (SELECT ORGANIZATION.*	  ");
		sql.append("  	          FROM ORGANIZATION,	  ");
		sql.append("  	               (SELECT * FROM ORGANIZATION WHERE lngOrganizationID = 1) OrgCond	  ");
		sql.append("  	         WHERE ORGANIZATION.strOrganizationCode =	  ");
		sql.append("  	               OrgCond.strOrganizationCode	  ");
		sql.append("  	            OR ORGANIZATION.strOrganizationCode LIKE	  ");
		sql.append("  	               OrgCond.strOrganizationCode || '-%') organizationaux,	  ");
		sql.append("  	       FlexibleCheck	  ");
		sql.append("  	 Where (Currencys.lngCurrencyID = 1)	  ");
		sql.append("  	   And Account.lngAccountID = AccountDaily.lngAccountID	  ");
		sql.append("  	   And Currencys.lngCurrencyID(+) = AccountDaily.lngCurrencyID	  ");
		sql.append("  	   And Customer.lngCustomerID(+) = AccountDaily.lngCustomerID	  ");
		sql.append("  	   And Customer.lngCustomerTypeID = CustomerType.lngCustomerTypeID(+)	  ");
		sql.append("  	   And Employee.lngEmployeeID(+) = AccountDaily.lngEmployeeID	  ");
		sql.append("  	   AND AccountDaily.lngOrganizationID = Organization.lngOrganizationID	  ");
		sql.append("  	   AND AccountDaily.lngSourceOrganizationID =	  ");
		sql.append("  	       OrganizationAux.lngOrganizationID	  ");
		sql.append("  	       and class1.LNGCLASSID = AccountDaily.LNGCLASSID1	  ");
		sql.append("  	   And AccountDaily.strDate <= '"+endDate+"'	  ");
		sql.append("  	   And AccountDaily.strFlexibleID = FlexibleCheck.strFlexibleID(+)	  ");
		sql.append("  	   and (account.straccountcode like '1122%' or	  ");
		sql.append("  	       account.straccountcode like '1122%')	  ");
		sql.append("  	 Group By ACCOUNT.STRACCOUNTCODE,	  ");
		sql.append("  	          ACCOUNT.STRACCOUNTNAME,	  ");
		sql.append("  	          ACCOUNT.INTDIRECTION,	  ");
		sql.append("  	          customer.STRCUSTOMERNAME,	  ");
		sql.append("  	          class1.strclassname	  ");
		sql.append("  	 Order By ACCOUNT.STRACCOUNTCODE,	  ");
		sql.append("  	          ACCOUNT.STRACCOUNTNAME,	  ");
		sql.append("  	          ACCOUNT.INTDIRECTION	  ");

		return sql.toString();
	}


	public List<CodeBean> getCompanyData(String type) {
	    DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.MYSQL);
			Session session = getSession();
			StringBuffer sql = new StringBuffer();
			sql.append(" 	SELECT e.*  	 ");
//			sql.append(" 	SELECT e.CODE,e.NAME  	 ");
			sql.append(" 	FROM s_code	e ");
			sql.append(" 	WHERE IS_VALID ='1' and p_code='1' AND TYPE= ?	 ");
			SQLQuery query = session.createSQLQuery(sql.toString()).addEntity("e", CodeBean.class)  ;
			query.setString(0, type);
			List<CodeBean> goodsBeans = query.list();
			return goodsBeans;
	}
	
	public List getCB(String pcode,String type){
		DynamicDataSourceHolder.setDataSourceType(DynamicDataSourceGlobal.MYSQL);
		Session session = getSession();
		StringBuffer sql = new StringBuffer();
		sql.append(" 	SELECT e.*  	 ");
		sql.append(" 	FROM s_code	e ");
		sql.append(" 	WHERE IS_VALID ='1' and p_code=? AND TYPE= ?	 ");
		SQLQuery query = session.createSQLQuery(sql.toString()).addEntity("e", CodeBean.class)  ;
		query.setString(0, pcode);
		query.setString(1, type);
		List<CodeBean> goodsBeans = query.list();
		
		List<CodeBeanList> list1 = new ArrayList();
		CodeBeanList cbl = null;
		for (CodeBean cb : goodsBeans) {
			cbl = new CodeBeanList();
			cbl.setName(cb.getName());
			cbl.setCode(cb.getCode());
			List l = getCB(cb.getCode(),type);
			cbl.setCbList(l);
			list1.add(cbl);
		}
		return list1;
	}
	
	private String getSql6(String startDate,String endDate){
		StringBuffer sql = new StringBuffer();
		sql.append(" 	Select	  ");
		sql.append(" 	       customer.STRCUSTOMERNAME,	  ");
		sql.append(" 	       SUM(DECODE(ACCOUNT.INTDIRECTION, 1, 1, 0) *	  ");
		sql.append(" 	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+startDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  -1,	  ");
		sql.append(" 	                  1,	  ");
		sql.append(" 	                  0) * ((dblUnPostedDebit + dblPostedDebit) -	  ");
		sql.append(" 	                        (dblUnPostedCredit + dblPostedCredit))) +	  ");
		sql.append(" 	       SUM(DECODE(ACCOUNT.INTDIRECTION, -1, 1, 0) *	  ");
		sql.append(" 	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+startDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  -1,	  ");
		sql.append(" 	                  1,	  ");
		sql.append(" 	                  0) * ((dblUnPostedCredit + dblPostedCredit) -	  ");
		sql.append(" 	                        (dblUnPostedDebit + dblPostedDebit))) As 期初余额本币金额,	  ");
		sql.append(" 	       SUM(DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+startDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  -1,	  ");
		sql.append(" 	                  0,	  ");
		sql.append(" 	                  1) *	  ");
		sql.append(" 	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+startDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  1,	  ");
		sql.append(" 	                  0,	  ");
		sql.append(" 	                  1) * (dblUnPostedDebit + dblPostedDebit)) As 本期借方发生额本币金额,	  ");
		sql.append(" 	       SUM(DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  -1,	  ");
		sql.append(" 	                  0,	  ");
		sql.append(" 	                  1) *	  ");
		sql.append(" 	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  1,	  ");
		sql.append(" 	                  0,	  ");
		sql.append(" 	                  1) * (dblUnPostedCredit + dblPostedCredit)) As 本期贷方发生额本币金额,	  ");
		sql.append(" 	       SUM(DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  1,	  ");
		sql.append(" 	                  0,	  ");
		sql.append(" 	                  DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                              TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                         -1,	  ");
		sql.append(" 	                         0,	  ");
		sql.append(" 	                         (dblUnPostedDebit + dblPostedDebit)))) As 借方累计本币金额,	  ");
		sql.append(" 	       SUM(DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  1,	  ");
		sql.append(" 	                  0,	  ");
		sql.append(" 	                  DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                              TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                         -1,	  ");
		sql.append(" 	                         0,	  ");
		sql.append(" 	                         (dblUnPostedCredit + dblPostedCredit)))) As 贷方累计本币金额,	  ");
		sql.append(" 	       SUM(DECODE(ACCOUNT.INTDIRECTION, 1, 1, 0) *	  ");
		sql.append(" 	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  1,	  ");
		sql.append(" 	                  0,	  ");
		sql.append(" 	                  1) * ((dblUnPostedDebit + dblPostedDebit) -	  ");
		sql.append(" 	                        (dblUnPostedCredit + dblPostedCredit))) +	  ");
		sql.append(" 	       SUM(DECODE(ACCOUNT.INTDIRECTION, -1, 1, 0) *	  ");
		sql.append(" 	           DECODE(SIGN(TO_DATE(ACCOUNTDAILY.STRDATE, 'YYYY-MM-DD') -	  ");
		sql.append(" 	                       TO_DATE('"+endDate+"', 'YYYY-MM-DD')),	  ");
		sql.append(" 	                  1,	  ");
		sql.append(" 	                  0,	  ");
		sql.append(" 	                  1) * ((dblUnPostedCredit + dblPostedCredit) -	  ");
		sql.append(" 	                        (dblUnPostedDebit + dblPostedDebit))) As 期末余额本币金额	  ");
		sql.append(" 	  From Account,	  ");
		sql.append(" 	       AccountDaily,	  ");
		sql.append(" 	       Currencys,	  ");
		sql.append(" 	       Customer,	  ");
		sql.append(" 	       CustomerType,	  ");
		sql.append(" 	       Employee,	  ");
		sql.append(" 	       (SELECT ORGANIZATION.*	  ");
		sql.append(" 	          FROM ORGANIZATION,	  ");
		sql.append(" 	               (SELECT * FROM ORGANIZATION WHERE lngOrganizationID = 1) OrgCond	  ");
		sql.append(" 	         WHERE ORGANIZATION.strOrganizationCode =	  ");
		sql.append(" 	               OrgCond.strOrganizationCode	  ");
		sql.append(" 	            OR ORGANIZATION.strOrganizationCode LIKE	  ");
		sql.append(" 	               OrgCond.strOrganizationCode || '-%') Organization,	  ");
		sql.append(" 	       (SELECT ORGANIZATION.*	  ");
		sql.append(" 	          FROM ORGANIZATION,	  ");
		sql.append(" 	               (SELECT * FROM ORGANIZATION WHERE lngOrganizationID = 1) OrgCond	  ");
		sql.append(" 	         WHERE ORGANIZATION.strOrganizationCode =	  ");
		sql.append(" 	               OrgCond.strOrganizationCode	  ");
		sql.append(" 	            OR ORGANIZATION.strOrganizationCode LIKE	  ");
		sql.append(" 	               OrgCond.strOrganizationCode || '-%') organizationaux,	  ");
		sql.append(" 	       FlexibleCheck	  ");
		sql.append(" 	 Where (Currencys.lngCurrencyID = 1)	  ");
		sql.append(" 	   And Account.lngAccountID = AccountDaily.lngAccountID	  ");
		sql.append(" 	   And Currencys.lngCurrencyID(+) = AccountDaily.lngCurrencyID	  ");
		sql.append(" 	   And Customer.lngCustomerID(+) = AccountDaily.lngCustomerID	  ");
		sql.append(" 	   And Customer.lngCustomerTypeID = CustomerType.lngCustomerTypeID(+)	  ");
		sql.append(" 	   And Employee.lngEmployeeID(+) = AccountDaily.lngEmployeeID	  ");
		sql.append(" 	   AND AccountDaily.lngOrganizationID = Organization.lngOrganizationID	  ");
		sql.append(" 	   AND AccountDaily.lngSourceOrganizationID =	  ");
		sql.append(" 	       OrganizationAux.lngOrganizationID	  ");
		sql.append(" 	   And AccountDaily.strDate <= '"+endDate+"'	  ");
		sql.append(" 	   And AccountDaily.strFlexibleID = FlexibleCheck.strFlexibleID(+)	  ");
		sql.append(" 	   and (account.straccountcode like '1122%' or	  ");
		sql.append(" 	       account.straccountcode like '1122%')	  ");
		sql.append(" 	 Group By ACCOUNT.STRACCOUNTCODE,	  ");
		sql.append(" 	          ACCOUNT.STRACCOUNTNAME,	  ");
		sql.append(" 	          ACCOUNT.INTDIRECTION,	  ");
		sql.append(" 	          customer.STRCUSTOMERNAME	  ");
		sql.append(" 	 Order By ACCOUNT.STRACCOUNTCODE,	  ");
		sql.append(" 	          ACCOUNT.STRACCOUNTNAME,	  ");
		sql.append(" 	          ACCOUNT.INTDIRECTION	  ");

		return sql.toString();
	}
}
