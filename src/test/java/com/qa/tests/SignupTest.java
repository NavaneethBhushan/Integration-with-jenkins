package com.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.Signup;
import com.qa.utility.TestUtil1;

public class SignupTest extends Testbase {
        Signup signup;
        
        String sheetName="FBsignup";
	
	public SignupTest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setup() throws IOException {
	initialization();	
	signup=new Signup();
	}
	
	@AfterMethod
	public void teardown() {
     driver.quit();
	}

	@DataProvider
	public Object[][] getfbTestData() {
	Object[][] data=TestUtil1.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=1,dataProvider="getfbTestData")
	public void createnewAccount(String fname,String lname,String mail,String pwd,String DOB) {
		String[] birthdate=DOB.split("-");
		String day=birthdate[0];
		String month=birthdate[1];
		String year=birthdate[2];
		signup.newaccount(fname,lname,mail,pwd,day,month,year);
	}
}
