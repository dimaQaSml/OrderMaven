package Client.OrderNowClass;

import Client.Restaurant.RestaurantModalClass;
import GlobalMethods.GlobalMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 04.08.16.
 */
public class ChooseOrderClass {

    WebDriver driver;
    WebDriverWait waiting;

    public ChooseOrderClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement restaurantMenuPhotoArea;

    private List<WebElement> restaurantMenuPhoto;

    private WebElement chooseFavoriteOrder;

    private WebElement chooseFavoriteOrderSelect;

    private List<WebElement> chooseFavoriteOrderElementList;

    private WebElement typeNewOrder;

    private WebElement cancelButton;

    private WebElement submitButton;

    private WebElement errorLabel;


    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setRestaurantMenuPhotoArea(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantMenuPhoto(driver.findElements(By.xpath(pathWeb + "")));
                setChooseFavoriteOrder(driver.findElement(By.xpath(pathWeb + "")));
                setChooseFavoriteOrderElementList(driver.findElements(By.xpath(pathWeb + "")));
                setChooseFavoriteOrderSelect(driver.findElement(By.xpath(pathWeb + "")));
                setTypeNewOrder(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setRestaurantMenuPhotoArea(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantMenuPhoto(driver.findElements(By.xpath(pathWeb + "")));
                setChooseFavoriteOrder(driver.findElement(By.xpath(pathWeb + "")));
                setChooseFavoriteOrderElementList(driver.findElements(By.xpath(pathWeb + "")));
                setChooseFavoriteOrderSelect(driver.findElement(By.xpath(pathWeb + "")));
                setTypeNewOrder(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setRestaurantMenuPhotoArea(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantMenuPhoto(driver.findElements(By.xpath(pathWeb + "")));
                setChooseFavoriteOrder(driver.findElement(By.xpath(pathWeb + "")));
                setChooseFavoriteOrderElementList(driver.findElements(By.xpath(pathWeb + "")));
                setChooseFavoriteOrderSelect(driver.findElement(By.xpath(pathWeb + "")));
                setTypeNewOrder(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public boolean testCase117() throws InterruptedException {
        boolean result = GlobalMethods.validationChooseOrder(this,GlobalMethods.getOrder(), GlobalMethods.getOrderEdit());
        return result;
    }

    public boolean testCase118() throws InterruptedException {
        boolean result = GlobalMethods.validationChooseOrderFavoriteOrder(this);
        return result;
    }

    public boolean testCase120() throws InterruptedException {
        getChooseFavoriteOrder().sendKeys("!@#$%^&*");
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setErrorLabel(driver.findElement(By.xpath("")));
        } catch (TimeoutException e){
            return false;
        }
        if(getErrorLabel().isDisplayed()){
            return true;
        } else{
            return false;
        }
    }

    public boolean testCase121() throws InterruptedException {
        getChooseFavoriteOrder().sendKeys(GlobalMethods.getOrder());
        if(getChooseFavoriteOrderElementList().get(0).isDisplayed()){
            return false;
        }
        if(getTypeNewOrder().isEnabled()){
            return false;
        }
        if(!getSubmitButton().isEnabled()){
            return false;
        }
        return true;
    }

    public boolean testCase122() throws InterruptedException {
        getTypeNewOrder().sendKeys("TestNewOrder");
        if(getChooseFavoriteOrder().isEnabled()){
            return false;
        }
        if(!getSubmitButton().isEnabled()){
            return false;
        }
        return true;
    }

    public boolean testCase123() throws InterruptedException {
        getChooseFavoriteOrder().sendKeys(GlobalMethods.getOrder());
        if(getTypeNewOrder().isEnabled()){
            return false;
        }
        if(!getSubmitButton().isEnabled()){
            return false;
        }
        while (!getChooseFavoriteOrder().getAttribute("value").isEmpty()) {
            getChooseFavoriteOrder().sendKeys(Keys.BACK_SPACE);
        }
        if(!getChooseFavoriteOrder().isEnabled()){
            return false;
        }
        if(getSubmitButton().isEnabled()){
            return false;
        }
        return true;
    }

    public boolean testCase124() throws InterruptedException {
        getTypeNewOrder().sendKeys(GlobalMethods.getOrder());
        if(getChooseFavoriteOrder().isEnabled()){
            return false;
        }
        if(!getSubmitButton().isEnabled()){
            return false;
        }
        while (!getTypeNewOrder().getAttribute("value").isEmpty()) {
            getTypeNewOrder().sendKeys(Keys.BACK_SPACE);
        }
        if(!getChooseFavoriteOrder().isEnabled()){
            return false;
        }
        if(getSubmitButton().isEnabled()){
            return false;
        }
        return true;
    }

    public boolean testCase125() throws InterruptedException {
        getCancelButton().click();
        try{
            RestaurantModalClass restaurantModalClass = PageFactory.initElements(driver, RestaurantModalClass.class);
            restaurantModalClass.chooseDevice();
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }

    public boolean testCase129() throws InterruptedException {
        getTypeNewOrder().sendKeys(GlobalMethods.getOrder());
        getSubmitButton().click();
        try{
            AddAddressClass addAddressClass = PageFactory.initElements(driver, AddAddressClass.class);
            addAddressClass.chooseDevice();
        } catch(TimeoutException e){
            return false;
        }
        return true;
    }



    public WebElement getRestaurantMenuPhotoArea() {
        return restaurantMenuPhotoArea;
    }

    public void setRestaurantMenuPhotoArea(WebElement restaurantMenuPhotoArea) {
        this.restaurantMenuPhotoArea = restaurantMenuPhotoArea;
    }

    public List<WebElement> getRestaurantMenuPhoto() {
        return restaurantMenuPhoto;
    }

    public void setRestaurantMenuPhoto(List<WebElement> restaurantMenuPhoto) {
        this.restaurantMenuPhoto = restaurantMenuPhoto;
    }

    public WebElement getChooseFavoriteOrder() {
        return chooseFavoriteOrder;
    }

    public void setChooseFavoriteOrder(WebElement chooseFavoriteOrder) {
        this.chooseFavoriteOrder = chooseFavoriteOrder;
    }

    public WebElement getChooseFavoriteOrderSelect() {
        return chooseFavoriteOrderSelect;
    }

    public void setChooseFavoriteOrderSelect(WebElement chooseFavoriteOrderSelect) {
        this.chooseFavoriteOrderSelect = chooseFavoriteOrderSelect;
    }

    public List<WebElement> getChooseFavoriteOrderElementList() {
        return chooseFavoriteOrderElementList;
    }

    public void setChooseFavoriteOrderElementList(List<WebElement> chooseFavoriteOrderElementList) {
        this.chooseFavoriteOrderElementList = chooseFavoriteOrderElementList;
    }

    public WebElement getTypeNewOrder() {
        return typeNewOrder;
    }

    public void setTypeNewOrder(WebElement typeNewOrder) {
        this.typeNewOrder = typeNewOrder;
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

    public WebElement getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(WebElement errorLabel) {
        this.errorLabel = errorLabel;
    }
}
