package TestClass.Client.MainScreenSidebarAddClass;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 07.06.16.
 */
public class MainScreenSidebarAddQuickOrderClass {

    WebDriver driver;
    WebDriverWait waiting;

    public MainScreenSidebarAddQuickOrderClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement favoriteOrder;

    private WebElement address;

    private WebElement payment;

    private WebElement favoriteOrderSelect;

    private WebElement addressSelect;

    private WebElement paymentSelect;

    private List<WebElement> favoriteOrderElementsList;

    private List<WebElement> addressElementsList;

    private List<WebElement> paymentElementsList;

    private WebElement addNewFavoriteOrderButton;

    private WebElement addNewAddressButton;

    private WebElement addNewPaymentButton;

    private WebElement submitButton;

    private WebElement cancelButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setFavoriteOrder(driver.findElement(By.xpath(pathWeb + "")));
                setAddress(driver.findElement(By.xpath(pathWeb + "")));
                setPayment(driver.findElement(By.xpath(pathWeb + "")));
                setFavoriteOrderSelect(driver.findElement(By.xpath(pathWeb + "")));
                setAddressSelect(driver.findElement(By.xpath(pathWeb + "")));
                setPaymentSelect(driver.findElement(By.xpath(pathWeb + "")));
                setAddNewFavoriteOrderButton(driver.findElement(By.xpath(pathWeb + "")));
                setAddNewAddressButton(driver.findElement(By.xpath(pathWeb + "")));
                setAddNewPaymentButton(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setFavoriteOrder(driver.findElement(By.xpath(pathWeb + "")));
                setAddress(driver.findElement(By.xpath(pathWeb + "")));
                setPayment(driver.findElement(By.xpath(pathWeb + "")));
                setFavoriteOrderSelect(driver.findElement(By.xpath(pathWeb + "")));
                setAddressSelect(driver.findElement(By.xpath(pathWeb + "")));
                setPaymentSelect(driver.findElement(By.xpath(pathWeb + "")));
                setAddNewFavoriteOrderButton(driver.findElement(By.xpath(pathWeb + "")));
                setAddNewAddressButton(driver.findElement(By.xpath(pathWeb + "")));
                setAddNewPaymentButton(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setFavoriteOrder(driver.findElement(By.xpath(pathWeb + "")));
                setAddress(driver.findElement(By.xpath(pathWeb + "")));
                setPayment(driver.findElement(By.xpath(pathWeb + "")));
                setFavoriteOrderSelect(driver.findElement(By.xpath(pathWeb + "")));
                setAddressSelect(driver.findElement(By.xpath(pathWeb + "")));
                setPaymentSelect(driver.findElement(By.xpath(pathWeb + "")));
                setAddNewFavoriteOrderButton(driver.findElement(By.xpath(pathWeb + "")));
                setAddNewAddressButton(driver.findElement(By.xpath(pathWeb + "")));
                setAddNewPaymentButton(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }


    public void addQuickOrder(String favoriteOrder, String address, String payment){
        getFavoriteOrder().sendKeys(favoriteOrder);
        getAddress().sendKeys(address);
        getPayment().sendKeys(payment);
        getSubmitButton().click();
    }

    public void addQuickOrderSelectValue() throws InterruptedException {
        //Добавляем FavoriteOrder из списка
        getFavoriteOrderSelect().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setFavoriteOrderElementsList(driver.findElements(By.xpath(pathWeb + "")));
        if(getFavoriteOrderElementsList().size() <= 1){
            getFavoriteOrderElementsList().get(0).click();
            MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarAddOrderClass.chooseDevice();
            mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(),GlobalMethods.getOrder());
        } else {
            getFavoriteOrderElementsList().get(1).click();
        }

        //Добавляем Address из списка
        getAddressSelect().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setAddressElementsList(driver.findElements(By.xpath(pathWeb + "")));
        if(getAddressElementsList().size() <= 1){
            getAddressElementsList().get(0).click();
            MainScreenSidebarAddAddressClass mainScreenSidebarAddAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddAddressClass.class);
            mainScreenSidebarAddAddressClass.chooseDevice();
            mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCity(),GlobalMethods.getAddress(),GlobalMethods.getName());
        } else {
            getAddressElementsList().get(1).click();
        }

