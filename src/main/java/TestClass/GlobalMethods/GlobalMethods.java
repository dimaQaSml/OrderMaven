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
        //System.setProperty("webdriver.gecko.driver", "/Users/Selenium/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driverBrowser = new RemoteWebDriver(new URL("http://192.168.10.156:4444/wd/hub"), capabilities);
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

    private static  String phone = GlobalMethods.randomPhone();

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




    public static boolean validationEmail(WebElement emailId, WebElement buttonCheckId) throws InterruptedException {

        ArrayList<ValidationValue> listValidationEmail = new ArrayList<>();
        listValidationEmail.add(new ValidationValue(false,""));
        if(GlobalMethods.chooseDevice().equals("web")) {
            listValidationEmail.add(new ValidationValue(false, "тест"));
            listValidationEmail.add(new ValidationValue(false, "тест1"));
            listValidationEmail.add(new ValidationValue(false, "тест@тест"));
            listValidationEmail.add(new ValidationValue(false, "тест1@тест1"));
            listValidationEmail.add(new ValidationValue(false, "тест@тест.тест"));
            listValidationEmail.add(new ValidationValue(false, "тест1@тест1.тест1"));
        }
        listValidationEmail.add(new ValidationValue(false,"test"));
        listValidationEmail.add(new ValidationValue(false,"test1"));
        listValidationEmail.add(new ValidationValue(false,"test@test"));
        listValidationEmail.add(new ValidationValue(false,"test1@test1"));
        listValidationEmail.add(new ValidationValue(false,"!#$$%@&*()!.qwe"));
        listValidationEmail.add(new ValidationValue(true,"test111111111111111@test222222222222222222222222.test3333333333333333333333"));
        listValidationEmail.add(new ValidationValue(true,"test1@test1.test1"));
        listValidationEmail.add(new ValidationValue(true,"test@test.test"));

        for(int i=0;i<listValidationEmail.size();i++){
            emailId.sendKeys(listValidationEmail.get(i).value);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(GlobalMethods.chooseDevice().equals("web")) {
                if (buttonCheckId.isEnabled() && listValidationEmail.get(i).key == false || !buttonCheckId.isEnabled() && listValidationEmail.get(i).key == true) {
                    return false;
                }
                while(!emailId.getAttribute("value").isEmpty()){
                    emailId.sendKeys(Keys.BACK_SPACE);
                }
            } /*else {
                buttonCheckId.click();
                if(!buttonCheckId.isDisplayed() && listValidationEmail.get(i).key == false || buttonCheckId.isDisplayed() && listValidationEmail.get(i).key == true){
                    return false;
                }
                while(!emailId.getText().equals("E-mail. Editing.")){
                    emailId.sendKeys(Keys.BACK_SPACE);
                }
            }*/

        }
        return true;
    }


    public static boolean validationPhone(WebElement phoneId, WebElement buttonCheckId) throws InterruptedException {

        ArrayList<ValidationValue> listValidationPhone = new ArrayList<>();
        listValidationPhone.add(new ValidationValue(false," "));
        listValidationPhone.add(new ValidationValue(false,""));
        listValidationPhone.add(new ValidationValue(false,"тест"));
        listValidationPhone.add(new ValidationValue(false,"test"));
        listValidationPhone.add(new ValidationValue(false,"1"));
        listValidationPhone.add(new ValidationValue(false,"12345^7890"));
        listValidationPhone.add(new ValidationValue(false,"123456789000000000"));
        listValidationPhone.add(new ValidationValue(false,"!@#$%^&**()"));
        listValidationPhone.add(new ValidationValue(true,"1234567890"));
        listValidationPhone.add(new ValidationValue(true,"(123)4567890"));
        listValidationPhone.add(new ValidationValue(true,"(123)456-78-90"));
        listValidationPhone.add(new ValidationValue(true,"123 456 78 90"));
        listValidationPhone.add(new ValidationValue(true,"123 456-78-90"));
        listValidationPhone.add(new ValidationValue(true,"(123)456 78 90"));
        listValidationPhone.add(new ValidationValue(true,"(123)456-7890"));

        for(int i=0;i<listValidationPhone.size();i++){
            phoneId.sendKeys(listValidationPhone.get(i).value);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(buttonCheckId.isEnabled() && listValidationPhone.get(i).key == false || !buttonCheckId.isEnabled() && listValidationPhone.get(i).key == true){
                return false;
            }
            while(!phoneId.getAttribute("value").isEmpty()){
                phoneId.sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationVerificationCode(WebElement codeId, WebDriver driver) throws InterruptedException {

        String UsrInput = JOptionPane.showInputDialog("Input VerificationCode!!!");

        String verificationUrl = driver.getCurrentUrl();

        ArrayList<ValidationValue> listValidationVerificationCode = new ArrayList<>();

        //listValidationVerificationCode.add(new ValidationValue(false,""));
        listValidationVerificationCode.add(new ValidationValue(false,"1"));
        listValidationVerificationCode.add(new ValidationValue(false,"111111"));
        listValidationVerificationCode.add(new ValidationValue(false,"qqq"));
        listValidationVerificationCode.add(new ValidationValue(false,"qqqqqq"));
        listValidationVerificationCode.add(new ValidationValue(false,"ййй"));
        listValidationVerificationCode.add(new ValidationValue(false,"йййййй"));
        listValidationVerificationCode.add(new ValidationValue(false,"111111111111111"));
        listValidationVerificationCode.add(new ValidationValue(false,"!@#$%^&*()_"));
        listValidationVerificationCode.add(new ValidationValue(true,UsrInput));

        for(int i=0;i<listValidationVerificationCode.size();i++){
            codeId.sendKeys(listValidationVerificationCode.get(i).value);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(!verificationUrl.equals(driver.getCurrentUrl()) && listValidationVerificationCode.get(i).key == false || verificationUrl.equals(driver.getCurrentUrl()) && listValidationVerificationCode.get(i).key == true){
                return false;
            }
            if(listValidationVerificationCode.get(i).key == false) {
                while (!codeId.getAttribute("value").isEmpty()) {
                    codeId.sendKeys(Keys.BACK_SPACE);
                }
            }
        }
        return true;
    }

    public static boolean checkResendVerificationCode(WebElement codeId, WebDriver driver) throws InterruptedException {

        String UsrInput = JOptionPane.showInputDialog("Input second VerificationCode");

        String verificationUrl = driver.getCurrentUrl();

        codeId.sendKeys(UsrInput);
        //TODO: Переделать sleep! говно!
        Thread.sleep(700);
        if(verificationUrl.equals(driver.getCurrentUrl())){
            return false;
        }
        return true;
    }

    public static boolean validationSignUpRestaurant(SignUpStep1Class signUpStep1Class, String name, String email, String password, String confirmPassword, String confirmPasswordNotEquals, String passwordNotCorrect, String confirmPasswordNotCorrect) throws InterruptedException {

        ArrayList<ValidationValueSignUpRestaurant> listValidationSighUpRestaurant = new ArrayList<>();
        //listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"","","",""));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,"","",""));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"",email,"",""));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"","",password,""));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"","","",confirmPassword));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,email,"",""));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,"",password,""));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,"","",confirmPassword));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"",email,password,""));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"",email,"",confirmPassword));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"","",password,confirmPassword));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,email,password,""));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,email,"",confirmPassword));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,"",password,confirmPassword));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"",email,password,confirmPassword));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(true,name,email,password,confirmPassword));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,email,passwordNotCorrect,confirmPassword));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,email,password,confirmPasswordNotCorrect));
        listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,name,email,password,confirmPasswordNotEquals));

        for(int i=0;i<listValidationSighUpRestaurant.size();i++){
            signUpStep1Class.getName().sendKeys(listValidationSighUpRestaurant.get(i).name);
            signUpStep1Class.getEmail().sendKeys(listValidationSighUpRestaurant.get(i).email);
            signUpStep1Class.getPassword().sendKeys(listValidationSighUpRestaurant.get(i).password);
            signUpStep1Class.getConfirmPassword().sendKeys(listValidationSighUpRestaurant.get(i).confirmPassword);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(signUpStep1Class.getSignUpButton().isEnabled() && listValidationSighUpRestaurant.get(i).key == false || !signUpStep1Class.getSignUpButton().isEnabled() && listValidationSighUpRestaurant.get(i).key == true){
                return false;
            }
            while(!signUpStep1Class.getName().getAttribute("value").isEmpty()){
                signUpStep1Class.getName().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpStep1Class.getEmail().getAttribute("value").isEmpty()){
                signUpStep1Class.getEmail().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpStep1Class.getPassword().getAttribute("value").isEmpty()){
                signUpStep1Class.getPassword().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpStep1Class.getConfirmPassword().getAttribute("value").isEmpty()){
                signUpStep1Class.getConfirmPassword().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }


    public static boolean validationSignUpRestaurantStep2 (SignUpStep2Class signUpStep2Class, String logoFileName, String name, String imageFileName, String menuFileName) throws InterruptedException {

        String path = "/Users/dmitry/Desktop/";

        ArrayList<ValidationSignUpRestaurantStep2> listValidationSighUpRestaurantStep2 = new ArrayList<>();
        //listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"","","",""));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(true,"",name,"",""));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(false,"","",imageFileName,""));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(false,"","","",menuFileName));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(true,"",name,imageFileName,""));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(true,"",name,"",menuFileName));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(false,"","",imageFileName,menuFileName));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(true,"",name,imageFileName,menuFileName));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(false,logoFileName,"","",""));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(true,logoFileName,name,"",""));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(false,logoFileName,"",imageFileName,""));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(false,logoFileName,"","",menuFileName));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(true,logoFileName,name,imageFileName,""));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(true,logoFileName,name,"",menuFileName));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(false,logoFileName,"",imageFileName,menuFileName));
        listValidationSighUpRestaurantStep2.add(new ValidationSignUpRestaurantStep2(true,logoFileName,name,imageFileName,menuFileName));

        for(int i=0;i<listValidationSighUpRestaurantStep2.size();i++){
            if(!listValidationSighUpRestaurantStep2.get(i).logo.equals("")) {
                signUpStep2Class.getLogoButton().sendKeys(path + listValidationSighUpRestaurantStep2.get(i).logo);
            }
            if(!listValidationSighUpRestaurantStep2.get(i).name.equals("")) {
                signUpStep2Class.getNameRestaurant().sendKeys(listValidationSighUpRestaurantStep2.get(i).name);
            }
            if(!listValidationSighUpRestaurantStep2.get(i).restoImage.equals("")) {
                signUpStep2Class.addRestoImages(listValidationSighUpRestaurantStep2.get(i).restoImage);
            }
            if(!listValidationSighUpRestaurantStep2.get(i).restoMenu.equals("")) {
                signUpStep2Class.addPhotoMenu(listValidationSighUpRestaurantStep2.get(i).restoMenu);
            }
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(signUpStep2Class.getSignUpButton().isEnabled() && listValidationSighUpRestaurantStep2.get(i).key == false || !signUpStep2Class.getSignUpButton().isEnabled() && listValidationSighUpRestaurantStep2.get(i).key == true){
                return false;
            }
            while(!signUpStep2Class.getNameRestaurant().getAttribute("value").isEmpty()){
                signUpStep2Class.getNameRestaurant().sendKeys(Keys.BACK_SPACE);
            }
            if(!listValidationSighUpRestaurantStep2.get(i).restoMenu.equals("")) {
                signUpStep2Class.getMenuImageClose().click();
            }
            if(!listValidationSighUpRestaurantStep2.get(i).restoImage.equals("")) {
                signUpStep2Class.getRestoImageClose().click();
            }
        }
        return true;
    }

    public static Boolean validationCountry(WebElement countryId, WebElement countrySelectId) throws InterruptedException {
        ArrayList<ValidationValue> listValidationCountry = new ArrayList<>();
        listValidationCountry.add(new ValidationValue(false," "));
        listValidationCountry.add(new ValidationValue(false,"Russiaqwe"));
        listValidationCountry.add(new ValidationValue(false,"Россия"));
        listValidationCountry.add(new ValidationValue(false,"1"));
        listValidationCountry.add(new ValidationValue(false,"!@#$%^&**()"));
        listValidationCountry.add(new ValidationValue(true,"Ru"));
        //False потому что при вводе названия страны полностью, список select не показывается
        listValidationCountry.add(new ValidationValue(true,"Russia"));
        listValidationCountry.add(new ValidationValue(true,"russia"));
        listValidationCountry.add(new ValidationValue(false,"ussia"));


        for(int i=0;i<listValidationCountry.size();i++){
            countryId.sendKeys(listValidationCountry.get(i).value);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(!listValidationCountry.get(i).value.isEmpty()) {
                if (listValidationCountry.get(i).key == false && !countrySelectId.getText().isEmpty() || listValidationCountry.get(i).key == true && countrySelectId.getText().isEmpty()) {
                    return false;
                }
            } else {
                if (countrySelectId.isDisplayed()){
                    return false;
                }
            }
            while(!countryId.getAttribute("value").isEmpty()){
                countryId.sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationSignUpClient(TestClass.Client.SignUpClass signUpClass, String country, String phone, String password, String confirmPassword, String confirmPasswordNotEquals, String passwordNotCorrect, String confirmPasswordNotCorrect) throws InterruptedException {

        ArrayList<ValidationValueSignUpClient> listValidationSighUpClient = new ArrayList<>();
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,"","",""));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,"",phone,"",""));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,"","",password,""));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,"","","",confirmPassword));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,phone,"",""));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,"",password,""));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,"","",confirmPassword));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,"",phone,password,""));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,"",phone,"",confirmPassword));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,"","",password,confirmPassword));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,phone,password,""));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,phone,"",confirmPassword));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,"",password,confirmPassword));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,"",phone,password,confirmPassword));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(true,country,phone,password,confirmPassword));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,phone,passwordNotCorrect,confirmPassword));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,phone,password,confirmPasswordNotCorrect));
        listValidationSighUpClient.add(new ValidationValueSignUpClient(false,country,phone,password,confirmPasswordNotEquals));

        for(int i=0;i<listValidationSighUpClient.size();i++){
            signUpClass.getCountryField().sendKeys(listValidationSighUpClient.get(i).country);
            Thread.sleep(1000);
            signUpClass.getPhone().sendKeys(listValidationSighUpClient.get(i).phone);
            signUpClass.getPassword().sendKeys(listValidationSighUpClient.get(i).password);
            signUpClass.getConfirmPassword().sendKeys(listValidationSighUpClient.get(i).confirmPassword);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(signUpClass.getSignUpButton().isEnabled() && listValidationSighUpClient.get(i).key == false || !signUpClass.getSignUpButton().isEnabled() && listValidationSighUpClient.get(i).key == true){
                return false;
            }
            while(!signUpClass.getCountryField().getAttribute("value").isEmpty()){
                signUpClass.getCountryField().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpClass.getPhone().getAttribute("value").isEmpty()){
                signUpClass.getPhone().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpClass.getPassword().getAttribute("value").isEmpty()){
                signUpClass.getPassword().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpClass.getConfirmPassword().getAttribute("value").isEmpty()){
                signUpClass.getConfirmPassword().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean ValidationSignUpRestaurantStep3(WebDriver driver, SignUpStep3Class signUpStep3, String address, String city, String state, String country, String zipCode) throws InterruptedException {

        ArrayList<ValidationSignUpRestaurantStep3> listValidationSighUpRestaurantStep3 = new ArrayList<>();

        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"","","","",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(true,address,city,state,country,zipCode));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,"","","",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"",city,"","",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"","",state,"",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"","","",country,""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"","","","",zipCode));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,city,"","",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,"",state,"",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,"","",country,""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,"","","",zipCode));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,city,"","",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,city,"","",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"",city,state,"",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"",city,"",country,""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"",city,"","",zipCode));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,"",state,"",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"",city,state,"",""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"","",state,country,""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"",city,"","",zipCode));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,"","",country,""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"",city,"",country,""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"","",state,country,""));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"","","",country,zipCode));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,address,"","","",zipCode));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"",city,"","",zipCode));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"","",state,"",zipCode));
        listValidationSighUpRestaurantStep3.add(new ValidationSignUpRestaurantStep3(false,"","","",country,zipCode));


        for(int i=0;i<listValidationSighUpRestaurantStep3.size();i++){
            signUpStep3.getAddress().sendKeys(listValidationSighUpRestaurantStep3.get(i).address);
            signUpStep3.getCity().sendKeys(listValidationSighUpRestaurantStep3.get(i).city);
            signUpStep3.getState().sendKeys(listValidationSighUpRestaurantStep3.get(i).state);
            signUpStep3.getCountry().sendKeys(listValidationSighUpRestaurantStep3.get(i).country);
            signUpStep3.getZipCode().sendKeys(listValidationSighUpRestaurantStep3.get(i).zipCode);
            Thread.sleep(700);
            //System.out.println(driver.findElement(By.id("submitAddress")).getAttribute("disabled") + " " + listValidationSighUpRestaurantStep3.get(i).key);
            if(driver.findElement(By.id("submitAddress")).getAttribute("disabled") == null && listValidationSighUpRestaurantStep3.get(i).key == false || driver.findElement(By.id("submitAddress")).getAttribute("disabled") !=null && listValidationSighUpRestaurantStep3.get(i).key == true){
                return false;
            }
            while(!signUpStep3.getAddress().getAttribute("value").isEmpty()){
                signUpStep3.getAddress().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpStep3.getCity().getAttribute("value").isEmpty()){
                signUpStep3.getCity().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpStep3.getState().getAttribute("value").isEmpty()){
                signUpStep3.getState().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpStep3.getCountry().getAttribute("value").isEmpty()){
                signUpStep3.getCountry().sendKeys(Keys.BACK_SPACE);
            }
            while(!signUpStep3.getZipCode().getAttribute("value").isEmpty()){
                signUpStep3.getZipCode().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static String randomPhone() {
        Random random = new Random();
        String phone = "918";
        for(int i=0;i<7;i++) {
            phone += String.valueOf(random.nextInt(10));
        }
        return phone;
    }


    public static boolean validationAddOrder(MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass, String restaurant, String order, String description) throws InterruptedException {

        ArrayList<ValidationAddOrder> listValidationAddOrder = new ArrayList<>();
        listValidationAddOrder.add(new ValidationAddOrder(false,restaurant,"",""));
        listValidationAddOrder.add(new ValidationAddOrder(false,"",order,""));
        listValidationAddOrder.add(new ValidationAddOrder(false,"","",description));
        listValidationAddOrder.add(new ValidationAddOrder(false,"","",""));
        listValidationAddOrder.add(new ValidationAddOrder(true,restaurant,order,""));
        listValidationAddOrder.add(new ValidationAddOrder(false,restaurant,"",description));
        listValidationAddOrder.add(new ValidationAddOrder(false,restaurant,"",""));
        listValidationAddOrder.add(new ValidationAddOrder(false,"",order,description));
        listValidationAddOrder.add(new ValidationAddOrder(true,restaurant,order,description));

        for(int i=0;i<listValidationAddOrder.size();i++){
            mainScreenSidebarAddOrderClass.getRestaurantName().sendKeys(listValidationAddOrder.get(i).restaurant);
            mainScreenSidebarAddOrderClass.getOrderName().sendKeys(listValidationAddOrder.get(i).order);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(mainScreenSidebarAddOrderClass.getSubmitButton().isEnabled() && listValidationAddOrder.get(i).key == false || !mainScreenSidebarAddOrderClass.getSubmitButton().isEnabled() && listValidationAddOrder.get(i).key == true){
                return false;
            }
            while(!mainScreenSidebarAddOrderClass.getRestaurantName().getAttribute("value").isEmpty()){
                mainScreenSidebarAddOrderClass.getRestaurantName().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddOrderClass.getOrderName().getAttribute("value").isEmpty()){
                mainScreenSidebarAddOrderClass.getOrderName().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationRestaurant(WebElement restaurantId, WebElement buttonCheckId) throws InterruptedException {
        ArrayList<ValidationValue> listValidationRestaurant = new ArrayList<>();
        listValidationRestaurant.add(new ValidationValue(false," "));
        listValidationRestaurant.add(new ValidationValue(false,""));
        listValidationRestaurant.add(new ValidationValue(false,"тест"));
        listValidationRestaurant.add(new ValidationValue(false,"КФС"));
        listValidationRestaurant.add(new ValidationValue(false,"123"));
        listValidationRestaurant.add(new ValidationValue(true,"KFC"));
        listValidationRestaurant.add(new ValidationValue(false,"KFCTEST"));
        listValidationRestaurant.add(new ValidationValue(true,"K"));
        listValidationRestaurant.add(new ValidationValue(true,"F"));
        listValidationRestaurant.add(new ValidationValue(true,"kfc"));
        listValidationRestaurant.add(new ValidationValue(false,"!@$#$#$%^&*"));
        listValidationRestaurant.add(new ValidationValue(false,"1KFC"));

        for(int i=0;i<listValidationRestaurant.size();i++){
            restaurantId.sendKeys(listValidationRestaurant.get(i).value);
            Thread.sleep(700);
            if(buttonCheckId.isEnabled() && listValidationRestaurant.get(i).key == false || !buttonCheckId.isEnabled() && listValidationRestaurant.get(i).key == true){
                return false;
            }
            while(!restaurantId.getAttribute("value").isEmpty()){
                restaurantId .sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }


    public static boolean validationAddAddress(MainScreenSidebarAddAddressClass mainScreenSidebarAddAddressClass, String city, String address, String home) throws InterruptedException {

        ArrayList<ValidationAddAddress> listValidationAddAddress = new ArrayList<>();
        //listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"","","",""));
        listValidationAddAddress.add(new ValidationAddAddress(false,"","",""));
        listValidationAddAddress.add(new ValidationAddAddress(false,city,"",""));
        listValidationAddAddress.add(new ValidationAddAddress(false,"",address,""));
        listValidationAddAddress.add(new ValidationAddAddress(false,"","",home));
        listValidationAddAddress.add(new ValidationAddAddress(false,city,"",""));
        listValidationAddAddress.add(new ValidationAddAddress(false,"",address,""));
        listValidationAddAddress.add(new ValidationAddAddress(false,"","",home));
        listValidationAddAddress.add(new ValidationAddAddress(false,city,address,""));
        listValidationAddAddress.add(new ValidationAddAddress(false,city,"",home));
        listValidationAddAddress.add(new ValidationAddAddress(false,"",address,home));
        listValidationAddAddress.add(new ValidationAddAddress(false,city,address,""));
        listValidationAddAddress.add(new ValidationAddAddress(false,city,"",home));
        listValidationAddAddress.add(new ValidationAddAddress(false,"",address,home));
        listValidationAddAddress.add(new ValidationAddAddress(false,city,address,home));
        listValidationAddAddress.add(new ValidationAddAddress(true,city,address,home));

        for(int i=0;i<listValidationAddAddress.size();i++){
            mainScreenSidebarAddAddressClass.getCity().sendKeys(listValidationAddAddress.get(i).city);
            mainScreenSidebarAddAddressClass.getAddress().sendKeys(listValidationAddAddress.get(i).address);
            mainScreenSidebarAddAddressClass.getName().sendKeys(listValidationAddAddress.get(i).home);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(mainScreenSidebarAddAddressClass.getSubmitButton().isEnabled() && listValidationAddAddress.get(i).key == false || !mainScreenSidebarAddAddressClass.getSubmitButton().isEnabled() && listValidationAddAddress.get(i).key == true){
                return false;
            }
            while(!mainScreenSidebarAddAddressClass.getCity().getAttribute("value").isEmpty()){
                mainScreenSidebarAddAddressClass.getCity().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddAddressClass.getAddress().getAttribute("value").isEmpty()){
                mainScreenSidebarAddAddressClass.getAddress().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddAddressClass.getName().getAttribute("value").isEmpty()){
                mainScreenSidebarAddAddressClass.getName().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }


    public static boolean validationPayment(MainScreenSidebarAddPaymentsClass mainScreenSidebarAddPaymentsClass, String number1, String number2, String dateMonth, String dateYear, String cvv) throws InterruptedException {

        ArrayList<ValidationPayment> listValidationPayment = new ArrayList<>();
        //listValidationSighUpRestaurant.add(new ValidationValueSignUpRestaurant(false,"","","",""));
        listValidationPayment.add(new ValidationPayment(false, number1, number2, number2, number2, "", "", ""));
        listValidationPayment.add(new ValidationPayment(false, "", "", "", "",dateMonth, "", ""));
        listValidationPayment.add(new ValidationPayment(false, "" , "", "", "", "", dateYear,""));
        listValidationPayment.add(new ValidationPayment(false, "" , "", "", "", "", "", cvv));
        listValidationPayment.add(new ValidationPayment(false, number1, number2, number2, number2, dateMonth, dateYear, ""));
        listValidationPayment.add(new ValidationPayment(false,number1, number2, number2, number2,"",dateYear,""));
        listValidationPayment.add(new ValidationPayment(false,number1, number2, number2, number2,"","",cvv));
        listValidationPayment.add(new ValidationPayment(false, "", "", "", "", dateMonth, dateYear, ""));
        listValidationPayment.add(new ValidationPayment(false, "" , "", "", "",dateMonth,"",cvv));
        listValidationPayment.add(new ValidationPayment(false,"" , "", "", "","",dateYear,cvv));
        listValidationPayment.add(new ValidationPayment(false,number1, number2, number2, number2,dateMonth,dateYear,""));
        listValidationPayment.add(new ValidationPayment(false,number1, number2, number2, number2,dateMonth,"",cvv));
        listValidationPayment.add(new ValidationPayment(false,number1, number2, number2, number2,"",dateYear,cvv));
        listValidationPayment.add(new ValidationPayment(false, "", "", "", "",dateMonth,dateYear,cvv));
        listValidationPayment.add(new ValidationPayment(true, number1, number2, number2, number2, dateMonth, dateYear, cvv));

        for(int i=0;i<listValidationPayment.size();i++){
            mainScreenSidebarAddPaymentsClass.getCardNumber1().sendKeys(listValidationPayment.get(i).number1);
            mainScreenSidebarAddPaymentsClass.getCardNumber2().sendKeys(listValidationPayment.get(i).number2);
            mainScreenSidebarAddPaymentsClass.getCardNumber3().sendKeys(listValidationPayment.get(i).number3);
            mainScreenSidebarAddPaymentsClass.getCardNumber4().sendKeys(listValidationPayment.get(i).number4);
            mainScreenSidebarAddPaymentsClass.getCardDateMonth().sendKeys(listValidationPayment.get(i).dateMonth);
            mainScreenSidebarAddPaymentsClass.getCardDateYear().sendKeys(listValidationPayment.get(i).dateYear);
            mainScreenSidebarAddPaymentsClass.getCardCvv().sendKeys(listValidationPayment.get(i).cvv);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(mainScreenSidebarAddPaymentsClass.getSubmitButton().isEnabled() && listValidationPayment.get(i).key == false || !mainScreenSidebarAddPaymentsClass.getSubmitButton().isEnabled() && listValidationPayment.get(i).key == true){
                return false;
            }
            while(!mainScreenSidebarAddPaymentsClass.getCardNumber1().getAttribute("value").isEmpty()){
                mainScreenSidebarAddPaymentsClass.getCardNumber1().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddPaymentsClass.getCardNumber2().getAttribute("value").isEmpty()){
                mainScreenSidebarAddPaymentsClass.getCardNumber2().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddPaymentsClass.getCardNumber3().getAttribute("value").isEmpty()){
                mainScreenSidebarAddPaymentsClass.getCardNumber3().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddPaymentsClass.getCardNumber4().getAttribute("value").isEmpty()){
                mainScreenSidebarAddPaymentsClass.getCardNumber4().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddPaymentsClass.getCardDateMonth().getAttribute("value").isEmpty()){
                mainScreenSidebarAddPaymentsClass.getCardDateMonth().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddPaymentsClass.getCardDateYear().getAttribute("value").isEmpty()){
                mainScreenSidebarAddPaymentsClass.getCardDateYear().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddPaymentsClass.getCardCvv().getAttribute("value").isEmpty()){
                mainScreenSidebarAddPaymentsClass.getCardCvv().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationAddress(WebElement addressId, WebElement buttonCheckId) throws InterruptedException {
        ArrayList<ValidationValue> listValidationAddress = new ArrayList<>();
        listValidationAddress.add(new ValidationValue(false," "));
        listValidationAddress.add(new ValidationValue(false,""));
        listValidationAddress.add(new ValidationValue(true,"Russia,Krasnodar,ulitsa Kommunarov,268а корпус 1"));
        listValidationAddress.add(new ValidationValue(false,"Rus"));
        listValidationAddress.add(new ValidationValue(false,"russia"));
        listValidationAddress.add(new ValidationValue(false,"ussia"));
        listValidationAddress.add(new ValidationValue(false,"Krasnodar"));
        listValidationAddress.add(new ValidationValue(false,"krasnodar"));
        listValidationAddress.add(new ValidationValue(false,"!@$#$#$%^&*"));
        listValidationAddress.add(new ValidationValue(false,"kommunarov"));
        listValidationAddress.add(new ValidationValue(false,"68"));
        listValidationAddress.add(new ValidationValue(false,"1"));
        listValidationAddress.add(new ValidationValue(false,"Russiaasd,Krasnodarasdc,ulitsasdf Kommunarov,268а корпус 12"));
        listValidationAddress.add(new ValidationValue(false,"Russia,Krasnodarasdc,ulitsasdf Kommunarov,268а корпус 1 1"));

        for(int i=0;i<listValidationAddress.size();i++){
            addressId.sendKeys(listValidationAddress.get(i).value);
            Thread.sleep(700);
            if(buttonCheckId.isEnabled() && listValidationAddress.get(i).key == false || !buttonCheckId.isEnabled() && listValidationAddress.get(i).key == true){
                return false;
            }
            while(!addressId.getAttribute("value").isEmpty()){
                addressId .sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationDatePayment(WebElement dateMonthId, WebElement dateYearId, WebElement buttonCheckId) throws InterruptedException {
        ArrayList<ValidationPayment> listValidationPayment = new ArrayList<>();
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "","","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", " "," ","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","99","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "99","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "99","99","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "99","17","333"));
        listValidationPayment.add(new ValidationPayment(true, "4444","4444","4444","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "qwe","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","qwe","333"));

        for(int i=0;i<listValidationPayment.size();i++){
            dateMonthId.sendKeys(listValidationPayment.get(i).dateMonth);
            dateYearId.sendKeys(listValidationPayment.get(i).dateYear);
            Thread.sleep(700);
            if(buttonCheckId.isEnabled() && listValidationPayment.get(i).key == false || !buttonCheckId.isEnabled() && listValidationPayment.get(i).key == true){
                return false;
            }
            while(!dateMonthId.getAttribute("value").isEmpty()){
                dateMonthId .sendKeys(Keys.BACK_SPACE);
            }
            while(!dateYearId.getAttribute("value").isEmpty()){
                dateYearId .sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationNumberPayment(WebElement number1Id, WebElement number2Id, WebElement number3Id, WebElement number4Id, WebElement buttonCheckId) throws InterruptedException {
        ArrayList<ValidationPayment> listValidationPayment = new ArrayList<>();
        listValidationPayment.add(new ValidationPayment(false, "qqqq","4444","4444","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","qqqq","4444","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","qqqq","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","qqqq", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "44444","4444","4444","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","44444","4444","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(true, "4444","4444","44444","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","44444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "444","4444","4444","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","444","4444","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","444","444", "11","17","333"));

        for(int i=0;i<listValidationPayment.size();i++){
            number1Id.sendKeys(listValidationPayment.get(i).number1);
            number2Id.sendKeys(listValidationPayment.get(i).number2);
            number3Id.sendKeys(listValidationPayment.get(i).number3);
            number4Id.sendKeys(listValidationPayment.get(i).number4);
            Thread.sleep(700);
            if(buttonCheckId.isEnabled() && listValidationPayment.get(i).key == false || !buttonCheckId.isEnabled() && listValidationPayment.get(i).key == true){
                return false;
            }
            while(!number1Id.getAttribute("value").isEmpty()){
                number1Id.sendKeys(Keys.BACK_SPACE);
            }
            while(!number2Id.getAttribute("value").isEmpty()){
                number2Id.sendKeys(Keys.BACK_SPACE);
            }
            while(!number3Id.getAttribute("value").isEmpty()){
                number3Id.sendKeys(Keys.BACK_SPACE);
            }
            while(!number4Id.getAttribute("value").isEmpty()){
                number4Id.sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationCvvPayment(WebElement cvvId, WebElement buttonCheckId) throws InterruptedException {
        ArrayList<ValidationPayment> listValidationPayment = new ArrayList<>();
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","17","333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","17","3333"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","17","33"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","17","qwe"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","17","q"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","17","qqqq"));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","17",""));
        listValidationPayment.add(new ValidationPayment(false, "4444","4444","4444","4444", "11","17","!@#"));

        for(int i=0;i<listValidationPayment.size();i++){
            cvvId.sendKeys(listValidationPayment.get(i).dateMonth);
            Thread.sleep(700);
            if(buttonCheckId.isEnabled() && listValidationPayment.get(i).key == false || !buttonCheckId.isEnabled() && listValidationPayment.get(i).key == true){
                return false;
            }
            while(!cvvId.getAttribute("value").isEmpty()){
                cvvId .sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationQuickOrder(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass, String restaurant, String address, String payment) throws InterruptedException {

        ArrayList<ValidationAddQuickOrder> listValidationAddQuickOrder = new ArrayList<>();
        listValidationAddQuickOrder.add(new ValidationAddQuickOrder(false,restaurant,"",""));
        listValidationAddQuickOrder.add(new ValidationAddQuickOrder(false,"",address,""));
        listValidationAddQuickOrder.add(new ValidationAddQuickOrder(false,"","",payment));
        listValidationAddQuickOrder.add(new ValidationAddQuickOrder(false,"","",""));
        listValidationAddQuickOrder.add(new ValidationAddQuickOrder(true,restaurant,address,""));
        listValidationAddQuickOrder.add(new ValidationAddQuickOrder(false,restaurant,"",payment));
        listValidationAddQuickOrder.add(new ValidationAddQuickOrder(false,restaurant,"",""));
        listValidationAddQuickOrder.add(new ValidationAddQuickOrder(false,"",address,payment));
        listValidationAddQuickOrder.add(new ValidationAddQuickOrder(true,restaurant,address,payment));

        for(int i=0;i<listValidationAddQuickOrder.size();i++){
            mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(listValidationAddQuickOrder.get(i).restaurant);
            mainScreenSidebarAddQuickOrderClass.getAddress().sendKeys(listValidationAddQuickOrder.get(i).address);
            mainScreenSidebarAddQuickOrderClass.getPayment().sendKeys(listValidationAddQuickOrder.get(i).payment);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(mainScreenSidebarAddQuickOrderClass.getSubmitButton().isEnabled() && listValidationAddQuickOrder.get(i).key == false || !mainScreenSidebarAddQuickOrderClass.getSubmitButton().isEnabled() && listValidationAddQuickOrder.get(i).key == true){
                return false;
            }
            while(!mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().getAttribute("value").isEmpty()){
                mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddQuickOrderClass.getAddress().getAttribute("value").isEmpty()){
                mainScreenSidebarAddQuickOrderClass.getAddress().sendKeys(Keys.BACK_SPACE);
            }
            while(!mainScreenSidebarAddQuickOrderClass.getPayment().getAttribute("value").isEmpty()){
                mainScreenSidebarAddQuickOrderClass.getPayment().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationFavoriteOrder(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        //Проверка открытия выпадающего списка со значениями Restaurant при вводе значений в это поле
        //TODO дополнить список
        ArrayList<ValidationValue> listValidationRestaurant = new ArrayList<>();
        listValidationRestaurant.add(new ValidationValue(false," "));
        listValidationRestaurant.add(new ValidationValue(false,""));
        listValidationRestaurant.add(new ValidationValue(true,"K"));
        listValidationRestaurant.add(new ValidationValue(false,"334645623411111"));
        listValidationRestaurant.add(new ValidationValue(false,"Test"));
        listValidationRestaurant.add(new ValidationValue(false,"!@$#$#$%^&*"));

        for(int i=0;i<listValidationRestaurant.size();i++){
            mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(listValidationRestaurant.get(i).value);
            Thread.sleep(700);
            if(!mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).isDisplayed() && listValidationRestaurant.get(i).key == true || mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).isDisplayed() && listValidationRestaurant.get(i).key == false){
                return false;
            }
            while(!mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().getAttribute("value").isEmpty()){
                mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationChooseOrderFavoriteOrder(ChooseOrderClass chooseOrderClass) throws InterruptedException {
        //Проверка открытия выпадающего списка со значениями Restaurant при вводе значений в это поле
        //TODO дополнить список
        ArrayList<ValidationValue> listValidationRestaurant = new ArrayList<>();
        listValidationRestaurant.add(new ValidationValue(false," "));
        listValidationRestaurant.add(new ValidationValue(false,""));
        listValidationRestaurant.add(new ValidationValue(true,"K"));
        listValidationRestaurant.add(new ValidationValue(false,"334645623411111"));
        listValidationRestaurant.add(new ValidationValue(false,"Test"));
        listValidationRestaurant.add(new ValidationValue(false,"!@$#$#$%^&*"));

        for(int i=0;i<listValidationRestaurant.size();i++){
            chooseOrderClass.getChooseFavoriteOrder().sendKeys(listValidationRestaurant.get(i).value);
            Thread.sleep(700);
            if(!chooseOrderClass.getChooseFavoriteOrderElementList().get(0).isDisplayed() && listValidationRestaurant.get(i).key == true || chooseOrderClass.getChooseFavoriteOrderElementList().get(0).isDisplayed() && listValidationRestaurant.get(i).key == false){
                return false;
            }
            while(!chooseOrderClass.getChooseFavoriteOrder().getAttribute("value").isEmpty()){
                chooseOrderClass.getChooseFavoriteOrder().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationFavoriteOrderList(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        //Проверка открытия выпадающего списка со значениями Restaurant при вводе значений в это поле
        //TODO дополнить список
        ArrayList<ValidationValue> listValidationFavoriteOrder = new ArrayList<>();
        listValidationFavoriteOrder.add(new ValidationValue(false," "));
        listValidationFavoriteOrder.add(new ValidationValue(false,""));
        listValidationFavoriteOrder.add(new ValidationValue(true,"K"));
        listValidationFavoriteOrder.add(new ValidationValue(false,"334645623411111"));
        listValidationFavoriteOrder.add(new ValidationValue(false,"Test"));
        listValidationFavoriteOrder.add(new ValidationValue(false,"!@$#$#$%^&*"));

        for(int i=0;i<listValidationFavoriteOrder.size();i++){
            mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(listValidationFavoriteOrder.get(i).value);
            Thread.sleep(700);
            if(!mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).isDisplayed() && listValidationFavoriteOrder.get(i).key == true || mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).isDisplayed() && listValidationFavoriteOrder.get(i).key == false){
                return false;
            }
            while(!mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().getAttribute("value").isEmpty()){
                mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationAddressList(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        //Проверка открытия выпадающего списка со значениями Address при вводе значений в это поле
        //TODO дополнить список
        ArrayList<ValidationValue> listValidationAddress = new ArrayList<>();
        listValidationAddress.add(new ValidationValue(false," "));
        listValidationAddress.add(new ValidationValue(false,""));
        listValidationAddress.add(new ValidationValue(true,"K"));
        listValidationAddress.add(new ValidationValue(false,"334645623411111"));
        listValidationAddress.add(new ValidationValue(false,"Test"));
        listValidationAddress.add(new ValidationValue(false,"!@$#$#$%^&*"));

        for(int i=0;i<listValidationAddress.size();i++){
            mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(listValidationAddress.get(i).value);
            Thread.sleep(700);
            if(!mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).isDisplayed() && listValidationAddress.get(i).key == true || mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).isDisplayed() && listValidationAddress.get(i).key == false){
                return false;
            }
            while(!mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().getAttribute("value").isEmpty()){
                mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationPaymentList(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        //Проверка открытия выпадающего списка со значениями Payment при вводе значений в это поле
        //TODO дополнить список
        ArrayList<ValidationValue> listValidationPayment = new ArrayList<>();
        listValidationPayment.add(new ValidationValue(false," "));
        listValidationPayment.add(new ValidationValue(false,""));
        listValidationPayment.add(new ValidationValue(true,"K"));
        listValidationPayment.add(new ValidationValue(false,"334645623411111"));
        listValidationPayment.add(new ValidationValue(false,"Test"));
        listValidationPayment.add(new ValidationValue(false,"!@$#$#$%^&*"));

        for(int i=0;i<listValidationPayment.size();i++){
            mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(listValidationPayment.get(i).value);
            Thread.sleep(700);
            if(!mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).isDisplayed() && listValidationPayment.get(i).key == true || mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).isDisplayed() && listValidationPayment.get(i).key == false){
                return false;
            }
            while(!mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().getAttribute("value").isEmpty()){
                mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }


    public static boolean validationSearchRestaurant(RestaurantSearchClass restaurantSearchClass, RestaurantScreenClass restaurantScreenClass) throws InterruptedException {
        //Проверка поиска ресторанов
        //TODO дополнить список
        ArrayList<ValidationValue> listValidationPayment = new ArrayList<>();
        listValidationPayment.add(new ValidationValue(false," "));
        listValidationPayment.add(new ValidationValue(false,""));
        listValidationPayment.add(new ValidationValue(true,"K"));
        listValidationPayment.add(new ValidationValue(false,"334645623411111"));
        listValidationPayment.add(new ValidationValue(false,"Test"));
        listValidationPayment.add(new ValidationValue(false,"!@$#$#$%^&*"));
        listValidationPayment.add(new ValidationValue(true,"F"));
        listValidationPayment.add(new ValidationValue(true,"KFC"));
        listValidationPayment.add(new ValidationValue(true,"kfc"));

        for(int i=0;i<listValidationPayment.size();i++){
            restaurantSearchClass.getSearchField().sendKeys(listValidationPayment.get(i).value);
            restaurantSearchClass.getSearchButton().click();
            Thread.sleep(700);
            if(restaurantScreenClass.getRestaurantList().size() == 0 && listValidationPayment.get(i).key == true || restaurantScreenClass.getRestaurantList().size() != 0 && listValidationPayment.get(i).key == false){
                return false;
            }
            //Проверяем, чтобы все найденные рестораны содержали в своем названии искомую подстроку
            for(int j=0; j<restaurantScreenClass.getRestaurantList().size(); j++){
                if(!restaurantScreenClass.getNameRestaurant().get(j).getText().contains(listValidationPayment.get(i).value)){
                    return false;
                }
            }
            while(!restaurantSearchClass.getSearchField().getAttribute("value").isEmpty()){
                restaurantSearchClass.getSearchField().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }

    public static boolean validationChooseOrder(ChooseOrderClass chooseOrderClass, String favoriteOrder, String typeNewOrder) throws InterruptedException {

        ArrayList<ValidationChooseOrder> listValidationAddQuickOrder = new ArrayList<>();
        listValidationAddQuickOrder.add(new ValidationChooseOrder(false,"",""));
        listValidationAddQuickOrder.add(new ValidationChooseOrder(true,"",typeNewOrder));
        listValidationAddQuickOrder.add(new ValidationChooseOrder(true,favoriteOrder,""));
        listValidationAddQuickOrder.add(new ValidationChooseOrder(false,favoriteOrder,typeNewOrder));

        for(int i=0;i<listValidationAddQuickOrder.size();i++){
            chooseOrderClass.getChooseFavoriteOrder().sendKeys(listValidationAddQuickOrder.get(i).favoriteOrder);
            chooseOrderClass.getTypeNewOrder().sendKeys(listValidationAddQuickOrder.get(i).typeNewOrder);
            //TODO: Переделать sleep! говно!
            Thread.sleep(700);
            if(chooseOrderClass.getSubmitButton().isEnabled() && listValidationAddQuickOrder.get(i).key == false || !chooseOrderClass.getSubmitButton().isEnabled() && listValidationAddQuickOrder.get(i).key == true){
                return false;
            }
            while(!chooseOrderClass.getChooseFavoriteOrder().getAttribute("value").isEmpty()){
                chooseOrderClass.getChooseFavoriteOrder().sendKeys(Keys.BACK_SPACE);
            }
            while(!chooseOrderClass.getTypeNewOrder().getAttribute("value").isEmpty()){
                chooseOrderClass.getTypeNewOrder().sendKeys(Keys.BACK_SPACE);
            }
        }
        return true;
    }



}





