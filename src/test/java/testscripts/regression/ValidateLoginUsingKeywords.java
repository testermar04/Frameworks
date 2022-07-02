package testscripts.regression;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

import base.BaseClass;
import keywords.LoginKeywords;

public class ValidateLoginUsingKeywords extends BaseClass {
	
	
	@Test
	public void validateLoginTest()
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
				keys.enterUserName(pr3.getProperty("usernameText"),"reyaz0617");
			}
			else if(action.equalsIgnoreCase("enterPassword"))
			{
				keys.enterPassword(pr3.getProperty("passwordText"),"reyaz123");
			}
			else if(action.equalsIgnoreCase("clickButton"))
			{
				keys.clickButton(pr3.getProperty("loginBtn"));
			}
			else if(action.equalsIgnoreCase("verifyTitle"))
			{
				keys.verifyTitle("Adactin.com - Search Hotel");
			}
			else if(action.equalsIgnoreCase("quitBrowser"))
			{
				keys.quitBrowser();
			}
			
		}
		
	}

}
