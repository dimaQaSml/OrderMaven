package Restaurant.MobileCategories;

import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 28.06.16.
 */
public class SignUpStep2CategoriesClass {

    WebDriver driver;
    WebDriverWait waiting;

    public SignUpStep2CategoriesClass(WebDriver driver){
        this.driver = driver;
    }

    String pathAndroid = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]" +
            "/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]";
    String pathIOS = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]";

    private WebElement search;

    private WebElement categories;

    private List<WebElement> kosherList;

    private List<WebElement> notKosherList;

    private WebElement okButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,40);
        switch (GlobalMethods.chooseDevice()) {
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.name("Ok")));
                setSearch(driver.findElement(By.xpath(pathIOS + "/UIASearchBar[1]")));
                setCategories(driver.findElement(By.xpath(pathIOS + "/UIASwitch[1]")));
                setKosherList(driver.findElements(By.xpath(pathIOS + "/UIATableView[1]/UIATableCell")));
                setNotKosherList(driver.findElements(By.xpath(pathIOS + "/UIATableView[1]/UIATableCell")));
                setOkButton(driver.findElement(By.name("Ok")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchEditText")));
                setSearch(driver.findElement(By.id("searchEditText")));
                setCategories(driver.findElement(By.id("mandatoryCategorySwitch")));
                setKosherList(driver.findElements(By.xpath(pathAndroid + "android.widget.RelativeLayout/android.widget.CheckBox[1]")));
                setNotKosherList(driver.findElements(By.xpath(pathAndroid + "android.widget.RelativeLayout/android.widget.CheckBox[1]")));
                setOkButton(driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]" +
                        "/android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.Button[1]")));
                break;
        }
    }

    public WebElement getSearch() {
        return search;
    }

    public void setSearch(WebElement search) {
        this.search = search;
    }

    public WebElement getCategories() {
        return categories;
    }

    public void setCategories(WebElement categories) {
        this.categories = categories;
    }

    public List<WebElement> getKosherList() {
        return kosherList;
    }

    public void setKosherList(List<WebElement> kosherList) {
        this.kosherList = kosherList;
    }

    public List<WebElement> getNotKosherList() {
        return notKosherList;
    }

    public void setNotKosherList(List<WebElement> notKosherList) {
        this.notKosherList = notKosherList;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public void setOkButton(WebElement okButton) {
        this.okButton = okButton;
    }
}
