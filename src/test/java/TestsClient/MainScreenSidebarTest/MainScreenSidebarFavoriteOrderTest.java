package TestsClient.MainScreenSidebarTest;

import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import Client.MainScreenSidebarClass.MainScreenClass;
import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import Client.SignInClass;
import GlobalMethods.GlobalMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 06.06.16.
 */
public class MainScreenSidebarFavoriteOrderTest {

    AppiumDriver driver = null;
    WebDriver driverBrowser = null;
    DesiredCapabilities capabilities;
    SignInClass signInClass;
    List<WebElement> before;
    MainScreenSidebarFavoriteOrderClass mainScreenSidebarFavoriteOrderClass;
    MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass;
    MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass;
    MainScreenSidebarFavoriteOrderDeleteClass mainScreenSidebarFavoriteOrderDeleteClass;
    boolean result;

    @Before
    public void before() throws InterruptedException, MalformedURLException {
        switch (GlobalMethods.chooseDevice()){
            case "web":
                GlobalMethods.web(driverBrowser);
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
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddQuickOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddQuickOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarFavoriteOrderDeleteClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderDeleteClass.class);

        } else {
            signInClass = PageFactory.initElements(driverBrowser, SignInClass.class);
            mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarFavoriteOrderClass.class);
            mainScreenSidebarAddQuickOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddQuickOrderClass.class);
            mainScreenSidebarAddOrderClass = PageFactory.initElements(driverBrowser, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarFavoriteOrderDeleteClass = PageFactory.initElements(driverBrowser, MainScreenSidebarFavoriteOrderDeleteClass.class);
        }
        before = new ArrayList<>();
        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick("+79280373736","123456");
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        before = mainScreenSidebarFavoriteOrderClass.countOrdersElementsBefore();
        mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(),GlobalMethods.getOrder());
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        result = mainScreenSidebarFavoriteOrderClass.checkAddOrder(before);
    }



    @Ignore
    @Test
    public void testCase33() throws InterruptedException {
        //TODO
        String orderName = mainScreenSidebarFavoriteOrderClass.getOrderNameLabel().get(0).getText();
        if(orderName.equals("TestRestaurant")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Error!");
        }
    }

    @Ignore
    @Test
    public void testCase34() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(before.size()+1).click();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.getCancelButton().click();
        /*try{
            mainScreenSidebarFavoriteOrderClass.chooseDevice();
        } catch(){
            Assert.fail("Error!");
        }*/
        Assert.assertTrue(true);
    }

    @Ignore
    @Test
    public void testCase35() throws InterruptedException {
        if(result) {
            mainScreenSidebarFavoriteOrderClass.getAddQuickOrderButton().get(before.size()).click();
            try {
                mainScreenSidebarAddQuickOrderClass.chooseDevice();
            } catch (org.openqa.selenium.TimeoutException e) {
                Assert.fail("Error!");
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                Assert.fail("Error!");
            }
            Assert.assertTrue(true);
        } else{
            Assert.fail("Order is not created!");
        }
    }


    @Ignore
    @Test
    public void testCase37() throws InterruptedException {
        if(result) {
            mainScreenSidebarFavoriteOrderClass.getDeleteOrderButton().get(before.size()).click();
            mainScreenSidebarFavoriteOrderDeleteClass.chooseDevice();
            mainScreenSidebarFavoriteOrderDeleteClass.deleteNoClick();
        /*try{
            mainScreenSidebarFavoriteOrderClass.chooseDevice();
            boolean result = mainScreenSidebarFavoriteOrderClass.checkDeleteOrder()
        } catch(){
            Assert.fail("Error!");
        }
        Assert.assertFalse("Error!", result);*/
        } else{
            Assert.fail("Order is not created!");
        }
    }

    @Ignore
    @Test
    public void testCase38() throws InterruptedException {
        if(result) {
            mainScreenSidebarFavoriteOrderClass.getDeleteOrderButton().get(before.size()).click();
            mainScreenSidebarFavoriteOrderDeleteClass.chooseDevice();
            mainScreenSidebarFavoriteOrderDeleteClass.deleteYesClick();
            boolean result = mainScreenSidebarFavoriteOrderClass.checkDeleteOrder(before);
            Assert.assertTrue("Error!", result);
        } else{
            Assert.fail("Order is not created!");
        }
    }

    @Ignore
    @Test
    public void testCase62() throws InterruptedException {
        if(result) {
            mainScreenSidebarFavoriteOrderClass.getAddQuickOrderButton().get(before.size()).click();
            mainScreenSidebarAddOrderClass.chooseDevice();
            mainScreenSidebarAddOrderClass.addOrder("TestRestaurant", "TestOrder");
            mainScreenSidebarFavoriteOrderClass.chooseDevice();
        /*if(mainScreenSidebarFavoriteOrderClass.equals("TestRestaurant")...){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Error!");
        }*/
        } else{
            Assert.fail("Order is not created!");
        }
    }

    @Ignore
    @Test
    public void testCase74() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(0).click();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.editOrder(GlobalMethods.getRestaurant(), GlobalMethods.getOrder());
        boolean result = mainScreenSidebarFavoriteOrderClass.checkDataOrder("editOrder");
        Assert.assertTrue("Error!",result);
    }

    @Ignore
    @Test
    public void testCase73() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(0).click();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.getRestaurantName().sendKeys("editRest");
        mainScreenSidebarAddOrderClass.getOrderName().sendKeys("editOrder");
        mainScreenSidebarAddOrderClass.getCancelButton().click();
        boolean result = mainScreenSidebarFavoriteOrderClass.checkDataOrder("editOrder");
        Assert.assertTrue("Error!",result);
    }

    @Ignore
    @Test
    public void testCase75() throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(0).click();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.getRestaurantName().sendKeys("editRest");
        mainScreenSidebarAddOrderClass.getOrderName().sendKeys("editOrder");
        mainScreenSidebarAddOrderClass.getCancelButton().click();
        mainScreenSidebarFavoriteOrderClass.getEditOrderButton().get(0).click();
        mainScreenSidebarAddOrderClass.chooseDevice();
        mainScreenSidebarAddOrderClass.checkEditAddressFields("editRest","editOrder");
        boolean result = mainScreenSidebarFavoriteOrderClass.checkDataOrder("editOrder");
        Assert.assertFalse("Error!",result);
    }


}
