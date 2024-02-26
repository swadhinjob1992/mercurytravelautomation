package MercuryTravels.qa.util;

import org.openqa.selenium.JavascriptExecutor;

import static MercuryTravels.qa.base.TestBase.driver;

public class PageScrolling {

    public static void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)","");
    }
}
