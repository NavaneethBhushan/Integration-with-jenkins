package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utility.TestUtil1;
import com.qa.utility.WebEventlistener;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventlistener eventListener;
	
	public Testbase() throws IOException {
	try {	
	 prop=new Properties();
	FileInputStream ip=new FileInputStream("C:\\Users\\Navaneeth Bhushan\\eclipse-workspace\\POMTestautomation\\src\\main\\java\\com\\qa\\config\\config.properties");
	prop.load(ip);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}

  public static void initialization() throws IOException {
	  String browser=prop.getProperty("browser");
	  if (browser.equals("chrome")) {
	  System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\ChromeDriver.exe");
	    driver=new ChromeDriver(); 
	  }else if (browser.equals("firefox")){	
		  System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\GeckoDriver.exe");
      driver=new FirefoxDriver(); 
	}
	    e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventlistener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	 
	 driver.manage().timeouts().pageLoadTimeout(TestUtil1.Page_load_timeout,TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(TestUtil1.Implicit_wait,TimeUnit.SECONDS);
	 
	 driver.get(prop.getProperty("url"));
	  }
  
  }
  

