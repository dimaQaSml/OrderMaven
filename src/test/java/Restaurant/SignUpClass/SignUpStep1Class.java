package Restaurant.SignUpClass;

import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 12.05.16.
 */
public class SignUpStep1Class {

    WebDriver driver;
    WebDriverWait waiting;

    public SignUpStep1Class(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "html/body/div[1]/div/div[3]/div[3]/form";
    String pathAndroid = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]" +
            "/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.ScrollView[1]" +
            "/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]";
    String pathIOS = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]";

    private WebElement logoMobile;

    private WebElement name;

    private WebElement email;

    private WebElement password;

    private WebElement confirmPassword;

    private WebElement signUpButton;

    private WebElement backMobile;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,40);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[3]/div[3]/form/input[1]")));
                setName(driver.findElement(By.xpath(pathWeb + "/input[1]")));
                setEmail(driver.findElement(By.xpath(pathWeb + "/input[2]")));
                setPassword(driver.findElement(By.xpath(pathWeb + "/input[3]")));
                setConfirmPassword(driver.findElement(By.xpath(pathWeb + "/input[4]")));
                setSignUpButton(driver.findElement(By.xpath(pathWeb + "/div[8]/input")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
                setLogoMobile(driver.findElement(By.xpath(pathAndroid + "/android.widget.ImageButton[1]")));
                setName(driver.findElement(By.id("name")));
                setEmail(driver.findElement(By.id("email")));
                setPassword(driver.findElement(By.id("password")));
                setConfirmPassword(driver.findElement(By.id("confirmPassword")));
                setSignUpButton(driver.findElement(By.id("nextButton")));
                setBackMobile(driver.findElement(By.id("backButton")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathIOS + "/UIAButton[1]")));
                setName(driver.findElement(By.xpath(pathIOS + "/UIATextField[1]")));
                setEmail(driver.findElement(By.xpath(pathIOS + "/UIATextField[2]")));
                setPassword(driver.findElement(By.xpath(pathIOS + "/UIASecureTextField[1]")));
                setConfirmPassword(driver.findElement(By.xpath(pathIOS + "/UIASecureTextField[2]")));
                setSignUpButton(driver.findElement(By.xpath(pathIOS + "/UIAButton[1]")));
                setBackMobile(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")));
                break;
        }
    }


    public void signUpClick(String name,String email,String password, String confirmPassword){
        getEmail().sendKeys(email);
        getName().sendKeys(name);
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(confirmPassword);
        getSignUpButton().click();
    }



    public WebElement getName() {
        return name;
    }

    public void setName(WebElement name) {
        this.name = name;
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

    public WebElement getBackMobile() {
        return backMobile;
    }

    public void setBackMobile(WebElement backMobile) {
        this.backMobile = backMobile;
    }

    public WebElement getLogoMobile() {
        return logoMobile;
    }

    public void setLogoMobile(WebElement logoMobile) {
        this.logoMobile = logoMobile;
    }
}
