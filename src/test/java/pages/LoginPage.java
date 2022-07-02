package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement login;
	
	public void username(String text)
	{
		username.sendKeys(text);
	}
	
	public void password(String text)
	{
		password.sendKeys(text);
	}
	
	public void login()
	{
		login.click();
	}
	
	public void doLogin(String usernameText,String passwordText)
	{
		username.sendKeys(usernameText);
		password.sendKeys(passwordText);
		login.click();
	}
	

}
