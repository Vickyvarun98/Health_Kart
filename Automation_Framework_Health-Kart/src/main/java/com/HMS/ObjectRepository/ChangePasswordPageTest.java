package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPageTest {

	public ChangePasswordPageTest(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "cpass")
	private WebElement CurrentPassword;
	@FindBy(name = "npass")
	private WebElement NewPassword;
	@FindBy(name = "cfpass")
	private WebElement ConformPassword;
	@FindBy(name = "submit")
	private WebElement Submitbtn;
	public WebElement getCurrentPassword() {
		return CurrentPassword;
	}
	public WebElement getNewPassword() {
		return NewPassword;
	}
	public WebElement getConformPassword() {
		return ConformPassword;
	}
	public WebElement getSubmitbtn() {
		return Submitbtn;
	}
	
	public void changePassword(String OPsd,String NPsd) {
		CurrentPassword.sendKeys(OPsd);
		NewPassword.sendKeys(NPsd);
		ConformPassword.sendKeys(NPsd);
		Submitbtn.click();
		
	}
	
	
}
