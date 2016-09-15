package Client.MainScreenSidebarAddClass;

import Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import Client.MainScreenSidebarClass.MainScreenSidebarPaymentsClass;
import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 03.06.16.
 */
public class MainScreenSidebarAddPaymentsClass {

    WebDriver driver;
    WebDriverWait waiting;

    MainScreenSidebarAddPaymentsClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";


    private WebElement cardDateMonth;

    private WebElement cardDateYear;

    private WebElement cardNumber1;

    private WebElement cardNumber2;

    private WebElement cardNumber3;

    private WebElement cardNumber4;

    private WebElement cardCvv;

    private WebElement cancelButton;

    private WebElement submitButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCardNumber1(driver.findElement(By.xpath(pathWeb + "")));
                setCardNumber2(driver.findElement(By.xpath(pathWeb + "")));
                setCardNumber3(driver.findElement(By.xpath(pathWeb + "")));
                setCardNumber4(driver.findElement(By.xpath(pathWeb + "")));
                setCardCvv(driver.findElement(By.xpath(pathWeb + "")));
                setCardDateMonth(driver.findElement(By.xpath(pathWeb + "")));
                setCardDateYear(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCardNumber1(driver.findElement(By.xpath(pathWeb + "")));
                setCardNumber2(driver.findElement(By.xpath(pathWeb + "")));
                setCardNumber3(driver.findElement(By.xpath(pathWeb + "")));
                setCardNumber4(driver.findElement(By.xpath(pathWeb + "")));
                setCardCvv(driver.findElement(By.xpath(pathWeb + "")));
                setCardDateMonth(driver.findElement(By.xpath(pathWeb + "")));
                setCardDateYear(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCardNumber1(driver.findElement(By.xpath(pathWeb + "")));
                setCardNumber2(driver.findElement(By.xpath(pathWeb + "")));
                setCardNumber3(driver.findElement(By.xpath(pathWeb + "")));
                setCardNumber4(driver.findElement(By.xpath(pathWeb + "")));
                setCardCvv(driver.findElement(By.xpath(pathWeb + "")));
                setCardDateMonth(driver.findElement(By.xpath(pathWeb + "")));
                setCardDateYear(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;

        }
    }

    public void addPayment(String number1, String number2, String dateMonth, String dateYear, String cvv){
        getCardNumber1().sendKeys(number1);
        getCardNumber2().sendKeys(number2);
        getCardNumber3().sendKeys(number2);
        getCardNumber4().sendKeys(number2);
        getCardDateMonth().sendKeys(dateMonth);
        getCardDateYear().sendKeys(dateYear);
        getCardCvv().sendKeys(cvv);
        getSubmitButton().click();
    }
    public void editPayment(String number1, String number2, String dateMonth, String dateYear, String cvv){
        while(!getCardNumber1().getAttribute("value").isEmpty()){
            getCardNumber1().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCardNumber2().getAttribute("value").isEmpty()){
            getCardNumber2().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCardNumber3().getAttribute("value").isEmpty()){
            getCardNumber3().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCardNumber4().getAttribute("value").isEmpty()){
            getCardNumber4().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCardDateMonth().getAttribute("value").isEmpty()){
            getCardDateMonth().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCardDateYear().getAttribute("value").isEmpty()){
            getCardDateYear().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCardCvv().getAttribute("value").isEmpty()){
            getCardCvv().sendKeys(Keys.BACK_SPACE);
        }
        getCardNumber1().sendKeys(number1);
        getCardNumber2().sendKeys(number2);
        getCardNumber3().sendKeys(number2);
        getCardNumber4().sendKeys(number2);
        getCardDateMonth().sendKeys(dateMonth);
        getCardDateYear().sendKeys(dateYear);
        getCardCvv().sendKeys(cvv);
    }

    public boolean testCase64() throws InterruptedException {
        MainScreenSidebarPaymentsClass mainScreenSidebarPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarPaymentsClass.class);
        List<WebElement> before = mainScreenSidebarPaymentsClass.countPaymentsElementsBefore();
        addPayment(GlobalMethods.getNumberCard1(), GlobalMethods.getNumberCard2(), GlobalMethods.getDateCardMonth(), GlobalMethods.getDateCardYear(), GlobalMethods.getCvvCard());
        if(mainScreenSidebarPaymentsClass.checkAddPayment(before)){
            int lengthCardNumber = mainScreenSidebarPaymentsClass.getPayments().get(0).getAttribute("value").length();
            String number4 = mainScreenSidebarPaymentsClass.getPayments().get(0).getAttribute("value").substring(lengthCardNumber-4, lengthCardNumber);
            if(number4.equals(GlobalMethods.getNumberCard2())){
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }


    public WebElement getCardDateMonth() {
        return cardDateMonth;
    }

    public void setCardDateMonth(WebElement cardDateMonth) {
        this.cardDateMonth = cardDateMonth;
    }

    public WebElement getCardDateYear() {
        return cardDateYear;
    }

    public void setCardDateYear(WebElement cardDateYear) {
        this.cardDateYear = cardDateYear;
    }

    public WebElement getCardNumber1() {
        return cardNumber1;
    }

    public void setCardNumber1(WebElement cardNumber1) {
        this.cardNumber1 = cardNumber1;
    }

    public WebElement getCardNumber2() {
        return cardNumber2;
    }

    public void setCardNumber2(WebElement cardNumber2) {
        this.cardNumber2 = cardNumber2;
    }

    public WebElement getCardNumber3() {
        return cardNumber3;
    }

    public void setCardNumber3(WebElement cardNumber3) {
        this.cardNumber3 = cardNumber3;
    }

    public WebElement getCardNumber4() {
        return cardNumber4;
    }

    public void setCardNumber4(WebElement cardNumber4) {
        this.cardNumber4 = cardNumber4;
    }

    public WebElement getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(WebElement cardCvv) {
        this.cardCvv = cardCvv;
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
