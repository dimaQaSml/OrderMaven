package TestsClient;

import Client.ForgotPasswordClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import Client.SignInClass;
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

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 13.05.16.
 */
public class SignInTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    ForgotPasswordClass forgotPasswordClass;
    SignInClass signInClass;
    SignUpClass signUpClass;
    WebDriverWait wait;
    String fakePhone = GlobalMethods.getPhone();
    String password = GlobalMethods.getPassword();
    String realPhone = GlobalMethods.getRealPhone();
    String fakePassword = GlobalMethods.getFakePassword();

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

        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            forgotPasswordClass = PageFactory.initElements(driverBrowser,ForgotPasswordClass.class);
        }


        signUpClass = PageFactory.initElements(driver,SignUpClass.class);
        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }


    @Test
    public void testCase5() {
        boolean result = signInClass.signInClick(fakePhone,password);
        Assert.assertTrue("Authorization error!",result);
    }

    @Test
    public void testCase8() {
        signInClass.getLogin().sendKeys("");
        signInClass.getPassword().sendKeys("");
        Assert.assertFalse("Authorization error!",signInClass.getSignInButton().isEnabled());
    }


    @Test
    public void testCase6() {
        boolean result = signInClass.signInClick(fakePhone,fakePassword);
        Assert.assertTrue("Authorization error!",result);
    }

    @Test
    public void testCase7() throws InterruptedException {
        signInClass.signInClick("+7" + realPhone,password);
        //TODO Переделать sleep!
        Thread.sleep(1500);
        //System.out.println(driver.getCurrentUrl() + " " + GlobalMethods.getUrl().substring(0,GlobalMethods.getUrl().length()-2));
        Assert.assertTrue("Authorization error!",driver.getCurrentUrl().equals(GlobalMethods.getUrl().substring(0,GlobalMethods.getUrl().length()-1)));
    }

}
