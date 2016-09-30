package TestClass.Restaurant.MobileCategories;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 07.07.16.
 */
public class SignUpStep3DeliveryArea {

    WebDriver driver;
    WebDriverWait waiting;

    public SignUpStep3DeliveryArea(WebDriver driver){
        this.driver = driver;
    }

    String pathAndroid = "";
    String pathIOS = "";

    private WebElement mapArea;

    private WebElement makeArea;

    private WebElement makeCircle;

    private WebElement circle;

    private WebElement deleteButton;

    private WebElement clearButton;

    private WebElement searchMap;

    private WebElement point;

    private WebElement searchListMap;

    private WebElement okButton;

    private WebElement backDevice;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,40);
        switch (GlobalMethods.chooseDevice()) {
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchEditText")));
                setMapArea(driver.findElement(By.id("touchLayout")));
                setMakeArea(driver.findElement(By.id("polyButton")));
                setMakeCircle(driver.findElement(By.id("circleButton")));
                setDeleteButton(driver.findElement(By.id("deleteButton")));
                setClearButton(driver.findElement(By.id("clearButton")));
                setOkButton(driver.findElement(By.id("doneButton")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchEditText")));
                setMapArea(driver.findElement(By.id("touchLayout")));
                setMakeArea(driver.findElement(By.id("polyButton")));
                setMakeCircle(driver.findElement(By.id("circleButton")));
                setDeleteButton(driver.findElement(By.id("deleteButton")));
                setClearButton(driver.findElement(By.id("clearButton")));
                setOkButton(driver.findElement(By.id("doneButton")));
                setBackDevice(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]" +
                        "/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")));
                break;
        }
    }


    public WebElement getMapArea() {
        return mapArea;
    }

    public void setMapArea(WebElement mapArea) {
        this.mapArea = mapArea;
    }

    public WebElement getMakeArea() {
        return makeArea;
    }

    public void setMakeArea(WebElement makeArea) {
        this.makeArea = makeArea;
    }

    public WebElement getMakeCircle() {
        return makeCircle;
    }

    public void setMakeCircle(WebElement makeCircle) {
        this.makeCircle = makeCircle;
    }

    public WebElement getCircle() {
        return circle;
    }

    public void setCircle(WebElement circle) {
        this.circle = circle;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(WebElement deleteButton) {
        this.deleteButton = deleteButton;
    }

    public WebElement getClearButton() {
        return clearButton;
    }

    public void setClearButton(WebElement clearButton) {
        this.clearButton = clearButton;
    }

    public WebElement getSearchMap() {
        return searchMap;
    }

    public void setSearchMap(WebElement searchMap) {
        this.searchMap = searchMap;
    }

    public WebElement getPoint() {
        return point;
    }

    public void setPoint(WebElement point) {
        this.point = point;
    }

    public WebElement getSearchListMap() {
        return searchListMap;
    }

    public void setSearchListMap(WebElement searchListMap) {
        this.searchListMap = searchListMap;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public void setOkButton(WebElement okButton) {
        this.okButton = okButton;
    }

    public WebElement getBackDevice() {
        return backDevice;
    }

    public void setBackDevice(WebElement backDevice) {
        this.backDevice = backDevice;
    }
}
