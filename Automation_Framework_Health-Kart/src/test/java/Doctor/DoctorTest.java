package Doctor;

import java.io.IOException;

import org.testng.annotations.Test;

import com.HMS.BaseClass.BaseClassForHMS;
import com.HMS.ObjectRepository.AddDoctorTest;
import com.HMS.ObjectRepository.AdminHomePageTest;
import com.HMS.ObjectRepository.AdminLoginPageTest;
import com.HMS.ObjectRepository.DoctorHomePage;
import com.HMS.ObjectRepository.DoctorLoginPageTest;
import com.HMS.ObjectRepository.HomePageTest;
import com.HMS.ObjectRepository.PatientHomePageTest;
import com.HMS.ObjectRepository.PatientLoginPageTest;

public class DoctorTest extends BaseClassForHMS {

	
	@Test(groups="integration",retryAnalyzer = com.HMS.Generic.ListenerUtility.ListenerClassForHMS.class)
	public void cancelAppointment() throws IOException {
		String Username=file.getDataFromPropFile("doctorusername");
		String Password=file.getDataFromPropFile("doctorpassword");
		String DoctorTitle = file.getDataFromPropFile("doctortitle");
		HomePageTest home=new HomePageTest(driver);
		wu.clicktoElement(driver, home.getDoctorLogin());
		wu.switchToBrowserByTitle(driver, DoctorTitle);
		DoctorLoginPageTest d_log=new DoctorLoginPageTest(driver);
		d_log.doctorLogin(Username,Password);
		DoctorHomePage d_home=new DoctorHomePage(driver);
		d_home.cancelAppointment(driver);
		wu.acceptPopup(driver);
		d_home.verifyCancelAppointment();
	}
	
	@Test(groups="smoke")
	public void login() throws IOException {
		String Username=file.getDataFromPropFile("doctorusername");
		String Password=file.getDataFromPropFile("doctorpassword");
		String DoctorTitle = file.getDataFromPropFile("doctortitle");
		HomePageTest home=new HomePageTest(driver);
		wu.clicktoElement(driver, home.getDoctorLogin());
		wu.switchToBrowserByTitle(driver, DoctorTitle);
		DoctorLoginPageTest d_log=new DoctorLoginPageTest(driver);
		d_log.doctorLogin(Username,Password);
	}
	
	@Test(groups="system",retryAnalyzer = com.HMS.Generic.ListenerUtility.ListenerClassForHMS.class)
	public void cancelAppointmentAndCheck() throws IOException {
		String DUsername=file.getDataFromPropFile("doctorusername");
		String DPassword=file.getDataFromPropFile("doctorpassword");
		String PUsername=file.getDataFromPropFile("userusername");
		String PPassword=file.getDataFromPropFile("userpassword");
		String DoctorTitle = file.getDataFromPropFile("doctortitle");
		HomePageTest home=new HomePageTest(driver);
		wu.clicktoElement(driver, home.getDoctorLogin());
		wu.switchToBrowserByTitle(driver, DoctorTitle);
		DoctorLoginPageTest d_log=new DoctorLoginPageTest(driver);
		d_log.doctorLogin(DUsername,DPassword);
		DoctorHomePage d_home=new DoctorHomePage(driver);
		d_home.cancelAppointment(driver);
		wu.acceptPopup(driver);
		d_home.verifyCancelAppointment();
		d_home.logout();
		home.login();
		home.userLogin();
		PatientLoginPageTest p_log=new PatientLoginPageTest(driver);
		p_log.login(PUsername, PPassword);
		PatientHomePageTest p_home=new PatientHomePageTest(driver);
		p_home.appointmentHistory();
	}
	
