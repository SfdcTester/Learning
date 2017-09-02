package TestNGPractice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example2 
{
	@Test(priority=2)
	public void Method1()
	{
		System.out.println("Method1");
		Reporter.log("TestNG framework Method1");			// related to TestNG frame work. will display in console
	}
	
	@Test(priority=1)
	public void Method2()
	{
		System.out.println("Method2");
		Reporter.log("TestNG framework Method2");
	}
	
	@AfterClass
	public void Method3()
	{
		System.out.println("Method3");
	}
	
	@BeforeClass
	public void Method4()
	{
		System.out.println("Method4");  	 	// sysout is related to java
	}
	
	@BeforeMethod
	public void method5()
	{
		System.out.println("Method5");
	}
	
	@AfterMethod
	private void Method6()
	{
		System.out.println("Method6");
	}
}