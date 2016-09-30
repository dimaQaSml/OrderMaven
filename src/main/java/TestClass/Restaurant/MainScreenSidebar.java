package TestClass.Restaurant;

import TestClass.GlobalMethods.GlobalMethods;
import TestClass.Restaurant.SignUpClass.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 04.07.16.
 */
public class MainScreenSidebar {

    WebDriver driver;
    WebDriverWait waiting;

    public MainScreenSidebar(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "html/body/div[1]/div/div/sidebar/nav";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement menuToggle;

    private WebElement status;

    private WebElement sidebarSettingOpen;

    private WebElement sidebarSettingClose;

    private WebElement delivering;

    private WebElement notDelivering;

    private WebElement chat;

    private WebElement dashboard;

    private WebElement templates;

    private WebElement coworkers;

    private WebElement resto;

    private WebElement flaggedUsers;

    private WebElement settings;

    private WebElement marker;

    private WebElement socialFacebook;

    private WebElement socialTwitter;

    private WebElement socialGoogle;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("settings")));
                setMenuToggle(driver.findElement(By.id("menuToggle")));
                setStatus(driver.findElement(By.id("status")));
                setSidebarSettingOpen(driver.findElement(By.id("open")));
                setSidebarSettingClose(driver.findElement(By.id("close")));
                setDelivering(driver.findElement(By.id("delivering")));
                setNotDelivering(driver.findElement(By.id("not-delivering")));
                setChat(driver.findElement(By.id("chat")));
                setDashboard(driver.findElement(By.id("dashboard")));
                setTemplates(driver.findElement(By.id("templates")));
                setCoworkers(driver.findElement(By.id("coworkers")));
                setResto(driver.findElement(By.id("resto")));
                setFlaggedUsers(driver.findElement(By.id("flaggedUsers")));
                setSettings(driver.findElement(By.id("settings")));
                setMarker(driver.findElement(By.xpath(pathWeb + "/div[1]/ul/li[8]/div")));
                setSocialFacebook(driver.findElement(By.xpath(pathWeb + "/div[2]/a[3]")));
                setSocialTwitter(driver.findElement(By.xpath(pathWeb + "/div[2]/a[2]")));
                setSocialGoogle(driver.findElement(By.xpath(pathWeb + "/div[2]/a[1]")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
                setMenuToggle(driver.findElement(By.id("")));
                setStatus(driver.findElement(By.id("")));
                setSidebarSettingOpen(driver.findElement(By.id("")));
                setSidebarSettingClose(driver.findElement(By.id("")));
                setDelivering(driver.findElement(By.id("")));
                setNotDelivering(driver.findElement(By.id("")));
                setChat(driver.findElement(By.id("")));
                setDashboard(driver.findElement(By.id("")));
                setTemplates(driver.findElement(By.id("")));
                setCoworkers(driver.findElement(By.id("")));
                setResto(driver.findElement(By.id("")));
                setFlaggedUsers(driver.findElement(By.id("")));
                setSettings(driver.findElement(By.id("")));
                setMarker(driver.findElement(By.xpath(pathWeb + "")));
                setSocialFacebook(driver.findElement(By.xpath(pathWeb + "")));
                setSocialTwitter(driver.findElement(By.xpath(pathWeb + "")));
                setSocialGoogle(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
                setMenuToggle(driver.findElement(By.id("")));
                setStatus(driver.findElement(By.id("")));
                setSidebarSettingOpen(driver.findElement(By.id("")));
                setSidebarSettingClose(driver.findElement(By.id("")));
                setDelivering(driver.findElement(By.id("")));
                setNotDelivering(driver.findElement(By.id("")));
                setChat(driver.findElement(By.id("")));
                setDashboard(driver.findElement(By.id("")));
                setTemplates(driver.findElement(By.id("")));
                setCoworkers(driver.findElement(By.id("")));
                setResto(driver.findElement(By.id("")));
                setFlaggedUsers(driver.findElement(By.id("")));
                setSettings(driver.findElement(By.id("")));
                setMarker(driver.findElement(By.xpath(pathWeb + "")));
                setSocialFacebook(driver.findElement(By.xpath(pathWeb + "")));
                setSocialTwitter(driver.findElement(By.xpath(pathWeb + "")));
                setSocialGoogle(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }

    public WebElement getMenuToggle() {
        return menuToggle;
    }

    public void setMenuToggle(WebElement menuToggle) {
        this.menuToggle = menuToggle;
    }

    public WebElement getStatus() {
        return status;
    }

    public void setStatus(WebElement status) {
        this.status = status;
    }

    public WebElement getSidebarSettingOpen() {
        return sidebarSettingOpen;
    }

    public void setSidebarSettingOpen(WebElement sidebarSettingOpen) {
        this.sidebarSettingOpen = sidebarSettingOpen;
    }

    public WebElement getSidebarSettingClose() {
        return sidebarSettingClose;
    }

    public void setSidebarSettingClose(WebElement sidebarSettingClose) {
        this.sidebarSettingClose = sidebarSettingClose;
    }

    public WebElement getDelivering() {
        return delivering;
    }

    public void setDelivering(WebElement delivering) {
        this.delivering = delivering;
    }

    public WebElement getNotDelivering() {
        return notDelivering;
    }

    public void setNotDelivering(WebElement notDelivering) {
        this.notDelivering = notDelivering;
    }

    public WebElement getChat() {
        return chat;
    }

    public void setChat(WebElement chat) {
        this.chat = chat;
    }

    public WebElement getDashboard() {
        return dashboard;
    }

    public void setDashboard(WebElement dashboard) {
        this.dashboard = dashboard;
    }

    public WebElement getTemplates() {
        return templates;
    }

    public void setTemplates(WebElement templates) {
        this.templates = templates;
    }

    public WebElement getCoworkers() {
        return coworkers;
    }

    public void setCoworkers(WebElement coworkers) {
        this.coworkers = coworkers;
    }

    public WebElement getResto() {
        return resto;
    }

    public void setResto(WebElement resto) {
        this.resto = resto;
    }

    public WebElement getFlaggedUsers() {
        return flaggedUsers;
    }

    public void setFlaggedUsers(WebElement flaggedUsers) {
        this.flaggedUsers = flaggedUsers;
    }

    public WebElement getSettings() {
        return settings;
    }

    public void setSettings(WebElement settings) {
        this.settings = settings;
    }

    public WebElement getMarker() {
        return marker;
    }

    public void setMarker(WebElement marker) {
        this.marker = marker;
    }

    public WebElement getSocialFacebook() {
        return socialFacebook;
    }

    public void setSocialFacebook(WebElement socialFacebook) {
        this.socialFacebook = socialFacebook;
    }

    public WebElement getSocialTwitter() {
        return socialTwitter;
    }

    public void setSocialTwitter(WebElement socialTwitter) {
        this.socialTwitter = socialTwitter;
    }

    public WebElement getSocialGoogle() {
        return socialGoogle;
    }

    public void setSocialGoogle(WebElement socialGoogle) {
        this.socialGoogle = socialGoogle;
    }
}
