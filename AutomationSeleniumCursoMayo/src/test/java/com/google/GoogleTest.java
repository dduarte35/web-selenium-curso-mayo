package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {
	  
  @BeforeTest
  public void beforeTest() {
	  
  }


	@Test                  
	  public void f() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://www.google.com/");
		  driver.manage().window().maximize();
	}
	
  @AfterTest
  public void afterTest() {
  }

}
