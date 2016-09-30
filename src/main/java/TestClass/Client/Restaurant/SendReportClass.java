package TestClass.Client.Restaurant;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 04.08.16.
 */
public class SendReportClass {

    WebDriver driver;
    WebDriverWait waiting;

    public SendReportClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement fullName;

    private WebElement errorLabelFullName;

    private WebElement description;

    private WebElement errorLabelDescription;

    private WebElement sendButton;

    private WebElement cancelButton;


    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setFullName(driver.findElement(By.xpath(pathWeb + "")));
                setDescription(driver.findElement(By.xpath(pathWeb + "")));
                setSendButton(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }






    public WebElement getFullName() {
        return fullName;
    }

    public void setFullName(WebElement fullName) {
        this.fullName = fullName;
    }

    public WebElement getErrorLabelFullName() {
        return errorLabelFullName;
    }

    public void setErrorLabelFullName(WebElement errorLabelFullName) {
        this.errorLabelFullName = errorLabelFullName;
    }

    public WebElement getDescription() {
        return description;
    }

    public void setDescription(WebElement description) {
        this.description = description;
    }

    public WebElement getErrorLabelDescription() {
        return errorLabelDescription;
    }

    public void setErrorLabelDescription(WebElement errorLabelDescription) {
        this.errorLabelDescription = errorLabelDescription;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public void setSendButton(WebElement sendButton) {
        this.sendButton = sendButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(WebElement cancelButton) {
        this.cancelButton = cancelButton;
    }
}
