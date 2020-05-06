package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.Homepage;
import com.qa.pages.Loginpage;

public class Loginpagetest extends Testbase{
	Loginpage loginpage;
	Homepage homepage;

	public Loginpagetest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
	initialization();
    loginpage=new Loginpage();
	
	}
	@AfterMethod
	public void teardown() {
     driver.quit();
	}

	@Test(priority=1)
	public void loginpagetitletest() {
	String title=loginpage.validatePageTitle();
	System.out.println(title);
	Assert.assertEquals("Facebook – log in or sign up",title);
	}
	
	@Test(priority=2)
	public void loginfbtest() throws IOException {
	homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	System.out.println(driver.getTitle());
	}
	}

