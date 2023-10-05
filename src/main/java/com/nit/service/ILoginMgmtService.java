package com.nit.service;

public interface ILoginMgmtService 
{
	public boolean login(String user,String pwd);
	public String registeruser(String user,String role);
}
