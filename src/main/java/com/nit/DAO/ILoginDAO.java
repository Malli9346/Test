package com.nit.DAO;

public interface ILoginDAO 
{
	public int authenticate(String username, String Password);
	public String addUser(String username, String role);
}
