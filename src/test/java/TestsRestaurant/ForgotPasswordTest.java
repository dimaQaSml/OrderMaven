package TestsRestaurant;

import TestClass.GlobalMethods.GlobalMethods;
import TestClass.Restaurant.ForgotPasswordClass;
import TestClass.Restaurant.SignInClass;
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
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 13.05.16.
 */
public class ForgotPasswordTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    ForgotPasswordClass forgotPasswordClass;
    SignInClass signInClass;
    String emailForForgotPassword = "ddubtsov@smedialink.com";

    public static void main(String[] args) throws ClassNotFoundException {
        Result result = JUnitCore.runClasses(ForgotPasswordTest.class);
        System.out.println("Total count of tests - " + "\"" + result.getRunCount() + "\"");
        System.out.println("Total count of tests failed - " + "\"" + result.getFailureCount() + "\"");

        for (Failure failure : result.getFailures()) {
            System.out.println("Failed tests message - " + "\"" + failure.getMessage() + "\"");
            System.out.println();
        }
        System.out.println("Result - " + "\"" + result.wasSuccessful() + "\"");
    }


    @Before
    public void before() throws MalformedURLException, InterruptedException {
        switch (GlobalMethods.chooseDevice()){
            case "web":
                GlobalMethods.web();
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
            driverBrowser.get(GlobalMethods.getUrl());
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            forgotPasswordClass = PageFactory.initElements(driverBrowser,ForgotPasswordClass.class);
        }

        driver.get(GlobalMethods.getUrl());
        signInClass.chooseDevice();
        signInClass.forgotPasswordClick();
        forgotPasswordClass.chooseDevice();
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }


    @Test
    public void testCase6() throws InterruptedException {
        boolean result = GlobalMethods.validationEmail(forgotPasswordClass.getEmail(), forgotPasswordClass.getSubmitButton());
        Assert.assertTrue("Email validation not correct!",result);
    }


    @Test
    public void testCase7() throws InterruptedException {
        forgotPasswordClass.submitButtonClick(emailForForgotPassword);
        signInClass.chooseDevice();
        Assert.assertTrue("Forgot Password error!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/login"));
    }


    @Test
    public void testCase8() throws InterruptedException {
        forgotPasswordClass.signInClick();
        signInClass.chooseDevice();
        Assert.assertTrue("Forgot password -> Sign in transit error!",driver.getCurrentUrl().equals(GlobalMethods.getUrl() + "/login"));
    }


}
