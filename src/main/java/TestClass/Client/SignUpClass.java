package TestClass.Client;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 12.05.16.
 */
public class SignUpClass {

    WebDriver driver;
    WebDriverWait waiting;

    public SignUpClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = ".//*[@id='ModalContainer']/div/div/div[3]";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement countryField;

    private WebElement countrySelectButton;

    private WebElement countryList;

    private WebElement countryListRussia;

    private WebElement phone;

    private WebElement password;

    private WebElement confirmPassword;

    private WebElement signUpButton;

    private WebElement signInButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,40);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ModalContainer']/div/div/div[3]/div[1]/div[1]/div[1]/input")));
                setCountryField(driver.findElement(By.xpath(pathWeb + "/div[1]/div[1]/div[1]/input")));
                setCountrySelectButton(driver.findElement(By.xpath(pathWeb + "/div[1]/div[1]/div[2]")));
                setCountryList(driver.findElement(By.xpath(pathWeb + "/div[1]/div[2]")));
                //Указано конкретное значение страны(Russia) потому что список сделан не Select'ом а просто div'ами
                setCountryListRussia(driver.findElement(By.xpath(pathWeb + "/div[1]/div[2]/div/div[182]/div[1]")));
                setPhone(driver.findElement(By.xpath(pathWeb + "/input[1]")));
                setPassword(driver.findElement(By.xpath(pathWeb + "/input[2]")));
                setConfirmPassword(driver.findElement(By.xpath(pathWeb + "/input[3]")));
                setSignUpButton(driver.findElement(By.xpath(pathWeb + "/div[2]/div[1]/button")));
                setSignInButton(driver.findElement(By.xpath(pathWeb + "/div[2]/div[2]/p")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCountryField(driver.findElement(By.xpath(pathWeb + "")));
                setCountrySelectButton(driver.findElement(By.xpath(pathWeb + "")));
                setCountryList(driver.findElement(By.xpath(pathWeb + "")));
                //Указано конкретное значение страны(Russia) потому что список сделан не Select'ом а просто div'ами
                setCountryListRussia(driver.findElement(By.xpath(pathWeb + "")));
                setPhone(driver.findElement(By.xpath(pathWeb + "")));
                setPassword(driver.findElement(By.xpath(pathWeb + "")));
                setConfirmPassword(driver.findElement(By.xpath(pathWeb + "")));
                setSignUpButton(driver.findElement(By.xpath(pathWeb + "")));
                setSignInButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCountryField(driver.findElement(By.xpath(pathWeb + "")));
                setCountrySelectButton(driver.findElement(By.xpath(pathWeb + "")));
                setCountryList(driver.findElement(By.xpath(pathWeb + "")));
                //Указано конкретное значение страны(Russia) потому что список сделан не Select'ом а просто div'ами
                setCountryListRussia(driver.findElement(By.xpath(pathWeb + "")));
                setPhone(driver.findElement(By.xpath(pathWeb + "")));
                setPassword(driver.findElement(By.xpath(pathWeb + "")));
                setConfirmPassword(driver.findElement(By.xpath(pathWeb + "")));
                setSignUpButton(driver.findElement(By.xpath(pathWeb + "")));
                setSignInButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }


    public WebDriver signUpClick(String country,String phone,String password, String confirmPassword){
        getCountryField().sendKeys(country);
        getPhone().sendKeys(phone);
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirmPassword);
        getSignUpButton().click();
        return driver;
    }

    public void signInClick(String country,String phone,String password, String confirmPassword){
        getSignInButton().click();
    }


    public WebElement getCountryField() {
        return countryField;
    }

    public void setCountryField(WebElement countryField) {
        this.countryField = countryField;
    }

    public WebElement getCountrySelectButton() {
        return countrySelectButton;
    }

    public void setCountrySelectButton(WebElement countrySelectButton) {
        this.countrySelectButton = countrySelectButton;
    }

    public WebElement getPhone() {
        return phone;
    }

    public void setPhone(WebElement phone) {
        this.phone = phone;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(WebElement confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(WebElement signUpButton) {
        this.signUpButton = signUpButton;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(WebElement signInButton) {
        this.signInButton = signInButton;
    }

    public WebElement getCountryListRussia() {
        return countryList;
    }

    public void setCountryListRussia(WebElement countryList) {
        this.countryList = countryList;
    }

    public WebElement getCountryList() {
        return countryList;
    }

    public void setCountryList(WebElement countryList) {
        this.countryList = countryList;
    }
}
