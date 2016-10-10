package TestsClient.MainScreenSidebarTest;

import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarPaymentsClass;
import TestClass.Client.SignInClass;
import TestClass.GlobalMethods.GlobalMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 07.06.16.
 */
public class MainScreenTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    MainScreenSidebarFavoriteOrderClass mainScreenSidebarFavoriteOrderClass;
    MainScreenSidebarAddressClass mainScreenSidebarAddressClass;
    MainScreenSidebarPaymentsClass mainScreenSidebarPaymentsClass;
    MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass;

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
            mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddressClass.class);
            mainScreenSidebarPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarPaymentsClass.class);
            mainScreenSidebarAddQuickOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddQuickOrderClass.class);


        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenClass = PageFactory.initElements(driverBrowser, MainScreenClass.class);
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddressClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddressClass.class);
            mainScreenSidebarPaymentsClass = PageFactory.initElements(driverBrowser, MainScreenSidebarPaymentsClass.class);
            mainScreenSidebarAddQuickOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddQuickOrderClass.class);
            driverBrowser.get(GlobalMethods.getUrl());
            driverBrowser.manage().window().maximize();
        }

        signInClass.chooseDevice();
        signInClass.signInClick(GlobalMethods.getRealPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
    }

    @After
    public void after(){
        driverBrowser.quit();
    }

    @Ignore
    @Test
    public void testCase27() throws InterruptedException {
        mainScreenClass.favoriteOrderSectionClick();
        try {
            mainScreenSidebarFavoriteOrderClass.getAddOrderButton();
        } catch(org.openqa.selenium.TimeoutException e){
            Assert.fail("Error!");
        }
        mainScreenClass.addressSectionClick();
        try {
            mainScreenSidebarAddressClass.addAddressButtonFind();
        } catch(org.openqa.selenium.TimeoutException e){
            Assert.fail("Error!");
        }
        mainScreenClass.paymentSectionClick();
        try {
            mainScreenSidebarPaymentsClass.addPaymentButtonFind();
        } catch(org.openqa.selenium.TimeoutException e){
            Assert.fail("Error!");
        }
        Assert.assertTrue(true);
    }

    @Ignore
    @Test
    public void testCase64() throws InterruptedException {
        boolean result = mainScreenClass.testCase64(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase65() throws InterruptedException {
        boolean result = mainScreenClass.testCase65(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase67() throws InterruptedException {
        boolean result = mainScreenClass.testCase67(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase68() throws InterruptedException {
        boolean result = mainScreenClass.testCase68(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase69() throws InterruptedException {
        boolean result = mainScreenClass.testCase69(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase70() throws InterruptedException {
        boolean result = mainScreenClass.testCase70(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase71() throws InterruptedException {
        boolean result = mainScreenClass.testCase71(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase77() throws InterruptedException {
        boolean result = mainScreenClass.testCase77(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase79() throws InterruptedException {
        boolean result = mainScreenClass.testCase79(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase81() throws InterruptedException {
        boolean result = mainScreenClass.testCase81(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase78() throws InterruptedException {
        boolean result = mainScreenClass.testCase78(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase80() throws InterruptedException {
        boolean result = mainScreenClass.testCase80(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

    @Ignore
    @Test
    public void testCase82() throws InterruptedException {
        boolean result = mainScreenClass.testCase82(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue(result);
    }

}
