package TestClass.Client.MainScreenSidebarDeleteClass;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 07.06.16.
 */
public class MainScreenSidebarPaymentsDeleteClass {

    WebDriver driver;
    WebDriverWait waiting;

    public MainScreenSidebarPaymentsDeleteClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement deleteYes;

    private WebElement deleteNo;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setDeleteNo(driver.findElement(By.xpath(pathWeb + "")));
                setDeleteYes(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setDeleteNo(driver.findElement(By.xpath(pathWeb + "")));
                setDeleteYes(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setDeleteNo(driver.findElement(By.xpath(pathWeb + "")));
                setDeleteYes(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public void deleteNoClick(){
        getDeleteNo().click();
    }

    public void deleteYesClick(){
        getDeleteYes().click();
    }



    public WebElement getDeleteYes() {
        return deleteYes;
    }

    public void setDeleteYes(WebElement deleteYes) {
        this.deleteYes = deleteYes;
    }

    public WebElement getDeleteNo() {
        return deleteNo;
    }

    public void setDeleteNo(WebElement deleteNo) {
        this.deleteNo = deleteNo;
    }

}
