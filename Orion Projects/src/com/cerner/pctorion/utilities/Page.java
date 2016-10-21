package com.cerner.pctorion.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	 public WebDriver driver;
	 
		public Page(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(this.driver, this);
			
		}

}
