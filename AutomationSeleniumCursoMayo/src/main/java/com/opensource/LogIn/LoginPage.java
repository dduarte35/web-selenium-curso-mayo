package com.opensource.LogIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.SeleniumWrapper;

public class LoginPage extends SeleniumWrapper{
	
	//Constructor
	public LoginPage (WebDriver driver) {
		super (driver);
	}

	//Objetos
	By txtUsername = By.xpath("//input[@id='txtUsername']");
	By txtPassword = By.xpath("//input[@id='txtPassword']");
	By btnLogin = By.xpath("//input[@id='btnLogin']");
	
	
	//Metodos
	
	/**
	 * Set up environment
	 * @author LOGICSTUDIO
	 */
	
	public void setup(String url) {
		launchBrowser(url);
		
	}
	
	/**
	 * Login Orange App
	 * @author LOGICSTUDIO
	 */
	
	public void LoginOrange (String username, String password) {
		reportLog ("Login OrangeHRM web page...");
		Type(username, txtUsername);
		Type(password, txtPassword);
		click(btnLogin);
		implicitWait (5);
	}
	
	/**
	* Log out Orange
	* @author LOGICSTUDIO
	* 
	*/
	public void logoutOrange() {
	reportLog("Logout OrangeHRM web page...");
	click(btnWelcome);
	click(btnLogout);
	implicitWait(5);
	}
	
	
	/**
	 * Validate Login Access
	 * @author LOGICSTUDIO
	 */
	
	public void 
	
	
	
	
	
}
