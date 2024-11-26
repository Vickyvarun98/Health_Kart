package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HMS.Generic.WebDriverUtilityTest.JavaUtility;
import com.HMS.Generic.WebDriverUtilityTest.WebDriverUtility;

public class PatientHomePageTest {

	
	WebDriverUtility wu=new WebDriverUtility();
	JavaUtility j= new JavaUtility();
	public PatientHomePageTest(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()=' Dashboard ']")
	private WebElement Dashboard;
	@FindBy(xpath = "//span[contains(text(),'Book')]")
	private WebElement BookAppointment;
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement AppointmentHistory;
	@FindBy(xpath = "//span[text()=' Medical History ']")
	private WebElement MedicalHistory;
	@FindAll({@FindBy(linkText = "Cancel"),@FindBy(xpath = "//a[text()='Cancel']")})
	private WebElement CancelAppointment;
	@FindBy(xpath = "//span[@class='username']")
	private WebElement UserProfile;
	@FindBy(partialLinkText = "My Profile")
	private WebElement MyProfile;
	@FindBy(partialLinkText = "Change")
	private WebElement ChangePassword;
	@FindBy(partialLinkText = "Log")
	private WebElement Logout;
	@FindBy(name = "Doctorspecialization")
	private WebElement Specialization;
	@FindAll({@FindBy(id = "doctor"),@FindBy(name = "doctor")})
	private WebElement DoctorName;
	@FindAll({@FindBy(id = "timepicker1"),@FindBy(name = "apptime")})
	private WebElement Time;
	@FindBy(name = "appdate")
	private WebElement Date;
	@FindBy(name = "submit")
	private WebElement Submitbtn;
	
	
	public WebElement getDashboard() {
		return Dashboard;
	}
	public WebElement getBookAppointment() {
		return BookAppointment;
	}
	public WebElement getAppointmentHistory() {
		return AppointmentHistory;
	}
	public WebElement getMedicalHistory() {
		return MedicalHistory;
	}
	public WebElement getCancelAppointment() {
		return CancelAppointment;
	}
	public WebElement getUserProfile() {
		return UserProfile;
	}
	public WebElement getMyProfile() {
		return MyProfile;
	}
	public WebElement getChangePassword() {
		return ChangePassword;
	}
	public WebElement getLogout() {
		return Logout;
	}
	public WebElement getSpecialization() {
		return Specialization;
	}
	public WebElement getDoctorName() {
		return DoctorName;
	}
	public WebElement getTime() {
		return Time;
	}
	public WebElement getDate() {
		return Date;
	}
	public WebElement getSubmitbtn() {
		return Submitbtn;
	}
	
	
	
	public void BookAppointment(String Spe,String DocName) {
		BookAppointment.click();
		Specialization.click();
		wu.selectByVisibleText(Specialization, Spe);
		DoctorName.click();
		wu.selectByVisibleText(DoctorName, DocName);
		Date.clear();
		Date.sendKeys(j.getRequiredDate(3));
		Time.clear();
		Time.sendKeys(j.getTime());
		Submitbtn.click();
		
	}
	
	public void cancelAppointment(WebDriver driver) {
		AppointmentHistory.click();
		wu.clicktoElement(driver, CancelAppointment);
		//CancelAppointment.click();
	}
	
	public void logout() {
		UserProfile.click();
		Logout.click();
	}
	
	public void appointmentHistory() {
		AppointmentHistory.click();
	}
	
	
	
	
	
	
	
	

}
