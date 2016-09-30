package TestClass.Client.Restaurant;

import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import TestClass.Client.OrderNowClass.*;
import TestClass.GlobalMethods.GlobalMethods;
import TestClass.Restaurant.MainScreenSidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 03.08.16.
 */
public class RestaurantQuickOrderClass {

    WebDriver driver;
    WebDriverWait waiting;

    public RestaurantQuickOrderClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement quickOrderTab;

    private List<WebElement> quickOrders;

    private WebElement orderNow;

    private WebElement editQuickOrder;


    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setQuickOrderTab(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public List<WebElement> countQuickOrdersElements(){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setQuickOrders(driver.findElements(By.xpath("")));
        } catch (org.openqa.selenium.TimeoutException e){
            return null;
        }
        return getQuickOrders();
    }


    public boolean testCase96() throws InterruptedException {
        getQuickOrderTab().click();
        try {
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setQuickOrders(driver.findElements(By.xpath("")));
        } catch (TimeoutException e){
            return false;
        }
        getQuickOrders().get(0).click();
        try {
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setEditQuickOrder(driver.findElement(By.xpath("")));
            setOrderNow(driver.findElement(By.xpath("")));
        } catch (TimeoutException e){
            return false;
        }
        getEditQuickOrder().click();
        MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddQuickOrderClass.class);
        try {
            mainScreenSidebarAddQuickOrderClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase97() throws InterruptedException {
        getQuickOrderTab().click();
        try {
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setQuickOrders(driver.findElements(By.xpath("")));
        } catch (TimeoutException e){
            return false;
        }
        getQuickOrders().get(0).click();
        try {
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setEditQuickOrder(driver.findElement(By.xpath("")));
            setOrderNow(driver.findElement(By.xpath("")));
        } catch (TimeoutException e){
            return false;
        }
        getOrderNow().click();
        MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddQuickOrderClass.class);
        try {
            //TODO чатик и orderNow
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase139() throws InterruptedException {
        getQuickOrderTab().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setQuickOrders(driver.findElements(By.xpath("")));
        List<WebElement> beforeQuickOrders = countQuickOrdersElements();

        PlaceOrderClass placeOrderClass;
        CongratulationsClass congratulationsClass;
        DeliveriesClass deliveriesClass;
        DeliveriesReceivedClass deliveriesReceivedClass;
        RestaurantModalClass restaurantModalClass;
        SummarySendClass summarySendClass = PageFactory.initElements(driver, SummarySendClass.class);
        summarySendClass.chooseDevice();

        if(!summarySendClass.getSaveAsQuickOrderCheckbox().isEnabled()){
            summarySendClass.getSaveAsQuickOrderCheckbox().click();
        }
        summarySendClass.getSubmitButton().click();
        try{
            placeOrderClass = PageFactory.initElements(driver, PlaceOrderClass.class);
            placeOrderClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        placeOrderClass.getSubmitButton().click();

        try {
            congratulationsClass = PageFactory.initElements(driver, CongratulationsClass.class);
            congratulationsClass.chooseDevice();
            congratulationsClass.getSubmitButton().click();
        } finally {
            deliveriesClass = PageFactory.initElements(driver, DeliveriesClass.class);
            deliveriesClass.chooseDevice();
            deliveriesClass.getNoButton().click();
            deliveriesReceivedClass = PageFactory.initElements(driver, DeliveriesReceivedClass.class);
            deliveriesReceivedClass.chooseDevice();
            deliveriesClass.getYesButton().click();
        }
        restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
        restaurantModalClass.chooseDevice();
        restaurantModalClass.getCloseButton().click();

        chooseDevice();
        getQuickOrderTab().click();
        if(beforeQuickOrders.size() < countQuickOrdersElements().size()){
            return true;
        } else{
            return false;
        }
    }

    public boolean testCase140() throws InterruptedException {
        getQuickOrderTab().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setQuickOrders(driver.findElements(By.xpath("")));
        List<WebElement> beforeQuickOrders = countQuickOrdersElements();

        PlaceOrderClass placeOrderClass;
        CongratulationsClass congratulationsClass;
        DeliveriesClass deliveriesClass;
        DeliveriesReceivedClass deliveriesReceivedClass;
        RestaurantModalClass restaurantModalClass;
        SummarySendClass summarySendClass = PageFactory.initElements(driver, SummarySendClass.class);
        summarySendClass.chooseDevice();

        if(summarySendClass.getSaveAsQuickOrderCheckbox().isEnabled()){
            summarySendClass.getSaveAsQuickOrderCheckbox().click();
        }
        summarySendClass.getSubmitButton().click();
        try{
            placeOrderClass = PageFactory.initElements(driver, PlaceOrderClass.class);
            placeOrderClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        placeOrderClass.getSubmitButton().click();

        try {
            congratulationsClass = PageFactory.initElements(driver, CongratulationsClass.class);
            congratulationsClass.chooseDevice();
            congratulationsClass.getSubmitButton().click();
        } finally {
            deliveriesClass = PageFactory.initElements(driver, DeliveriesClass.class);
            deliveriesClass.chooseDevice();
            deliveriesClass.getNoButton().click();
            deliveriesReceivedClass = PageFactory.initElements(driver, DeliveriesReceivedClass.class);
            deliveriesReceivedClass.chooseDevice();
            deliveriesClass.getYesButton().click();
        }
        restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
        restaurantModalClass.chooseDevice();
        restaurantModalClass.getCloseButton().click();

        chooseDevice();
        getQuickOrderTab().click();
        if(beforeQuickOrders.size() < countQuickOrdersElements().size()){
            return false;
        } else{
            return true;
        }
    }





    public WebElement getQuickOrderTab() {
        return quickOrderTab;
    }

    public void setQuickOrderTab(WebElement quickOrderTab) {
        this.quickOrderTab = quickOrderTab;
    }

    public List<WebElement> getQuickOrders() {
        return quickOrders;
    }

    public void setQuickOrders(List<WebElement> quickOrders) {
        this.quickOrders = quickOrders;
    }

    public WebElement getOrderNow() {
        return orderNow;
    }

    public void setOrderNow(WebElement orderNow) {
        this.orderNow = orderNow;
    }

    public WebElement getEditQuickOrder() {
        return editQuickOrder;
    }

    public void setEditQuickOrder(WebElement editQuickOrder) {
        this.editQuickOrder = editQuickOrder;
    }
}
