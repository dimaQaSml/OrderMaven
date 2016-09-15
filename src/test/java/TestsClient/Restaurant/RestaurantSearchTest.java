package TestsClient.Restaurant;

import Client.ForgotPasswordClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import Client.MainScreenSidebarClass.MainScreenClass;
import Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import Client.Restaurant.RestaurantModalClass;
import Client.Restaurant.RestaurantScreenClass;
import Client.Restaurant.RestaurantSearchClass;
import Client.SignInClass;
import Client.SignUpClass;
import Client.VerificationCodeClass;
import GlobalMethods.GlobalMethods;
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
        boolean result = GlobalMethods.validationSearchRestaurant(restaurantSearchClass, restaurantScreenClass);
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