	@Test(groups="system",retryAnalyzer = com.HMS.Generic.ListenerUtility.ListenerClassForHMS.class)
	public void createDoctorAndBookAppointment() throws IOException {
		String AUsername=file.getDataFromPropFile("adminusername");
		String APassword=file.getDataFromPropFile("adminpassword");
		String UUsername=file.getDataFromPropFile("userusername");
		String UPassword=file.getDataFromPropFile("userpassword");
		String Specialization = Excel.getDataFromExcelFile("DOCTOR", 1, 1);
		String DoctorName = Excel.getDataFromExcelFile("DOCTOR", 1, 2);
		String Address = Excel.getDataFromExcelFile("DOCTOR", 1, 3);
		String Fee = Excel.getDataFromExcelFile("DOCTOR", 1, 4);
		String Contact = Excel.getDataFromExcelFile("DOCTOR", 1, 5);
		String Mail = j.generateRandomNumber(10000)+Excel.getDataFromExcelFile("DOCTOR", 1, 6);
		String Password = Excel.getDataFromExcelFile("DOCTOR", 1, 7);
		String AdminTitle = file.getDataFromPropFile("admintitle");
		HomePageTest home=new HomePageTest(driver);
		wu.clicktoElement(driver, home.getAdminLogin());
		wu.switchToBrowserByTitle(driver, AdminTitle);
		AdminLoginPageTest a_log=new AdminLoginPageTest(driver);
		a_log.login(AUsername, APassword);
		AdminHomePageTest a_home=new AdminHomePageTest(driver);
		a_home.addDoctor();
		AddDoctorTest add=new AddDoctorTest(driver);
		add.addDoctor(Specialization, DoctorName, Address, Fee, Contact, Mail, Password);
		wu.acceptPopup(driver);
		Excel.dataBackToExcel("DOCTOR", 1, 8, Mail);
		System.out.println("Doctor Mail is added....");
		wu.mouseHover(driver, a_home.getLogOut());
		a_home.logout();
		home.login();
		home.userLogin();
		PatientLoginPageTest p_log=new PatientLoginPageTest(driver);
		p_log.login(UUsername, UPassword);
		PatientHomePageTest p_home=new PatientHomePageTest(driver);
		p_home.BookAppointment(Specialization, DoctorName);
		
	}
	
	
	@Test(groups="smoke",retryAnalyzer = com.HMS.Generic.ListenerUtility.ListenerClassForHMS.class)
	public void createDoctor() throws IOException {
		String AUsername=file.getDataFromPropFile("adminusername");
		String APassword=file.getDataFromPropFile("adminpassword");
		String Specialization = Excel.getDataFromExcelFile("DOCTOR", 1, 1);
		String DoctorName = Excel.getDataFromExcelFile("DOCTOR", 1, 2);
		String Address = Excel.getDataFromExcelFile("DOCTOR", 1, 3);
		String Fee = Excel.getDataFromExcelFile("DOCTOR", 1, 4);
		String Contact = Excel.getDataFromExcelFile("DOCTOR", 1, 5);
		String Mail = j.generateRandomNumber(10000)+Excel.getDataFromExcelFile("DOCTOR", 1, 6);
		String Password = Excel.getDataFromExcelFile("DOCTOR", 1, 7);
		String AdminTitle = file.getDataFromPropFile("admintitle");
		HomePageTest home=new HomePageTest(driver);
		wu.clicktoElement(driver, home.getAdminLogin());
		wu.switchToBrowserByTitle(driver, AdminTitle);
		AdminLoginPageTest a_log=new AdminLoginPageTest(driver);
		a_log.login(AUsername, APassword);
		AdminHomePageTest a_home=new AdminHomePageTest(driver);
		a_home.addDoctor();
		AddDoctorTest add=new AddDoctorTest(driver);
		add.addDoctor(Specialization, DoctorName, Address, Fee, Contact, Mail, Password);
		wu.acceptPopup(driver);
		Excel.dataBackToExcel("DOCTOR", 1, 8, Mail);
		System.out.println("Doctor Mail is added....");
		wu.mouseHover(driver, a_home.getLogOut());
		a_home.logout();
	}
	
}
