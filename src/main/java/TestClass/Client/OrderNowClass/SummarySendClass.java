package TestClass.Client.OrderNowClass;

import TestClass.Client.Restaurant.RestaurantModalClass;
import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 10.08.16.
 */
public class SummarySendClass {

    WebDriver driver;
    WebDriverWait waiting;

    public SummarySendClass(WebDriver driver) {
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement saveAsQuickOrderCheckbox;

    private WebElement cancelButton;

    private WebElement submitButton;

    private WebElement editOrder;

    private WebElement editAddress;

    private WebElement editPayment;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setSaveAsQuickOrderCheckbox(driver.findElement(By.xpath(pathWeb + "")));
                setEditAddress(driver.findElement(By.xpath(pathWeb + "")));
                setEditOrder(driver.findElement(By.xpath(pathWeb + "")));
                setEditPayment(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setSaveAsQuickOrderCheckbox(driver.findElement(By.xpath(pathWeb + "")));
                setEditAddress(driver.findElement(By.xpath(pathWeb + "")));
                setEditOrder(driver.findElement(By.xpath(pathWeb + "")));
                setEditPayment(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setSaveAsQuickOrderCheckbox(driver.findElement(By.xpath(pathWeb + "")));
                setEditAddress(driver.findElement(By.xpath(pathWeb + "")));
                setEditOrder(driver.findElement(By.xpath(pathWeb + "")));
                setEditPayment(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public boolean testCase136() throws InterruptedException {
        getEditOrder().click();
        try{
            ChooseOrderClass chooseOrderClass = PageFactory.initElements(driver, ChooseOrderClass.class);
            chooseOrderClass.chooseDevice();
        } catch(TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase137() throws InterruptedException {
        getEditAddress().click();
        try{
            AddAddressClass addAddressClass = PageFactory.initElements(driver, AddAddressClass.class);
            addAddressClass.chooseDevice();
        } catch(TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase138() throws InterruptedException {
        getEditPayment().click();
        try{
            PaymentMethodClass paymentMethodClass = PageFactory.initElements(driver, PaymentMethodClass.class);
            paymentMethodClass.chooseDevice();
        } catch(TimeoutException e){
            return false;
        }
        return true;
    }




    public WebElement getSaveAsQuickOrderCheckbox() {
        return saveAsQuickOrderCheckbox;
    }

    public void setSaveAsQuickOrderCheckbox(WebElement saveAsQuickOrderCheckbox) {
        this.saveAsQuickOrderCheckbox = saveAsQuickOrderCheckbox;
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

    public WebElement getEditOrder() {
        return editOrder;
    }

    public void setEditOrder(WebElement editOrder) {
        this.editOrder = editOrder;
    }

    public WebElement getEditAddress() {
        return editAddress;
    }

    public void setEditAddress(WebElement editAddress) {
        this.editAddress = editAddress;
    }

    public WebElement getEditPayment() {
        return editPayment;
    }

    public void setEditPayment(WebElement editPayment) {
        this.editPayment = editPayment;
    }
}
