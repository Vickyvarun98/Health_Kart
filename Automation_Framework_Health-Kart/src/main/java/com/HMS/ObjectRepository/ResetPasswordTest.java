package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordTest {
	
	
	public ResetPasswordTest(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindAll({@FindBy(id = "password"),@FindBy(name = "password")})
	private WebElement ResetPassword;
	@FindAll({@FindBy(id = "password_again"),@FindBy(name = "password_again")})
	private WebElement ConfirmPassword;
	@FindBy(partialLinkText = "Log")
	private WebElement Login;
	@FindAll({@FindBy(name = "change"),@FindBy(xpath = "//button[contains(text(),'Change')]")})
	private WebElement ChangeBtn;
	
	
	public WebElement getResetPassword() {
		return ResetPassword;
	}


	public WebElement getConfirmPassword() {
		return ConfirmPassword;
	}


	public WebElement getLogin() {
		return Login;
	}


	public WebElement getChangeBtn() {
		return ChangeBtn;
	}


	public void resetPassword(String NewPassword) {
		ResetPassword.sendKeys(NewPassword);
		ConfirmPassword.sendKeys(NewPassword);
		ChangeBtn.click();
	}
}
