package TestsClient.Restaurant;


import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.Restaurant.RestaurantQuickOrderClass;
import TestClass.Client.SignInClass;
import TestClass.GlobalMethods.GlobalMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dmitry on 04.08.16.
 */
public class  RestaurantQuickOrderTest {

    WebDriver driver;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    RestaurantQuickOrderClass restaurantQuickOrderClass;

    @Before
    public void before() throws InterruptedException {
        driver = new FirefoxDriver();
        signInClass = PageFactory.initElements(driver, SignInClass.class);
        mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);
        restaurantQuickOrderClass = PageFactory.initElements(driver, RestaurantQuickOrderClass.class);

        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick(GlobalMethods.getPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
        mainScreenClass.getRestaurantsScreen().click();
        restaurantQuickOrderClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }


    @Test
    public void testCase96() throws InterruptedException {
        boolean result = restaurantQuickOrderClass.testCase96();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase97() throws InterruptedException {
        boolean result = restaurantQuickOrderClass.testCase97();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase139() throws InterruptedException {
        boolean result = restaurantQuickOrderClass.testCase139();
        org.junit.Assert.assertTrue(result);
    }

}
