package com.cerner.pctorion.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class Settings {

	public ExtentReports extent;
	public ExtentTest test;
	public WebDriver driver = new FirefoxDriver();
	public static DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	public static String projectFolderPath =System.getProperty("user.dir");

	@BeforeTest
	public void setup () {
		projectFolderPath=projectFolderPath+"/Reports";
		System.out.println("******* "+projectFolderPath);

		extent = ExtentManger.Instance();

		driver.manage().window().maximize();
		driver.get("https://deveng.test.devcernerpowerchart.com/search/patients");
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	} 

	@AfterTest
	public void tearDown() {
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.quit();
	}
}
