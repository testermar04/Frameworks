package testscripts.regression;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ValidateLoginUsingDataProviderExcel extends BaseTest{
	
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
		
		int noOfRows=ws2.getPhysicalNumberOfRows()-1;
		
		int noOfCells=ws2.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] obj=new Object[noOfRows][noOfCells];
		
		for(int i=0;i<noOfRows;i++)
		{
			for(int j=0;j<noOfCells;j++)
			{
				obj[i][j]=ws2.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		
		
		
		
		return obj;
		
	}

}
