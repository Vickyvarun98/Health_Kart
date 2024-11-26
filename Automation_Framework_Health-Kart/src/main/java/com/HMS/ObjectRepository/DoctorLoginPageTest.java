package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPageTest {
	
	public DoctorLoginPageTest(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "username")
	private WebElement Usernametxt;
	@FindBy(name = "password")
	private WebElement Passwordtxt;
	@FindBy(name = "submit")
	private WebElement Submitbtn;
	@FindBy(xpath = "//a[contains(text(),'Forgot')]")
	private WebElement ForgotPassword;
	public WebElement getUsernametxt() {
		return Usernametxt;
	}
	public WebElement getPasswordtxt() {
		return Passwordtxt;
	}
	public WebElement getSubmitbtn() {
		return Submitbtn;
	}
	public WebElement getForgotPassword() {
		return ForgotPassword;
	}
	
	
	public void doctorLogin(String Username,String Password) {
		Usernametxt.sendKeys(Username);
		Passwordtxt.sendKeys(Password);
		Submitbtn.click();
	}
	

}
