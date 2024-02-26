package mercuryTravels.qa.testcases;

import MercuryTravels.qa.pages.HomePage;
import MercuryTravels.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;

import MercuryTravels.qa.base.TestBase;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
