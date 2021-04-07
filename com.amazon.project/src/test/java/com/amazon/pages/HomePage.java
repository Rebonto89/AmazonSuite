/**
 * 
 */
package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author 311035
 *
 */
public class HomePage {

	WebDriver driver;
	By lnkAccountName = By.id("nav-link-accountList");
	
	public  HomePage(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	public void Nav2OrderPg(){
		driver.findElement(lnkAccountName).click();
	}
	
	
}
