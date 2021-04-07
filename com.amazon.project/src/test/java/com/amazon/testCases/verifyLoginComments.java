/**
 * 
 */
package com.amazon.testCases;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.Utilities.Utilities;
import com.amazon.initDriver.initDriver;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;

import Log4j.ReportingLogs;

/**
 * @author 311035
 *
 */


public class verifyLoginComments{
	
	WebDriver driver;
	ReportingLogs rprt=new ReportingLogs();
	@BeforeClass
	public void StartApp()
	{
	
	initDriver ini = new initDriver();
    ini.initDrvr();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	}
	
	@BeforeMethod
	public void LogStartTime()
	
	{
		rprt.startlog(verifyLoginComments.class);
	}
	
	
    @Parameters({"usrnm","pass"})
	@Test(priority=1,description="Login is being verified")	
	public void verifyPublicLogin(String usnm,String Pswrd) throws InterruptedException
	
	{   
		LoginPage logIn=new LoginPage(driver);
		logIn.Login2Amazon(usnm,Pswrd);
	       
	    String Usrname = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		Assert.assertTrue(Usrname.contains("Rebonto"), "User has not logged in successfully");
		rprt.setLog(verifyLoginComments.class, "Login Successful");
	    
	}
	@Test(priority=2,dependsOnMethods="verifyPublicLogin",description="Order Page is displayed")
	
	public void verifyNavigation2Trackorder(){
		
		HomePage hmPg = new HomePage(driver);
		hmPg.Nav2OrderPg();
		String trckordr = driver.findElement(By.xpath("//*[@class='a-color-secondary'][contains(text(),'Track')]")).getText();
		Assert.assertEquals("Track, return, or buy things again", trckordr, "User has not navigated to order page");
		rprt.setLog(verifyLoginComments.class, "Order Track page is displayed");
	}
	
	@AfterMethod
	public void takeSnapsOfFailure(ITestResult res){
		
		if(ITestResult.FAILURE==res.getStatus()){
			
			Utilities.captureScreenshot(driver,res.getName());
		}
		
		rprt.endLog(verifyLoginComments.class);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

	
}
