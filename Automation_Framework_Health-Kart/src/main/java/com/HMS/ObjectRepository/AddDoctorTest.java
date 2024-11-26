package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HMS.Generic.WebDriverUtilityTest.WebDriverUtility;

public class AddDoctorTest {
	
	WebDriverUtility wu=new WebDriverUtility();
	public AddDoctorTest(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(name = "Doctorspecialization")
	private WebElement DocSpecialization;
	@FindBy(name = "docname")
	private WebElement DoctorName;
	@FindBy(name = "clinicaddress")
	private WebElement DoctorAddress;
	@FindBy(name = "docfees")
	private WebElement DoctorFee;
	@FindBy(name = "doccontact")
	private WebElement DoctorContact;
	@FindAll({@FindBy(name = "docemail"),@FindBy(id = "docemail")})
	private WebElement DoctorMail;
	@FindBy(name = "npass")
	private WebElement DoctorPassword;
	@FindBy(name = "cfpass")
	private WebElement ConformPassword;
	@FindAll({@FindBy(id = "submit"),@FindBy(name = "submit"),@FindBy(xpath = "//button[contains(text(),'Submit')]")})
	private WebElement Submitbtn;
	
	
	public WebElement getDocSpecialization() {
		return DocSpecialization;
	}
	public WebElement getDoctorName() {
		return DoctorName;
	}
	public WebElement getDoctorAddress() {
		return DoctorAddress;
	}
	public WebElement getDoctorFee() {
		return DoctorFee;
	}
	public WebElement getDoctorContact() {
		return DoctorContact;
	}
	public WebElement getDoctorMail() {
		return DoctorMail;
	}
	public WebElement getDoctorPassword() {
		return DoctorPassword;
	}
	public WebElement getConformPassword() {
		return ConformPassword;
	}
	public WebElement getSubmitbtn() {
		return Submitbtn;
	}

	
	public void addDoctor(String Specialization,String Name,String Address,String Fee,String Contact,String Mail,String Password) {
		DocSpecialization.click();
		wu.selectByVisibleText(DocSpecialization, Specialization);
		DoctorName.sendKeys(Name);
		DoctorAddress.sendKeys(Address);
		DoctorFee.sendKeys(Fee);
		DoctorContact.sendKeys(Contact);
		DoctorMail.sendKeys(Mail);
		DoctorPassword.sendKeys(Password);
		ConformPassword.sendKeys(Password);
		Submitbtn.click();
	}
}
