package TestClass.Restaurant.MobileCategories;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 28.06.16.
 */
public class SignUpStep2AddMenuPhotosClass {

    WebDriver driver;
    WebDriverWait waiting;

    public SignUpStep2AddMenuPhotosClass(WebDriver driver){
        this.driver = driver;
    }

    String pathAndroid = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]";
    String pathIOS = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]";

    private WebElement addPicturesCorner;

    private WebElement addPictures;

    private WebElement backButton;

    private WebElement skipButton;

    private WebElement sendButton;

    private WebElement backMobile;

    private List<WebElement> photoList;

    private List<WebElement> photoCloseList;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,40);
        switch (GlobalMethods.chooseDevice()) {
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")));
                setAddPictures(driver.findElement(By.xpath(pathIOS + "/UIAButton[1]")));
                setAddPicturesCorner(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[3]")));
                setBackButton(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")));
                setSkipButton(driver.findElement(By.name("Skip")));
                setSkipButton(driver.findElement(By.name("Send")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("nextButton")));
                setAddPicturesCorner(driver.findElement(By.id("addButton")));
                setBackButton(driver.findElement(By.id("backButton")));
                setSkipButton(driver.findElement(By.id("nextButton")));
                setBackMobile(driver.findElement(By.xpath(pathAndroid + "/android.widget.ImageButton[1]")));
                setPhotoList(driver.findElements(By.xpath("/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.ImageView[1]")));
                setPhotoCloseList(driver.findElements(By.xpath(pathAndroid + "/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.ImageButton[1]")));
                break;
        }
    }

    public WebElement getAddPicturesCorner() {
        return addPicturesCorner;
    }

    public void setAddPicturesCorner(WebElement addPicturesCorner) {
        this.addPicturesCorner = addPicturesCorner;
    }

    public WebElement getAddPictures() {
        return addPictures;
    }

    public void setAddPictures(WebElement addPictures) {
        this.addPictures = addPictures;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public void setBackButton(WebElement backButton) {
        this.backButton = backButton;
    }

    public WebElement getSkipButton() {
        return skipButton;
    }

    public void setSkipButton(WebElement skipButton) {
        this.skipButton = skipButton;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public void setSendButton(WebElement sendButton) {
        this.sendButton = sendButton;
    }

    public WebElement getBackMobile() {
        return backMobile;
    }

    public void setBackMobile(WebElement backMobile) {
        this.backMobile = backMobile;
    }

    public List<WebElement> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<WebElement> photoList) {
        this.photoList = photoList;
    }

    public List<WebElement> getPhotoCloseList() {
        return photoCloseList;
    }

    public void setPhotoCloseList(List<WebElement> photoCloseList) {
        this.photoCloseList = photoCloseList;
    }
}
