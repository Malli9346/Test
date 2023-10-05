package com.nit.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nit.DAO.ILoginDAO;
import com.nit.service.ILoginMgmtService;
import com.nit.service.LoginMgmtServiceImpl;

public class LoginTestsWithMockito 
{
	private static ILoginMgmtService loginService;
	private static ILoginDAO loginDAO;
	
	@BeforeAll
	public static void setup()
	{
		loginDAO=Mockito.mock(ILoginDAO.class);
		System.out.println("Mockobject class name::"+loginDAO.getClass());
		loginService=new LoginMgmtServiceImpl(loginDAO);
	}
	@AfterAll
	public static void clearDown()
	{
		loginDAO=null;
		loginService=null;		
	}
	@Test
	public void testLoginWithValidCredentials()
	{
		Mockito.when(loginDAO.authenticate("raja", "rani")).thenReturn(1);
		assertTrue(loginService.login("raja", "rani"));
	}
	@Test
	public void testLoginWithInvalidCredentials()
	{
		Mockito.when(loginDAO.authenticate("raja", "rani1")).thenReturn(0);
		assertFalse(loginService.login("raja", "rani1"));
	}	@Test
	public void testLoginWithNoCredentials()
	{
		assertThrows(IllegalArgumentException.class, ()->loginService.login("", ""));
	}
	@Test
	public void testRegisterUserWithSpy()
	{
		ILoginDAO loginDAoSpy=Mockito.spy(ILoginDAO.class);
		ILoginMgmtService loginService=new LoginMgmtServiceImpl(loginDAoSpy);
		loginService.registeruser("raja", "admin");
		loginService.registeruser("suresh", "customer");
		loginService.registeruser("jani", "");
		Mockito.verify(loginDAoSpy,Mockito.times(1)).addUser("raja", "admin");
		Mockito.verify(loginDAoSpy,Mockito.times(1)).addUser("suresh", "customer");
		Mockito.verify(loginDAoSpy,Mockito.times(0)).addUser("jani", "");
	}
}
