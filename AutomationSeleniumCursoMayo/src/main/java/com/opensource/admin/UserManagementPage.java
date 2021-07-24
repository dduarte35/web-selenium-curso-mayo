package com.opensource.admin;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.SeleniumWrapper;

public class UserManagementPage extends SeleniumWrapper {
	
	public UserManagementPage (WebDriver driver) {
		
		super (driver);
	}

	By LinkUM = By.xpath ("//a[@id='menu_admin_viewAdminModule']");
	By txtUsername = By.xpath("//input[@id='searchSystemUser_userName']");
	By txtSearchUser = By.xpath("//input[@id='searchSystemUser_userName']");
	By btnSearch = By.xpath("//input[@id='searchBtn']");
	By tblUsername = By.xpath("//tbody/tr[1]/td[2]");
	
	/**
	 * Validate Login success
	 * @author LOGICSTUDIO
	 *
	 **/
	
	public void validateLoginSuccessfully() {
		reportLog ("Validate that you have logged in successfully");
		waitForElementPresent(LinkUM);
	}
	
	/**
	 * Click Admin
	 * @author LOGICSTUDIO
	 */
	
	public void clickAdmin () {
		reportLog ("Click Admin - Go to the admin page");
		click (LinkUM);
		waitForElementPresent (txtUsername);
	}
	
	/**
	 * Search Username
	 * @author LOGICSTUDIO
	 */
	
	public void searchUser(String username, boolean clickSearch) {
		reportLog ("Search username in field 'Username'");
		Type(username, txtSearchUser);
		if (clickSearch) {
			click(btnSearch);
		}
	}
	
	/**
	 * Validate exists in table
	 * @author LOGICSTUDIO
	 */
	
	public void validateUserTAble (String expectedUser) {
		reportLog ("Verify username exist in table");
		String actualUser = getText (tblUsername);
		assertEquals(actualUser, expectedUser);
	}
}
