package com.yrkj.extract.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="P_profit")
public class Profit implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  id ;    
	@Column(name="project_code",  nullable=false, length=8)
	private String project_code ;
	@Column(name="company_code",  nullable=false, length=8)
	private String company_code ;
	@Column(name="profit_data",  nullable=false, length=16)
	private String profit_data ;
	@Column(name="profit_date",  nullable=false, length=8)
	private String profit_date ;
	@Column(name="	account_code",  nullable=false, length=8)
	private String 	account_code ;

	public Profit() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProject_code() {
		return project_code;
	}
	public void setProject_code(String project_code) {
		this.project_code = project_code;
	}
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}
	public String getProfit_data() {
		return profit_data;
	}
	public void setProfit_data(String profit_data) {
		this.profit_data = profit_data;
	}
	public String getProfit_date() {
		return profit_date;
	}
	public void setProfit_date(String profit_date) {
		this.profit_date = profit_date;
	}
	public String getAccount_code() {
		return account_code;
	}
	public void setAccount_code(String account_code) {
		this.account_code = account_code;
	}     

	
	
}
