package Admin;

import java.io.IOException;

import org.testng.annotations.Test;

import com.HMS.BaseClass.BaseClassForHMS;
import com.HMS.ObjectRepository.AdminLoginPageTest;
import com.HMS.ObjectRepository.HomePageTest;

public class AdminTest extends BaseClassForHMS {
	
	@Test(groups = "smoke",retryAnalyzer = com.HMS.Generic.ListenerUtility.ListenerClassForHMS.class)
	public void loginAdmin() throws IOException {
		String AdminUser = file.getDataFromPropFile("adminusername");
		String AdminPsd = file.getDataFromPropFile("adminpassword");
		String Admintitle = Excel.getDataFromExcelFile("PAGE VERIFY", 1, 1);
		HomePageTest home=new HomePageTest(driver);
		home.login();
		home.adminLogin();
		//wu.clicktoElement(driver, home.getAdminLogin());
		wu.switchToBrowserByTitle(driver, Admintitle);
		AdminLoginPageTest admin=new AdminLoginPageTest(driver);
		admin.login(AdminUser,AdminPsd);
		System.out.println("Admin is Login to Account Successfully");
	}

}