        //Добавляем Payment из списка
        getAddressSelect().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setPaymentElementsList(driver.findElements(By.xpath(pathWeb + "")));
        if(getPaymentElementsList().size() <= 1){
            getPaymentElementsList().get(0).click();
            MainScreenSidebarAddPaymentsClass mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarAddPaymentsClass.class);
            mainScreenSidebarAddPaymentsClass.chooseDevice();
            mainScreenSidebarAddPaymentsClass.addPayment(GlobalMethods.getNumberCard1(), GlobalMethods.getNumberCard2(), GlobalMethods.getDateCardMonth(), GlobalMethods.getDateCardYear(),GlobalMethods.getCvvCard());
        } else {
            getPaymentElementsList().get(1).click();
        }

        getSubmitButton().click();
    }

    public boolean restaurantValidation(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        boolean result = GlobalMethods.validationFavoriteOrder(mainScreenSidebarAddQuickOrderClass);
        return result;
    }

    public void editQuickOrder() throws InterruptedException {
        //Редактирование полей QuickOrder (если создан всего один favorite order, создаем второй)
        getFavoriteOrderSelect().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setFavoriteOrderElementsList(driver.findElements(By.xpath(pathWeb + "")));
        if(getFavoriteOrderElementsList().size()>2){
            getFavoriteOrderElementsList().get(2).click();
        } else{
            getFavoriteOrderElementsList().get(0).click();
            MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);
            mainScreenSidebarAddOrderClass.chooseDevice();
            mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurantEdit(),GlobalMethods.getOrderEdit());
            getFavoriteOrderSelect().click();
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setFavoriteOrderElementsList(driver.findElements(By.xpath(pathWeb + "")));
            getFavoriteOrderElementsList().get(2).click();
        }

        getAddressSelect().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setAddressElementsList(driver.findElements(By.xpath(pathWeb + "")));
        if(getAddressElementsList().size()>2){
            getAddressElementsList().get(2).click();
        } else{
            getAddressElementsList().get(0).click();
            MainScreenSidebarAddAddressClass mainScreenSidebarAddAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddAddressClass.class);
            mainScreenSidebarAddAddressClass.chooseDevice();
            mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCityEdit(), GlobalMethods.getAddressEdit(),GlobalMethods.getHomeEdit());
            getAddressSelect().click();
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setAddressElementsList(driver.findElements(By.xpath(pathWeb + "")));
            getAddressElementsList().get(2).click();
        }

        getPaymentSelect().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setFavoriteOrderElementsList(driver.findElements(By.xpath(pathWeb + "")));
        if(getPaymentElementsList().size()>2){
            getPaymentElementsList().get(2).click();
        } else{
            getPaymentElementsList().get(0).click();
            MainScreenSidebarAddPaymentsClass mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarAddPaymentsClass.class);
            mainScreenSidebarAddPaymentsClass.chooseDevice();
            mainScreenSidebarAddPaymentsClass.addPayment(GlobalMethods.getNumberCardEdit1(), GlobalMethods.getNumberCardEdit2(),GlobalMethods.getDateCardMonthEdit(), GlobalMethods.getDateCardYearEdit(),GlobalMethods.getCvvCardEdit());
            getPaymentSelect().click();
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setPaymentElementsList(driver.findElements(By.xpath(pathWeb + "")));
            getPaymentElementsList().get(2).click();
        }
    }



    public WebElement getFavoriteOrder() {
        return favoriteOrder;
    }

    public void setFavoriteOrder(WebElement favoriteOrder) {
        this.favoriteOrder = favoriteOrder;
    }

    public WebElement getAddress() {
        return address;
    }

    public void setAddress(WebElement address) {
        this.address = address;
    }

    public WebElement getPayment() {
        return payment;
    }

    public void setPayment(WebElement payment) {
        this.payment = payment;
    }

    public WebElement getFavoriteOrderSelect() {
        return favoriteOrderSelect;
    }

    public void setFavoriteOrderSelect(WebElement favoriteOrderSelect) {
        this.favoriteOrderSelect = favoriteOrderSelect;
    }

    public WebElement getAddressSelect() {
        return addressSelect;
    }

    public void setAddressSelect(WebElement addressSelect) {
        this.addressSelect = addressSelect;
    }

    public WebElement getPaymentSelect() {
        return paymentSelect;
    }

    public void setPaymentSelect(WebElement paymentSelect) {
        this.paymentSelect = paymentSelect;
    }

    public List<WebElement> getFavoriteOrderElementsList() {
        return favoriteOrderElementsList;
    }

    public void setFavoriteOrderElementsList(List<WebElement> favoriteOrderElementsList) {
        this.favoriteOrderElementsList = favoriteOrderElementsList;
    }

    public List<WebElement> getAddressElementsList() {
        return addressElementsList;
    }

    public void setAddressElementsList(List<WebElement> addressElementsList) {
        this.addressElementsList = addressElementsList;
    }

    public List<WebElement> getPaymentElementsList() {
        return paymentElementsList;
    }

    public void setPaymentElementsList(List<WebElement> paymentElementsList) {
        this.paymentElementsList = paymentElementsList;
    }

    public WebElement getAddNewFavoriteOrderButton() {
        return addNewFavoriteOrderButton;
    }

    public void setAddNewFavoriteOrderButton(WebElement addNewFavoriteOrderButton) {
        this.addNewFavoriteOrderButton = addNewFavoriteOrderButton;
    }

    public WebElement getAddNewAddressButton() {
        return addNewAddressButton;
    }

    public void setAddNewAddressButton(WebElement addNewAddressButton) {
        this.addNewAddressButton = addNewAddressButton;
    }

    public WebElement getAddNewPaymentButton() {
        return addNewPaymentButton;
    }

    public void setAddNewPaymentButton(WebElement addNewPaymentButton) {
        this.addNewPaymentButton = addNewPaymentButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(WebElement cancelButton) {
        this.cancelButton = cancelButton;
    }
}
