package Client.MainScreenSidebarClass;

import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 06.06.16.
 */
public class MainScreenSidebarPaymentsClass {

    WebDriver driver;
    WebDriverWait waiting;

    public MainScreenSidebarPaymentsClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement paymentSection;

    private List<WebElement> addPaymentButton;

    private List<WebElement> addCard;

    private List<WebElement> typeCardImg;

    private List<WebElement> editCardButton;

    private List<WebElement> deleteCardButton;

    private List<WebElement> payments;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setPaymentSection(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setPaymentSection(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setPaymentSection(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public void paymentSectionClick(){
        getPaymentSection().click();
    }

    public void editPaymentClick(){
        getEditCardButton().get(0).click();
    }

    public void addPaymentButtonClick(){
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setAddPaymentButton(driver.findElements(By.xpath("")));
        getAddPaymentButton().get(0).click();
    }

    public void addPaymentButtonFind(){
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setAddPaymentButton(driver.findElements(By.xpath("")));
    }

    public List<WebElement> countPaymentsElementsBefore(){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setPayments(driver.findElements(By.xpath("")));
        } catch (org.openqa.selenium.TimeoutException e){
            return null;
        }
        return getPayments();
    }

    public boolean checkAddPayment(List<WebElement> countOrderElementsBefore){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setPayments(driver.findElements(By.xpath("")));
        } catch (org.openqa.selenium.TimeoutException e){
            return false;
        }
        if(countOrderElementsBefore.size()<getPayments().size()) {
            return true;
        } else{
            return false;
        }
    }

    public boolean checkDeletePayment(List<WebElement> countOrderElementsBefore){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setPayments(driver.findElements(By.xpath("")));
        } catch (org.openqa.selenium.TimeoutException e){
            return false;
        }
        if(countOrderElementsBefore.size() > getPayments().size()) {
            return true;
        } else{
            return false;
        }
    }





    public WebElement getPaymentSection() {
        return paymentSection;
    }

    public void setPaymentSection(WebElement paymentSection) {
        this.paymentSection = paymentSection;
    }

    public List<WebElement> getAddPaymentButton() {
        return addPaymentButton;
    }

    public void setAddPaymentButton(List<WebElement> addPaymentButton) {
        this.addPaymentButton = addPaymentButton;
    }

    public List<WebElement> getAddCard() {
        return addCard;
    }

    public void setAddCard(List<WebElement> addCard) {
        this.addCard = addCard;
    }

    public List<WebElement> getTypeCardImg() {
        return typeCardImg;
    }

    public void setTypeCardImg(List<WebElement> typeCardImg) {
        this.typeCardImg = typeCardImg;
    }

    public List<WebElement> getEditCardButton() {
        return editCardButton;
    }

    public void setEditCardButton(List<WebElement> editCardButton) {
        this.editCardButton = editCardButton;
    }

    public List<WebElement> getDeleteCardButton() {
        return deleteCardButton;
    }

    public void setDeleteCardButton(List<WebElement> deleteCardButton) {
        this.deleteCardButton = deleteCardButton;
    }

    public List<WebElement> getPayments() {
        return payments;
    }

    public void setPayments(List<WebElement> payments) {
        this.payments = payments;
    }
}
