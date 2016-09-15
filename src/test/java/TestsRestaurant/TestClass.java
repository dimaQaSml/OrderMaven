package TestsRestaurant;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dmitry on 14.09.16.
 */
public class TestClass {

    WebDriver driver;

    @Before
    public void before(){
        driver = new FirefoxDriver();
        driver.get("https://web.pechkin-mail.ru/registration4.php");
    }

    @Test
    public void test(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[4]/div[2]/a[1]")));
        //driver.findElement(By.xpath("html/body/div[2]/div[4]/div[2]/a[1]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("$('#recaptcha-anchor').setAttribute('aria-checked','true');");
        //js.executeScript("$('#recaptcha-anchor').attr('aria-checked','true');");
        js.executeScript("arguments[0].setAttribute('aria-checked','true');");

    }

}
