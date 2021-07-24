package com.opensource.admin.qa;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class TC004_Admin_DeleteUser {

	int random = (int) (Math.random() * 100);
	String newUser = "DChase"+ random;
	
	@BeforeTest
	public void beforeTest() {

		// Data 
		String username = "Admin";
		String password = "admin123";
		String employee = "Dominic Chase";
		String mainPwd = "domchase123";

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//CREACION DE UN NUEVO USUARIO
		// Step #1 - Open Browser "OrangeHRM" web page
		Reporter.log("Open Browser \"OrangeHRM\" web page");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step #2 - Enter Username and Password
		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Step #3 - Validate that you have logged in successfully
		Reporter.log("Validate that you have logged in successfully");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"menu_admin_viewAdminModule\"]")));

		// Step #4 - Click Admin - Go to the admin page
		Reporter.log("Click Admin - Go to the admin page");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='searchSystemUser_userName']")));

		// Step #5 - Click Add
		Reporter.log("Click Add");
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();

		// Step #6 - Enter valid Employee Name
		Reporter.log("Enter valid Employee Name");
		driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empName']")).sendKeys(employee);

		// Step #7 - Enter valid Employee Name
		Reporter.log("Enter valid Employee Name");
		driver.findElement(By.xpath("//input[@id='systemUser_userName']")).sendKeys(newUser);

		// Step #8 - Change Status Disabled
		Reporter.log("Change Status Disabled");
		driver.findElement(By.xpath("//input[@id='systemUser_password']")).sendKeys(mainPwd);
		driver.findElement(By.xpath("//input[@id='systemUser_confirmPassword']")).sendKeys(mainPwd);

		// Step #9 - Click Save
		Reporter.log("Click Save");
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void TC004_Admin_DeleteUser_Script() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Data
		String username = "Admin";
		String password = "admin123";
		
		// Step #1 - Open Browser "OrangeHRM" web page
		Reporter.log("Open Browser \"OrangeHRM\" web page");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step #2 - Enter Username and Password
		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step #3 - Validate that you have logged in successfully
		Reporter.log("Validate that you have logged in successfully");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"menu_admin_viewAdminModule\"]")));

		// Step #4 - Click Admin - Go to the admin page
		Reporter.log("Click Admin - Go to the admin page");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='searchSystemUser_userName']")));

		// Step #5 - Search username in field "Username"
		Reporter.log("Click Search");
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(newUser);
		
		// Step #6 - Click Search
		Reporter.log("Click Search");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Step #7 - Verify username exist in table
		Reporter.log("Verify username exist in table");
		String getUsername = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        Assert.assertEquals(getUsername, newUser);
        
        //Step #8 - Select User
		Reporter.log("Select User");
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).click();
		
		 //Step #9 - Click Delete
		Reporter.log("Click Delete");
		driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		//Step #10 - Validate pop-window is displayed: "Delete Records?"
//		Reporter.log("Validate pop-window is displayed: \"Delete Records?\"");
//		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		
		
		
		
	
	}

	@AfterTest
	public void afterTest() {
	}

}
