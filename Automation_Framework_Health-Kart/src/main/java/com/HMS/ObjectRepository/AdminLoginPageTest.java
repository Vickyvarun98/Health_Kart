package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPageTest {

	public AdminLoginPageTest(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "username")
	private WebElement UsernameTxt;
	@FindBy(name = "password")
	private WebElement PasswordTxt;
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement LoginButton;
	@FindAll({@FindBy(partialLinkText = "Page"),@FindBy(xpath = "//a[contains(text(),'Page')]")})
	private WebElement BackPageLink;
		
	public WebElement getUsernameTxt() {
		return UsernameTxt;
	}
	public WebElement getPasswordTxt() {
		return PasswordTxt;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
	public WebElement getBackPageLink() {
		return BackPageLink;
	}


	public void login(String Username,String Password) {
		UsernameTxt.sendKeys(Username);
		PasswordTxt.sendKeys(Password);
		LoginButton.click();
	}
	
	
	
}
