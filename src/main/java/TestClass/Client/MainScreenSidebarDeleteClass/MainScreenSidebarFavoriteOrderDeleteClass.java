package TestClass.Client.MainScreenSidebarDeleteClass;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 06.06.16.
 */
public class MainScreenSidebarFavoriteOrderDeleteClass {

    WebDriver driver;
    WebDriverWait waiting;

    public MainScreenSidebarFavoriteOrderDeleteClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = ".//*[@id='ModalContainer']/div/div/div[3]/div";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement deleteYes;

    private WebElement deleteNo;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ModalContainer']/div/div/div[3]/div/button[2]")));
                setDeleteNo(driver.findElement(By.xpath(pathWeb + "/button[1]")));
                setDeleteYes(driver.findElement(By.xpath(pathWeb + "/button[2]")));
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
