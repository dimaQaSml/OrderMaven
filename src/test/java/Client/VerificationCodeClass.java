package Client;

import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 18.05.16.
 */
public class VerificationCodeClass {
    WebDriver driver;
    WebDriverWait waiting;

    public VerificationCodeClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = ".//*[@id='ModalContainer']/div/div/div[3]";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement changeMobileNumber;

    private WebElement resendButton;

    private WebElement verificationCodeInput;


    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ModalContainer']/div/div/div[3]/p[2]/span")));
                setChangeMobileNumber(driver.findElement(By.xpath(pathWeb + "/p[2]/span")));
                setResendButton(driver.findElement(By.xpath(".//*[@id='ModalContainer']/div/div/div[4]/p/span")));
                setVerificationCodeInput(driver.findElement(By.xpath(pathWeb + "/input")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setChangeMobileNumber(driver.findElement(By.xpath(pathWeb + "")));
                setResendButton(driver.findElement(By.xpath("")));
                setVerificationCodeInput(driver.findElement(By.xpath(pathWeb + "")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setChangeMobileNumber(driver.findElement(By.xpath(pathWeb + "")));
                setResendButton(driver.findElement(By.xpath("")));
                setVerificationCodeInput(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }


    public void resendButtonClick(){
        getResendButton().click();
    }

    public void changeMobileNumbeButtonClick(){
        getChangeMobileNumber().click();
    }

    public void verificationCode(String code){
        getVerificationCodeInput().sendKeys(code);
    }



    public WebElement getChangeMobileNumber() {
        return changeMobileNumber;
    }

    public void setChangeMobileNumber(WebElement changeMobileNumber) {
        this.changeMobileNumber = changeMobileNumber;
    }

    public WebElement getResendButton() {
        return resendButton;
    }

    public void setResendButton(WebElement resendButton) {
        this.resendButton = resendButton;
    }

    public WebElement getVerificationCodeInput() {
        return verificationCodeInput;
    }

    public void setVerificationCodeInput(WebElement verificationCodeInput) {
        this.verificationCodeInput = verificationCodeInput;
    }
}
