package Client.MainScreenSidebarClass;

import Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddPaymentsClass;
import Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import GlobalMethods.GlobalMethods;
import Restaurant.MainScreenSidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 03.06.16.
 */
public class MainScreenClass {

    WebDriver driver;
    WebDriverWait waiting;

    public MainScreenClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = ".//*[@id='Container']/div[3]/div/div[1]";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement logo;

    private WebElement fullName;

    private WebElement emailAddress;

    private WebElement favoriteOrderSection;

    private WebElement addressSection;

    private WebElement paymentSection;

    private List<WebElement> quickOrderList;

    private List<WebElement> editQuickOrderList;

    private List<WebElement> orderNowList;

    private WebElement addQuickOrder;

    private List<WebElement> beforeQuickOrder;

    private WebElement restaurantsScreen;

    private WebElement chatScreen;

    private WebElement myProfileScreen;

    private WebElement hebrewScreen;

    private WebElement settingScreen;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Container']/div[3]/div/div[1]/div[1]/div[2]/label")));
                setLogo(driver.findElement(By.xpath(pathWeb + "/div[1]/div[2]/label")));
                setFullName(driver.findElement(By.xpath(pathWeb + "/div[2]/div/div[1]/input")));
                setEmailAddress(driver.findElement(By.xpath(pathWeb + "/div[2]/div/div[2]/input")));
                setFavoriteOrderSection(driver.findElement(By.xpath(pathWeb + "")));
                setQuickOrderList(driver.findElements(By.xpath(pathWeb + "")));
                setEditQuickOrderList(driver.findElements(By.xpath(pathWeb + "")));
                setOrderNowList(driver.findElements(By.xpath(pathWeb + "")));
                setAddQuickOrder(driver.findElement(By.xpath(pathWeb + "")));
                setAddressSection(driver.findElement(By.xpath(pathWeb + "")));
                setPaymentSection(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantsScreen(driver.findElement(By.xpath(pathWeb + "")));
                setChatScreen(driver.findElement(By.xpath(pathWeb + "")));
                setMyProfileScreen(driver.findElement(By.xpath(pathWeb + "")));
                setHebrewScreen(driver.findElement(By.xpath(pathWeb + "")));
                setSettingScreen(driver.findElement(By.xpath(pathWeb + "")));
                beforeQuickOrder = countQuickOrderElementsBefore();
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setLogo(driver.findElement(By.xpath(pathWeb + "")));
                setFullName(driver.findElement(By.xpath(pathWeb + "")));
                setEmailAddress(driver.findElement(By.xpath(pathWeb + "")));
                setFavoriteOrderSection(driver.findElement(By.xpath(pathWeb + "")));
                setQuickOrderList(driver.findElements(By.xpath(pathWeb + "")));
                setEditQuickOrderList(driver.findElements(By.xpath(pathWeb + "")));
                setOrderNowList(driver.findElements(By.xpath(pathWeb + "")));
                setAddQuickOrder(driver.findElement(By.xpath(pathWeb + "")));
                setAddressSection(driver.findElement(By.xpath(pathWeb + "")));
                setPaymentSection(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantsScreen(driver.findElement(By.xpath(pathWeb + "")));
                setChatScreen(driver.findElement(By.xpath(pathWeb + "")));
                setMyProfileScreen(driver.findElement(By.xpath(pathWeb + "")));
                setHebrewScreen(driver.findElement(By.xpath(pathWeb + "")));
                setSettingScreen(driver.findElement(By.xpath(pathWeb + "")));
                beforeQuickOrder = countQuickOrderElementsBefore();
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setLogo(driver.findElement(By.xpath(pathWeb + "")));
                setFullName(driver.findElement(By.xpath(pathWeb + "")));
                setEmailAddress(driver.findElement(By.xpath(pathWeb + "")));
                setFavoriteOrderSection(driver.findElement(By.xpath(pathWeb + "")));
                setQuickOrderList(driver.findElements(By.xpath(pathWeb + "")));
                setEditQuickOrderList(driver.findElements(By.xpath(pathWeb + "")));
                setOrderNowList(driver.findElements(By.xpath(pathWeb + "")));
                setAddQuickOrder(driver.findElement(By.xpath(pathWeb + "")));
                setAddressSection(driver.findElement(By.xpath(pathWeb + "")));
                setPaymentSection(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantsScreen(driver.findElement(By.xpath(pathWeb + "")));
                setChatScreen(driver.findElement(By.xpath(pathWeb + "")));
                setMyProfileScreen(driver.findElement(By.xpath(pathWeb + "")));
                setHebrewScreen(driver.findElement(By.xpath(pathWeb + "")));
                setSettingScreen(driver.findElement(By.xpath(pathWeb + "")));
                beforeQuickOrder = countQuickOrderElementsBefore();
                break;
        }
    }

    public List<WebElement> countQuickOrderElementsBefore(){
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            setQuickOrderList(driver.findElements(By.xpath(pathWeb + "")));
        } catch (org.openqa.selenium.TimeoutException e){
            return null;
        }
        return getQuickOrderList();
    }

