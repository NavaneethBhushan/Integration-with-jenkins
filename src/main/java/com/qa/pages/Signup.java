package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Testbase;

public class Signup extends Testbase {
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement surName;
	
	@FindBy(name="reg_email__")
	WebElement MobileOrEmail;
	
	@FindBy(name="reg_passwd__")
	WebElement Newpassword;
	
	public Signup() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void newaccount(String fname,String lname,String mail,String pwd,String day,String month,String year) {
		firstName.sendKeys(fname);
		surName.sendKeys(lname);
		MobileOrEmail.sendKeys(mail);
		Newpassword.sendKeys(pwd);
		
		Select daydrop=new Select(driver.findElement(By.id("day")));
		daydrop.selectByVisibleText(day);
		
		Select monthdrop=new Select(driver.findElement(By.id("month")));
		monthdrop.selectByVisibleText(month);
		
		Select yeardrop=new Select(driver.findElement(By.id("year")));
		yeardrop.selectByVisibleText(year);
					
				}

}
