package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class Homepage extends Testbase{

	@FindBy(xpath="//span[@class='_1vp5']")
	WebElement profileName;
	
	@FindBy(xpath="//a[@title='Kannada']")
	WebElement language;
	
	@FindBy(xpath="//ul[@class='_bui _3-96']//div[text()='Events' and @dir='ltr']")
	WebElement EventName;
	
	public Homepage() throws IOException{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyprofileuser() {
		return profileName.getText();
	}
	
	public KannadlangPage clicklanguageTitle() {
		language.click();	
		return new KannadlangPage();
}
	public EventPage verifyEventnavigate() {
		EventName.click();
		return new EventPage();
	}
}