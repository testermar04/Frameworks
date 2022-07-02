package testscripts.regression;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateLoginUsingExcel {
	
WebDriver  driver;
	
	@BeforeMethod
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}
	
	@Test
	public void validateLoginTest() throws IOException, InterruptedException
	{
		
		
		FileInputStream fis= new FileInputStream("src\\test\\resources\\TestData\\excels\\LoginData.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("credentials");
		
		Iterator<Row> rows=ws.rowIterator();
		
		//to skip first row
		
		rows.next();
		
		Row row=null;
		
		while(rows.hasNext())
		{
			
			row=rows.next();
			
			driver.findElement(By.xpath("//input[@name='username']")).clear();
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(row.getCell(0).getStringCellValue());
			
			driver.findElement(By.xpath("//input[@name='password']")).clear();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(row.getCell(1).getStringCellValue());
			
			driver.findElement(By.xpath("//input[@name='login']")).click();
			
			Assert.assertEquals(driver.getTitle(), row.getCell(2).getStringCellValue());
			
			driver.navigate().back();
			
			Thread.sleep(5000);
		}
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
