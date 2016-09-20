package Client.OrderNowClass;

import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 11.08.16.
 */
public class DeliveriesClass {

    WebDriver driver;
    WebDriverWait waiting;

    public DeliveriesClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement noButton;

    private WebElement yesButton;


    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setNoButton(driver.findElement(By.xpath(pathWeb + "")));
                setYesButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setNoButton(driver.findElement(By.xpath(pathWeb + "")));
                setYesButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setNoButton(driver.findElement(By.xpath(pathWeb + "")));
                setYesButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }


    public WebElement getNoButton() {
        return noButton;
    }

    public void setNoButton(WebElement noButton) {
        this.noButton = noButton;
    }

    public WebElement getYesButton() {
        return yesButton;
    }

    public void setYesButton(WebElement yesButton) {
        this.yesButton = yesButton;
    }
}
