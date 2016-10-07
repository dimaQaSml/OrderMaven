package TestClass.Client.MainScreenSidebarClass;

import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 06.06.16.
 */
public class MainScreenSidebarAddressClass {

    WebDriver driver;
    WebDriverWait waiting;

    public MainScreenSidebarAddressClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement addressSection;

    private WebElement addAddressButton;

    private List<WebElement> addressLabel;

    private List<WebElement> editAddressButton;

    private List<WebElement> deleteAddressButton;

    private List<WebElement> addressList;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[1]/div[2]/p")));
                setAddressSection(driver.findElement(By.xpath(pathWeb + ".//*[@id='Container']/div[2]/div/div[3]/div[1]/div[2]/p")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setAddressSection(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setAddressSection(driver.findElement(By.xpath(pathWeb + "")));
                break;

        }
    }

    public void addAddressButtonClick(){
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[5]/button")));
        setAddAddressButton(driver.findElement(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[5]/button")));
        getAddAddressButton().click();
    }

    public void addAddressButtonFind(){
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setAddAddressButton(driver.findElement(By.xpath("")));
    }

    public List<WebElement> countAddressElementsBefore(){
        try{
            if(!driver.findElements(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[3]/div/div")).equals(null)) {
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[3]/div/div")));
                setAddressList(driver.findElements(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[3]/div/div")));
            } else{
                return new ArrayList<WebElement>();
            }
        } catch (org.openqa.selenium.TimeoutException e){
            return null;
        }
        return getAddressList();
    }

    public boolean checkAddAddress(List<WebElement> countOrderElementsBefore){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[3]/div/div")));
            setAddressList(driver.findElements(By.xpath(".//*[@id='Container']/div[2]/div/div[3]/div[3]/div/div")));
        } catch (org.openqa.selenium.TimeoutException e){
            return false;
        }
        if(countOrderElementsBefore.size()<getAddressList().size()) {
            return true;
        } else{
            return false;
        }
    }

    public boolean checkDeleteAddress(List<WebElement> countOrderElementsBefore){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setAddressList(driver.findElements(By.xpath("")));
        } catch (org.openqa.selenium.TimeoutException e){
            return false;
        }
        if(countOrderElementsBefore.size() > getAddressList().size()) {
            return true;
        } else{
            return false;
        }
    }


    public WebElement getAddressSection() {
        return addressSection;
    }

    public void setAddressSection(WebElement addressSection) {
        this.addressSection = addressSection;
    }

    public WebElement getAddAddressButton() {
        return addAddressButton;
    }

    public void setAddAddressButton(WebElement addAddressButton) {
        this.addAddressButton = addAddressButton;
    }

    public List<WebElement> getAddressLabel() {
        return addressLabel;
    }

    public void setAddressLabel(List<WebElement> addressLabel) {
        this.addressLabel = addressLabel;
    }

    public List<WebElement> getEditAddressButton() {
        return editAddressButton;
    }

    public void setEditAddressButton(List<WebElement> editAddressButton) {
        this.editAddressButton = editAddressButton;
    }

    public List<WebElement> getDeleteAddressButton() {
        return deleteAddressButton;
    }

    public void setDeleteAddressButton(List<WebElement> deleteAddressButton) {
        this.deleteAddressButton = deleteAddressButton;
    }

    public List<WebElement> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<WebElement> addressList) {
        this.addressList = addressList;
    }
}
