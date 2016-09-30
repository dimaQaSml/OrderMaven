package TestsClient.MainScreenSidebarAddTest;

import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddAddressClass;
import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddOrderClass;
import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddPaymentsClass;
import TestClass.Client.MainScreenSidebarAddClass.MainScreenSidebarAddQuickOrderClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarAddressClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarFavoriteOrderClass;
import TestClass.Client.MainScreenSidebarClass.MainScreenSidebarPaymentsClass;
import TestClass.Client.SignInClass;
import TestClass.GlobalMethods.GlobalMethods;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitry on 07.06.16.
 */
public class MainScreenSidebarAddQuickOrderTest {

    WebDriver driver;
    SignInClass signInClass;
    List<WebElement> before;
    MainScreenClass mainScreenClass;
    boolean result;
    MainScreenSidebarFavoriteOrderClass mainScreenSidebarFavoriteOrderClass;
    MainScreenSidebarAddOrderClass mainScreenSidebarAddOrderClass;
    MainScreenSidebarAddQuickOrderClass mainScreenSidebarAddQuickOrderClass;
    MainScreenSidebarAddressClass mainScreenSidebarAddressClass;
    MainScreenSidebarAddAddressClass mainScreenSidebarAddAddressClass;
    MainScreenSidebarPaymentsClass mainScreenSidebarPaymentsClass;
    MainScreenSidebarAddPaymentsClass mainScreenSidebarAddPaymentsClass;

    @Before
    public void before() throws InterruptedException {
        driver = new FirefoxDriver();
        signInClass = PageFactory.initElements(driver, SignInClass.class);
        before = new ArrayList<>();
        mainScreenClass = PageFactory.initElements(driver, MainScreenClass.class);
        mainScreenSidebarFavoriteOrderClass = PageFactory.initElements(driver, MainScreenSidebarFavoriteOrderClass.class);
        mainScreenSidebarAddOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddOrderClass.class);
        mainScreenSidebarAddQuickOrderClass = PageFactory.initElements(driver, MainScreenSidebarAddQuickOrderClass.class);
        mainScreenSidebarAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddressClass.class);
        mainScreenSidebarAddAddressClass = PageFactory.initElements(driver, MainScreenSidebarAddAddressClass.class);
        mainScreenSidebarPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarPaymentsClass.class);
        mainScreenSidebarAddPaymentsClass = PageFactory.initElements(driver, MainScreenSidebarAddPaymentsClass.class);

        driver.get(GlobalMethods.getUrl());
        driver.manage().window().maximize();
        signInClass.chooseDevice();
        signInClass.signInClick("+79280373736","123456");

        //Проверяем наличие созданных order, address, payment, если не созданы создаем
        mainScreenClass.chooseDevice();
        mainScreenClass.favoriteOrderSectionClick();
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        before = mainScreenSidebarFavoriteOrderClass.countOrdersElementsBefore();
        if(before.size()<1) {
            mainScreenSidebarFavoriteOrderClass.addOrderButtonClick();
            mainScreenSidebarAddOrderClass.chooseDevice();
            mainScreenSidebarAddOrderClass.addOrder(GlobalMethods.getRestaurant(),GlobalMethods.getOrder());
            result = mainScreenSidebarFavoriteOrderClass.checkAddOrder(before);
            if(result) {
                mainScreenSidebarAddQuickOrderClass.chooseDevice();
            } else{
                Assert.fail("Order is not created!");
            }
            mainScreenSidebarFavoriteOrderClass.chooseDevice();
        }
        mainScreenClass.addressSectionClick();
        mainScreenSidebarAddressClass.chooseDevice();
        before = mainScreenSidebarAddressClass.countAddressElementsBefore();
        if(before.size()<1) {
            mainScreenSidebarAddressClass.addAddressButtonClick();
            mainScreenSidebarAddAddressClass.chooseDevice();
            mainScreenSidebarAddAddressClass.addAddress(GlobalMethods.getCountry(),GlobalMethods.getCity(), GlobalMethods.getHome());
            mainScreenSidebarAddressClass.chooseDevice();
        }
        mainScreenClass.paymentSectionClick();
        mainScreenSidebarPaymentsClass.chooseDevice();
        before = mainScreenSidebarPaymentsClass.countPaymentsElementsBefore();
        if(before.size()<1) {
            mainScreenSidebarPaymentsClass.addPaymentButtonClick();
            mainScreenSidebarAddPaymentsClass.chooseDevice();
            mainScreenSidebarAddPaymentsClass.addPayment(GlobalMethods.getNameCard(), GlobalMethods.getNumberCard2(), GlobalMethods.getDateCardMonth(), GlobalMethods.getDateCardYear(), GlobalMethods.getCvvCard());
            mainScreenSidebarPaymentsClass.chooseDevice();
        }
        mainScreenClass.favoriteOrderSectionClick();
        mainScreenSidebarFavoriteOrderClass.chooseDevice();
        mainScreenSidebarFavoriteOrderClass.getAddQuickOrderButton().get(before.size()).click();
    }

    /*@Ignore
    @Test
    public void testCase28() throws InterruptedException {
        mainScreenSidebarAddQuickOrderClass.getPayment().sendKeys(GlobalMethods.getNumberCard());
        mainScreenSidebarAddQuickOrderClass.getAddress().sendKeys(GlobalMethods.getCountry() + "," + GlobalMethods.getCity() + "," + GlobalMethods.getStreet() + "," + GlobalMethods.getNumber());
        boolean result = GlobalMethods.validationRestaurant(mainScreenSidebarAddQuickOrderClass.getFavoriteOrder(),mainScreenSidebarAddQuickOrderClass.getSubmitButton());
        Assert.assertTrue("Error!", result);
    }*/

    @Ignore
    @Test
    public void testCase28() throws InterruptedException {
        boolean result = GlobalMethods.validationFavoriteOrderList(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue("Error!", result);
    }

    @Ignore
    @Test
    public void testCase60() throws InterruptedException {
        mainScreenSidebarAddQuickOrderClass.getPayment().sendKeys(GlobalMethods.getNumberCard1());
        mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(GlobalMethods.getRestaurant());
        boolean result = GlobalMethods.validationAddress(mainScreenSidebarAddQuickOrderClass.getAddress(),mainScreenSidebarAddQuickOrderClass.getSubmitButton());
        Assert.assertTrue("Error!", result);
    }

    @Ignore
    @Test
    public void testCase61() throws InterruptedException {
        mainScreenSidebarAddQuickOrderClass.getAddress().sendKeys(GlobalMethods.getCountry() + "," + GlobalMethods.getCity() + "," + GlobalMethods.getHome());
        mainScreenSidebarAddQuickOrderClass.getFavoriteOrder().sendKeys(GlobalMethods.getRestaurant());
        boolean result = GlobalMethods.validationPaymentList(mainScreenSidebarAddQuickOrderClass);
        Assert.assertTrue("Error!", result);
    }

    @Ignore
    @Test
    public void testCase29() throws InterruptedException {
        boolean result = GlobalMethods.validationQuickOrder(mainScreenSidebarAddQuickOrderClass,GlobalMethods.getRestaurant(),GlobalMethods.getOrder(),"testDescriptions");
        Assert.assertTrue("Error!", result);
    }

    @Ignore
    @Test
    public void testCase30() throws InterruptedException {
        mainScreenSidebarAddOrderClass.cancelClick();
        boolean result = mainScreenSidebarAddOrderClass.checkCancelButtonClick(mainScreenSidebarFavoriteOrderClass);
        Assert.assertTrue(result);
    }



}
