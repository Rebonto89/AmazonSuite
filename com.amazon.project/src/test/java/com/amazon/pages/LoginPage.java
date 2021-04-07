/**
 * 
 */
package com.amazon.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.amazon.initDriver.initDriver;

/**
 * @author 311035
 *
 */
public class LoginPage extends initDriver{

	WebDriver driver;
	
	
	By txtEmailPh = By.id("ap_email");
	By btnContinue = By.id("continue");
	By txtPassword = By.id("ap_password");
	By btnSign = By.id("signInSubmit");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void Login2Amazon(String Ph,String pass)
	
	{
		driver.findElement(txtEmailPh).sendKeys(Ph);
		driver.findElement(btnContinue).click();
		driver.findElement(txtPassword).sendKeys(pass);
		driver.findElement(btnSign).click();
		
	}
	
	
}
