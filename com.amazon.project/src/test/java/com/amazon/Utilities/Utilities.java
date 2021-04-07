package com.amazon.Utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
   
	
	public static void captureScreenshot(WebDriver driver,String SsName){
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("./Screenshots/"+SsName+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}