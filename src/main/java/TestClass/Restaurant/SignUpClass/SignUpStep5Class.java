package TestClass.Restaurant.SignUpClass;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 31.05.16.
 */
public class SignUpStep5Class {

    WebDriver driver;
    WebDriverWait waiting;

    public SignUpStep5Class(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "html/body/div[1]/div/div[7]/div[3]/div[2]";
    String pathIOS = "";

    private WebElement signUpButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,15);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("goLogin")));
                setSignUpButton(driver.findElement(By.id("goLogin")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathIOS + "")));
                setSignUpButton(driver.findElement(By.xpath(pathIOS + "")));
                break;
        }
    }

    public void signUpClick(){
        getSignUpButton().click();
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(WebElement signUpButton) {
        this.signUpButton = signUpButton;
    }
}
