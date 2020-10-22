package Tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Common.BaseClass;

public class CustomizedStatement003 extends BaseClass {
  
	
	@Test(description= "Fill Account no box with Characters")
	 public void CStatement003() throws IOException {
	driver.findElement(By.name("accountno")).sendKeys("abc");
	WebElement fdate =	 driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input"));
	fdate.sendKeys("10/20/2020");
	WebElement tdate = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"));
	tdate.sendKeys("10/22/2020");
	
	driver.findElement(By.name("amountlowerlimit")).sendKeys("30000");
	driver.findElement(By.name("numtransaction")).sendKeys("30");
	driver.findElement(By.name("AccSubmit")).click();
	

	
Alert alt = driver.switchTo().alert();
	
	String actualAlert = "Please fill all fields";
	String EAlertmsg = alt.getText();
	
	if(actualAlert.equals(EAlertmsg))
	{
		//scrnShot(driver,"CStatement003_Bug");
		System.out.println("Account No. with Character Test Failed");
	}
	else
	{
		//scrnShot(driver,"CStatement003");
		System.out.println("Account No. with Character Test Pass");
	}
	
		 
	 }

	 
  }

