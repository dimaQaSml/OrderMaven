package TestsClient.Restaurant;


import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.Restaurant.RestaurantModalClass;
import TestClass.Client.Restaurant.RestaurantScreenClass;
import TestClass.Client.Restaurant.RestaurantSearchClass;
import TestClass.Client.SignInClass;
import TestClass.GlobalMethods.GlobalMethods;
import TestClass.GlobalMethods.ValidationClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dmitry on 04.08.16.
 */
public class RestaurantSearchTest {

    WebDriver driver;
    SignInClass signInClass;
    MainScreenClass mainScreenClass;
    RestaurantSearchClass restaurantSearchClass;
    RestaurantScreenClass restaurantScreenClass;
    RestaurantModalClass restaurantModalClass;

    @Before
    public void before() throws InterruptedException {
        driver = new FirefoxDriver();
        signInClass = PageFactory.initElements(driver, SignInClass.class);
        mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);
        restaurantSearchClass = PageFactory.initElements(driver, RestaurantSearchClass.class);
        restaurantScreenClass = PageFactory.initElements(driver, RestaurantScreenClass.class);
        restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);

        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick(GlobalMethods.getPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
        mainScreenClass.getRestaurantsScreen().click();
        restaurantSearchClass.chooseDevice();
    }

    @After
    public void after(){
        driver.close();
    }


    @Test
    public void testCase85() throws InterruptedException {
        boolean result = ValidationClass.validationSearchRestaurant(restaurantSearchClass, restaurantScreenClass);
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase86() throws InterruptedException {
        boolean result = restaurantSearchClass.testCase86(restaurantScreenClass, restaurantModalClass);
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase87() throws InterruptedException {
        boolean result = restaurantSearchClass.testCase87(restaurantScreenClass, restaurantModalClass);
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase89() throws InterruptedException {
        boolean result = restaurantSearchClass.testCase89_91(restaurantScreenClass, restaurantSearchClass.getSearchField());
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase90() throws InterruptedException {
        boolean result = restaurantSearchClass.testCase89_91(restaurantScreenClass, restaurantSearchClass.getChangeMyLocation());
        org.junit.Assert.assertTrue(result);
    }

    @Test
    public void testCase91() throws InterruptedException {
        boolean result = restaurantSearchClass.testCase89_91(restaurantScreenClass, restaurantSearchClass.getCategory());
        org.junit.Assert.assertTrue(result);
    }



}
