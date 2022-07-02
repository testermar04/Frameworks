package testscripts.regression;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import keywords.LoginKeywords;

public class ValidateLoginUsingHybrid extends BaseClass {
	
	
	@Test(dataProvider="getData")
	public void validateLoginTest(String username,String password,String expTitle)
	{
		
		Iterator<Row>  rows=ws2.rowIterator();
		
		rows.next();
		
		Row row=null;
		
		LoginKeywords keys=new LoginKeywords();
		
		while(rows.hasNext())
		{
			
			row=rows.next();
			
			String action=row.getCell(4).getStringCellValue();
			
			if(action.equalsIgnoreCase("startBrowser"))
			{
				keys.startBrowser(pr1.getProperty("browser"));
			}
			else if(action.equalsIgnoreCase("launchApp"))
			{
				keys.launchApp(pr1.getProperty("url"),pr1.getProperty("implicitWait"));
			}
			else if(action.equalsIgnoreCase("enterUserName"))
			{
				keys.enterUserName(pr3.getProperty("usernameText"),username);
			}
			else if(action.equalsIgnoreCase("enterPassword"))
			{
				keys.enterPassword(pr3.getProperty("passwordText"),password);
			}
			else if(action.equalsIgnoreCase("clickButton"))
			{
				keys.clickButton(pr3.getProperty("loginBtn"));
			}
			else if(action.equalsIgnoreCase("verifyTitle"))
			{
				keys.verifyTitle(expTitle);
			}
			else if(action.equalsIgnoreCase("quitBrowser"))
			{
				keys.quitBrowser();
			}
			
		}
		
	}
	
	
	@DataProvider
	public Object[][] getData()
	{

		int noOfRows=ws4.getPhysicalNumberOfRows()-1;
		
		int noOfCells=ws4.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] obj=new Object[noOfRows][noOfCells];
		
		for(int i=0;i<noOfRows;i++)
		{
			for(int j=0;j<noOfCells;j++)
			{
				obj[i][j]=ws4.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		
		
		
		
		return obj;
		
		
	}

}
