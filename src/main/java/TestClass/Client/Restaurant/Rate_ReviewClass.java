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
public class Rate_ReviewClass {

    WebDriver driver;
    WebDriverWait waiting;

    public Rate_ReviewClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement rating;

    private WebElement typeReview;

    private WebElement errorLabel;

    private WebElement cancelButton;

    private WebElement submitButton;


    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setRating(driver.findElement(By.xpath(pathWeb + "")));
                setTypeReview(driver.findElement(By.xpath(pathWeb + "")));
                //setErrorLabel(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }






    public WebElement getRating() {
        return rating;
    }

    public void setRating(WebElement rating) {
        this.rating = rating;
    }

    public WebElement getTypeReview() {
        return typeReview;
    }

    public void setTypeReview(WebElement typeReview) {
        this.typeReview = typeReview;
    }

    public WebElement getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(WebElement errorLabel) {
        this.errorLabel = errorLabel;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(WebElement cancelButton) {
        this.cancelButton = cancelButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }
}
