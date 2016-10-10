package TestsClient;

import TestClass.Client.ForgotPasswordClass;
import TestClass.Client.SignInClass;
import TestClass.Client.SignUpClass;
import TestClass.Client.VerificationCodeClass;
import TestClass.GlobalMethods.GlobalMethods;
import TestClass.GlobalMethods.ValidationClass;
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

/**
 * Created by dmitry on 18.05.16.
 */
public class VerificationCodeTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    ForgotPasswordClass forgotPasswordClass;
    SignInClass signInClass;
    SignUpClass signUpClass;
    VerificationCodeClass verificationCodeClass;
    String realPhone = GlobalMethods.getRealPhone();
    String password = GlobalMethods.getPassword();
    String confirmPassword = GlobalMethods.getPassword();
    String country = GlobalMethods.getCountry();

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
        signInClass.signUpClick();
        signUpClass.chooseDevice();
    }

    @After
    public void after(){
        driverBrowser.quit();
    }

    @Test
    public void testCase15() throws InterruptedException {
        signUpClass.signUpClick(country,GlobalMethods.getPhone(),password,confirmPassword);
        verificationCodeClass.chooseDevice();
        verificationCodeClass.changeMobileNumbeButtonClick();
        signUpClass.chooseDevice();
        Assert.assertTrue("Failed!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/sign-up"));
    }

    @Test
    public void testCase18() throws InterruptedException {
        signUpClass.signUpClick(country,realPhone,password,confirmPassword);
        verificationCodeClass.chooseDevice();
        boolean result = ValidationClass.validationVerificationCode(verificationCodeClass.getVerificationCodeInput(),driver);
        Assert.assertTrue("Failed!",result);
    }


    @Test
    public void testCase17() throws InterruptedException {
        signUpClass.signUpClick(country,realPhone,password,confirmPassword);
        verificationCodeClass.chooseDevice();
        verificationCodeClass.resendButtonClick();
        boolean result = ValidationClass.checkResendVerificationCode(verificationCodeClass.getVerificationCodeInput(),driver);
        Assert.assertTrue("Failed!",result);
    }


}
