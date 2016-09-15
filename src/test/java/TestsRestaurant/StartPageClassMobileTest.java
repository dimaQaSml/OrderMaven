package TestsRestaurant;

import GlobalMethods.GlobalMethods;
import Restaurant.SignInClass;
import Restaurant.SignUpClass.SignUpStep1Class;
import Restaurant.StartPageClassMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 24.05.16.
 */
public class StartPageClassMobileTest {
    AppiumDriver driver;
    StartPageClassMobile startPageClassMobile;
    SignInClass signInClass;
    SignUpStep1Class signUpStep1Class;
    DesiredCapabilities capabilities;

    @Before
    public void before() throws InterruptedException, MalformedURLException {
        switch (GlobalMethods.chooseDevice()) {
            case "ios":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("appium-version", "1.0");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("platformVersion", "9.2");
                capabilities.setCapability("deviceName", "iPhone 5s");
                capabilities.setCapability("app", "/Users/dmitry/Downloads/OrderAppManager-6.ipa");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                startPageClassMobile = PageFactory.initElements(driver, StartPageClassMobile.class);
                signInClass = PageFactory.initElements(driver, SignInClass.class);
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
                startPageClassMobile = PageFactory.initElements(driver, StartPageClassMobile.class);
                signUpStep1Class = PageFactory.initElements(driver, SignUpStep1Class.class);
                signInClass = PageFactory.initElements(driver, SignInClass.class);
                break;
        }
    }

    @Test
    public void testCaseXXX() throws InterruptedException {
        startPageClassMobile.chooseDevice();
        startPageClassMobile.signInClick();
        signInClass.chooseDevice();
        Assert.assertTrue("Sign in ENABLED!",signInClass.getSignInButton().isDisplayed());
    }

    @Test
    public void testCaseXXXX() throws InterruptedException {
        startPageClassMobile.chooseDevice();
        startPageClassMobile.signUpClick();
        signUpStep1Class.chooseDevice();
        Assert.assertTrue("Sign in ENABLED!",signUpStep1Class.getSignUpButton().isDisplayed());
    }
}
