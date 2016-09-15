package TestsClient.MainScreenSidebarAddTest;

import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddPaymentsClass;
import Client.MainScreenSidebarClass.MainScreenClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarClass.MainScreenSidebarPaymentsClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import Client.SignInClass;
import GlobalMethods.GlobalMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
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
                driverBrowser = new FirefoxDriver();
                driverBrowser.get(GlobalMethods.getUrl());
                break;
            case "ios":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("appium-version", "1.0");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("platformVersion", "9.2");
                capabilities.setCapability("deviceName", "iPhone 5s");
                capabilities.setCapability("app", "/Users/dmitry/Downloads/OrderAppManager-6.ipa");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case "android":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("appium-version", "1.0");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "4.4");
                capabilities.setCapability("deviceName", "rtyuetrrtyurtuyftytykufuykfkuyfuyvgylughiulhuiftyehsesgrrt");
                capabilities.setCapability("app", "/Users/dmitry/Downloads/app-stage-release-1.apk");
                capabilities.setCapability("appPackage", "ps.orderapp.rest");
                capabilities.setCapability("appActivity", "ps.orderapp.rest.views.welcome.WelcomeActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        if(driver != null) {
            signInClass = PageFactory.initElements(driver, SignInClass.class);
            mainScreenSidebarPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarPaymentsClass.class);
            mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarAddPaymentsClass.class);
            mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenSidebarPaymentsClass = PageFactory.initElements(driverBrowser, MainScreenSidebarPaymentsClass.class);
            mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddPaymentsClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
        }


        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick("+79280373736","123456");
        mainScreenClass.chooseDevice();
        mainScreenClass.getPaymentSection().click();
        mainScreenSidebarPaymentsClass.chooseDevice();
    }

    /*@After
    public void after(){
        driver.close();
    }*/

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
        boolean result = GlobalMethods.validationPayment(mainScreenSidebarAddPaymentsClass,GlobalMethods.getNumberCard1(), GlobalMethods.getNumberCard2(),GlobalMethods.getDateCardMonth(), GlobalMethods.getDateCardYear(),GlobalMethods.getCvvCard());
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
