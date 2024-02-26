package mercuryTravels.qa.testcases;

import MercuryTravels.qa.base.TestBase;
import MercuryTravels.qa.pages.LoginPage;
import MercuryTravels.qa.pages.SeatBookingPage;
import MercuryTravels.qa.util.PageScrolling;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class SeatBookingPageTest extends TestBase {

    LoginPage loginPage;
    SeatBookingPage seatBookingPage;
    public SeatBookingPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage =new LoginPage();
        seatBookingPage = new SeatBookingPage();
    }

    @Test(description = "Flights Booking")
    public void clickOnFlights() throws InterruptedException {
        Reporter.log("Test Start-> Booking a flight");
        driver.navigate().to("https://in.via.com/?referrer=mercurytravels.co.in");
        Reporter.log("Flight page is displayed successfully");
        seatBookingPage.closeLoginPageNotification();
        Reporter.log("Close home page Notification");
        seatBookingPage.selectBoardingCity();
        seatBookingPage.selectDestinationCity();
        seatBookingPage.selectDepartureDate();
        Reporter.log("Click on Search flights");
        seatBookingPage.clickOnSearchFlightButton();
        String title = loginPage.validateLoginPageTitle();
        Reporter.log("Flight Page is displayed");
        seatBookingPage.selectFlight();
        Assert.assertEquals(title, "Book Flights, Hotels, Bus and Holiday Packages Online - Via.com");
        Assert.assertEquals(seatBookingPage.validateBoardingCity(),"DEL Delhi");
        Reporter.log("The Boarding city is Delhi");
        Assert.assertEquals(seatBookingPage.validateDestinationCity(),"GOI Goa");
        Reporter.log("The Destination city is GOA");
        seatBookingPage.selectFlight();
        seatBookingPage.clickOnBookingButton();
        Reporter.log("User click on book button");
        Assert.assertTrue(seatBookingPage.validateFlightName());
        Reporter.log("User Validate the Flight name");
        Assert.assertTrue(seatBookingPage.validateDateOfFlight());
        Reporter.log("User validate the flight timing");
        seatBookingPage.selectTittleAndName();
        Reporter.log("Select Tittle and name");
        PageScrolling.scrollPage();
        seatBookingPage.selectSeatButton();
        seatBookingPage.selectFirstSeat();
        Reporter.log("The passenger selects his seat number");
        Assert.assertEquals( seatBookingPage.validateFirstSeatNo(),"7A");
        Reporter.log("First Seat no is 7A");
        seatBookingPage.clickOnProceedSeat();
        seatBookingPage.enterMobileNumber();
        Reporter.log("The passenger enter his Mobile Number");
        seatBookingPage.enterEmailId();
        Reporter.log("The passenger enter his EmailId");
        PageScrolling.scrollPage();
        seatBookingPage.clickOnBooking();
        Reporter.log("Click on proceedToBooking");
        seatBookingPage.clickOnPaymentButton();
        Reporter.log("User clicks on payment option");
        Assert.assertTrue(seatBookingPage.validateFlightPrice());
        Reporter.log("User validate the price Details");
        Assert.assertTrue(seatBookingPage.verifyTheBookingRefNo());
        Reporter.log("Test Complete-> The flight booking has been completed");
    }

     @Test(description = "Seat pricing validation")
     public void validateSeatPricing() throws InterruptedException {
        Reporter.log("Test Start-> Seat pricing validation");
        driver.navigate().to("https://in.via.com/?referrer=mercurytravels.co.in");
        Reporter.log("Flight page is displayed successfully");
        seatBookingPage.closeLoginPageNotification();
        Reporter.log("Close home page Notification");
        seatBookingPage.selectBoardingCity();
        seatBookingPage.selectDestinationCity();
        seatBookingPage.selectDepartureDate();
        Reporter.log("Click on Search flights");
        seatBookingPage.clickOnSearchFlightButton();
        String title = loginPage.validateLoginPageTitle();
        Reporter.log("Flight Page is displayed");
        Assert.assertEquals(title, "Book Flights, Hotels, Bus and Holiday Packages Online - Via.com");
        seatBookingPage.selectFlight();
        seatBookingPage.clickOnBookingButton();
        Reporter.log("User click on book button");
        Assert.assertTrue(seatBookingPage.validateFlightName());
        Reporter.log("User Validate the Flight name");
        seatBookingPage.selectTittleAndName();
        Reporter.log("Select Tittle and name");
        PageScrolling.scrollPage();
        seatBookingPage.selectSeatButton();
        seatBookingPage.selectFirstSeat();
        Reporter.log("The passenger selects his First seat");
        Assert.assertEquals(seatBookingPage.validateFirstSeatPrice(), "350");
        Reporter.log("First Seat price is 350");
        Assert.assertEquals( seatBookingPage.validateFirstSeatNo(),"7A");
        Reporter.log("First Seat no is 7A");
        seatBookingPage.selectSecondSeat();
        Reporter.log("The passenger selects his Second seat");
        Assert.assertEquals(seatBookingPage.validateSecondSeatPrice(),"400");
        Reporter.log("Second Seat price is 400");
        Assert.assertEquals( seatBookingPage.validateSecondSeatNo(),"11A");
        Reporter.log("Second Seat no is 11A");
         seatBookingPage.clickOnProceedSeat();
        seatBookingPage.enterMobileNumber();
        Reporter.log("The passenger enter his Mobile Number");
        seatBookingPage.enterEmailId();
        Reporter.log("The passenger enter his EmailId");
        seatBookingPage.clickOnBooking();
        Reporter.log("Click on proceedToBooking");
        seatBookingPage.clickOnPaymentButton();
        Reporter.log("User clicks on payment option");
        Assert.assertTrue(seatBookingPage.validateFlightPrice());
        Reporter.log("User validate the price Details");
        Assert.assertTrue(seatBookingPage.verifyTheBookingRefNo());
        Reporter.log("Test Complete-> Seat pricing validation successfully");
}
 	@AfterMethod
 	public void tearDown(){
 		driver.quit();
 		Reporter.log("Close the browser");
 	}
 }