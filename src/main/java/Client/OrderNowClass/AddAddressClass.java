package Client.OrderNowClass;

import Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 05.08.16.
 */
public class AddAddressClass extends MainScreenSidebarAddAddressClass {

    WebDriver driver;
    WebDriverWait waiting;

    public AddAddressClass(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement chooseAddressSelect;

    private List<WebElement> getChooseAddressElementsList;

    private WebElement chooseAddressField;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setChooseAddressField(driver.findElement(By.xpath(pathWeb + "")));
                setAddress(driver.findElement(By.xpath(pathWeb + "")));
                setCity(driver.findElement(By.xpath(pathWeb + "")));
                setGetLocationButton(driver.findElement(By.xpath(pathWeb + "")));
                setHome(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setChooseAddressField(driver.findElement(By.xpath(pathWeb + "")));
                setAddress(driver.findElement(By.xpath(pathWeb + "")));
                setCity(driver.findElement(By.xpath(pathWeb + "")));
                setGetLocationButton(driver.findElement(By.xpath(pathWeb + "")));
                setHome(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setChooseAddressField(driver.findElement(By.xpath(pathWeb + "")));
                setAddress(driver.findElement(By.xpath(pathWeb + "")));
                setCity(driver.findElement(By.xpath(pathWeb + "")));
                setGetLocationButton(driver.findElement(By.xpath(pathWeb + "")));
                setHome(driver.findElement(By.xpath(pathWeb + "")));
                setCancelButton(driver.findElement(By.xpath(pathWeb + "")));
                setSubmitButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }


    public boolean testCase127() throws InterruptedException {
        ChooseOrderClass chooseOrderClass = PageFactory.initElements(driver, ChooseOrderClass.class);
        chooseOrderClass.chooseDevice();
        chooseOrderClass.getTypeNewOrder().sendKeys(GlobalMethods.getOrder());
        chooseOrderClass.getSubmitButton().click();
        chooseDevice();
        getChooseAddressSelect().click();
        getGetChooseAddressElementsList().get(0).click();
        if(getHome().isEnabled() || getAddress().isEnabled() || getCity().isEnabled() || getGetLocationButton().isEnabled()){
            return false;
        } else{
            return true;
        }
    }




    public WebElement getChooseAddressSelect() {
        return chooseAddressSelect;
    }

    public void setChooseAddressSelect(WebElement chooseAddressSelect) {
        this.chooseAddressSelect = chooseAddressSelect;
    }

    public List<WebElement> getGetChooseAddressElementsList() {
        return getChooseAddressElementsList;
    }

    public void setGetChooseAddressElementsList(List<WebElement> getChooseAddressElementsList) {
        this.getChooseAddressElementsList = getChooseAddressElementsList;
    }

    public WebElement getChooseAddressField() {
        return chooseAddressField;
    }

    public void setChooseAddressField(WebElement chooseAddressField) {
        this.chooseAddressField = chooseAddressField;
    }
}
