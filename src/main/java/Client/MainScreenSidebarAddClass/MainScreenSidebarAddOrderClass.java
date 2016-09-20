package Client.MainScreenSidebarAddClass;

import Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import GlobalMethods.GlobalMethods;
//TODO
//import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 03.06.16.
 */
public class MainScreenSidebarAddOrderClass {

    WebDriver driver;
    WebDriverWait waiting;

    public MainScreenSidebarAddOrderClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = ".//*[@id='ModalContainer']/div/div/div[3]";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement restaurantName;

    private WebElement restaurantSelectButton;

    private WebElement restaurantList;

    private WebElement orderName;

    //private WebElement description;

    private WebElement cancelButton;

    private WebElement submitButton;

    private WebElement modalWindow;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ModalContainer']/div/div/div[3]/div[1]/div[1]/div[1]/input")));
                setRestaurantName(driver.findElement(By.xpath(pathWeb + "/div[1]/div[1]/div[1]/input")));
                setRestaurantSelectButton(driver.findElement(By.xpath(pathWeb + "/div[1]/div[1]/div[2]")));
                setOrderName(driver.findElement(By.xpath(pathWeb + "/input")));
                //setDescription(driver.findElement(By.xpath(pathWeb + "/textarea")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "/div[3]/button[1]")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "/div[3]/button[2]")));
                setModalWindow(driver.findElement(By.xpath(".//*[@id='ModalContainer']/div")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setRestaurantName(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantSelectButton(driver.findElement(By.xpath(pathWeb + "")));
                setOrderName(driver.findElement(By.xpath(pathWeb + "")));
                //setDescription(driver.findElement(By.xpath(pathWeb + "/textarea")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                setModalWindow(driver.findElement(By.xpath("")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setRestaurantName(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantSelectButton(driver.findElement(By.xpath(pathWeb + "")));
                setOrderName(driver.findElement(By.xpath(pathWeb + "")));
                //setDescription(driver.findElement(By.xpath(pathWeb + "/textarea")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                setModalWindow(driver.findElement(By.xpath("")));
                break;
        }
    }


    public void cancelClick(){
        getCancelButton().click();
    }

    public boolean restaurantValidation() throws InterruptedException {
        getOrderName().sendKeys("testOrder");
        //getDescription().sendKeys("testDescription");
        boolean result = GlobalMethods.validationRestaurant(getRestaurantName(),getSubmitButton());
        return result;
    }

    public void addOrder(String restaurant,String order){
        getRestaurantName().sendKeys(restaurant);
        getOrderName().sendKeys(order);
        getSubmitButton().click();
    }

    public void editOrder(String restaurant,String order){
        while(!getRestaurantName().getAttribute("value").isEmpty()){
            getRestaurantName().sendKeys(Keys.BACK_SPACE);
        }
        while(!getOrderName().getAttribute("value").isEmpty()){
            getOrderName().sendKeys(Keys.BACK_SPACE);
        }
        while(!getSubmitButton().getAttribute("value").isEmpty()){
            getSubmitButton().sendKeys(Keys.BACK_SPACE);
        }
        getRestaurantName().sendKeys(restaurant);
        getOrderName().sendKeys(order);
        getSubmitButton().click();
    }


    public boolean checkEditAddressFields(String restaurant, String order) throws InterruptedException {
        if(getRestaurantName().equals(restaurant) && getOrderName().equals(order)){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCancelButtonClick(MainScreenSidebarFavoriteOrderClass mainScreenSidebarFavoriteOrderClass) throws InterruptedException {
        getCancelButton().click();
        try{
            mainScreenSidebarFavoriteOrderClass.chooseDevice();
        } catch(org.openqa.selenium.TimeoutException e){
            //TODO
            //Assert.fail("Error!");
        }
        return true;
    }

    public WebElement getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(WebElement restaurantName) {
        this.restaurantName = restaurantName;
    }

    public WebElement getOrderName() {
        return orderName;
    }

    public void setOrderName(WebElement orderName) {
        this.orderName = orderName;
    }

    /*public WebElement getDescription() {
        return description;
    }*/

    /*public void setDescription(WebElement description) {
        this.description = description;
    }*/

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

    public WebElement getRestaurantSelectButton() {
        return restaurantSelectButton;
    }

    public void setRestaurantSelectButton(WebElement restaurantSelectButton) {
        this.restaurantSelectButton = restaurantSelectButton;
    }

    public WebElement getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(WebElement restaurantList) {
        this.restaurantList = restaurantList;
    }

    public WebElement getModalWindow() {
        return modalWindow;
    }

    public void setModalWindow(WebElement modalWindow) {
        this.modalWindow = modalWindow;
    }
}
