package TestClass.Client.OrderNowClass;

import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddPaymentsClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarPaymentsClass;
import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 11.08.16.
 */
public class ChooseCreditCardClass {

    WebDriver driver;
    WebDriverWait waiting;

    public ChooseCreditCardClass(WebDriver driver) {
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement addNewPaymentButton;

    private List<WebElement> creditCardElementList;

    private WebElement cancelButton;

    private WebElement okButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setAddNewPaymentButton(driver.findElement(By.xpath(pathWeb + "")));
                setCreditCardElementList(driver.findElements(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setOkButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setAddNewPaymentButton(driver.findElement(By.xpath(pathWeb + "")));
                setCreditCardElementList(driver.findElements(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setOkButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setAddNewPaymentButton(driver.findElement(By.xpath(pathWeb + "")));
                setCreditCardElementList(driver.findElements(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setOkButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public boolean testCase145() throws InterruptedException {
        getAddNewPaymentButton().click();
        try{
            MainScreenSidebarAddPaymentsClass mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarAddPaymentsClass.class);
            mainScreenSidebarAddPaymentsClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase148() throws InterruptedException {
        getCancelButton().click();
        try{
            PaymentMethodClass paymentMethodClass = PageFactory.initElements(driver, PaymentMethodClass.class);
            paymentMethodClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase149() throws InterruptedException {
        getCreditCardElementList().get(0).click();
        getOkButton().click();
        try{
            SummarySendClass summarySendClass = PageFactory.initElements(driver, SummarySendClass.class);
            summarySendClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }



    public WebElement getAddNewPaymentButton() {
        return addNewPaymentButton;
    }

    public void setAddNewPaymentButton(WebElement addNewPaymentButton) {
        this.addNewPaymentButton = addNewPaymentButton;
    }

    public List<WebElement> getCreditCardElementList() {
        return creditCardElementList;
    }

    public void setCreditCardElementList(List<WebElement> creditCardElementList) {
        this.creditCardElementList = creditCardElementList;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(WebElement cancelButton) {
        this.cancelButton = cancelButton;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public void setOkButton(WebElement okButton) {
        this.okButton = okButton;
    }
}
