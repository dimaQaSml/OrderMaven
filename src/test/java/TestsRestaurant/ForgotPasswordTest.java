package TestsRestaurant;

import GlobalMethods.GlobalMethods;
import Restaurant.ForgotPasswordClass;
import Restaurant.SignInClass;
import Restaurant.SignUpClass.SignUpStep1Class;
import Restaurant.StartPageClassMobile;
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
 * Created by dmitry on 13.05.16.
 */
public class ForgotPasswordTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    ForgotPasswordClass forgotPasswordClass;
    SignInClass signInClass;
    String emailForForgotPassword = "ddubtsov@smedialink.com";


    @Before
    public void before() throws MalformedURLException, InterruptedException {
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