    public void favoriteOrderSectionClick(){
        getFavoriteOrderSection().click();
    }

    public void addressSectionClick(){
        getAddressSection().click();
    }

    public void paymentSectionClick(){
        getPaymentSection().click();
    }

    public void addQuickOrder(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        getAddQuickOrder().click();
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.addQuickOrderSelectValue();
    }

    public boolean checkCountQuickOrder(){
        if(getQuickOrderList().size()>beforeQuickOrder.size()){
            return true;
        } else{
            return false;
        }
    }

    public boolean testCase64(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        addQuickOrder(mainScreenSidebarAddQuickOrderClass);
        if(checkCountQuickOrder()) {
            getQuickOrderList().get(0).click();
            try {
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                getOrderNowList().get(0).click();
            } catch (org.openqa.selenium.TimeoutException e) {
                return false;
            }
            return true;
        } else {
            return  false;
        }
    }

    public boolean testCase65(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        addQuickOrder(mainScreenSidebarAddQuickOrderClass);
        if(checkCountQuickOrder()) {
            getQuickOrderList().get(0).click();
            try {
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                getEditQuickOrderList().get(0).click();
            } catch (org.openqa.selenium.TimeoutException e) {
                return false;
            }
            return true;
        } else {
            return  false;
        }
    }

    public boolean testCase67(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        addQuickOrder(mainScreenSidebarAddQuickOrderClass);
        if(checkCountQuickOrder()) {
            getQuickOrderList().get(0).click();
            try {
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                getEditQuickOrderList().get(0).click();
                mainScreenSidebarAddQuickOrderClass.chooseDevice();
                mainScreenSidebarAddQuickOrderClass.editQuickOrder();
                mainScreenSidebarAddQuickOrderClass.getSubmitButton().click();
                //Повторно открываем EditQuickOrder для проверки значений
                getQuickOrderList().get(0).click();
                getEditQuickOrderList().get(0).click();
                mainScreenSidebarAddQuickOrderClass.chooseDevice();
                if(mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().getAttribute("value").equals(GlobalMethods.getOrderEdit()) &&
                        mainScreenSidebarAddQuickOrderClass.getAddress().getAttribute("value").contains(GlobalMethods.getCityEdit()) &&
                                mainScreenSidebarAddQuickOrderClass.getAddress().getAttribute("value").contains(GlobalMethods.getAddressEdit()) &&
                                mainScreenSidebarAddQuickOrderClass.getAddress().getAttribute("value").contains(GlobalMethods.getHomeEdit()) &&
                                        mainScreenSidebarAddQuickOrderClass.getPayment().getAttribute("value").contains(GlobalMethods.getNameCardEdit())){
                    return true;
                } else {
                    return false;
                }
            } catch (org.openqa.selenium.TimeoutException e) {
                return false;
            }
        } else {
            return  false;
        }
    }

