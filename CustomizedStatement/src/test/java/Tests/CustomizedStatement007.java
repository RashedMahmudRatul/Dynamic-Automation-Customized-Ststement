package Tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Common.BaseClass;

public class CustomizedStatement007 extends BaseClass {
  
	
	@Test(description= "Check Customized Statement with Future From-date and Future to-date inputs")
	 public void CStatement007() throws IOException {
	driver.findElement(By.name("accountno")).sendKeys("86169");
	WebElement fdate =	 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input"));
	fdate.sendKeys("10/20/2022");
	WebElement tdate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"));
	tdate.sendKeys("10/22/2022");
	
	driver.findElement(By.name("amountlowerlimit")).sendKeys("30000");
	driver.findElement(By.name("numtransaction")).sendKeys("30");
	driver.findElement(By.name("AccSubmit")).click();
	
	Alert alt  = driver.switchTo().alert();
	
	String actualmsg = "No Transaction details found !!!";
	String Expectmsg = alt.getText();
	
	if(actualmsg.equals(Expectmsg))
	{
		//scrnShot(driver,"CStatement001");
		System.out.println("Check Customized Statement with Future From-date and Future to-date inputs Test Failed");
	}
	else
	{
		//scrnShot(driver,"CStatement001_BUG");
		System.out.println("Check Customized Statement with Valid inputs Test Passed");
	}
	
		 
	 }

	 
  }

