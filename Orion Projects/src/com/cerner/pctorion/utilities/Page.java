package com.cerner.pctorion.utilities;

import java.text.DateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Page {
	
	 public WebDriver driver;
	 
		public Page(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(this.driver, this);
			
		}
		
		public void passTestCase(ExtentTest test,String visibleText,DateFormat formatter, String projectFolderPath){
			test.log(LogStatus.PASS, visibleText+" text found");
			test.log(LogStatus.INFO, test.addScreenCapture(ExtentManger.CaptureScreen(driver, projectFolderPath+formatter)));
		}
		
		public void failTestCase(ExtentTest test,String visibleText,DateFormat formatter, String projectFolderPath){
			test.log(LogStatus.FAIL, visibleText+" text found");
			test.log(LogStatus.INFO, test.addScreenCapture(ExtentManger.CaptureScreen(driver, projectFolderPath+formatter)));
		}

}
