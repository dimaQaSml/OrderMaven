package TestsClient;

import Client.ForgotPasswordClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import Client.SignInClass;
import Client.VerificationCodeClass;
import GlobalMethods.GlobalMethods;
import Client.SignUpClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 13.05.16.
 */
public class SignUpTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    ForgotPasswordClass forgotPasswordClass;
    VerificationCodeClass verificationCodeClass;
    SignInClass signInClass;
    SignUpClass signUpClass;
    WebDriverWait wait;

    String password = GlobalMethods.getPassword();
    String confirmPassword = GlobalMethods.getPassword();
    String confirmPasswordNotEquals = "test1234";
    String passwordNotCorrect = "1";
    String confirmPasswordNotCorrect = "1";
    String country = GlobalMethods.getCountry();
    String phone = GlobalMethods.getPhone();
    String realPhone = GlobalMethods.getRealPhone();

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
            forgotPasswordClass = PageFactory.initElements(driver,ForgotPasswordClass.class);
            verificationCodeClass = PageFactory.initElements(driver,VerificationCodeClass.class);
            wait = new WebDriverWait(driver,15);
            signUpClass = PageFactory.initElements(driver,SignUpClass.class);

        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            forgotPasswordClass = PageFactory.initElements(driverBrowser,ForgotPasswordClass.class);
            verificationCodeClass = PageFactory.initElements(driverBrowser,VerificationCodeClass.class);
            wait = new WebDriverWait(driverBrowser,15);
            signUpClass = PageFactory.initElements(driverBrowser,SignUpClass.class);
        }


        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.getSignUpButton().click();
        signUpClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }

    @Test
    public void testCase1() throws InterruptedException {
        signUpClass.getCountrySelectButton().click();
        signUpClass.getCountryListRussia().click();
        Assert.assertEquals("Country not equals!",signUpClass.getCountryField().getAttribute("value"),"Russia");
    }


    @Test
    public void testCase2() throws InterruptedException {
        boolean result = GlobalMethods.validationCountry(signUpClass.getCountryField(),signUpClass.getCountryList());
        Assert.assertTrue("Validation country not correct!",result);
    }


    @Test
    public void testCase3() throws InterruptedException {
        signUpClass.getCountryField().sendKeys("Russia");
        signUpClass.getPassword().sendKeys(password);
        signUpClass.getConfirmPassword().sendKeys(confirmPassword);
        boolean result = GlobalMethods.validationPhone(signUpClass.getPhone(),signUpClass.getSignUpButton());
        Assert.assertTrue("Error!",result);
    }


    @Test
    public void testCase4() throws InterruptedException {
        boolean result = GlobalMethods.validationSignUpClient(signUpClass,country,phone,password,confirmPassword,confirmPasswordNotEquals,passwordNotCorrect,confirmPasswordNotCorrect);
        Assert.assertTrue("Phone validation not correct!",result);
    }


    @Test
    public void testCase16() throws InterruptedException {
        signUpClass.signUpClick(country,phone,password,confirmPassword);
        try {
            verificationCodeClass.chooseDevice();
        } catch(org.openqa.selenium.TimeoutException e){
            Assert.fail("Sign up not correct!");
        }
        Assert.assertTrue("Sign up not correct!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/verification"));
    }


    @Test
    public void testCase19() throws InterruptedException {
        signUpClass.signUpClick(country,realPhone,password,confirmPassword);
        verificationCodeClass.chooseDevice();
        String UsrInput = JOptionPane.showInputDialog("Input VerificationCode");
        verificationCodeClass.getVerificationCodeInput().sendKeys(UsrInput);
        signInClass.chooseDevice();
        signInClass.signInClick("+7" + realPhone,password);
        //TODO Переделать sleep на screen.chooseDevise()
        Thread.sleep(1500);
        Assert.assertTrue("Sign up not correct!",driver.getCurrentUrl().equals(GlobalMethods.getUrl()));
    }
}
