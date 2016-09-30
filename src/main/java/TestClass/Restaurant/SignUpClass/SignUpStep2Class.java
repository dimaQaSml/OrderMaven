package TestClass.Restaurant.SignUpClass;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 12.05.16.
 */
public class SignUpStep2Class {

    WebDriver driver;
    WebDriverWait waiting;

    public SignUpStep2Class(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "html/body/div[1]/div/div[4]/div[3]/form";
    String pathAndroid = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]" +
            "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]" +
            "/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]";
    String pathIOS = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]";

    private WebElement logoImage;

    private WebElement logoButton;

    private WebElement kosherInput;

    private WebElement notKosherInput;

    private WebElement restoImageClose;

    private WebElement restoImage;

    private WebElement restoImageButton;

    private WebElement restoImageArea;

    private WebElement menuImageClose;

    private WebElement menuImage;

    private WebElement menuImageButton;

    private WebElement menuImageArea;

    private WebElement backButton;

    private WebElement signUpButton;

    private WebElement nameRestaurant;

    private WebElement kosherInputData;

    private WebElement notKosherInputData;

    public List<WebElement> categoriesList;

    private WebElement chooseCategories;

    private WebElement descriptionMobile;

    private WebElement backMobile;

    private List<WebElement> categoriesCloseMobile;

    private WebElement bannerMobile;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,40);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[4]/div[3]/div[3]/input")));
                setLogoImage(driver.findElement(By.xpath(pathWeb + "/div[1]/img")));
                setLogoButton(driver.findElement(By.xpath(pathWeb + "/div[2]/input[2]")));
                setNameRestaurant(driver.findElement(By.xpath(pathWeb + "/input")));
                setKosherInput(driver.findElement(By.xpath(pathWeb + "/div[5]/div[1]/label[2]")));
                setNotKosherInput(driver.findElement(By.xpath(pathWeb + "/div[5]/div[2]/label[2]")));
                setRestoImageButton(driver.findElement(By.xpath(pathWeb + "/div[8]/input[2]")));
                setMenuImageButton(driver.findElement(By.xpath(pathWeb + "/div[10]/input[2]")));
                setBackButton(driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[3]/div[2]/input")));
                setSignUpButton(driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[3]/div[3]/input")));
                setKosherInputData(driver.findElement(By.xpath(pathWeb + "/div[5]/div[1]/input[1]")));
                setNotKosherInputData(driver.findElement(By.xpath(pathWeb + "/div[5]/div[2]/input[1]")));
                setCategoriesList(driver.findElements(By.xpath(pathWeb + "/div[6]/div/label")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("Send")));
                setLogoImage(driver.findElement(By.xpath(pathIOS + "/UIAButton[1]")));
                setNameRestaurant(driver.findElement(By.xpath(pathIOS + "UIATextField[1]")));
                setChooseCategories(driver.findElement(By.xpath(pathIOS + "UIAButton[2]")));
                setDescriptionMobile(driver.findElement(By.xpath(pathIOS + "UIATextView[1]")));
                setSignUpButton(driver.findElement(By.name("Send")));
                setCategoriesList(driver.findElements(By.xpath(pathWeb + "/UIACollectionView[1]/UIACollectionCell")));
                setCategoriesCloseMobile(driver.findElements(By.xpath(pathWeb + "/UIACollectionView[1]/UIACollectionCell[2]/UIAButton")));
                setBackMobile(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("banner")));
                setNameRestaurant(driver.findElement(By.id("restaurantName")));
                setChooseCategories(driver.findElement(By.xpath(pathAndroid + "/android.widget.TextView[3]")));
                setDescriptionMobile(driver.findElement(By.id("description")));
                setSignUpButton(driver.findElement(By.id("nextButton")));
                setCategoriesList(driver.findElements(By.id("categoryList")));
                setCategoriesCloseMobile(driver.findElements(By.xpath(pathAndroid + "android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[1]")));
                setBackMobile(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]" +
                        "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")));
                setBannerMobile(driver.findElement(By.id("banner")));
                break;
        }
    }


    public void signUpClick(String name,String imageFileName,String menuFileName){
        addPhotoLogo();
        getNameRestaurant().sendKeys(name);
        addRestoImages(imageFileName);
        addPhotoMenu(menuFileName);
        getSignUpButton().click();
    }

    public void signUpFullClick(String name,String imageFileName,String menuFileName) throws InterruptedException {
        addPhotoLogo();
        getKosherInput().click();
        for(WebElement element: getCategoriesList()){
            element.click();
        }
        getNameRestaurant().sendKeys(name);
        addRestoImages(imageFileName);
        addPhotoMenu(menuFileName);
        getSignUpButton().click();
    }

    public void signUpEmptyClick(String name){
        getNameRestaurant().sendKeys(name);
        getSignUpButton().click();
    }

    public boolean checkCombobox(){
        boolean condition1, condition2;
        if(getNotKosherInputData().getAttribute("class").contains("ng-valid-parse") && !getKosherInputData().getAttribute("class").contains("ng-valid-parse")) {
            condition1 = true;
        } else {
            condition1 = false;
        }
        getKosherInput().click();
        if(getKosherInputData().getAttribute("class").contains("ng-valid-parse") && !getNotKosherInputData().getAttribute("class").contains("ng-valid-parse")) {
            condition2 = true;
        } else {
            condition2 = false;
        }
        if(condition1 == false || condition2 == false){
            return false;
        } else {
            return true;
        }
    }

    public void addPhotoLogo(){
        getLogoButton().sendKeys("/Users/dmitry/Desktop/йцу.jpg");
    }

    public void addRestoImages(String imageFileName){
        getRestoImageButton().sendKeys("/Users/dmitry/Desktop/" + imageFileName);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[4]/div[3]/form/div[7]/div/div/span")));
        setRestoImageClose(driver.findElement(By.xpath(pathWeb + "/div[7]/div/div/span")));
        setRestoImage(driver.findElement(By.xpath(pathWeb + "/div[7]/div/div/img")));
        setRestoImageArea(driver.findElement(By.xpath(pathWeb + "/div[7]")));
    }

    public void addPhotoMenu(String menuFileName){
        getMenuImageButton().sendKeys("/Users/dmitry/Desktop/" + menuFileName);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[4]/div[3]/form/div[9]/div/div/span")));
        setMenuImageClose(driver.findElement(By.xpath(pathWeb + "/div[9]/div/div/span")));
        setMenuImage(driver.findElement(By.xpath(pathWeb + "/div[9]/div/div/img")));
        setMenuImageArea(driver.findElement(By.xpath(pathWeb + "/div[9]")));
    }

    public void addPhotoFiveImages(){
        getRestoImageButton().sendKeys("/Users/dmitry/Desktop/xcv.jpg");
        getRestoImageButton().sendKeys("/Users/dmitry/Desktop/sdf.jpg");
        getRestoImageButton().sendKeys("/Users/dmitry/Desktop/wert.jpeg");
        getRestoImageButton().sendKeys("/Users/dmitry/Desktop/images.jpg");
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[4]/div[3]/form/div[7]/div[4]/div/span")));
        setRestoImageClose(driver.findElement(By.xpath(pathWeb + "/div[7]/div[4]/div/span")));
        setRestoImageArea(driver.findElement(By.xpath(pathWeb + "/div[7]")));
    }

    public void addPhotoFiveMenu(){
        getMenuImageButton().sendKeys("/Users/dmitry/Desktop/xcv.jpg");
        getMenuImageButton().sendKeys("/Users/dmitry/Desktop/sdf.jpg");
        getMenuImageButton().sendKeys("/Users/dmitry/Desktop/wert.jpeg");
        getMenuImageButton().sendKeys("/Users/dmitry/Desktop/images.jpg");
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[4]/div[3]/form/div[9]/div[4]/div/span")));
        setMenuImageClose(driver.findElement(By.xpath(pathWeb + "/div[9]/div[4]/div/span")));
        setMenuImageArea(driver.findElement(By.xpath(pathWeb + "/div[9]")));
    }

    public WebElement getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(WebElement logoImage) {
        this.logoImage = logoImage;
    }

    public WebElement getLogoButton() {
        return logoButton;
    }

    public void setLogoButton(WebElement logoButton) {
        this.logoButton = logoButton;
    }

    public WebElement getKosherInput() {
        return kosherInput;
    }

    public void setKosherInput(WebElement kosherInput) {
        this.kosherInput = kosherInput;
    }

    public WebElement getNotKosherInput() {
        return notKosherInput;
    }

    public void setNotKosherInput(WebElement notKosherInput) {
        this.notKosherInput = notKosherInput;
    }

    public WebElement getRestoImageClose() {
        return restoImageClose;
    }

    public void setRestoImageClose(WebElement restoImageClose) {
        this.restoImageClose = restoImageClose;
    }

    public WebElement getRestoImage() {
        return restoImage;
    }

    public void setRestoImage(WebElement restoImage) {
        this.restoImage = restoImage;
    }

    public WebElement getRestoImageButton() {
        return restoImageButton;
    }

    public void setRestoImageButton(WebElement restoImageButton) {
        this.restoImageButton = restoImageButton;
    }

    public WebElement getMenuImageClose() {
        return menuImageClose;
    }

    public void setMenuImageClose(WebElement menuImageClose) {
        this.menuImageClose = menuImageClose;
    }

    public WebElement getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(WebElement menuImage) {
        this.menuImage = menuImage;
    }

    public WebElement getMenuImageButton() {
        return menuImageButton;
    }

    public void setMenuImageButton(WebElement menuImageButton) {
        this.menuImageButton = menuImageButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public void setBackButton(WebElement backButton) {
        this.backButton = backButton;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(WebElement signUpButton) {
        this.signUpButton = signUpButton;
    }

    public WebElement getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(WebElement nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public WebElement getRestoImageArea() {
        return restoImageArea;
    }

    public void setRestoImageArea(WebElement restoImageArea) {
        this.restoImageArea = restoImageArea;
    }

    public WebElement getMenuImageArea() {
        return menuImageArea;
    }

    public void setMenuImageArea(WebElement menuImageArea) {
        this.menuImageArea = menuImageArea;
    }

    public WebElement getKosherInputData() {
        return kosherInputData;
    }

    public void setKosherInputData(WebElement kosherInputData) {
        this.kosherInputData = kosherInputData;
    }

    public WebElement getNotKosherInputData() {
        return notKosherInputData;
    }

    public void setNotKosherInputData(WebElement notKosherInputData) {
        this.notKosherInputData = notKosherInputData;
    }

    public List<WebElement> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<WebElement> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public WebElement getChooseCategories() {
        return chooseCategories;
    }

    public void setChooseCategories(WebElement chooseCategories) {
        this.chooseCategories = chooseCategories;
    }

    public WebElement getDescriptionMobile() {
        return descriptionMobile;
    }

    public void setDescriptionMobile(WebElement descriptionMobile) {
        this.descriptionMobile = descriptionMobile;
    }

    public List<WebElement> getCategoriesCloseMobile() {
        return categoriesCloseMobile;
    }

    public void setCategoriesCloseMobile(List<WebElement> categoriesCloseMobile) {
        this.categoriesCloseMobile = categoriesCloseMobile;
    }

    public WebElement getBackMobile() {
        return backMobile;
    }

    public void setBackMobile(WebElement backMobile) {
        this.backMobile = backMobile;
    }

    public WebElement getBannerMobile() {
        return bannerMobile;
    }

    public void setBannerMobile(WebElement bannerMobile) {
        this.bannerMobile = bannerMobile;
    }
}
