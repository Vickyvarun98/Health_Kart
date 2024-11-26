package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPageTest {
	
	public PatientLoginPageTest(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "username")
	private WebElement UsernameTxt;
	@FindBy(name = "password")
	private WebElement PasswordTxt;
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement LoginButton;
	@FindAll({@FindBy(partialLinkText = "Forgot"),@FindBy(xpath = "//a[contains(text(),'Forgot')]"),@FindBy(xpath = "//a[@href='forgot-password.php']")})
	private WebElement ForgotPassword;	
	@FindAll({@FindBy(partialLinkText = "Create"),@FindBy(xpath = "//a[contains(text(),'Create')]"),@FindBy(xpath = "//a[@href='registration.php']")})
	private WebElement CreateAccount;
	
	public WebElement getUsernameTxt() {
		return UsernameTxt;
	}
	public WebElement getPasswordTxt() {
		return PasswordTxt;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
	public WebElement getForgotPassword() {
		return ForgotPassword;
	}
	public WebElement getCreateAccount() {
		return CreateAccount;
	}
	
	
	public void login(String Username,String Password) {
		UsernameTxt.sendKeys(Username);
		PasswordTxt.sendKeys(Password);
		LoginButton.click();
	}
	public void createPatient() {
		CreateAccount.click();
	}

}
