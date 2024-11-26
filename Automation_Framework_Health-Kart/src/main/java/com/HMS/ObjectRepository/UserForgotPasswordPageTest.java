package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserForgotPasswordPageTest {
	
	public UserForgotPasswordPageTest(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "fullname")
	private WebElement RegisteredName;
	@FindBy(name = "email")
	private WebElement RegisteredMail;
	@FindBy(name = "submit")
	private WebElement ResetBtn;
	@FindBy(partialLinkText = "Log")
	private WebElement Loginbtn;
	public WebElement getRegisteredName() {
		return RegisteredName;
	}
	public WebElement getRegisteredMail() {
		return RegisteredMail;
	}
	public WebElement getResetBtn() {
		return ResetBtn;
	}
	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	
	public void forgotPassword(String Username,String mail) {
		RegisteredName.sendKeys(Username);
		RegisteredMail.sendKeys(mail);
		ResetBtn.click();
	}
	

}
