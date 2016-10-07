package TestClass.Client;

import TestClass.GlobalMethods.GlobalMethods;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 06.10.16.
 */
public class AuthorizationClass {

    WebDriver driverBrowser;
    WebDriverWait waiting;

    public AuthorizationClass(WebDriver driverBrowser){
        this.driverBrowser = driverBrowser;
    }

    String pathWeb = ".//*[@id='ModalContainer']/div/div/div/div[2]";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement qrCode;

    private WebElement signUpButton;

    private WebElement signInButton;


    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driverBrowser, 40);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathWeb)));
                setSignUpButton(driverBrowser.findElement(By.xpath(pathWeb + "/button")));
                setSignInButton(driverBrowser.findElement(By.xpath(pathWeb + "/div[2]")));
                break;
        }
    }

    public WebElement getQrCode() {
        return qrCode;
    }

    public void setQrCode(WebElement qrCode) {
        this.qrCode = qrCode;
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
}

