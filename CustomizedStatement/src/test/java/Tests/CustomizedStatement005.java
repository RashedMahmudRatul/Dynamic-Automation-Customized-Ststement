package Tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Common.BaseClass;

public class CustomizedStatement005 extends BaseClass {
  
	
	@Test(description= "Check Customized Statement Transaction Value Amount Lower Limit with  InValid inputs")
	 public void CStatement005() throws IOException {
	driver.findElement(By.name("accountno")).sendKeys("86169");
	WebElement fdate =	 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input"));
	fdate.sendKeys("10/20/2020");
	WebElement tdate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"));
	tdate.sendKeys("10/22/2020");
	
	driver.findElement(By.name("amountlowerlimit")).sendKeys("");
	driver.findElement(By.name("numtransaction")).sendKeys("30");
	driver.findElement(By.name("AccSubmit")).click();
	

	String actualmsg = "Transaction Details for Account No: 86169 from Date: 2020-10-21 to: 2020-10-22";
	String Expectmsg = driver.findElement(By.cssSelector(".heading3")).getText();
	
	if(actualmsg.equals(Expectmsg))
	{
		//scrnShot(driver,"CStatement001");
		System.out.println("Check Customized Statement with InValid inputs(Blank) Test Failed");
	}
	else
	{
		//scrnShot(driver,"CStatement001_BUG");
		System.out.println("Check Customized Statement with InValid inputs(Blank) Test Passed");
	}
	
		 
	 }

	 
  }

