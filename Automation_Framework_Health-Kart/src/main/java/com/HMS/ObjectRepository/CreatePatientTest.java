package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePatientTest {

	public CreatePatientTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "full_name")
	private WebElement FullNametxt;
	@FindBy(name = "address")
	private WebElement Addresstxt;
	@FindBy(name = "city")
	private WebElement Citytxt;
	@FindBy(xpath = "//label[contains(text(),'Female')]")
	private WebElement Female;
	@FindBy(xpath = "//label[contains(text(),'Male')]")
	private WebElement Male;
	@FindAll({ @FindBy(id = "email"), @FindBy(name = "email") })
	private WebElement Emailtxt;
	@FindAll({ @FindBy(id = "password"), @FindBy(name = "password") })
	private WebElement Passwordtxt;
	@FindAll({ @FindBy(id = "password_again"), @FindBy(name = "password_again") })
	private WebElement ConfirmPassword;
	@FindAll({ @FindBy(id = "submit"), @FindBy(name = "submit") })
	private WebElement Submitbtn;
	@FindBy(partialLinkText = "Log")
	private WebElement Login;

	public WebElement getFullNametxt() {
		return FullNametxt;
	}

	public WebElement getAddresstxt() {
		return Addresstxt;
	}

	public WebElement getCitytxt() {
		return Citytxt;
	}

	public WebElement getFemale() {
		return Female;
	}

	public WebElement getMale() {
		return Male;
	}

	public WebElement getEmailtxt() {
		return Emailtxt;
	}

	public WebElement getPasswordtxt() {
		return Passwordtxt;
	}

	public WebElement getConfirmPassword() {
		return ConfirmPassword;
	}

	public WebElement getSubmitbtn() {
		return Submitbtn;
	}

	public WebElement getLogin() {
		return Login;
	}
	
	
	
	
	
	
	

	public void createAccount(String Fullname, String Address, String City, String Gender, String Mail,
			String Password) {
		FullNametxt.sendKeys(Fullname);
		Addresstxt.sendKeys(Address);
		Citytxt.sendKeys(City);
		if (Male.getText().equalsIgnoreCase(Gender)) {
			Male.click();
		} else {
			Female.click();
		}
		Emailtxt.sendKeys(Mail);
		Passwordtxt.sendKeys(Password);
		ConfirmPassword.sendKeys(Password);
		
	}
	
	public void login() {
		Login.click();
	}
	
}
