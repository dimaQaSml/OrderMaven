package TestsClient;


import TestClass.Client.ForgotPasswordClass;
import TestClass.Client.SignInClass;
import TestClass.Client.SignUpClass;
import TestClass.Client.VerificationCodeClass;
import TestClass.GlobalMethods.GlobalMethods;
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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmitry on 13.05.16.
 */
public class ForgotPasswordTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    ForgotPasswordClass forgotPasswordClass;
    SignInClass signInClass;
    SignUpClass signUpClass;
    VerificationCodeClass verificationCodeClass;
    String phone = GlobalMethods.getPhone();
    String country = GlobalMethods.getCountry();
    String realPhone = GlobalMethods.getRealPhone();

    @Before
    public void before() throws InterruptedException, MalformedURLException {
        switch (GlobalMethods.chooseDevice()){
            case "web":
                GlobalMethods.web(driverBrowser);
                break;
            case "ios":
                GlobalMethods.ios(capabilities, driver);
                break;
            case "android":
                GlobalMethods.android(capabilities, driver);
                break;
        }
        if(driver != null) {
            signInClass = PageFactory.initElements(driver, SignInClass.class);
            forgotPasswordClass = PageFactory.initElements(driver,ForgotPasswordClass.class);
            verificationCodeClass = PageFactory.initElements(driver,VerificationCodeClass.class);
            signUpClass = PageFactory.initElements(driver,SignUpClass.class);

        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            forgotPasswordClass = PageFactory.initElements(driverBrowser,ForgotPasswordClass.class);
            verificationCodeClass = PageFactory.initElements(driverBrowser,VerificationCodeClass.class);
            signUpClass = PageFactory.initElements(driverBrowser,SignUpClass.class);
            driverBrowser.get(GlobalMethods.getUrl());
            driverBrowser.manage().window().maximize();
        }



        signInClass.chooseDevice();
        signInClass.forgotPasswordClick();
        forgotPasswordClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }


    @Test
    public void testCase9() throws InterruptedException {
        forgotPasswordClass.cancelClick();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        Assert.assertTrue("Cancel button doesn't work!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/sign-in"));
    }


    @Test
    public void testCase10() throws InterruptedException {
        forgotPasswordClass.getCountryField().sendKeys(country);
        boolean result = GlobalMethods.validationPhone(forgotPasswordClass.getPhone(),forgotPasswordClass.getSubmitButton());
        Assert.assertTrue("Validation phone failed!",result);
    }


    @Test
    public void testCase11() throws InterruptedException {
        forgotPasswordClass.getPhone().sendKeys(phone);
        Assert.assertTrue("Failed!",!forgotPasswordClass.getSubmitButton().isEnabled());
    }


    @Test
    public void testCase12() throws InterruptedException {
        forgotPasswordClass.getCountryField().sendKeys(country);
        Assert.assertTrue("Failed!",!forgotPasswordClass.getSubmitButton().isEnabled());
    }

    @Test
    public void testCase13() throws InterruptedException {
        Assert.assertTrue("Failed!",!forgotPasswordClass.getSubmitButton().isEnabled());
    }


    @Test
    public void testCase15() throws InterruptedException {
        forgotPasswordClass.submitButtonClick(country,realPhone);
        verificationCodeClass.chooseDevice();
        Assert.assertTrue("Failed!", driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/verification"));
    }



}
