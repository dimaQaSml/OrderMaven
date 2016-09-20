package Restaurant.SignUpClass;

import GlobalMethods.GlobalMethods;
//TODO
//import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Created by dmitry on 26.05.16.
 */
public class SignUpStep3Class {

    WebDriver driver;
    WebDriverWait waiting;

    public SignUpStep3Class(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "html/body/div[1]/div/div[5]/div[3]/form";
    String pathAndroid = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]";
    String pathIOS = "";

    private WebElement address;

    private WebElement city;

    private WebElement state;

    private WebElement country;

    private WebElement countrySelect;

    private WebElement zipCode;

    private WebElement mapArea;

    private WebElement makeArea;

    private WebElement makeCircle;

    private WebElement circle;

    private WebElement deleteButton;

    private WebElement clearButton;

    private WebElement searchMap;

    private WebElement point;

    private WebElement searchListMap;

    private WebElement okButton;

    private WebElement signUpButton;

    private WebElement previousButton;

    private WebElement deliveryMap;

    private WebElement deliveryTittle;

    private WebElement backMobile;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,15);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("address")));
                setAddress(driver.findElement(By.id("address")));
                setCity(driver.findElement(By.id("city")));
                setState(driver.findElement(By.id("state")));
                setCountry(driver.findElement(By.xpath(pathWeb + "/div[4]/autocomplete/div/input")));
                setCountrySelect(driver.findElement(By.xpath(pathWeb + "/div[4]/autocomplete/div/div[2]/ul/li")));
                setZipCode(driver.findElement(By.id("zip")));
                setMapArea(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[3]")));
                setMakeArea(driver.findElement(By.xpath(".//*[@id='delivery']/div/div[1]/div[3]/div[1]/div[2]")));
                setMakeCircle(driver.findElement(By.xpath(".//*[@id='delivery']/div/div[1]/div[3]/div[1]/div[1]")));
                setDeleteButton(driver.findElement(By.xpath(".//*[@id='delivery']/div/div[1]/div[3]/div[1]/div[3]")));
                setClearButton(driver.findElement(By.xpath(".//*[@id='delivery']/div/div[1]/div[3]/div[1]/div[4]")));
                setSearchMap(driver.findElement(By.id("pac-input")));
                setOkButton(driver.findElement(By.xpath(".//*[@id='delivery']/div/div[2]/input")));
                setSignUpButton(driver.findElement(By.id("submitAddress")));
                setPreviousButton(driver.findElement(By.id("goStep2")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
                setAddress(driver.findElement(By.id("")));
                setCity(driver.findElement(By.id("")));
                setState(driver.findElement(By.id("")));
                setCountry(driver.findElement(By.xpath(pathIOS + "")));
                setCountrySelect(driver.findElement(By.xpath(pathIOS + "")));
                setZipCode(driver.findElement(By.id("")));
                setMapArea(driver.findElement(By.xpath("")));
                setMakeArea(driver.findElement(By.xpath("")));
                setMakeCircle(driver.findElement(By.xpath("")));
                setDeleteButton(driver.findElement(By.xpath("")));
                setClearButton(driver.findElement(By.xpath("")));
                setSearchMap(driver.findElement(By.id("")));
                setOkButton(driver.findElement(By.xpath("")));
                setSignUpButton(driver.findElement(By.id("")));
                setPreviousButton(driver.findElement(By.id("")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.id("address")));
                setAddress(driver.findElement(By.id("address")));
                setCity(driver.findElement(By.id("city")));
                setState(driver.findElement(By.id("state")));
                //setCountry(driver.findElement(By.xpath("")));
                //setCountrySelect(driver.findElement(By.xpath("")));
                setZipCode(driver.findElement(By.id("zip")));
                setSignUpButton(driver.findElement(By.id("nextButton")));
                setPreviousButton(driver.findElement(By.id("backButton")));
                setDeliveryMap(driver.findElement(By.xpath(pathAndroid + "/android.widget.TextView[2]")));
                setBackMobile(driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]" +
                        "/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")));
                setDeliveryTittle(driver.findElement(By.id("deliveryArea")));
                break;
        }
    }


    public void signUpClick(String address,String city,String state, String country, String zipCode){
        while(!getAddress().getAttribute("value").isEmpty()){
            getAddress().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCity().getAttribute("value").isEmpty()){
            getCity().sendKeys(Keys.BACK_SPACE);
        }
        while(!getState().getAttribute("value").isEmpty()){
            getState().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCountry().getAttribute("value").isEmpty()){
            getCountry().sendKeys(Keys.BACK_SPACE);
        }
        while(!getZipCode().getAttribute("value").isEmpty()){
            getZipCode().sendKeys(Keys.BACK_SPACE);
        }
        getAddress().sendKeys(address);
        getCity().sendKeys(city);
        getState().sendKeys(state);
        getCountry().sendKeys(country);
        getZipCode().sendKeys(zipCode);
        getSignUpButton().click();
    }

    public void signUpSearchClick(String address){
        try {
            getSearchMap().sendKeys(address);
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div[1]")));
            setSearchListMap(driver.findElement(By.xpath("html/body/div[2]")));
            driver.findElement(By.xpath("html/body/div[2]/div[1]")).click();
            Actions act = new Actions(driver);
            act.sendKeys(Keys.DOWN);
            act.sendKeys(Keys.ENTER);
            getSignUpButton().click();

        } catch (org.openqa.selenium.TimeoutException e){
            //TODO
            //Assert.fail("Error!");
        }
    }

    public void signUpFullClick(String address,String city,String state, String country, String zipCode){
        getAddress().sendKeys(address);
        getCity().sendKeys(city);
        getState().sendKeys(state);
        getCountry().sendKeys(country);
        getZipCode().sendKeys(zipCode);


        Actions act = new Actions(driver);
        getMakeArea().click();

        act.moveToElement(getMapArea(),coordinates().get(0).x,coordinates().get(0).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(1).x,coordinates().get(1).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(2).x,coordinates().get(2).y).clickAndHold().release().perform();

        getMakeCircle().click();
        act.moveToElement(getMapArea(), coordinates().get(0).x, coordinates().get(0).y +100).clickAndHold().moveToElement(getMapArea(), coordinates().get(0).x + 70, coordinates().get(0).y + 70).release().build().perform();
        getOkButton().click();

        getSignUpButton().click();
    }


    public ArrayList<Point> coordinates(){

        Integer sizeX = getMapArea().getSize().getWidth();
        Integer sizeY = getMapArea().getSize().getHeight();

        ArrayList<Point> coordinates = new ArrayList<>();
        coordinates.add(new Point(sizeX/2,sizeY/2+50));
        coordinates.add(new Point(sizeX/2+100,sizeY/2+100));
        coordinates.add(new Point(sizeX/2-100,sizeY/2+100));

        return coordinates;
    }

    public boolean makeAreaTest32() throws InterruptedException {

        Actions act = new Actions(driver);
        getMakeArea().click();

        //Ставим на карте 3 точки
        //act.moveToElement(getMapArea(),coordinates().get(0).x,coordinates().get(0).y).click().build().perform();
        //clickAndHold().release() это пиздец дичь!!! просто click() перестал работать(((
        act.moveToElement(getMapArea(),coordinates().get(0).x,coordinates().get(0).y).clickAndHold().release().build().perform();
        act.moveToElement(getMapArea(), coordinates().get(1).x, coordinates().get(1).y).clickAndHold().release().build().perform();
        act.moveToElement(getMapArea(),coordinates().get(2).x,coordinates().get(2).y).clickAndHold().release().perform();

        getOkButton().click();

        for(int i=2;i<5;i++){
            try{
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
                setPoint(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
            } catch (org.openqa.selenium.TimeoutException e) {
                return false;
            }
            if(!getPoint().isDisplayed()){
                getClearButton().click();
                return false;
            }
        }
        getClearButton().click();
        return true;
    }

    public boolean makeAreaTest33(){

        Actions act = new Actions(driver);
        getMakeArea().click();

        //Ставим на карте 3 точки
        act.moveToElement(getMapArea(),coordinates().get(0).x,coordinates().get(0).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(1).x,coordinates().get(1).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(2).x,coordinates().get(2).y).clickAndHold().release().perform();

        getOkButton().click();

        for(int i=2;i<5;i++) {
            try{
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
                setPoint(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
            } catch (org.openqa.selenium.TimeoutException e) {
                return false;
            }
            //Перемещаем по карте 3 точки
            act.moveToElement(getMapArea(), coordinates().get(i-2).x, coordinates().get(i-2).y - 1).clickAndHold().moveToElement(getMapArea(), coordinates().get(i-2).x + 30, coordinates().get(i-2).y + 30).release().build().perform();

            // +8 и +39 потому что getPoint возвращает координаты левого верхнего угла, а getMapArea()+coordinates возвращает координаты основания и без этой хуйни хуй сделаешь
            int pointX = getPoint().getLocation().x+8;
            int pointX2 = getMapArea().getLocation().x+coordinates().get(i-2).x;
            int pointY = getPoint().getLocation().y+39;
            int pointY2 = getMapArea().getLocation().y+coordinates().get(i-2).y;
            if(pointX == pointX2 && pointY == pointY2){
                return false;
            }
        }
        return true;
    }

    public boolean makeAreaTest34(){

        Actions act = new Actions(driver);
        getMakeArea().click();

        //Ставим на карте 3 точки
        act.moveToElement(getMapArea(),coordinates().get(0).x,coordinates().get(0).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(1).x,coordinates().get(1).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(2).x,coordinates().get(2).y).clickAndHold().release().perform();

        getOkButton().click();

        //Перемещаем область
        act.moveToElement(getMapArea(),coordinates().get(0).x,coordinates().get(0).y+15).clickAndHold().moveToElement(getMapArea(),coordinates().get(0).x,coordinates().get(0).y+130).release().build().perform();

        for(int i=2;i<5;i++) {
            try{
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
                setPoint(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
            } catch (org.openqa.selenium.TimeoutException e) {
                return false;
            }
            // +8 и +39 потому что getPoint возвращает координаты левого верхнего угла, а getMapArea()+coordinates возвращает координаты основания и без этой хуйни хуй сделаешь
            int pointX = getPoint().getLocation().x+8;
            int pointX2 = getMapArea().getLocation().x+coordinates().get(i-2).x;
            int pointY = getPoint().getLocation().y+39;
            int pointY2 = getMapArea().getLocation().y+coordinates().get(i-2).y;

            if(pointX == pointX2 && pointY == pointY2){
                return false;
            }
        }
        return true;
    }

    public boolean makeAreaTest35() throws InterruptedException {

        Actions act = new Actions(driver);
        getMakeArea().click();

        //Ставим на карте 3 точки
        act.moveToElement(getMapArea(),coordinates().get(0).x,coordinates().get(0).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(1).x,coordinates().get(1).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(2).x,coordinates().get(2).y).clickAndHold().release().perform();

        getOkButton().click();

        try {
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[3]/img")));
            setPoint(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[3]/img")));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }

        int pointX = coordinates().get(0).x;
        int pointY = coordinates().get(0).y+15;

        act.moveToElement(getMapArea(),pointX,pointY).clickAndHold().release().perform();
        getDeleteButton().click();

            try {
                getPoint().isDisplayed();
                return false;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                return true;
            }
    }

    public boolean makeAreaTest36() throws InterruptedException {

        Actions act = new Actions(driver);
        getMakeArea().click();

        //Ставим на карте 3 точки
        act.moveToElement(getMapArea(), coordinates().get(0).x, coordinates().get(0).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(1).x,coordinates().get(1).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(2).x,coordinates().get(2).y).clickAndHold().release().perform();

        getOkButton().click();

        for(int i=4;i>1;i--) {
            //if(i!=2) {
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
                setPoint(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
            /*} else{
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathWeb + "/div[7]/delivery-area/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div/img")));
                setPoint(driver.findElement(By.xpath(pathWeb + "/div[7]/delivery-area/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div/img")));
            }*/

            act.moveToElement(getPoint(), 8, 5).clickAndHold().release().perform();
            getDeleteButton().click();

        }
        try {
            getPoint().isDisplayed();
            return false;
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            return true;
        }
    }

    public boolean makeAreaTest27() throws InterruptedException {
        Actions act = new Actions(driver);
        getMakeCircle().click();

        act.moveToElement(getMapArea(), coordinates().get(0).x, coordinates().get(0).y +100).clickAndHold().moveToElement(getMapArea(), coordinates().get(0).x + 70, coordinates().get(0).y + 70).release().build().perform();

        getOkButton().click();
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
            setCircle(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
        try {
            getCircle().isDisplayed();
            return true;
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }


    public boolean makeAreaTest28() throws InterruptedException {

        Actions act = new Actions(driver);
        getMakeCircle().click();

        //Создание окружности Circle
        act.moveToElement(getMapArea(), coordinates().get(0).x, coordinates().get(0).y + 50).clickAndHold().moveToElement(getMapArea(), coordinates().get(0).x, coordinates().get(0).y + 10).release().build().perform();

        getOkButton().click();

        for(int i=2;i<6;i++) {
            try{
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[" + i + "]/div")));
                setPoint(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[" + i + "]/div")));
            } catch (org.openqa.selenium.TimeoutException e) {
                return false;
            }
            int pointX = getPoint().getLocation().getX() - getMapArea().getLocation().getX();
            int pointY = getPoint().getLocation().getY() - getMapArea().getLocation().getY();
            act.moveToElement(getMapArea(),pointX,pointY).clickAndHold().moveToElement(getMapArea(),pointX+25,pointY+25).release().build().perform();

            try{
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[" + i + "]/div")));
                setPoint(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[" + i + "]/div")));
            } catch (org.openqa.selenium.TimeoutException e) {
                return false;
            }
            try {
                int resultX = getPoint().getLocation().getX() - getMapArea().getLocation().getX();
                int resultY = getPoint().getLocation().getY() - getMapArea().getLocation().getY();
                if (resultX == pointX && resultY == pointY) {
                    return false;
                }
            }catch(org.openqa.selenium.StaleElementReferenceException e){
                    return false;
                }
            }
        return true;
    }

    public boolean makeAreaTest29(){
        Actions act = new Actions(driver);
        getMakeCircle().click();

        act.moveToElement(getMapArea(), coordinates().get(0).x, coordinates().get(0).y +100).clickAndHold().moveToElement(getMapArea(), coordinates().get(0).x + 70, coordinates().get(0).y + 70).release().build().perform();
        getOkButton().click();

        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
            setCircle(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }

        int beforeX = getCircle().getLocation().getX() - getMapArea().getLocation().getX();
        int beforeY = getCircle().getLocation().getY() - getMapArea().getLocation().getY();

        //Перемещаем Circle
        act.moveToElement(getMapArea(),beforeX,beforeY).clickAndHold().moveToElement(getMapArea(),beforeX+50,beforeY+50).release().build().perform();

        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
            setCircle(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }

        try {
            int afterX = getCircle().getLocation().getX() - getMapArea().getLocation().getX();
            int afterY = getCircle().getLocation().getY() - getMapArea().getLocation().getY();
            if (afterX == beforeX && afterY == beforeY) {
                return false;
            }
        } catch(org.openqa.selenium.StaleElementReferenceException e){
            return false;
        }
        return true;
    }


    public boolean makeAreaTest30(){
        Actions act = new Actions(driver);
        getMakeCircle().click();

        act.moveToElement(getMapArea(), coordinates().get(0).x, coordinates().get(0).y +50).clickAndHold().moveToElement(getMapArea(), coordinates().get(0).x + 50, coordinates().get(0).y + 50).release().build().perform();
        getOkButton().click();

        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
            setCircle(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }

        int beforeX = getCircle().getLocation().getX() - getMapArea().getLocation().getX();
        int beforeY = getCircle().getLocation().getY() - getMapArea().getLocation().getY();

        /*System.out.println(getMapArea().getSize().getHeight()+ " " + getMapArea().getSize().getWidth());
        System.out.println(beforeX+ " " + beforeY);
        System.out.println(getCircle().getLocation().getX()+ " " + getCircle().getLocation().getY());
        System.out.println(getMapArea().getLocation().getX()+ " " + getMapArea().getLocation().getY());

        getMakeArea().click();*/
        act.moveToElement(getMapArea(),beforeX,beforeY+15).clickAndHold().release().build().perform();
        getDeleteButton().click();

        try {
            getCircle().isDisplayed();
            return false;
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            return true;
        }
    }

    public boolean makeAreaTest38(){
        Actions act = new Actions(driver);
        getMakeCircle().click();

        //Создаем Circle
        act.moveToElement(getMapArea(), coordinates().get(0).x, coordinates().get(0).y +100).clickAndHold().moveToElement(getMapArea(), coordinates().get(0).x + 70, coordinates().get(0).y + 70).release().build().perform();
        getOkButton().click();

        //Ставим на карте 3 точки
        getMakeArea().click();
        act.moveToElement(getMapArea(),coordinates().get(0).x+10,coordinates().get(0).y+10).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(1).x,coordinates().get(1).y).clickAndHold().release().perform();
        act.moveToElement(getMapArea(),coordinates().get(2).x,coordinates().get(2).y).clickAndHold().release().perform();
        getOkButton().click();

        //Ожидаем появления всех добавленных элементов на карту
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[5]/img")));

        getClearButton().click();

        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
            setCircle(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div[2]/div[1]/div")));
        } catch (org.openqa.selenium.TimeoutException e) {
            return true;
        }

        try {
            for (int i = 2; i < 5; i++) {
                if (i != 1) {
                    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
                    setPoint(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
                } else {
                    waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
                    setPoint(driver.findElement(By.xpath(".//*[@id='delivery']/div/ui-gmap-google-map/div/div[1]/div/div[1]/div[4]/div[3]/div["+ i +"]/img")));
                }
            }
        } catch (org.openqa.selenium.TimeoutException e){
            return true;
        }
        return false;
    }

    public boolean makeAreaTest39() throws InterruptedException {
        System.out.println(getMakeCircle().isSelected());
        getMakeCircle().click();
        Thread.sleep(1000);
        System.out.println(getMakeCircle().isSelected());
        System.out.println(driver.findElement(By.className("map__circle map__circle--selected")).getText());
/*        if(getMakeCircle().isSelected()){
           getOkButton().click();
        }
        getMakeArea().click();
        if(getMakeArea().isSelected()){
            getOkButton().click();
        }
        System.out.println(getMakeCircle().isSelected());
        System.out.println(getMakeArea().isSelected());
        if(getMakeCircle().isSelected() || getMakeArea().isSelected()){
            return false;
        }*/
        return true;
    }


    public boolean makeAreaTest40() throws InterruptedException {
        getSearchMap().sendKeys("Rus");
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]")));
        } catch(org.openqa.selenium.StaleElementReferenceException e){
            return false;
        }
        return true;
    }

    public boolean makeAreaTest41() throws InterruptedException {
        getSearchMap().sendKeys("Krasnodar lenina 10");
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]")));
            driver.findElement(By.xpath("html/body/div[2]")).click();
            Actions act = new Actions(driver);
            act.sendKeys(Keys.DOWN);
            act.sendKeys(Keys.ENTER);
        } catch(org.openqa.selenium.StaleElementReferenceException e){
            return false;
        }
        if(!getAddress().getAttribute("value").isEmpty() && !getCity().getAttribute("value").isEmpty() && !getCountry().getAttribute("value").isEmpty()
                && !getState().getAttribute("value").isEmpty() && !getZipCode().getAttribute("value").isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public void makeAreaTest42() {
        getPreviousButton().click();
    }

    public void makeAreaTest43() {
        while(!getAddress().getAttribute("value").isEmpty()){
            getAddress().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCity().getAttribute("value").isEmpty()){
            getCity().sendKeys(Keys.BACK_SPACE);
        }
        while(!getState().getAttribute("value").isEmpty()){
            getState().sendKeys(Keys.BACK_SPACE);
        }
        while(!getCountry().getAttribute("value").isEmpty()){
            getCountry().sendKeys(Keys.BACK_SPACE);
        }
        while(!getZipCode().getAttribute("value").isEmpty()){
            getZipCode().sendKeys(Keys.BACK_SPACE);
        }
        getAddress().sendKeys("Krasnaya");
        getCity().sendKeys("Krasnodar");
        getState().sendKeys("Krasnodar Krai");
        getCountry().sendKeys("Russia");
        getZipCode().sendKeys("350000");
        getSignUpButton().click();
    }

    public WebElement getAddress() {
        return address;
    }

    public void setAddress(WebElement address) {
        this.address = address;
    }

    public WebElement getCity() {
        return city;
    }

    public void setCity(WebElement city) {
        this.city = city;
    }

    public WebElement getState() {
        return state;
    }

    public void setState(WebElement state) {
        this.state = state;
    }

    public WebElement getCountry() {
        return country;
    }

    public void setCountry(WebElement country) {
        this.country = country;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public void setZipCode(WebElement zipCode) {
        this.zipCode = zipCode;
    }

    public WebElement getMapArea() {
        return mapArea;
    }

    public void setMapArea(WebElement mapArea) {
        this.mapArea = mapArea;
    }

    public WebElement getMakeArea() {
        return makeArea;
    }

    public void setMakeArea(WebElement makeArea) {
        this.makeArea = makeArea;
    }

    public WebElement getMakeCircle() {
        return makeCircle;
    }

    public void setMakeCircle(WebElement makeCircle) {
        this.makeCircle = makeCircle;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(WebElement deleteButton) {
        this.deleteButton = deleteButton;
    }

    public WebElement getClearButton() {
        return clearButton;
    }

    public void setClearButton(WebElement clearButton) {
        this.clearButton = clearButton;
    }

    public WebElement getSearchMap() {
        return searchMap;
    }

    public void setSearchMap(WebElement searchMap) {
        this.searchMap = searchMap;
    }

    public WebElement getSearchListMap() {
        return searchListMap;
    }

    public void setSearchListMap(WebElement searchListMap) {
        this.searchListMap = searchListMap;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public void setOkButton(WebElement okButton) {
        this.okButton = okButton;
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

    public WebElement getCountrySelect() {
        return countrySelect;
    }

    public void setCountrySelect(WebElement countrySelect) {
        this.countrySelect = countrySelect;
    }

    public WebElement getPoint() {
        return point;
    }

    public void setPoint(WebElement point) {
        this.point = point;
    }

    public WebElement getCircle() {
        return circle;
    }

    public void setCircle(WebElement circle) {
        this.circle = circle;
    }

    public WebElement getDeliveryMap() {
        return deliveryMap;
    }

    public void setDeliveryMap(WebElement deliveryMap) {
        this.deliveryMap = deliveryMap;
    }

    public WebElement getBackMobile() {
        return backMobile;
    }

    public void setBackMobile(WebElement backMobile) {
        this.backMobile = backMobile;
    }

    public WebElement getDeliveryTittle() {
        return deliveryTittle;
    }

    public void setDeliveryTittle(WebElement deliveryTittle) {
        this.deliveryTittle = deliveryTittle;
    }
}
