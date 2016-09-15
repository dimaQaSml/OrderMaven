package TestsClient;

import Client.ForgotPasswordClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import Client.SignInClass;
import Client.SignUpClass;
import Client.VerificationCodeClass;
import GlobalMethods.GlobalMethods;
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
            signUpClass = PageFactory.initElements(driver,SignUpClass.class);

        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            forgotPasswordClass = PageFactory.initElements(driverBrowser,ForgotPasswordClass.class);
            verificationCodeClass = PageFactory.initElements(driverBrowser,VerificationCodeClass.class);
            signUpClass = PageFactory.initElements(driverBrowser,SignUpClass.class);
        }

        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
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
        boolean result = GlobalMethods.validationVerificationCode(verificationCodeClass.getVerificationCodeInput(),driver);
        Assert.assertTrue("Failed!",result);
    }


    @Test
    public void testCase17() throws InterruptedException {
        signUpClass.signUpClick(country,realPhone,password,confirmPassword);
        verificationCodeClass.chooseDevice();
        verificationCodeClass.resendButtonClick();
        boolean result = GlobalMethods.checkResendVerificationCode(verificationCodeClass.getVerificationCodeInput(),driver);
        Assert.assertTrue("Failed!",result);
    }


}
