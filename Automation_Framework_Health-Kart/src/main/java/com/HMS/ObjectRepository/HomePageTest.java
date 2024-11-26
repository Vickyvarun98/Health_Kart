package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage Info
 * @author Vignesh
 */

public class HomePageTest {
	
	public HomePageTest(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Home")
	private WebElement HomeLink;
	@FindBy(linkText = "Services")
	private WebElement ServiceLink;
	@FindBy(linkText = "About Us")
	private WebElement AboutLink;
	@FindBy(linkText = "Gallery")
	private WebElement GalleryLink;
	@FindBy(linkText = "Contact Us")
	private WebElement ContactUsLink;
	@FindBy(linkText = "Logins")
	private WebElement LoginLink;
	@FindBy(linkText = "Book an Appointment")
	private WebElement AppointmentLink;
	@FindBy(xpath="//a[@href='hms/user-login.php']")
	private WebElement PatientLogin;
	@FindBy(xpath = "//a[@href='hms/doctor']")
	private WebElement DoctorLogin;
	@FindBy(xpath = "//a[@href='hms/admin']")
	private WebElement AdminLogin;
	
	
	public WebElement getHomeLink() {
		return HomeLink;
	}
	public WebElement getServiceLink() {
		return ServiceLink;
	}
	public WebElement getAboutLink() {
		return AboutLink;
	}
	public WebElement getGalleryLink() {
		return GalleryLink;
	}
	public WebElement getContactUsLink() {
		return ContactUsLink;
	}
	public WebElement getLoginLink() {
		return LoginLink;
	}
	public WebElement getAppointmentLink() {
		return AppointmentLink;
	}
	public WebElement getPatientLogin() {
		return PatientLogin;
	}
	public WebElement getDoctorLogin() {
		return DoctorLogin;
	}
	public WebElement getAdminLogin() {
		return AdminLogin;
	}
	
	
	public void login() {
		LoginLink.click();
	}
	public void userLogin() {
		PatientLogin.click();
	}
	public void adminLogin() {
		AdminLogin.click();
	}
	public void doctorLogin() {
		DoctorLogin.click();
	}
	

}
