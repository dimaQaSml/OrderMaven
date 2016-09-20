package Restaurant.SignUpClass;

import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 30.05.16.
 */
public class SignUpStep4Class {

    WebDriver driver;
    WebDriverWait waiting;

    public SignUpStep4Class(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "html/body/div[1]/div/div[6]/div[3]/form";
    String pathIOS = "";
    String pathAndroid = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]" +
            "/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.support.v7.widget.RecyclerView[1]";

    private WebElement checkbox;

    private List<WebElement> listCheckbox;

    private List<WebElement> listOpening;

    private List<WebElement> listClosing;

    private WebElement opening;

    private WebElement closing;

    private WebElement openingList;

    private WebElement closingList;

    private WebElement signUpButton;

    private WebElement previousButton;

    private WebElement backDevice;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,15);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='0']")));
                setCheckbox(driver.findElement(By.xpath(".//*[@id='0']")));
                setListCheckbox(driver.findElements(By.xpath(pathWeb + "/div/label/label")));
                setListOpening(driver.findElements(By.xpath(pathWeb + "/div/input[1]")));
                setListClosing(driver.findElements(By.xpath(pathWeb + "/div/input[2]")));
                setOpening(driver.findElement(By.xpath(".//*[@id='100']")));
                setClosing(driver.findElement(By.xpath(".//*[@id='10']")));
                setSignUpButton(driver.findElement(By.id("submitHours")));
                setPreviousButton(driver.findElement(By.id("goStep3")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCheckbox(driver.findElement(By.xpath("")));
                setListCheckbox(driver.findElements(By.xpath(pathIOS + "")));
                setListOpening(driver.findElements(By.xpath(pathIOS + "")));
                setListClosing(driver.findElements(By.xpath(pathIOS + "")));
                setOpening(driver.findElement(By.xpath("")));
                setClosing(driver.findElement(By.xpath("")));
                setSignUpButton(driver.findElement(By.id("")));
                setPreviousButton(driver.findElement(By.id("")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                //setCheckbox(driver.findElement(By.xpath("")));
                setListCheckbox(driver.findElements(By.id("weekdayName")));
                setListOpening(driver.findElements(By.xpath(pathAndroid + "/android.widget.RelativeLayout/android.widget.LinearLayout[1]" +
                        "/android.widget.RelativeLayout[1]/android.widget.TextView[2]")));
                setListClosing(driver.findElements(By.xpath(pathAndroid + "android.widget.RelativeLayout/android.widget.LinearLayout[1]" +
                        "/android.widget.RelativeLayout[2]/android.widget.TextView[2]")));
                //setOpening(driver.findElement(By.xpath("")));
                //setClosing(driver.findElement(By.xpath("")));
                setSignUpButton(driver.findElement(By.id("nextButton")));
                setPreviousButton(driver.findElement(By.id("backButton")));
                setBackDevice(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]" +
                        "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")));
                break;
        }
    }

    public void signUpClick() throws InterruptedException {
        getCheckbox().click();
        getOpening().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]")));
        setOpeningList(driver.findElement(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]")));
        List<WebElement> allElementsOpening = driver.findElements(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]/ul/li"));
        for (WebElement element: allElementsOpening) {
            if(element.getText().equals("05:00")) {
                element.click();
                break;
            }
        }
        getClosing().click();

        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[2]")));
        setClosingList(driver.findElement(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[2]")));
        List<WebElement> allElementsClosing = driver.findElements(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[2]/ul/li"));
        for (WebElement element: allElementsClosing) {
            if(element.getText().equals("05:00")) {
                element.click();
                break;
            }
        }
        waiting.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[2]/ul/li")));
        getSignUpButton().click();
    }

    public void signUpFullClick() throws InterruptedException {
        for(int i=0;i<listCheckbox.size();i++){
            getListCheckbox().get(i).click();
            getListOpening().get(i).click();

            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div["+ (i+5) +"]/div[1]")));
            setOpeningList(driver.findElement(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]")));
            List<WebElement> allElementsOpening = driver.findElements(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[" + (i+5) + "]/div[1]/ul/li"));
            for (WebElement element: allElementsOpening) {
                if(element.getText().equals("05:00")) {
                    element.click();
                    break;
                }
            }
            getListClosing().get(i).click();

            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div["+ (i+5) +"]/div[2]")));
            setClosingList(driver.findElement(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div["+ (i+5) +"]/div[2]")));
            List<WebElement> allElementsClosing = driver.findElements(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div["+ (i+5) +"]/div[2]/ul/li"));
            for (WebElement element: allElementsClosing) {
                if(element.getText().equals("03:30")) {
                    element.click();
                    break;
                }
            }
        }

        waiting.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[2]/ul/li")));
        getSignUpButton().click();
    }

    public boolean testCase44(){
            //Проверяем только Monday - все остальные строки совпадают со строками из предыдущего шага)
            getCheckbox().click();
            //isSelected не прокатывает, поэтому проверяем доступность полей open и close
            if(!getOpening().isEnabled() && !getClosing().isEnabled()) {
                return false;
            }
        return true;
    }

    public boolean testCase47(){
            getCheckbox().click();
            getCheckbox().click();
            if(getOpening().isEnabled() && getClosing().isEnabled()) {
                return false;
            }
        return true;
    }

    public boolean testCase45(){
            getCheckbox().click();
            getOpening().click();
            try {
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]")));
                setOpeningList(driver.findElement(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]")));
            } catch (org.openqa.selenium.TimeoutException e){
                return false;
            }

            List<WebElement> allElements = driver.findElements(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]/ul/li"));
            for (WebElement element: allElements) {
                if(element.getText().equals("05:00")) {
                    element.click();
                    break;
                }
            }
        if(getOpening().getAttribute("value").equals("05:00")){
            return true;
        }
        return false;

    }

    public boolean testCase46(){
        getCheckbox().click();
        getClosing().click();
        try {
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]")));
            setClosingList(driver.findElement(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]")));
        } catch (org.openqa.selenium.TimeoutException e){
            return true;
        }

        List<WebElement> allElements = driver.findElements(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[5]/div[1]/ul/li"));
        for (WebElement element: allElements) {
            if(element.getText().equals("05:00")) {
                element.click();
                break;
            }
        }
        if(getClosing().getAttribute("value").equals("05:00")){
            return true;
        }
        return false;

    }

    public boolean testCase65(){
        getSignUpButton().click();
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[6]/div[3]/form/div[12]/span")));
        } catch (org.openqa.selenium.TimeoutException e){
            return false;
        }
        return true;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(WebElement checkbox) {
        this.checkbox = checkbox;
    }

    public WebElement getOpening() {
        return opening;
    }

    public void setOpening(WebElement opening) {
        this.opening = opening;
    }

    public WebElement getClosing() {
        return closing;
    }

    public void setClosing(WebElement closing) {
        this.closing = closing;
    }

    public WebElement getOpeningList() {
        return openingList;
    }

    public void setOpeningList(WebElement openingList) {
        this.openingList = openingList;
    }

    public WebElement getClosingList() {
        return closingList;
    }

    public void setClosingList(WebElement closingList) {
        this.closingList = closingList;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(WebElement signUpButton) {
        this.signUpButton = signUpButton;
    }

    public WebElement getPreviousButton() {
        return previousButton;
    }

    public void setPreviousButton(WebElement previousButton) {
        this.previousButton = previousButton;
    }

    public List<WebElement> getListCheckbox() {
        return listCheckbox;
    }

    public void setListCheckbox(List<WebElement> listCheckbox) {
        this.listCheckbox = listCheckbox;
    }

    public List<WebElement> getListOpening() {
        return listOpening;
    }

    public void setListOpening(List<WebElement> listOpening) {
        this.listOpening = listOpening;
    }

    public List<WebElement> getListClosing() {
        return listClosing;
    }

    public void setListClosing(List<WebElement> listClosing) {
        this.listClosing = listClosing;
    }

    public WebElement getBackDevice() {
        return backDevice;
    }

    public void setBackDevice(WebElement backDevice) {
        this.backDevice = backDevice;
    }
}
