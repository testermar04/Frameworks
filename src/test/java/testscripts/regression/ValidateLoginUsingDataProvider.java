package testscripts.regression;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ValidateLoginUsingDataProvider extends BaseTest{
	
	@Test(dataProvider="getData")
	public void validateLoginTest(String username,String password,String expTitle)
	{
		
		
			
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			
			
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			
			driver.findElement(By.xpath("//input[@name='login']")).click();
			
			
			Assert.assertEquals(driver.getTitle(),expTitle);
			
			
			
			
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] obj=new Object[4][3];
		
		
		obj[0][0]="reyaz0617";
		obj[0][1]="reyaz123";
		obj[0][2]="Adactin.com - Search Hotel";
		
		obj[1][0]="reyaz0617";
		obj[1][1]="reyaz456";
		obj[1][2]="Adactin.com - Hotel Reservation System";
		
		obj[2][0]="reyaz1212";
		obj[2][1]="reyaz123";
		obj[2][2]="Adactin.com - Hotel Reservation System";
		
		obj[3][0]="reyaz1212";
		obj[3][1]="reyaz456";
		obj[3][2]="Adactin.com - Hotel Reservation System";
		
		return obj;
		
	}

}