    public boolean testCase68(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        addQuickOrder(mainScreenSidebarAddQuickOrderClass);
        if(checkCountQuickOrder()) {
            getQuickOrderList().get(0).click();
            try {
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                getEditQuickOrderList().get(0).click();
                mainScreenSidebarAddQuickOrderClass.chooseDevice();
                mainScreenSidebarAddQuickOrderClass.editQuickOrder();
                mainScreenSidebarAddQuickOrderClass.getCancelButton().click();
                //Повторно открываем EditQuickOrder для проверки значений
                getQuickOrderList().get(0).click();
                getEditQuickOrderList().get(0).click();
                mainScreenSidebarAddQuickOrderClass.chooseDevice();
                if(mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().getAttribute("value").equals(GlobalMethods.getOrder()) &&
                        mainScreenSidebarAddQuickOrderClass.getAddress().getAttribute("value").contains(GlobalMethods.getCity()) &&
                        mainScreenSidebarAddQuickOrderClass.getAddress().getAttribute("value").contains(GlobalMethods.getAddress()) &&
                        mainScreenSidebarAddQuickOrderClass.getAddress().getAttribute("value").contains(GlobalMethods.getHome()) &&
                        mainScreenSidebarAddQuickOrderClass.getPayment().getAttribute("value").contains(GlobalMethods.getNameCard())){
                    return true;
                } else {
                    return false;
                }
            } catch (org.openqa.selenium.TimeoutException e) {
                return false;
            }
        } else {
            return  false;
        }
    }

    public boolean testCase69(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        addQuickOrder(mainScreenSidebarAddQuickOrderClass);
        if(checkCountQuickOrder()) {
            return true;
        } else {
            return  false;
        }
    }

    public boolean testCase70(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        getAddQuickOrder().click();
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys("testUncorrectOrder");
        mainScreenSidebarAddQuickOrderClass.getAddress().sendKeys("testUncorrectAddress");
        mainScreenSidebarAddQuickOrderClass.getPayment().sendKeys("testUncorrectPayment");
        mainScreenSidebarAddQuickOrderClass.getSubmitButton().click();
        if(checkCountQuickOrder()) {
            return true;
        } else {
            return  false;
        }
    }

    public boolean testCase71(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        getAddQuickOrder().click();
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        if(mainScreenSidebarAddQuickOrderClass.getSubmitButton().isEnabled()){
            return true;
        } else{
            return false;
        }
    }

