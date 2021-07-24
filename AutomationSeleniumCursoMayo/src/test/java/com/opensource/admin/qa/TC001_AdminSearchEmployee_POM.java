package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.LogIn.LoginPage;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

public class TC001_AdminSearchEmployee_POM {
	WebDriver driver;
	SeleniumWrapper seleniumWrapper;
	LoginPage login;
	String username, password;
  
  @BeforeTest
  public void beforeTest() {
	  seleniumWrapper = new SeleniumWrapper(driver);
	  driver = seleniumWrapper.chromeDriverConnection();
	  login =  new LoginPage (driver);
	  
	  //SETUP DATA
	  this.username = "Admin";
	  this.password = "admin123";
  }

  @Test
  public void TC001_AdminSearchEmployee_POM_Script() {
  
	  //Step 1
	  login.setup(GlobalVariables.QA_URL);
	  
	  //Step 2
	  login.LoginOrange(username, password);
	  
	  //Step 3
	  um.validateLoginSuccessfully ();
	  
	    
  }  
  
  @AfterTest
  public void afterTest() {
  }

}
