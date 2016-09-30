package TestClass.Restaurant;

import TestClass.GlobalMethods.GlobalMethods;
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

    String pathWeb = "html/body/div[1]/div/div[3]/div[2]";
    String pathAndroid = "";
    String pathIOS = "//UIAApplication[1]/UIAWindow[1]";

    private WebElement email;

    private WebElement signInButton;

    private WebElement submitButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[3]/div[2]/a")));
                setEmail(driver.findElement(By.xpath(pathWeb + "/form/input[1]")));
                setSignInButton(driver.findElement(By.xpath(pathWeb + "/a")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "/form/input[2]")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
                setEmail(driver.findElement(By.id("email")));
                setSubmitButton(driver.findElement(By.id("restoreButton")));
                setSignInButton(null);
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setEmail(driver.findElement(By.xpath(pathIOS + "/UIATextField[1]")));
                setSignInButton(driver.findElement(By.xpath(pathIOS + "/UIANavigationBar[1]/UIAButton[2]")));
                setSubmitButton(driver.findElement(By.name(pathIOS + "Restore password")));
                break;
        }
    }

    public void submitButtonClick(String email){
        getEmail().sendKeys(email);
        getSubmitButton().click();
    }

    public void signInClick(){
        getSignInButton().click();
    }

    public WebElement  getEmail() {
        return email;
    }

    public void setEmail(WebElement email) {
        this.email = email;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(WebElement signInButton) {
        this.signInButton = signInButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }
}
