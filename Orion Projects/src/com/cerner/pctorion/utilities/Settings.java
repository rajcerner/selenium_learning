package com.cerner.pctorion.utilities;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {


	public WebDriver driver = new FirefoxDriver();
	


	@BeforeTest
	public void setup () {
		
		driver.manage().window().maximize();
		driver.get("https://deveng.test.devcernerpowerchart.com/search/patients");
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	} 

	@AfterTest
	public void tearDown() {
		// close the browser
		driver.quit();
	}
}
