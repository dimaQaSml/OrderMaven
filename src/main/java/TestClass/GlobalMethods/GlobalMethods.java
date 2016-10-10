package TestClass.GlobalMethods;

import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddPaymentsClass;
import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import TestClass.Client.OrderNowClass.AddAddressClass;
import TestClass.Client.OrderNowClass.ChooseOrderClass;
import TestClass.Client.Restaurant.Rate_ReviewClass;
import TestClass.Client.Restaurant.RestaurantScreenClass;
import TestClass.Client.Restaurant.RestaurantSearchClass;
import TestClass.GlobalMethods.models.*;
import TestClass.Restaurant.SignUpClass.SignUpStep1Class;
import TestClass.Restaurant.SignUpClass.SignUpStep2Class;
import TestClass.Restaurant.SignUpClass.SignUpStep3Class;
import com.sun.glass.ui.View;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by dmitry on 12.05.16.
 */
public class GlobalMethods {

    enum Device {web,android,ios};
    public static String chooseDevice(){
        Device device = Device.web;
        return String.valueOf(device);
    }

    public static WebDriver web() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        capabilities.setCapability("browser.startup.homepage_override.mstone", "ignore");
        capabilities.setCapability("startup.homepage_welcome_url", "about:blank");
        capabilities.setCapability("startup.homepage_welcome_url.additional","about:blank");
        capabilities.setCapability("browser.startup.homepage","about:blank");
        WebDriver driverBrowser = new RemoteWebDriver(new URL("http://192.168.10.156:4444/wd/hub"), capabilities);
        driverBrowser.get(GlobalMethods.getUrl());
        return driverBrowser;
    }

    /*public static WebDriver web() throws MalformedURLException {
        WebDriver driverBrowser = new FirefoxDriver();
        driverBrowser.get(GlobalMethods.getUrl());
        return driverBrowser;
    }*/

    public static AppiumDriver android(DesiredCapabilities capabilities, AppiumDriver driver) throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("deviceName", "rtyuetrrtyurtuyftytykufuykfkuyfuyvgylughiulhuiftyehsesgrrt");
        capabilities.setCapability("app", "/Users/dmitry/Downloads/app-stage-release-1.apk");
        capabilities.setCapability("appPackage", "ps.orderapp.rest");
        capabilities.setCapability("appActivity", "ps.orderapp.rest.views.welcome.WelcomeActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return driver;
    }

    public static AppiumDriver ios(DesiredCapabilities capabilities, AppiumDriver driver) throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "9.2");
        capabilities.setCapability("deviceName", "iPhone 5s");
        capabilities.setCapability("app", "/Users/dmitry/Downloads/OrderAppManager-6.ipa");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return driver;
    }


    final static String pathLanguageButtons = "html/body/order-app/div/authorization/div";

    @FindBy(xpath = pathLanguageButtons + "/div[1]")
    private static WebElement englishButton;

    @FindBy(xpath = pathLanguageButtons + "/div[2]")
    private static WebElement hebrewButton;

    //Client
    //private static String password = "test123";
    private static String password = "123456";

    private static String fakePassword = "test1234";

    private static String realPhone = "+79280373736";

    private static String restaurant = "KFC";

    private static String orderEdit = "orderEdit";

    private static String restaurantEdit = "kfcEdit";

    private static String order = "testOrder";

    private static String country = "Russia";

    private static String home;

    private static String homeEdit = "home";

    private static String city;

    private static String address;

    private static String countryEdit = "Canada";

    private static String cityEdit = "testCityEdit";

    private static String addressEdit = "testStreetEdit";

    private static String numberEdit = "testNumberEdit";

    private static String email;

    private static  String phone = ValidationClass.randomPhone();

    private static String url = "http://dev.orderapp.com/";

    private static String nameCard = "TestName";

    private static String numberCard1 = "4111";

    private static String numberCard2 = "1111";

    private static String numberCardEdit1 = "4222";

    private static String numberCardEdit2 = "2222";

    private static String dateCardMonth = "11";

    private static String dateCardYear = "17";

    private static String dateCardMonthEdit = "12";

    private static String dateCardYearEdit = "18";

    private static String cvvCard = "111";

    private static String nameCardEdit = "TestNameEdit";

    private static String numberCardEdit = "0987654321";

    private static String dateCardEdit = "TestDateEdit";

    private static String cvvCardEdit = "222";



    //Restaurant
    //SignUpAllSteps
    private static String nameUserRestaurant = "testName";
    private static String nameRestaurant = "testRestaurant";
    private static String addressRestaurant = "testAddress";
    private static String searchAddressRestaurant = "ulitsa Kommunarov, 26, Krasnodar, Krasnodar Krai, Russia";
    private static String cityRestaurant = "Krasnodar";
    private static String stateRestaurant = "Krasnodarskiy kray";
    private static String countryRestaurant = "Russia";
    private static String zipCodeRestaurant = "350000";


    public static int readFile() {
        int result=0;
        Scanner sc = null;
        try {
            sc = new Scanner(new File("/Users/dmitry/IdeaProjects/OrderMaven/emailIdCount2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNext()){
            result=sc.nextInt();
        }
        sc.close();
        return result;
    }


    public static Integer getId() {
        int res = readFile();
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("/Users/dmitry/IdeaProjects/OrderMaven/emailIdCount2.txt");
            outputStream.write(String.valueOf(++res).getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String getEmail() {
        return email = "ddubtsov"+ getId() +"@smedialink.com";
    }

    public static String getCity() {
        return city = "testCity" + getId();
    }

    public static String getAddress() {
        return address = "testAddress" + getId();
    }

    public static String getName() {
        return home = "testAddress" + getId();
    }

    public static String getHomeEdit() {
        return homeEdit;
    }

    public static String getFakePassword() {
        return fakePassword;
    }

    public static String getRealPhone() {
        return realPhone;
    }

    public static String getCountry() {
        return country;
    }

    public static String getPhone() {
        return phone;
    }

    public static String getPassword() {
        return password;
    }

    public static WebElement getEnglishButton() {
        return englishButton;
    }

    public static WebElement getHebrewButton() {
        return hebrewButton;
    }

    public static String getRestaurant() {
        return restaurant;
    }

    public static String getOrder() {
        return order;
    }

    public static String getAddressEdit() {
        return addressEdit;
    }

    public static String getNumberCard1() {
        return numberCard1;
    }

    public static String getNumberCard2() {
        return numberCard2;
    }

    public static String getNumberCardEdit2() {
        return numberCardEdit2;
    }

    public static String getNumberCardEdit1() {
        return numberCardEdit1;
    }

    public static String getUrl() {
        return url;
    }

    public static String getNameCard() {
        return nameCard;
    }

    public static String getDateCardMonth() {
        return dateCardMonth;
    }

    public static String getDateCardYear() {
        return dateCardYear;
    }

    public static String getCvvCard() {
        return cvvCard;
    }

    public static String getRestaurantEdit() {
        return restaurantEdit;
    }

    public static String getOrderEdit() {
        return orderEdit;
    }

    public static String getCountryEdit() {
        return countryEdit;
    }

    public static String getCityEdit() {
        return cityEdit;
    }

    public static String getNumberEdit() {
        return numberEdit;
    }

    public static String getNameCardEdit() {
        return nameCardEdit;
    }

    public static String getNumberCardEdit() {
        return numberCardEdit;
    }

    public static String getDateCardEdit() {
        return dateCardEdit;
    }

    public static String getCvvCardEdit() {
        return cvvCardEdit;
    }

    public static String getDateCardMonthEdit() {
        return dateCardMonthEdit;
    }

    public static String getDateCardYearEdit() {
        return dateCardYearEdit;
    }

    public static String getZipCodeRestaurant() {
        return zipCodeRestaurant;
    }

    public static String getNameUserRestaurant() {
        return nameUserRestaurant;
    }

    public static String getNameRestaurant() {
        return nameRestaurant;
    }

    public static String getAddressRestaurant() {
        return addressRestaurant;
    }

    public static String getSearchAddressRestaurant() {
        return searchAddressRestaurant;
    }

    public static String getCityRestaurant() {
        return cityRestaurant;
    }

    public static String getStateRestaurant() {
        return stateRestaurant;
    }

    public static String getCountryRestaurant() {
        return countryRestaurant;
    }








}





