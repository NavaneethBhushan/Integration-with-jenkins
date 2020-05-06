package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class Loginpage extends Testbase{
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	public Loginpage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public Homepage login(String un,String pwd) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		return new Homepage();
	}
	}

	
