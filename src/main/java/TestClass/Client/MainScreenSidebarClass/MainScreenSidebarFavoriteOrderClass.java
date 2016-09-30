package TestClass.Client.MainScreenSidebarClass;

import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import TestClass.Client.MainScreenSidebarDeleteClass.MainScreenSidebarFavoriteOrderDeleteClass;
import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 06.06.16.
 */
public class MainScreenSidebarFavoriteOrderClass {

    WebDriver driver;
    WebDriverWait waiting;

    MainScreenSidebarFavoriteOrderClass mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderClass.class);
    MainScreenSidebarFavoriteOrderDeleteClass mainScreenSidebarFavoriteOrderDeleteClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderDeleteClass.class);

    public MainScreenSidebarFavoriteOrderClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = ".//*[@id='Container']/div[3]/div/div[3]";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement favoriteOrderSection;

    private WebElement addOrderButton;

    private List<WebElement> orderNameLabel;

    private List<WebElement> addQuickOrderButton;

    private List<WebElement> editOrderButton;

    private List<WebElement> deleteOrderButton;

    private WebElement categoriesOrderLabel;

    private List<WebElement> orders;

    //TODO ???? сделать addQuickOrderButton, editOrderButton, deleteOrderButton списками чтобы обращаться не только к первому
    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Container']/div[3]/div/div[3]/div[1]/div[1]/p")));
                setFavoriteOrderSection(driver.findElement(By.xpath(pathWeb + "/div[1]/div[1]/p")));
                setAddOrderButton(driver.findElement(By.xpath(pathWeb + "/div[3]/button")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setFavoriteOrderSection(driver.findElement(By.xpath(pathWeb + "")));
                setAddOrderButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setFavoriteOrderSection(driver.findElement(By.xpath(pathWeb + "")));
                setAddOrderButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public void addOrderButtonClick(){
        getAddOrderButton().click();
    }

    public void favoriteOrderSectionClick(){
        getFavoriteOrderSection().click();
    }

    public List<WebElement> countOrdersElementsBefore(){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Container']/div[3]/div/div[3]/div[2]/div")));
            setOrders(driver.findElements(By.xpath(".//*[@id='Container']/div[3]/div/div[3]/div[2]/div")));
        } catch (org.openqa.selenium.TimeoutException e){
            return null;
        }
        return getOrders();
    }

    public boolean checkAddOrder(List<WebElement> countOrderElementsBefore){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Container']/div[3]/div/div[3]/div[2]/div")));
            setOrders(driver.findElements(By.xpath(pathWeb + "/div[2]/div")));
            setAddQuickOrderButton(driver.findElements(By.xpath(pathWeb + "/div[2]/div/div[2]/img[1]")));
            setEditOrderButton(driver.findElements(By.xpath(pathWeb + "/div[2]/div/div[2]/img[2]")));
            setDeleteOrderButton(driver.findElements(By.xpath(pathWeb + "/div[2]/div/div[2]/img[3]")));
        } catch (org.openqa.selenium.TimeoutException e){
            return false;
        }
        if(countOrderElementsBefore.size()<getOrders().size()) {
            return true;
        } else{
            return false;
        }
    }

    public boolean checkDeleteOrder(List<WebElement> countOrderElementsBefore){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Container']/div[3]/div/div[3]/div[2]/div")));
            setOrders(driver.findElements(By.xpath(".//*[@id='Container']/div[3]/div/div[3]/div[2]/div")));
        } catch (org.openqa.selenium.TimeoutException e){
            return false;
        }
        if(countOrderElementsBefore.size() > getOrders().size()) {
            return true;
        } else{
            return false;
        }
    }

    public void deleteOrder(List<WebElement> before) throws InterruptedException {
        mainScreenSidebarFavoriteOrderClass.getDeleteOrderButton().get(before.size()).click();
        mainScreenSidebarFavoriteOrderDeleteClass.chooseDevice();
        mainScreenSidebarFavoriteOrderDeleteClass.deleteYesClick();
    }

    public boolean checkDataOrder(String nameOrder){
        if(getOrderNameLabel().equals(nameOrder)) {
            return true;
        } else{
            return false;
        }
    }

    public WebElement getFavoriteOrderSection() {
        return favoriteOrderSection;
    }

    public void setFavoriteOrderSection(WebElement favoriteOrderSection) {
        this.favoriteOrderSection = favoriteOrderSection;
    }

    public WebElement getAddOrderButton() {
        return addOrderButton;
    }

    public void setAddOrderButton(WebElement addOrderButton) {
        this.addOrderButton = addOrderButton;
    }

    public List<WebElement> getOrderNameLabel() {
        return orderNameLabel;
    }

    public void setOrderNameLabel(List<WebElement> orderNameLabel) {
        this.orderNameLabel = orderNameLabel;
    }

    public List<WebElement> getAddQuickOrderButton() {
        return addQuickOrderButton;
    }

    public void setAddQuickOrderButton(List<WebElement> addQuickOrderButton) {
        this.addQuickOrderButton = addQuickOrderButton;
    }

    public List<WebElement> getDeleteOrderButton() {
        return deleteOrderButton;
    }

    public void setDeleteOrderButton(List<WebElement> deleteOrderButton) {
        this.deleteOrderButton = deleteOrderButton;
    }

    public List<WebElement> getEditOrderButton() {
        return editOrderButton;
    }

    public void setEditOrderButton(List<WebElement> editOrderButton) {
        this.editOrderButton = editOrderButton;
    }


    public WebElement getCategoriesOrderLabel() {
        return categoriesOrderLabel;
    }

    public void setCategoriesOrderLabel(WebElement categoriesOrderLabel) {
        this.categoriesOrderLabel = categoriesOrderLabel;
    }

    public List<WebElement> getOrders() {
        return orders;
    }

    public void setOrders(List<WebElement> orders) {
        this.orders = orders;
    }
}
