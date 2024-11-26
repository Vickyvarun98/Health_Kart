package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorForgotPasswordTest {

	
	public DoctorForgotPasswordTest(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "contactno")
	private WebElement Contact;
	@FindBy(name = "email")
	private WebElement Email;
	@FindBy(name = "submit")
	private WebElement Resetbtn;
	public WebElement getContact() {
		return Contact;
	}
	public WebElement getEmail() {
		return Email;
	}
	public WebElement getResetbtn() {
		return Resetbtn;
	}
	
	public void forgotPassword(String contact,String mail) {
		Contact.sendKeys(contact);
		Email.sendKeys(mail);
		Resetbtn.click();
	}
	
}
