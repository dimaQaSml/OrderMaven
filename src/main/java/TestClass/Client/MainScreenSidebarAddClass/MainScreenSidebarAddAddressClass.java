package TestClass.Client.MainScreenSidebarAddClass;

import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import TestClass.GlobalMethods.GlobalMethods;
//import TestsClient.MainScreenSidebarTest.MainScreenSidebarAddressTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 03.06.16.
 */
public class  MainScreenSidebarAddAddressClass {

    WebDriver driver;
    WebDriverWait waiting;

    public MainScreenSidebarAddAddressClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = ".//*[@id='ModalContainer']/div/div/div[3]";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement city;

    private WebElement address;

    private WebElement name;

    private WebElement getLocationButton;

    private WebElement cancelButton;

    private WebElement submitButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ModalContainer']/div/div/div[2]/p")));
                setAddress(driver.findElement(By.xpath(pathWeb + "/div[2]/input")));
                setCity(driver.findElement(By.xpath(pathWeb + "/div[1]/input")));
                setName(driver.findElement(By.xpath(pathWeb + "/input")));
                setGetLocationButton(driver.findElement(By.xpath(pathWeb + "/div[3]/p")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "/div[4]/button[1]")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "/div[4]/button[2]")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setAddress(driver.findElement(By.xpath(pathWeb + "")));
                setCity(driver.findElement(By.xpath(pathWeb + "")));
                setName(driver.findElement(By.xpath(pathWeb + "")));
                setGetLocationButton(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setAddress(driver.findElement(By.xpath(pathWeb + "")));
                setCity(driver.findElement(By.xpath(pathWeb + "")));
                setName(driver.findElement(By.xpath(pathWeb + "")));
                setGetLocationButton(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public void addAddress( String city, String street, String name){
        getCity().sendKeys(city);
        getAddress().sendKeys(street);
        getName().sendKeys(name);
        getSubmitButton().click();
    }

    public void editAddress( String city, String street, String home){
        while(!getCity().getAttribute("value").isEmpty()){
            getCity().sendKeys(Keys.BACK_SPACE);
        }
        while(!getAddress().getAttribute("value").isEmpty()){
            getAddress().sendKeys(Keys.BACK_SPACE);
        }
        while(!getName().getAttribute("value").isEmpty()){
            getName().sendKeys(Keys.BACK_SPACE);
        }
        getCity().sendKeys(city);
        getAddress().sendKeys(street);
        getName().sendKeys(home);
    }

    public void cancelClick(){
        getCancelButton().click();
    }

    /*public boolean countryValidation() throws InterruptedException {
        getCity().sendKeys("TestCity");
        getStreet().sendKeys("testStreet");
        getNumber().sendKeys("testNumber");
        boolean result = GlobalMethods.validationCountry(getCountry());
        return result;
    }*/

    public boolean getLocation() throws InterruptedException {
        getGetLocationButton().click();
        Thread.sleep(700);
        if(getCity().getAttribute("value").isEmpty() && getAddress().getAttribute("value").isEmpty() && getName().getAttribute("value").isEmpty()){
            return false;
        } else{
            return true;
        }
    }

    public boolean testCase42(){
        getGetLocationButton().click();
        if(!getCity().equals("") && !getAddress().equals("") && !getName().equals("")){
            return true;
        } else{
            return false;
        }
    }

    public boolean testCase76() throws InterruptedException {
        addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getName());
        MainScreenSidebarAddressClass mainScreenSidebarAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddressClass.class);
        mainScreenSidebarAddressClass.chooseDevice();
        //Переходим на страницу редактирования созданного адреса
        mainScreenSidebarAddressClass.getEditAddressButton().get(0).click();
        editAddress(GlobalMethods.getCityEdit(), GlobalMethods.getAddressEdit(), GlobalMethods.getHomeEdit());
        getCancelButton().click();
        //
        mainScreenSidebarAddressClass.getEditAddressButton().get(0).click();
        if(getCity().equals(GlobalMethods.getCityEdit()) || getAddress().equals(GlobalMethods.getAddressEdit()) || getName().equals(GlobalMethods.getHomeEdit())){
            return false;
        } else {
            return true;
        }
    }

    public boolean testCase63() throws InterruptedException {
        addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getName());
        MainScreenSidebarAddressClass mainScreenSidebarAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddressClass.class);
        mainScreenSidebarAddressClass.chooseDevice();
        //Переходим на страницу редактирования созданного адреса
        mainScreenSidebarAddressClass.getEditAddressButton().get(0).click();
        editAddress(GlobalMethods.getCityEdit(), GlobalMethods.getAddressEdit(), GlobalMethods.getHomeEdit());
        getSubmitButton().click();
        //TODO уточнить и доделать сравнение!
        if(mainScreenSidebarAddressClass.getAddressList().get(0).getAttribute("value").equals(GlobalMethods.getCityEdit())){
            return true;
        } else {
            return false;
        }
    }

    public boolean testCase85() throws InterruptedException {
        addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getName());
        MainScreenSidebarAddressClass mainScreenSidebarAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddressClass.class);
        mainScreenSidebarAddressClass.chooseDevice();
        //Переходим на страницу редактирования созданного адреса
        mainScreenSidebarAddressClass.getEditAddressButton().get(0).click();
        editAddress(GlobalMethods.getCityEdit(), GlobalMethods.getAddressEdit(), GlobalMethods.getHomeEdit());
        getCancelButton().click();
        //
        mainScreenSidebarAddressClass.getEditAddressButton().get(0).click();
        //TODO уточнить и доделать сравнение!
        if(mainScreenSidebarAddressClass.getAddressLabel().get(0).getAttribute("value").equals(GlobalMethods.getCityEdit())){
            return false;
        } else {
            return true;
        }
    }

    public WebElement getName() {
        return name;
    }

    public void setName(WebElement name) {
        this.name = name;
    }

    public WebElement getCity() {
        return city;
    }

    public void setCity(WebElement city) {
        this.city = city;
    }

    public WebElement getAddress() {
        return address;
    }

    public void setAddress(WebElement address) {
        this.address = address;
    }

    public WebElement getGetLocationButton() {
        return getLocationButton;
    }

    public void setGetLocationButton(WebElement getLocationButton) {
        this.getLocationButton = getLocationButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(WebElement cancelButton) {
        this.cancelButton = cancelButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }
}
