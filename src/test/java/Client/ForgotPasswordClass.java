package Client;

import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 12.05.16.
 */
public class ForgotPasswordClass {

    WebDriver driver;
    WebDriverWait waiting;

    public ForgotPasswordClass(WebDriver driver){
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

    private WebElement cancel;

    private WebElement submitButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ModalContainer']/div/div/div[3]/div[1]/div[1]/div[1]/input")));
                setCountryField(driver.findElement(By.xpath(pathWeb + "/div[1]/div[1]/div[1]/input")));
                setCountrySelectButton(driver.findElement(By.xpath(pathWeb + "/div[1]/div[1]/div[2]")));
                setCountryList(driver.findElement(By.xpath(pathWeb + "/div[1]/div[2]")));
                setCountryListRussia(driver.findElement(By.xpath(pathWeb + "/div[1]/div[2]/div/div[182]/div[1]")));
                setPhone(driver.findElement(By.xpath(pathWeb + "/input")));
                setCancel(driver.findElement(By.xpath(pathWeb + "/div[2]/button[1]")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "/div[2]/button[2]")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCountryField(driver.findElement(By.xpath(pathWeb + "")));
                setCountrySelectButton(driver.findElement(By.xpath(pathWeb + "")));
                setCountryList(driver.findElement(By.xpath(pathWeb + "")));
                setCountryListRussia(driver.findElement(By.xpath(pathWeb + "")));
                setPhone(driver.findElement(By.xpath(pathWeb + "")));
                setCancel(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCountryField(driver.findElement(By.xpath(pathWeb + "")));
                setCountrySelectButton(driver.findElement(By.xpath(pathWeb + "")));
                setCountryList(driver.findElement(By.xpath(pathWeb + "")));
                setCountryListRussia(driver.findElement(By.xpath(pathWeb + "")));
                setPhone(driver.findElement(By.xpath(pathWeb + "")));
                setCancel(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public WebDriver submitButtonClick(String country, String phone){
        getCountryField().sendKeys(country);
        getPhone().sendKeys(phone);
        if(!getCountryField().equals("") && !getPhone().equals("")){
            waiting.until(ExpectedConditions.elementToBeClickable(getSubmitButton()));
        }
        getSubmitButton().click();
        return driver;
    }

    public void cancelClick(){
        getCancel().click();
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

    public WebElement getCountryList() {
        return countryList;
    }

    public void setCountryList(WebElement countryList) {
        this.countryList = countryList;
    }

    public WebElement getCountryListRussia() {
        return countryListRussia;
    }

    public void setCountryListRussia(WebElement countryListRussia) {
        this.countryListRussia = countryListRussia;
    }

    public WebElement getPhone() {
        return phone;
    }

    public void setPhone(WebElement phone) {
        this.phone = phone;
    }

    public WebElement getCancel() {
        return cancel;
    }

    public void setCancel(WebElement cancel) {
        this.cancel = cancel;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }
}
