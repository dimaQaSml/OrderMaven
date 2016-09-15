package Restaurant;

import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 24.05.16.
 */
public class StartPageClassMobile {

    WebDriver driver;
    WebDriverWait waiting;

    String pathAndroid = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]";

    public StartPageClassMobile(WebDriver driver){
        this.driver = driver;
    }

    private WebElement signUpButton;

    private WebElement signInButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,40);
        switch (GlobalMethods.chooseDevice()) {
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathAndroid + "/android.widget.Button[2]")));
                setSignUpButton(driver.findElement(By.xpath(pathAndroid + "/android.widget.Button[2]")));
                setSignInButton(driver.findElement(By.xpath(pathAndroid + "/android.widget.TextView[1]")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='Sign up']")));
                setSignUpButton(driver.findElement(By.xpath("//*[@name='Sign up']")));
                break;
        }
    }

    public void signUpClick(){
        getSignUpButton().click();
    }
    public void signInClick(){
        getSignInButton().click();
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
