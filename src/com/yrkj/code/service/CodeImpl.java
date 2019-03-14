package com.yrkj.code.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sun.org.omg.SendingContext.CodeBase;
import com.yrkj.code.bean.CodeBean;
import com.yrkj.code.bean.PCodeBean;
import com.yrkj.code.dao.CodeDao;

@Service
public class CodeImpl implements ICode{

	@Resource
	private CodeDao codeDao;
	
	public List selCode(HttpServletRequest request) {
		CodeBean cb = new CodeBean();
		return null;
	}

	public void saveCode(HttpServletRequest request) {
		CodeBean cb = new CodeBean();
		
	}

	public void delCode(HttpServletRequest request) {
		CodeBean cb = new CodeBean();

		
	}

	public void updateCode(HttpServletRequest request) {
		CodeBean cb = new CodeBean();
		
	}

	public List selPCode(HttpServletRequest request) {
		PCodeBean pcb = new PCodeBean();
		return null;
	}

	public void savePCode(HttpServletRequest request) {
		PCodeBean pcb = new PCodeBean();

		
	}

	public void delPCode(HttpServletRequest request) {
		PCodeBean pcb = new PCodeBean();

		
	}

	public void updatePCode(HttpServletRequest request) {
		PCodeBean pcb = new PCodeBean();

		
	}

}
