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
public class SignInClass {

    WebDriver driver;
    WebDriverWait waiting;

    public SignInClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = ".//*[@id='ModalContainer']/div/div/div[3]";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement login;

    private WebElement password;

    private WebElement forgotPassword;

    private WebElement signUpButton;

    private WebElement signInButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ModalContainer']/div/div/div[3]/input[1]")));
                setLogin(driver.findElement(By.xpath(pathWeb + "/input[1]")));
                setPassword(driver.findElement(By.xpath(pathWeb + "/input[2]")));
                setForgotPassword(driver.findElement(By.xpath(pathWeb + "/div/div[2]/p[2]")));
                setSignUpButton(driver.findElement(By.xpath(pathWeb + "/div/div[2]/p[1]")));
                setSignInButton(driver.findElement(By.xpath(pathWeb + "/div/div[1]/button")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setLogin(driver.findElement(By.xpath(pathWeb + "")));
                setPassword(driver.findElement(By.xpath(pathWeb + "")));
                setForgotPassword(driver.findElement(By.xpath(pathWeb + "")));
                setSignUpButton(driver.findElement(By.xpath(pathWeb + "")));
                setSignInButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setLogin(driver.findElement(By.xpath(pathWeb + "")));
                setPassword(driver.findElement(By.xpath(pathWeb + "")));
                setForgotPassword(driver.findElement(By.xpath(pathWeb + "")));
                setSignUpButton(driver.findElement(By.xpath(pathWeb + "")));
                setSignInButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public boolean signInClick(String login, String password){
        getLogin().sendKeys(login);
        getPassword().sendKeys(password);
        getSignInButton().click();
        try {
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ModalContainer']/div/div/div[3]/p[4]")));
            driver.findElement(By.xpath(".//*[@id='ModalContainer']/div/div/div[3]/p[4]")).isDisplayed();
        }  catch (org.openqa.selenium.TimeoutException e){
            return false;
        }
        return true;
    }

    public void forgotPasswordClick(){
        getForgotPassword().click();
    }

    public void signUpClick(){
        getSignUpButton().click();
    }

    public WebElement getLogin() {
        return login;
    }

    public void setLogin(WebElement login) {
        this.login = login;
    }

    public WebElement getForgotPassword() {
        return forgotPassword;
    }

    public void setForgotPassword(WebElement forgotPassword) {
        this.forgotPassword = forgotPassword;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
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
