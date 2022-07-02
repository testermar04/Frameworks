package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class ValidateLoginPOM extends BaseTest {
	
	@Test
	public void validateLoginTest()
	{
		
		LoginPage lp=new LoginPage(driver);
		
		lp.username("reyaz0617");
		
		lp.password("reyaz123");
		
		lp.login();
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Search Hotel");
	}
	
	
	
}
