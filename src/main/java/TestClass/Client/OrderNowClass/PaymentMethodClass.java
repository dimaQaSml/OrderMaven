package TestClass.Client.OrderNowClass;

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
public class PaymentMethodClass {

    WebDriver driver;
    WebDriverWait waiting;

    public PaymentMethodClass(WebDriver driver) {
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement cashMethod;

    private WebElement creditCardMethod;

    private WebElement cancelButton;

    private WebElement submitButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCashMethod(driver.findElement(By.xpath(pathWeb + "")));
                setCreditCardMethod(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCashMethod(driver.findElement(By.xpath(pathWeb + "")));
                setCreditCardMethod(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCashMethod(driver.findElement(By.xpath(pathWeb + "")));
                setCreditCardMethod(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }


    public boolean testCase131() throws InterruptedException {
        ChooseOrderClass chooseOrderClass = PageFactory.initElements(driver, ChooseOrderClass.class);
        chooseOrderClass.chooseDevice();
        chooseOrderClass.getTypeNewOrder().sendKeys(GlobalMethods.getOrder());
        chooseOrderClass.getSubmitButton().click();
        AddAddressClass addAddressClass = PageFactory.initElements(driver, AddAddressClass.class);
        addAddressClass.chooseDevice();
        addAddressClass.getChooseAddressSelect().click();
        addAddressClass.getGetChooseAddressElementsList().get(0).click();
        getCashMethod().click();
        try {
            SummarySendClass summarySendClass = PageFactory.initElements(driver, SummarySendClass.class);
            summarySendClass.chooseDevice();
        } catch(TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean testCase132() throws InterruptedException {
        ChooseOrderClass chooseOrderClass = PageFactory.initElements(driver, ChooseOrderClass.class);
        chooseOrderClass.chooseDevice();
        chooseOrderClass.getTypeNewOrder().sendKeys(GlobalMethods.getOrder());
        chooseOrderClass.getSubmitButton().click();
        AddAddressClass addAddressClass = PageFactory.initElements(driver, AddAddressClass.class);
        addAddressClass.chooseDevice();
        addAddressClass.getChooseAddressSelect().click();
        addAddressClass.getGetChooseAddressElementsList().get(0).click();
        getCreditCardMethod().click();
        try {
            ChooseCreditCardClass chooseCreditCardClass = PageFactory.initElements(driver, ChooseCreditCardClass.class);
            chooseCreditCardClass.chooseDevice();
        } catch(TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean testCase133() throws InterruptedException {
        getCancelButton().click();
        try{
            AddAddressClass addAddressClass = PageFactory.initElements(driver, AddAddressClass.class);
            addAddressClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public WebElement getCashMethod() {
        return cashMethod;
    }

    public void setCashMethod(WebElement cashMethod) {
        this.cashMethod = cashMethod;
    }

    public WebElement getCreditCardMethod() {
        return creditCardMethod;
    }

    public void setCreditCardMethod(WebElement creditCardMethod) {
        this.creditCardMethod = creditCardMethod;
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
