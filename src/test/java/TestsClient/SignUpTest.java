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
            wait = new WebDriverWait(driver,15);
            signUpClass = PageFactory.initElements(driver,SignUpClass.class);


        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            forgotPasswordClass = PageFactory.initElements(driverBrowser,ForgotPasswordClass.class);
            verificationCodeClass = PageFactory.initElements(driverBrowser,VerificationCodeClass.class);
            wait = new WebDriverWait(driverBrowser,15);
            signUpClass = PageFactory.initElements(driverBrowser,SignUpClass.class);
            driverBrowser.get(GlobalMethods.getUrl());
            driverBrowser.manage().window().maximize();
        }



        signInClass.chooseDevice();
        signInClass.getSignUpButton().click();
        signUpClass.chooseDevice();
    }

    @After
    public void after(){
        driverBrowser.quit();
    }
    @Test
    public void testCase1() throws InterruptedException {
        signUpClass.getCountrySelectButton().click();
        signUpClass.getCountryListRussia().click();
        Assert.assertEquals("Country not equals!",signUpClass.getCountryField().getAttribute("value"),"Russia");
    }


    @Test
    public void testCase2() throws InterruptedException {
        boolean result = ValidationClass.validationCountry(signUpClass.getCountryField(),signUpClass.getCountryList());
        Assert.assertTrue("Validation country not correct!",result);
    }


    @Test
    public void testCase3() throws InterruptedException {
        signUpClass.getCountryField().sendKeys("Russia");
        signUpClass.getPassword().sendKeys(password);
        signUpClass.getConfirmPassword().sendKeys(confirmPassword);
        boolean result = ValidationClass.validationPhone(signUpClass.getPhone(),signUpClass.getSignUpButton());
        Assert.assertTrue("Error!",result);
    }


    @Test
    public void testCase4() throws InterruptedException {
        boolean result = ValidationClass.validationSignUpClient(signUpClass,country,phone,password,confirmPassword,confirmPasswordNotEquals,passwordNotCorrect,confirmPasswordNotCorrect);
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
