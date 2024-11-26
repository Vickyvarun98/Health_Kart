package User;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.HMS.BaseClass.BaseClassForHMS;
import com.HMS.ObjectRepository.CreatePatientTest;
import com.HMS.ObjectRepository.DoctorHomePage;
import com.HMS.ObjectRepository.DoctorLoginPageTest;
import com.HMS.ObjectRepository.HomePageTest;
import com.HMS.ObjectRepository.PatientHomePageTest;
import com.HMS.ObjectRepository.PatientLoginPageTest;

public class UserTest extends BaseClassForHMS {
	
	@Test(groups="smoke",retryAnalyzer = com.HMS.Generic.ListenerUtility.ListenerClassForHMS.class)
	public void createUser() throws InterruptedException, EncryptedDocumentException, IOException {

		String Username = Excel.getDataFromExcelFile("USER", 2, 0);
		String Address = Excel.getDataFromExcelFile("USER", 2, 1);
		String City = Excel.getDataFromExcelFile("USER", 2, 2);
		String Gender = Excel.getDataFromExcelFile("USER", 2, 3);
		String Mail = Excel.getDataFromExcelFile("USER", 1, 4);
		String Password = Excel.getDataFromExcelFile("USER", 2, 5);
		HomePageTest home = new HomePageTest(driver);
		home.userLogin();
		PatientLoginPageTest pat = new PatientLoginPageTest(driver);
		pat.createPatient();
		CreatePatientTest cp = new CreatePatientTest(driver);
		cp.createAccount(Username,Address,City,Gender,j.generateRandomNumber(10000)+Mail,Password);
		wu.clicktoElement(driver, cp.getLogin());
		wu.waitForAlert(driver, 10);
		wu.acceptPopup(driver);
		System.out.println("User is Created...");
		
		
	}
	
	@Test(groups="smoke",retryAnalyzer = com.HMS.Generic.ListenerUtility.ListenerClassForHMS.class)
	public void bookAppointment() throws IOException {
		
		String PUsername = file.getDataFromPropFile("userusername");
		String PPassword = file.getDataFromPropFile("userpassword");
		
		HomePageTest home = new HomePageTest(driver);
		home.login();
		home.userLogin();
		//wu.clicktoElement(driver, home.getPatientLogin());
		PatientLoginPageTest p_log = new PatientLoginPageTest(driver);
		p_log.login(PUsername, PPassword);
		PatientHomePageTest p_home=new PatientHomePageTest(driver);
		p_home.BookAppointment("General Surgery", "Dilip VasoolRaja M.B.B.S");
		wu.waitForAlert(driver, 10);
		wu.acceptPopup(driver);
		System.out.println("Appintment is Booked.....");
		p_home.logout();
	}
	@Test(groups="integration",retryAnalyzer = com.HMS.Generic.ListenerUtility.ListenerClassForHMS.class)
	public void bookAppointmentAndCancelByPatient() throws IOException {
		
		String PUsername = file.getDataFromPropFile("userusername");
		String PPassword = file.getDataFromPropFile("userpassword");
		
		HomePageTest home = new HomePageTest(driver);
		home.login();
		home.userLogin();
		//wu.clicktoElement(driver, home.getPatientLogin());
		PatientLoginPageTest p_log = new PatientLoginPageTest(driver);
		p_log.login(PUsername, PPassword);
		PatientHomePageTest p_home=new PatientHomePageTest(driver);
		p_home.BookAppointment("General Surgery", "Dilip VasoolRaja M.B.B.S");
		wu.waitForAlert(driver, 10);
		wu.acceptPopup(driver);
		System.out.println("Appointment is booked....");
		p_home.cancelAppointment(driver);
		wu.waitForAlert(driver, 10);
		wu.acceptPopup(driver);
		System.out.println("Appointment is canceled by User......");
		
		
		
	}
	@Test(groups="integration",retryAnalyzer = com.HMS.Generic.ListenerUtility.ListenerClassForHMS.class)
	public void bookAppointmentAndCancelByDoctor() throws IOException {
		
		String DUsername = file.getDataFromPropFile("doctorusername");
		String DPassword = file.getDataFromPropFile("doctorpassword");
		String PUsername = file.getDataFromPropFile("userusername");
		String PPassword = file.getDataFromPropFile("userpassword");
		
		HomePageTest home = new HomePageTest(driver);
		home.login();
		home.userLogin();
		//wu.clicktoElement(driver, home.getPatientLogin());
		PatientLoginPageTest p_log = new PatientLoginPageTest(driver);
		p_log.login(PUsername, PPassword);
		System.out.println("Logged in as User");
		PatientHomePageTest p_home=new PatientHomePageTest(driver);
		p_home.BookAppointment("General Surgery", "Dilip VasoolRaja M.B.B.S");
		wu.waitForAlert(driver, 10);
		wu.acceptPopup(driver);
		System.out.println("Appointment is booked....");
		p_home.logout();
		System.out.println("Sucessfully Logged out from User.....");
		home.login();
		home.doctorLogin();
		wu.switchToBrowserByTitle(driver, file.getDataFromPropFile("doctortitle"));
		DoctorLoginPageTest d_log=new DoctorLoginPageTest(driver);
		d_log.doctorLogin(DUsername, DPassword);
		System.out.println("Logged in as Doctor");
		DoctorHomePage d_home=new DoctorHomePage(driver);
		d_home.cancelAppointment(driver);
		wu.waitForAlert(driver, 10);
		wu.acceptPopup(driver);
		d_home.verifyCancelAppointment();
		d_home.logout();
	}

}
