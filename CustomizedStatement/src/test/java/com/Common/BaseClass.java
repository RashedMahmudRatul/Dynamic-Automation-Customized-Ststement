package com.Common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver; 
	
  @Parameters("browser")
  @BeforeClass
  public void broswerConfig(String bswr) {
		
		
		  if(bswr.equals("firefox"))
		  { 
		  WebDriverManager.firefoxdriver().setup();
		  
		  
		  driver= new FirefoxDriver();
		  }
		  
		  else if(bswr.equals("chrome"))
		  {
		  WebDriverManager.chromedriver().setup();
		  //Headless
		  ChromeOptions obj = new ChromeOptions();
		  obj.setHeadless(true);
		 driver = new ChromeDriver(obj);
		 // driver = new ChromeDriver();
		  }
		
		
	   // WebDriverManager.firefoxdriver().setup();
		// driver = new FirefoxDriver();
	  
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

  }
 

  @AfterClass
  public void close()
  {
	  driver.quit();
  }
  
  
  @Test(description= "Check if login  goes to manager page")
  public void login() {
	  
	  driver.get("http://demo.guru99.com/V4/");
	  
	 driver.findElement(By.name("uid")).sendKeys("mngr291478");
	 driver.findElement(By.name("password")).sendKeys("YdApyja"); 
	 driver.findElement(By.name("btnLogin")).click(); 
	 
	 String postcondition = "Manger Id : mngr291478";
	 String actualcondition= driver.findElement(By.cssSelector("tr.heading3 > td:nth-child(1)")).getText();
	 if(postcondition.equals(actualcondition))
	 {
		 System.out.println("Login Test Pass");
	 }
	 else
	 {
		 System.out.println("Test Failled");
	 }
	 driver.findElement(By.cssSelector(".menusubnav > li:nth-child(14) > a:nth-child(1)")).click();

}
  
  

/*
 * @AfterTest public void scrnShot(WebDriver driver, String Name) throws
 * IOException { TakesScreenshot ts = (TakesScreenshot)driver; File source =
 * ts.getScreenshotAs(OutputType.FILE); File target = new
 * File(System.getProperty("user.dir")+Name+"/Sshot/"+".png");
 * FileUtils.copyFile(source, target);
 * 
 * }
 */
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
}
