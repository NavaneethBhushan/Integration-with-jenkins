package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.EventPage;
import com.qa.pages.Homepage;
import com.qa.pages.KannadlangPage;
import com.qa.pages.Loginpage;

public class Homepagetest extends Testbase {
	Loginpage loginpage;
    Homepage homepage;
    KannadlangPage kannadlangPage;
    EventPage eventpage;
   
	public Homepagetest() throws IOException{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
	initialization();
	loginpage=new Loginpage();
	homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	
	}
	@AfterMethod
	public void teardown() {
     driver.quit();
	}

	@Test(priority=1)
	public void verifyFBprofilename() {
	String fbname=homepage.verifyprofileuser();
	System.out.println(fbname);
	Assert.assertEquals("Navaneeth",fbname);
	}
	
	@Test(priority=2)
	public void languagenavigate() throws IOException, InterruptedException {
		Thread.sleep(6000);
	kannadlangPage= homepage.clicklanguageTitle();
	System.out.println(driver.getTitle());
	}
	
	@Test(priority=3)
	public void eventnavigate() throws IOException, InterruptedException {
		Thread.sleep(6000);
	eventpage= homepage.verifyEventnavigate();
	System.out.println(driver.getTitle());
	driver.navigate().back();
	}
}
