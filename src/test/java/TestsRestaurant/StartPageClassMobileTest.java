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
        switch (GlobalMethods.chooseDevice()){
            case "ios":
                GlobalMethods.ios(capabilities, driver);
                break;
            case "android":
                GlobalMethods.android(capabilities, driver);
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
