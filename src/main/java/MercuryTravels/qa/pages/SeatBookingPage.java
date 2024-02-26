package MercuryTravels.qa.pages;

import MercuryTravels.qa.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.concurrent.TransferQueue;


public class SeatBookingPage extends TestBase {
    Faker faker = new Faker();

    @FindBy(xpath = "//button[text() = 'No thanks!']")
    WebElement closeNotification;
    @FindBy(xpath = "//input[@id=\"source\"]")
    WebElement selectFromCity;
    @FindBy(xpath = "//span[text()='Delhi,Delhi - India']")
    WebElement clickOnBoardingPlace;
    @FindBy(xpath = "//div[@class = 'labl onw']/div")
    WebElement validateBoardingCity;
    @FindBy(xpath = "//div[@class = 'labl dest']/div")
    WebElement validateDestinationCity;
    @FindBy(xpath = "//input[@id = 'destination']")
    WebElement selectToCity;
    @FindBy(xpath = "//span[text()='Goa,Goa - India']")
    WebElement  clickOnDestinationCity;
    @FindBy(xpath ="(//div[text() = 'IndiGo'])[1]")
    WebElement flightName;
    @FindBy(xpath = "(//div[@class = 'fltLeg']/div[2]/div[2]/div[2]/div[3])[1]")
    WebElement validateDate;
    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[1]/div/div/div[2]/div[2]/span")
    WebElement validateFlightPrice;
    @FindBy(xpath = "//*[@id=\"depart-cal\"]/div[4]/div[2]/div[3]/div[5]")
    WebElement selectDate;
    @FindBy(xpath = "//div[text() = 'Search Flights']")
    WebElement clickOnSearchButton;
    @FindBy(xpath = "//*[@id=\"searchResultContainer\"]/div[7]/div/div[3]/div[1]/div[3]/div[2]/button")
    WebElement bookingButton;
    @FindBy(xpath = "//select[@id = 'adult1Title']")
    WebElement clickOnTittle;
    @FindBy(xpath = "//option[text() = 'Mr']")
    WebElement selectTittle;
    @FindBy(xpath = "//input[@id = 'adult1FirstName']")
    WebElement enterFirstName;
    @FindBy(xpath = "//input[@id = 'adult1Surname']")
    WebElement enterLastName;
    @FindBy(xpath = "//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]")
    WebElement selectFlight;
    @FindBy(xpath = "//button[@class = 'CTA jsSeatBtn']")
    WebElement clickOnSeatSelectionOption;
    @FindBy(xpath = "//div[text() = '7A']")
    WebElement selectSeatNo;
    @FindBy(xpath = "//div[text() = '7A']")
    WebElement seatNo;
    @FindBy(xpath = "//span[text() = '350']")
    WebElement firstSeatPrice;
    @FindBy(xpath = "//div[text() = '11A']")
    WebElement secondSeatNo;
    @FindBy(xpath = "//div[text() = '11A']")
    WebElement validateSecondSeatNo;
    @FindBy(xpath = "//span[text() = '400']")
    WebElement validateSecondSeatPrice;
    @FindBy(xpath = "(//button[text()='Proceed With Seats'])[2]")
    WebElement proceedWithSeatButton;
    @FindBy(xpath = "//input[@id = 'contactMobile']")
    WebElement enterMobileNumber;
    @FindBy(xpath = "//input[@name = 'contactEmail']")
    WebElement enterEmailId;
    @FindBy(xpath = "//button[text() = 'Proceed to Booking']")
    WebElement proceedToBooking;
    @FindBy(xpath = "//div[@id=\"refundProtectDiv\"]/div[3]/div/div[1]/div/div[1]/div/label")
    WebElement selectRefundableBooking;
    @FindBy(xpath = "//span[@class = 'u_inlineblk u_vertAlignSub']")
    WebElement makePayment;
    @FindBy(xpath = "//*[@id=\"bookingIdDiv\"]")
    WebElement verifyTheBookingRefNo;

    public SeatBookingPage(){
        PageFactory.initElements(driver, this);
    }

    public void closeLoginPageNotification() {
        closeNotification.click();
    }

    public void selectBoardingCity() {
        selectFromCity.sendKeys("DEL");
        clickOnBoardingPlace.click();
    }
    public String validateBoardingCity() {
        return validateBoardingCity.getText();
    }

    public void selectDestinationCity() {
        selectToCity.sendKeys("GOA");
        clickOnDestinationCity.click();
    }
    public String validateDestinationCity() {
        return validateDestinationCity.getText();
    }

    public void selectDepartureDate() {
        Reporter.log("Select date, The date format in dd/mm/yyyy");
        selectDate.click();
    }
    public void selectFlight() {
        selectFlight.click();
    }
    public void clickOnSearchFlightButton() {
        clickOnSearchButton.click();
    }
    public void clickOnBookingButton() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"searchResultContainer\"]/div[7]/div/div[3]/div[1]/div[3]/div[2]/button"));
        try {
            element.click();
        }catch (StaleElementReferenceException e)
        {
            element = driver.findElement(By.xpath("//*[@id=\"searchResultContainer\"]/div[7]/div/div[3]/div[1]/div[3]/div[2]/button"));
            element.click();
        }
    }
    public boolean validateFlightName() {
        return flightName.isDisplayed();
    }
    public boolean validateDateOfFlight() {
        return validateDate.isDisplayed();
    }
    public boolean validateFlightPrice() {
        return validateFlightPrice.isDisplayed();
    }
    public void selectTittleAndName() throws InterruptedException {
        Thread.sleep(5000);
        clickOnTittle.click();
        selectTittle.click();
        enterFirstName.sendKeys("Steven");
        enterLastName.sendKeys("Grove");
    }
    public void selectSeatButton() throws InterruptedException {
        Thread.sleep(5000);
        clickOnSeatSelectionOption.click();
    }
    public void selectFirstSeat() {
        selectSeatNo.click();
    }
    public String validateFirstSeatNo() {
        return seatNo.getText();
    }
    public String validateFirstSeatPrice() {
        return firstSeatPrice.getText();
    }
    public void selectSecondSeat() throws InterruptedException {
        Thread.sleep(5000);
        secondSeatNo.click();
    }
    public String validateSecondSeatNo() {
       return validateSecondSeatNo.getText();
    }
    public String validateSecondSeatPrice() {
        return validateSecondSeatPrice.getText();
    }

    public void clickOnProceedSeat() throws InterruptedException {
        Thread.sleep(5000);
        proceedWithSeatButton.click();
    }

    public void enterEmailId() {
        String emailId = faker.internet().emailAddress();
        enterEmailId.sendKeys(emailId);
    }
    public void enterMobileNumber() {
        enterMobileNumber.sendKeys("9040297614");
    }

    public void clickOnBooking() throws InterruptedException {
        Thread.sleep(5000);
        proceedToBooking.click();
    }

    public void clickOnPaymentButton() {
        selectRefundableBooking.click();
        makePayment.click();
    }

    public boolean verifyTheBookingRefNo() {
        return verifyTheBookingRefNo.isDisplayed();
    }
}
