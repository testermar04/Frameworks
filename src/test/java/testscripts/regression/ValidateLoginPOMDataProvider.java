package testscripts.regression;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class ValidateLoginPOMDataProvider extends BaseTest {
	
	@Test(dataProvider="getData")
	public void validateLoginTest(String username,String password,String expTitle)
	{
		test=reports.createTest("validateLogin");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.username(username);
		
		lp.password(password);
		
		lp.login();
		
		Assert.assertEquals(driver.getTitle(), expTitle);
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
