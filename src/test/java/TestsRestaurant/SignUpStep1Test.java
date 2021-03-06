package TestsRestaurant;

import GlobalMethods.GlobalMethods;
import Restaurant.ForgotPasswordClass;
import Restaurant.SignUpClass.*;
import Restaurant.SignInClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 13.05.16.
 */
public class SignUpStep1Test {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    FirefoxProfile firefoxProfile;
    ForgotPasswordClass forgotPasswordClass;
    SignInClass signInClass;
    SignUpStep1Class signUpStep1Class;
    String name = "testName";
    String email = GlobalMethods.getEmail();
    String password = GlobalMethods.getPassword();
    String confirmPassword = GlobalMethods.getPassword();
    String confirmPasswordNotEquals = "test1234";
    String passwordNotCorrect = "1";
    String confirmPasswordNotCorrect = "1";

    @Before
    public void before() throws InterruptedException, MalformedURLException {
        switch (GlobalMethods.chooseDevice()){
            case "web":
                ProfilesIni profile = new ProfilesIni();
                firefoxProfile = profile.getProfile("QA");
                driverBrowser = new FirefoxDriver(firefoxProfile);
                driverBrowser.get(GlobalMethods.getUrl() + "/registration");
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
            signUpStep1Class = PageFactory.initElements(driver, SignUpStep1Class.class);
        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            forgotPasswordClass = PageFactory.initElements(driverBrowser,ForgotPasswordClass.class);
            signUpStep1Class = PageFactory.initElements(driverBrowser, SignUpStep1Class.class);
        }
        signUpStep1Class.chooseDevice();
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }


    @Test
    public void testCase9() throws InterruptedException {
        signUpStep1Class.getName().sendKeys(name);
        signUpStep1Class.getPassword().sendKeys(password);
        signUpStep1Class.getConfirmPassword().sendKeys(confirmPassword);
        boolean result = GlobalMethods.validationEmail(signUpStep1Class.getEmail(), signUpStep1Class.getSignUpButton());
        Assert.assertTrue("Email validation not correct!",result);
    }


    @Test
    public void testCase10() throws InterruptedException {
        boolean result = GlobalMethods.validationSignUpRestaurant(signUpStep1Class,name,email,password,confirmPassword,confirmPasswordNotEquals,passwordNotCorrect,confirmPasswordNotCorrect);
        Assert.assertTrue("Restaurant sign up validation not correct!",result);
    }

}
