package com.nit.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LoginTestsWithMockitoAnnotations
{
	@Test
	public void testList() 
	{
	List<String> listMock=Mockito.mock(ArrayList.class); //Mock
	List<String> listSpy=Mockito.spy(ArrayList.class); //Spy (or)
	listMock.add("table");
	Mockito.when(listMock.size()).thenReturn(10); //stub on Mock obj
	System.out.println(listMock.size()+" "+listSpy.size());
	}
}
