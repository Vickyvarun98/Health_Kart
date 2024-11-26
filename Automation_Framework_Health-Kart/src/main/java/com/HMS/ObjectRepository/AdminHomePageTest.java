package com.HMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePageTest {
	
	public AdminHomePageTest(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()=' Dashboard ']")
	private WebElement Dashboard;
	@FindBy(xpath = "//span[text()=' Doctors ']")
	private WebElement Doctor;
	@FindBy(xpath = "//span[contains(text(),'Specialization')]")
	private WebElement Specialization;
	@FindBy(xpath = "//span[text()=' Add Doctor']")
	private WebElement AddDoctor;
	@FindBy(name = "doctorspecilization")
	private WebElement AddSpecialization;
	@FindBy(xpath = "//span[contains(text(),'Conatctus')]")
	private WebElement ContactUs;
	@FindBy(xpath = "//span[contains(text(),'Unread')]")
	private WebElement UnreadQuery;
	@FindBy(xpath = "//span[contains(text(),'Read')]")
	private WebElement ReadQuery;
	@FindBy(xpath = "//span[contains(text(),'User Session Logs')]")
	private WebElement UserSessionLogs;
	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	private WebElement Reports;
	@FindBy(xpath = "//span[contains(text(),'B/w dates reports')]")
	private WebElement ReportDates;
	@FindBy(xpath = "//span[contains(text(),'Pages')]")
	private WebElement Pages;
	@FindBy(xpath = "//span[contains(text(),'About')]")
	private WebElement About;
	@FindBy(xpath = "//span[contains(text(),'Cotnact')]")
	private WebElement Contact;
	@FindBy(xpath = "//span[contains(text(),'Search')]")
	private WebElement PatientSearch;
	@FindBy(xpath = "//a[@data-toggle='dropdown']/descendant::span[contains(text(),'Admin')]")
	private WebElement AdminDropdown;
	@FindAll({@FindBy(partialLinkText = "Password"),@FindBy(xpath = "//a[contains(text(),'Change')]")})
	private WebElement ChangePassword;
	@FindAll({@FindBy(partialLinkText = "Log"),@FindBy(xpath = "//a[contains(text(),'Log')]")})
	private WebElement LogOut;
	public WebElement getDashboard() {
		return Dashboard;
	}
	public WebElement getDoctor() {
		return Doctor;
	}
	public WebElement getSpecialization() {
		return Specialization;
	}
	public WebElement getAddSpecialization() {
		return AddSpecialization;
	}
	public WebElement getContactUs() {
		return ContactUs;
	}
	public WebElement getUnreadQuery() {
		return UnreadQuery;
	}
	public WebElement getReadQuery() {
		return ReadQuery;
	}
	public WebElement getUserSessionLogs() {
		return UserSessionLogs;
	}
	public WebElement getReports() {
		return Reports;
	}
	public WebElement getReportDates() {
		return ReportDates;
	}
	public WebElement getPages() {
		return Pages;
	}
	public WebElement getAbout() {
		return About;
	}
	public WebElement getContact() {
		return Contact;
	}
	public WebElement getPatientSearch() {
		return PatientSearch;
	}
	public WebElement getAdminDropdown() {
		return AdminDropdown;
	}
	public WebElement getChangePassword() {
		return ChangePassword;
	}
	public WebElement getLogOut() {
		return LogOut;
	}
	
	
	public void logout() {
		AdminDropdown.click();
		LogOut.click();
	}
	public void changePassword() {
		ChangePassword.click();
	}
	
	public void addDoctor() {
		Doctor.click();
		AddDoctor.click();
		
	}
	
	
	
	
	
}