    public boolean testCase77(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        getAddQuickOrder().click();
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getFavoriteOrderSelect().click();
        mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).click();
        MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);
        try {
            mainScreenSidebarAddOrderClass.chooseDevice();
        } catch (org.openqa.selenium.StaleElementReferenceException e){
            return false;
        }
        return true;
    }

    public boolean testCase79(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        getAddQuickOrder().click();
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getAddressSelect().click();
        mainScreenSidebarAddQuickOrderClass.getAddressElementsList().get(0).click();
        MainScreenSidebarAddAddressClass mainScreenSidebarAddAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddAddressClass.class);
        try {
            mainScreenSidebarAddAddressClass.chooseDevice();
        } catch (org.openqa.selenium.StaleElementReferenceException e){
            return false;
        }
        return true;
    }

    public boolean testCase81(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        getAddQuickOrder().click();
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getPaymentSelect().click();
        mainScreenSidebarAddQuickOrderClass.getPaymentElementsList().get(0).click();
        MainScreenSidebarAddPaymentsClass mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarAddPaymentsClass.class);
        try {
            mainScreenSidebarAddPaymentsClass.chooseDevice();
        } catch (org.openqa.selenium.StaleElementReferenceException e){
            return false;
        }
        return true;
    }

    public boolean testCase78(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        getAddQuickOrder().click();
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getFavoriteOrderSelect().click();
        mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().get(0).click();
        int beforeElementsListCount = mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().size();
        MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);
        mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(),GlobalMethods.getOrder());
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getFavoriteOrderSelect().click();
        if(beforeElementsListCount<mainScreenSidebarAddQuickOrderClass.getFavoriteOrderElementsList().size()){
            return true;
        } else{
            return false;
        }
    }

    public boolean testCase80(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        getAddQuickOrder().click();
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getAddressSelect().click();
        mainScreenSidebarAddQuickOrderClass.getAddressElementsList().get(0).click();
        int beforeElementsListCount = mainScreenSidebarAddQuickOrderClass.getAddressElementsList().size();
        MainScreenSidebarAddAddressClass mainScreenSidebarAddAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddAddressClass.class);
        mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCity(), GlobalMethods.getAddress(), GlobalMethods.getHome());
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getAddressSelect().click();
        if(beforeElementsListCount < mainScreenSidebarAddQuickOrderClass.getAddressElementsList().size()){
            return true;
        } else{
            return false;
        }
    }

    public boolean testCase82(MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass) throws InterruptedException {
        getAddQuickOrder().click();
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getPaymentSelect().click();
        mainScreenSidebarAddQuickOrderClass.getPaymentElementsList().get(0).click();
        int beforeElementsListCount = mainScreenSidebarAddQuickOrderClass.getPaymentElementsList().size();
        MainScreenSidebarAddPaymentsClass mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarAddPaymentsClass.class);
        mainScreenSidebarAddPaymentsClass.addPayment(GlobalMethods.getNumberCard1(), GlobalMethods.getNumberCard2(), GlobalMethods.getDateCardMonth(), GlobalMethods.getDateCardYear(), GlobalMethods.getCvvCard());
        mainScreenSidebarAddQuickOrderClass.chooseDevice();
        mainScreenSidebarAddQuickOrderClass.getPaymentSelect().click();
        if(beforeElementsListCount < mainScreenSidebarAddQuickOrderClass.getPaymentElementsList().size()){
            return true;
        } else{
            return false;
        }
    }



    public WebElement getLogo() {
        return logo;
    }

    public void setLogo(WebElement logo) {
        this.logo = logo;
    }

    public WebElement getFullName() {
        return fullName;
    }

    public void setFullName(WebElement fullName) {
        this.fullName = fullName;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(WebElement emailAddress) {
        this.emailAddress = emailAddress;
    }

    public WebElement getFavoriteOrderSection() {
        return favoriteOrderSection;
    }

    public void setFavoriteOrderSection(WebElement favoriteOrderSection) {
        this.favoriteOrderSection = favoriteOrderSection;
    }

    public WebElement getAddressSection() {
        return addressSection;
    }

    public void setAddressSection(WebElement addressSection) {
        this.addressSection = addressSection;
    }

    public WebElement getPaymentSection() {
        return paymentSection;
    }

    public void setPaymentSection(WebElement paymentSection) {
        this.paymentSection = paymentSection;
    }

    public List<WebElement> getQuickOrderList() {
        return quickOrderList;
    }

    public void setQuickOrderList(List<WebElement> quickOrderList) {
        this.quickOrderList = quickOrderList;
    }

    public List<WebElement> getEditQuickOrderList() {
        return editQuickOrderList;
    }

    public void setEditQuickOrderList(List<WebElement> editQuickOrderList) {
        this.editQuickOrderList = editQuickOrderList;
    }

    public List<WebElement> getOrderNowList() {
        return orderNowList;
    }

    public void setOrderNowList(List<WebElement> orderNowList) {
        this.orderNowList = orderNowList;
    }

    public WebElement getAddQuickOrder() {
        return addQuickOrder;
    }

    public void setAddQuickOrder(WebElement addQuickOrder) {
        this.addQuickOrder = addQuickOrder;
    }

    public WebElement getRestaurantsScreen() {
        return restaurantsScreen;
    }

    public void setRestaurantsScreen(WebElement restaurantsScreen) {
        this.restaurantsScreen = restaurantsScreen;
    }

    public WebElement getChatScreen() {
        return chatScreen;
    }

    public void setChatScreen(WebElement chatScreen) {
        this.chatScreen = chatScreen;
    }

    public WebElement getMyProfileScreen() {
        return myProfileScreen;
    }

    public void setMyProfileScreen(WebElement myProfileScreen) {
        this.myProfileScreen = myProfileScreen;
    }

    public WebElement getHebrewScreen() {
        return hebrewScreen;
    }

    public void setHebrewScreen(WebElement hebrewScreen) {
        this.hebrewScreen = hebrewScreen;
    }

    public WebElement getSettingScreen() {
        return settingScreen;
    }

    public void setSettingScreen(WebElement settingScreen) {
        this.settingScreen = settingScreen;
    }
}
