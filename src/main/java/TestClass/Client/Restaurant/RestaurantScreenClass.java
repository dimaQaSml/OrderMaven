package TestClass.Client.Restaurant;

import TestClass.GlobalMethods.GlobalMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 03.08.16.
 */
public class RestaurantScreenClass {

    WebDriver driver;
    WebDriverWait waiting;

    public RestaurantScreenClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private List<WebElement> ratingRestaurant;

    private List<WebElement> nameRestaurant;

    private List<WebElement> workingHours;

    private List<WebElement> orderNowButton;

    private List<WebElement> restaurantList;

    private WebElement errorLabelSearch;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setRatingRestaurant(driver.findElements(By.xpath(pathWeb + "")));
                setNameRestaurant(driver.findElements(By.xpath(pathWeb + "")));
                setWorkingHours(driver.findElements(By.xpath(pathWeb + "")));
                setOrderNowButton(driver.findElements(By.xpath(pathWeb + "")));
                break;
        }
    }

    public boolean testCase98() throws InterruptedException {
        if(getOrderNowButton().size()>0) {
            getOrderNowButton().get(0).click();
        } else{
            return false;
        }
        try {
            //TODO чатик и orderNow
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase99() throws InterruptedException {
        if(getNameRestaurant().size()>0) {
            getNameRestaurant().get(0).click();
        } else{
            return false;
        }
        try {
            RestaurantModalClass restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
            restaurantModalClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase100() throws InterruptedException {
        if(getNameRestaurant().size()>0) {
            getNameRestaurant().get(0).click();
        } else{
            return false;
        }
        try {
            RestaurantModalClass restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
            restaurantModalClass.chooseDevice();
            restaurantModalClass.getOrderNowButton().click();
            //TODO чатик и orderNow
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase101() throws InterruptedException {
        if(getNameRestaurant().size()>0) {
            getNameRestaurant().get(0).click();
        } else{
            return false;
        }
        try {
            RestaurantModalClass restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
            restaurantModalClass.chooseDevice();
            restaurantModalClass.getRateReviewsButton().click();
            Rate_ReviewClass rate_reviewClass = PageFactory.initElements(driver, Rate_ReviewClass.class);
            rate_reviewClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase102() throws InterruptedException {
        if(getNameRestaurant().size()>0) {
            getNameRestaurant().get(0).click();
        } else{
            return false;
        }
        try {
            RestaurantModalClass restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
            restaurantModalClass.chooseDevice();
            restaurantModalClass.getReportButton().click();
            SendReportClass sendReportClass = PageFactory.initElements(driver, SendReportClass.class);
            sendReportClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase103() throws InterruptedException {
        if(getNameRestaurant().size()>0) {
            getNameRestaurant().get(0).click();
        } else{
            return false;
        }
        try {
            RestaurantModalClass restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
            restaurantModalClass.chooseDevice();
            restaurantModalClass.getChatNowButton().click();
            //TODO chat choose device
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean comparation(String param1, String param2){
        if(param1.equals(param2)){
            return true;
        } else{
            return false;
        }
    }

    public boolean testCase104() throws InterruptedException {
        //Регистрация нового ресторана
        /*SignInClass signInClass= PageFactory.initElements(driver, SignInClass.class);
        SignUpStep1Class signUpStep1Class= PageFactory.initElements(driver, SignUpStep1Class.class);
        SignUpStep2Class signUpStep2Class = PageFactory.initElements(driver, SignUpStep2Class.class);
        SignUpStep3Class signUpStep3Class= PageFactory.initElements(driver, SignUpStep3Class.class);
        SignUpStep4Class signUpStep4Class = PageFactory.initElements(driver, SignUpStep4Class.class);
        SignUpStep5Class signUpStep5Class = PageFactory.initElements(driver, SignUpStep5Class.class);

        String name = "testName";
        String email = GlobalMethods.getEmail();
        String password = GlobalMethods.getPassword();
        String confirmPassword = GlobalMethods.getPassword();

        String nameRestaurant = "testRestaurant";

        String address = "testAddress";
        String searchAddress = "ulitsa Kommunarov, 26, Krasnodar, Krasnodar Krai, Russia";
        String city = "Krasnodar";
        String state = "Krasnodarskiy kray";
        String country = "Russia";
        String zipCode = "350000";

        FirefoxProfile firefoxProfile;
        ProfilesIni profile = new ProfilesIni();
        firefoxProfile = profile.getProfile("QA");
        driver = new FirefoxDriver(firefoxProfile);
        driver.get("URL_rest");
        signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();
        signUpStep1Class.signUpClick(name,email,password,confirmPassword);
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpClick(nameRestaurant,"wert.jpeg","bnm.jpg");
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpClick(address,city,state,country,zipCode);
        signUpStep4Class.chooseDevice();
        signUpStep4Class.signUpClick();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();
        driver.close();*/

        //TODO
       /* SignInClass signInClassRestaurant = PageFactory.initElements(driver, SignInClass.class);
        Client.SignInClass signInClassClient = PageFactory.initElements(driver, Client.SignInClass.class);
        MainScreenClass mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);
        RestaurantScreenClass restaurantScreenClass = PageFactory.initElements(driver, RestaurantScreenClass.class);
        RestaurantModalClass restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);

        SignUpAllSteps signUpAllSteps = PageFactory.initElements(driver, SignUpAllSteps.class);
        signUpAllSteps. testCase69();
        driver.close();
        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClassClient.chooseDevice();
        signInClassClient.signInClick(GlobalMethods.getPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
        mainScreenClass.getRestaurantsScreen().click();
        restaurantScreenClass.chooseDevice();
        restaurantScreenClass.getNameRestaurant().get(0).click();
        restaurantModalClass.chooseDevice();

        if(comparation(restaurantModalClass.getNameRestaurant().getAttribute("value"),GlobalMethods.getNameRestaurant()))
            return false;
        if(comparation(restaurantModalClass.getCategories().get(0).getAttribute("value"),"Not Kosher"))
            return false;
        if(!restaurantModalClass.getRestaurantPhotosArea().isDisplayed())
            return false;
        if(!restaurantModalClass.getRestaurantMenuPhotosArea().isDisplayed())
            return false;
        return true;*/
        return false;
    }

    public boolean testCase105() throws InterruptedException {
        //TODO
       /* SignInClass signInClassRestaurant = PageFactory.initElements(driver, SignInClass.class);
        MainScreenMyRestaurant mainScreenMyRestaurant = PageFactory.initElements(driver, MainScreenMyRestaurant.class);
        Client.SignInClass signInClassClient = PageFactory.initElements(driver, Client.SignInClass.class);
        MainScreenClass mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);
        RestaurantScreenClass restaurantScreenClass = PageFactory.initElements(driver, RestaurantScreenClass.class);
        RestaurantModalClass restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);

        SignUpAllSteps signUpAllSteps = PageFactory.initElements(driver, SignUpAllSteps.class);
        signUpAllSteps. testCase69();
        driver.close();
        driver.get("url_rest");
        driver.manage().window().maximize();
        signInClassRestaurant.chooseDevice();
        signInClassRestaurant.signInClick(GlobalMethods.getEmail(), GlobalMethods.getPassword());
        mainScreenMyRestaurant.chooseDevice();
        mainScreenMyRestaurant.editRestaurantDetails();
        driver.close();

        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClassClient.chooseDevice();
        signInClassClient.signInClick(GlobalMethods.getPhone(), GlobalMethods.getPassword());
        mainScreenClass.chooseDevice();
        mainScreenClass.getRestaurantsScreen().click();
        restaurantScreenClass.chooseDevice();
        restaurantScreenClass.getNameRestaurant().get(0).click();
        restaurantModalClass.chooseDevice();

        if(comparation(restaurantModalClass.getNameRestaurant().getAttribute("value"),GlobalMethods.getNameRestaurant()))
            return false;
        if(comparation(restaurantModalClass.getCategories().get(0).getAttribute("value"),"Kosher"))
            return false;
        if(!restaurantModalClass.getRestaurantPhotosArea().isDisplayed())
            return false;
        if(!restaurantModalClass.getRestaurantMenuPhotosArea().isDisplayed())
            return false;
        if(!restaurantModalClass.getDescription().getAttribute("value").equals("Edit"))
            return false;
        if(!restaurantModalClass.getRestaurantMenuPhotosArea().isDisplayed())
            return false;
        return true;*/
        return false;
    }

    public boolean testCase112() throws InterruptedException {
        if(getNameRestaurant().size()>0) {
            getNameRestaurant().get(0).click();
        } else{
            return false;
        }
        try {
            RestaurantModalClass restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
            restaurantModalClass.chooseDevice();
            restaurantModalClass.getRateReviewsButton().click();
            Rate_ReviewClass rate_reviewClass = PageFactory.initElements(driver, Rate_ReviewClass.class);
            rate_reviewClass.chooseDevice();
            rate_reviewClass.getCancelButton().click();
            restaurantModalClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }


    public void setRatingRestaurant(List<WebElement> ratingRestaurant) {
        this.ratingRestaurant = ratingRestaurant;
    }

    public List<WebElement> getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(List<WebElement> nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public List<WebElement> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<WebElement> workingHours) {
        this.workingHours = workingHours;
    }

    public List<WebElement> getOrderNowButton() {
        return orderNowButton;
    }

    public void setOrderNowButton(List<WebElement> orderNowButton) {
        this.orderNowButton = orderNowButton;
    }

    public List<WebElement> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<WebElement> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public WebElement getErrorLabelSearch() {
        return errorLabelSearch;
    }

    public void setErrorLabelSearch(WebElement errorLabelSearch) {
        this.errorLabelSearch = errorLabelSearch;
    }
}
