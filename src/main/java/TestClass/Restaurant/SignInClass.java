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
public class SignInClass {

    WebDriver driver;
    WebDriverWait waiting;

    public SignInClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "html/body/div[1]/div/div[3]";
    String pathIOS = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]";
    String pathAndroid = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]";

    private WebElement email;

    private WebElement password;

    private WebElement forgotPassword;

    private WebElement signUpButton;

    private WebElement signInButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,15);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[3]/div[3]/a")));
                setEmail(driver.findElement(By.xpath(pathWeb + "/div[2]/form/input[1]")));
                setPassword(driver.findElement(By.xpath(pathWeb + "/div[2]/form/input[2]")));
                setForgotPassword(driver.findElement(By.xpath(pathWeb + "/div[2]/a")));
                setSignUpButton(driver.findElement(By.xpath(pathWeb + "/div[3]/a")));
                setSignInButton(driver.findElement(By.xpath(pathWeb + "/div[2]/form/input[3]")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
                setEmail(driver.findElement(By.id("email")));
                setPassword(driver.findElement(By.id("password")));
                setForgotPassword(driver.findElement(By.xpath(pathAndroid + "/android.widget.TextView[1]")));
                setSignUpButton(driver.findElement(By.xpath(pathAndroid + "/android.widget.TextView[2]")));
                setSignInButton(driver.findElement(By.id("loginButton")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='Sign in']")));
                setEmail(driver.findElement(By.xpath(pathIOS + "/UIATextField[1]")));
                setPassword(driver.findElement(By.xpath(pathIOS + "/UIASecureTextField[1]")));
                setForgotPassword(driver.findElement(By.xpath("//*[@name='Forgot your password?']")));
                setSignUpButton(driver.findElement(By.xpath("//*[@name='Registration']")));
                setSignInButton(driver.findElement(By.xpath("//*[@name='Sign in']")));
                break;
        }
    }

    public void signInClick(String email,String password){
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getSignInButton().click();
    }

    public void signUpClick(){
        getSignUpButton().click();
    }

    public void forgotPasswordClick(){
        getForgotPassword().click();
    }


    public WebElement getEmail() {
        return email;
    }

    public void setEmail(WebElement email) {
        this.email = email;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getForgotPassword() {
        return forgotPassword;
    }

    public void setForgotPassword(WebElement forgotPassword) {
        this.forgotPassword = forgotPassword;
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
