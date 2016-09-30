package TestsClient.Restaurant;


import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.Restaurant.RestaurantModalClass;
import TestClass.Client.Restaurant.RestaurantQuickOrderClass;
import TestClass.Client.Restaurant.RestaurantScreenClass;
import TestClass.Client.Restaurant.RestaurantSearchClass;
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
public class RestaurantScreenTest {

    WebDriver driver;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    RestaurantSearchClass restaurantSearchClass;
    RestaurantScreenClass restaurantScreenClass;
    RestaurantModalClass restaurantModalClass;
    RestaurantQuickOrderClass restaurantQuickOrderClass;

    @Before
    public void before() throws InterruptedException {
        driver = new FirefoxDriver();
        signInClass = PageFactory.initElements(driver, SignInClass.class);
        mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);
        restaurantSearchClass = PageFactory.initElements(driver, RestaurantSearchClass.class);
        restaurantScreenClass = PageFactory.initElements(driver, RestaurantScreenClass.class);
        restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
        restaurantQuickOrderClass = PageFactory.initElements(driver, RestaurantQuickOrderClass.class);

        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick(GlobalMethods.getPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
        mainScreenClass.getRestaurantsScreen().click();
        restaurantScreenClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }


    @Test
    public void testCase98() throws InterruptedException {
        boolean result = restaurantScreenClass.testCase98();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase99() throws InterruptedException {
        boolean result = restaurantScreenClass.testCase99();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase100() throws InterruptedException {
        boolean result = restaurantScreenClass.testCase100();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase101() throws InterruptedException {
        boolean result = restaurantScreenClass.testCase101();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase102() throws InterruptedException {
        boolean result = restaurantScreenClass.testCase102();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase103() throws InterruptedException {
        boolean result = restaurantScreenClass.testCase103();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase104() throws InterruptedException {
        driver.close();
        boolean result = restaurantScreenClass.testCase104();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase105() throws InterruptedException {
        driver.close();
        boolean result = restaurantScreenClass.testCase105();
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase112() throws InterruptedException {
        driver.close();
        boolean result = restaurantScreenClass.testCase112();
        org.junit.Assert.assertTrue(result);
    }

}
