package com.opensource.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Selenium Wrapper Class Base Class
 * 
 * @author LOGICSTUDIO
 *
 */

public class SeleniumWrapper {

	private WebDriver driver;

	/**
	 * Constructor Selenium Wrapper @author logicstudio @param
	 * driver @return @throws
	 */

	public SeleniumWrapper(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * Chrome Driver Connection
	 * 
	 * @author LOGICSTUDIO
	 */

	public WebDriver chromeDriverConnection() {
		System.setProperty(GlobalVariables.CHROME_DRIVER_NAME, GlobalVariables.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		return driver;

	}

	/**
	 * Reporter Log
	 * 
	 * @author LOGICSTUDIO
	 * 
	 */

	public void reportLog(String log) {
		Reporter.log(log);
	}

	/**
	 * Implicit Wait Metodo
	 * 
	 * @author LOGICSTUDIO
	 */

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * Launch Browser
	 * 
	 * @author LOGICSTUDIO
	 */

	public void launchBrowser(String url) {
		try {

			Reporter.log("Launching..." + url + "application");
			driver.get(url);
			driver.manage().window().maximize();
			implicitWait(5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Find Element
	 * 
	 * @author LOGICSTUDIO
	 */

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * Type Text
	 * 
	 * @author LOGICSTUDIO
	 */

	public void Type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	/**
	 * Click
	 * 
	 * @author LOGICSTUDIO
	 */

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	/**
	 * Wait For Element Present
	 * 
	 * @author LOGICSTUDIO
	 */

	public void waitForElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get Text
	 * 
	 * @author LOGICSTUDIO
	 */
	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * Hard Assertion
	 * 
	 * @author LOGICSTUDIO
	 * @param
	 */
	public void AssertEquals(String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			Assert.fail("Not able to assert actual value <" + actualValue + "> with expected value <" + expectedValue
					+ ">");
		}
	}

	/**
	 * Get Value from Excel
	 * 
	 * @author LOGICSTUDIO
	 */

	public String getCellData(String excelName, int row, int column) {
		try {

			// Reading Data
			FileInputStream fis = new FileInputStream(GlobalVariables.PATH_EXCEL_DATA + excelName + ".xlsx");
			// Constructs an XSSFWorkbook object
			@SuppressWarnings("resource")
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			String value = cell.getStringCellValue();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}

}

//	/*
//	 * Take screenshot
//	 *
//	 * @author Ricardo Avalos
//	 * 
//	 * @throws IOException
//	 */
//public String takeScreenshot(String fileName){
//try {
//String pathFileName= GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
//Screenshot screenshot = new AShot().takeScreenshot(driver);
//ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
//return pathFileName;
//} catch (Exception e) {
//System.out.println(e.getMessage());
//return null;
//}

//public static final String PATH_SCREENSHOTS = System.getProperty("user.dir")+"/test-output/screenshots/";



