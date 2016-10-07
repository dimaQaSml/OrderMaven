import TestClass.GlobalMethods.GlobalMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dmitry on 30.09.16.
 */
public class TestClass {

    WebDriver driverBrowser;


    @Test
    public void test() throws MalformedURLException {
        driverBrowser = GlobalMethods.web();
        driverBrowser.get("http://google.ru");
        Assert.assertTrue("Parallel 2",3>2);
    }

    @After
    public void after(){
        driverBrowser.quit();
    }
}
