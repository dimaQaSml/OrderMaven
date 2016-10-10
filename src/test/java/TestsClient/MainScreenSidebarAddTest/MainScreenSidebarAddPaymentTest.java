package TestsClient.MainScreenSidebarAddTest;

import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddPaymentsClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarPaymentsClass;
import TestClass.Client.SignInClass;
import TestClass.GlobalMethods.GlobalMethods;
import TestClass.GlobalMethods.ValidationClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by dmitry on 07.06.16.
 */
public class MainScreenSidebarAddPaymentTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    MainScreenSidebarPaymentsClass mainScreenSidebarPaymentsClass;
    MainScreenSidebarAddPaymentsClass mainScreenSidebarAddPaymentsClass;

    @Before
    public void before() throws InterruptedException, MalformedURLException {
        switch (GlobalMethods.chooseDevice()){
            case "web":
                driverBrowser = GlobalMethods.web();
                break;
            case "ios":
                GlobalMethods.ios(capabilities, driver);
                break;
            case "android":
                GlobalMethods.android(capabilities, driver);
                break;
        }
        if(driverBrowser != null) {
            signInClass = PageFactory.initElements(driver, SignInClass.class);
            mainScreenSidebarPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarPaymentsClass.class);
            mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarAddPaymentsClass.class);
            mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);

        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenSidebarPaymentsClass = PageFactory.initElements(driverBrowser, MainScreenSidebarPaymentsClass.class);
            mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddPaymentsClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
            driverBrowser.get(GlobalMethods.getUrl());
            driverBrowser.manage().window().maximize();
        }

        signInClass.chooseDevice();
        signInClass.signInClick(GlobalMethods.getRealPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
        mainScreenClass.getPaymentSection().click();
        mainScreenSidebarPaymentsClass.chooseDevice();
    }

    @After
    public void after(){
        driverBrowser.quit();
    }

    public void addPayment() throws InterruptedException {
        mainScreenSidebarPaymentsClass.addPaymentButtonClick();
        mainScreenSidebarAddPaymentsClass.chooseDevice();
        mainScreenSidebarAddPaymentsClass.addPayment(GlobalMethods.getNumberCard1(), GlobalMethods.getNumberCard2(),GlobalMethods.getDateCardMonth(), GlobalMethods.getDateCardYear(),GlobalMethods.getCvvCard());
        mainScreenSidebarPaymentsClass.chooseDevice();
    }

    @Ignore
    @Test
    public void testCase51() throws InterruptedException {
        List<WebElement> before = mainScreenSidebarPaymentsClass.countPaymentsElementsBefore();
        addPayment();
        boolean result = mainScreenSidebarPaymentsClass.checkAddPayment(before);
        Assert.assertTrue("Error!", result);
    }

    @Ignore
    @Test
    public void testCase52() throws InterruptedException {
        mainScreenSidebarPaymentsClass.addPaymentButtonClick();
        mainScreenSidebarAddPaymentsClass.chooseDevice();
        boolean result = ValidationClass.validationPayment(mainScreenSidebarAddPaymentsClass,GlobalMethods.getNumberCard1(), GlobalMethods.getNumberCard2(),GlobalMethods.getDateCardMonth(), GlobalMethods.getDateCardYear(),GlobalMethods.getCvvCard());
        /*if(result == true){
            result = GlobalMethods.validationPayment(mainScreenSidebarAddPaymentsClass,true,GlobalMethods.getNameCard(),GlobalMethods.getNumberCard1(),GlobalMethods.getDateCard(),GlobalMethods.getCvvCard());
        }*/
        Assert.assertTrue("Error!", result);
    }

    @Ignore
    @Test
    public void testCase53() throws InterruptedException {
        mainScreenSidebarPaymentsClass.addPaymentButtonClick();
        mainScreenSidebarAddPaymentsClass.chooseDevice();
        mainScreenSidebarAddPaymentsClass.getCancelButton().click();
        //try {
        //mainScreenSidebarPaymentsClass.chooseDevice();
        //} catch(org.openqa.selenium.StaleElementReferenceException e){
        //Assert.fail("Error!");
        //}
        Assert.assertTrue(true);
    }


    @Ignore
    @Test
    public void testCase54() throws InterruptedException {
        addPayment();
        mainScreenSidebarPaymentsClass.editPaymentClick();
        mainScreenSidebarAddPaymentsClass.chooseDevice();
        if(!mainScreenSidebarAddPaymentsClass.getCardNumber1().equals(GlobalMethods.getNumberCard1()) && !mainScreenSidebarAddPaymentsClass.getCardNumber2().equals(GlobalMethods.getNumberCard2())
                || !mainScreenSidebarAddPaymentsClass.getCardDateMonth().equals(GlobalMethods.getDateCardMonth()) || !mainScreenSidebarAddPaymentsClass.getCardDateYear().equals(GlobalMethods.getDateCardYear()) || !mainScreenSidebarAddPaymentsClass.getCardCvv().equals(GlobalMethods.getCvvCard())) {
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
        }
    }

    @Ignore
    @Test
    public void testCase55() throws InterruptedException {
        addPayment();
        mainScreenSidebarPaymentsClass.editPaymentClick();
        mainScreenSidebarAddPaymentsClass.chooseDevice();
        mainScreenSidebarAddPaymentsClass.editPayment(GlobalMethods.getNumberCardEdit1(), GlobalMethods.getNumberCardEdit2(),GlobalMethods.getDateCardMonthEdit(), GlobalMethods.getDateCardYearEdit(),GlobalMethods.getCvvCardEdit());
        if(!mainScreenSidebarAddPaymentsClass.getCardNumber1().equals(GlobalMethods.getNumberCard1()) && !mainScreenSidebarAddPaymentsClass.getCardNumber2().equals(GlobalMethods.getNumberCard2())
                || !mainScreenSidebarAddPaymentsClass.getCardDateMonth().equals(GlobalMethods.getDateCardMonth()) || !mainScreenSidebarAddPaymentsClass.getCardDateYear().equals(GlobalMethods.getDateCardYear()) || !mainScreenSidebarAddPaymentsClass.getCardCvv().equals(GlobalMethods.getCvvCard())) {
            Assert.assertTrue(false);
        } else {
            Assert.assertTrue(true);
        }
    }

    @Ignore
    @Test
    public void testCase56() throws InterruptedException {
        addPayment();
        mainScreenSidebarPaymentsClass.editPaymentClick();
        mainScreenSidebarAddPaymentsClass.chooseDevice();
        mainScreenSidebarAddPaymentsClass.getCancelButton().click();
        try{
            mainScreenSidebarPaymentsClass.chooseDevice();
        } catch(org.openqa.selenium.TimeoutException e){
            Assert.fail("Error!");
        }
        Assert.assertTrue("Error!", mainScreenSidebarPaymentsClass.getAddPaymentButton().get(0).isDisplayed());
    }

    @Ignore
    @Test
    public void testCase64() throws InterruptedException {
        mainScreenSidebarPaymentsClass.addPaymentButtonClick();
        boolean result = mainScreenSidebarAddPaymentsClass.testCase64();
        org.junit.Assert.assertTrue(result);
    }

}
