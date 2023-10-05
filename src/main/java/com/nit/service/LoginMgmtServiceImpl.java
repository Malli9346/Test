package com.nit.service;

import com.nit.DAO.ILoginDAO;

public class LoginMgmtServiceImpl implements ILoginMgmtService
{
	private ILoginDAO dao;

	public LoginMgmtServiceImpl(ILoginDAO dao) {
		this.dao=dao;
	}

	@Override
	public boolean login(String user, String pwd) { 
	if(user.equalsIgnoreCase("") || pwd.equalsIgnoreCase(""))
		throw new IllegalArgumentException("Invalid inputs");
		
	int count=dao.authenticate(user, pwd);
	return false;
	//res=(num1>num2) ? (num1+num2):(num1-num2)
	
	}

	@Override
	public String registeruser(String user, String role) {
		if(!user.equals("")&& !role.equals("")) {
			dao.addUser(user, role);
			return "User added";
		}
		else
			return "User not added";
	}
}
