package Client.Restaurant;

import GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 03.08.16.
 */
public class RestaurantSearchClass {

    WebDriver driver;
    WebDriverWait waiting;

    public RestaurantSearchClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement searchField;

    private WebElement changeMyLocation;

    private WebElement changeMyLocationSelect;

    private List<WebElement> changeMyLocationElementList;

    private WebElement category;

    private WebElement categorySelect;

    private List<WebElement> categoryElementList;

    private WebElement searchButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,10);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setSearchField(driver.findElement(By.xpath(pathWeb + "")));
                setChangeMyLocation(driver.findElement(By.xpath(pathWeb + "")));
                setChangeMyLocationSelect(driver.findElement(By.xpath(pathWeb + "")));
                setCategory(driver.findElement(By.xpath(pathWeb + "")));
                setCategorySelect(driver.findElement(By.xpath(pathWeb + "")));
                setSearchButton(driver.findElement(By.xpath(pathWeb + "")));

                break;
        }
    }

    public boolean testCase86(RestaurantScreenClass restaurantScreenClass, RestaurantModalClass restaurantModalClass) throws InterruptedException {
        getChangeMyLocationSelect().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setChangeMyLocationElementList(driver.findElements(By.xpath("")));
        for(int i = 0; i< getChangeMyLocationElementList().size(); i++) {
            if (getChangeMyLocationElementList().get(i).getText().equals(GlobalMethods.getCountry())){
                getChangeMyLocationElementList().get(i).click();
            }
        }
        getSearchButton().click();
        //
        if(restaurantScreenClass.getNameRestaurant().size() > 0) {
            for(int i=0; i< restaurantScreenClass.getNameRestaurant().size(); i++) {
                restaurantScreenClass.getNameRestaurant().get(i).click();
                restaurantModalClass.chooseDevice();
                if (!restaurantModalClass.getAddressRestaurant().getText().contains(GlobalMethods.getCountry())) {
                    return false;
                }
                restaurantModalClass.getCloseButton().click();
            }
            return true;
        } else {
            //Изменить страну
        }
        return false;
    }

    public boolean testCase87(RestaurantScreenClass restaurantScreenClass, RestaurantModalClass restaurantModalClass) throws InterruptedException {
        getCategorySelect().click();
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        setCategoryElementList(driver.findElements(By.xpath("")));
        for(int i = 0; i< getCategoryElementList().size(); i++) {
            if (getChangeMyLocationElementList().get(i).getText().equals("Kosher")){
                getChangeMyLocationElementList().get(i).click();
            }
        }
        getSearchButton().click();
        if(restaurantScreenClass.getNameRestaurant().size() > 0) {
            for(int i=0; i< restaurantScreenClass.getNameRestaurant().size(); i++) {
                restaurantScreenClass.getNameRestaurant().get(i).click();
                restaurantModalClass.chooseDevice();
                for (int j = 0; j < restaurantModalClass.getCategories().size(); j++) {
                    if (!restaurantModalClass.getCategories().get(j).getText().contains("Kosher")) {
                        return false;
                    }
                }
                restaurantModalClass.getCloseButton().click();
            }
            return true;
        } else {
            //Изменить страну
        }
        return false;
    }


    public boolean testCase89_91(RestaurantScreenClass restaurantScreenClass, WebElement field) throws InterruptedException {
        //Заведомо неверное название ресторана или категории или локации
        field.sendKeys("!@#$%^&*()");
        getSearchButton().click();
        try{
            waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            restaurantScreenClass.setErrorLabelSearch(driver.findElement(By.xpath("")));
        } catch (TimeoutException e){
            return false;
        }
        return true;
    }




    public WebElement getSearchField() {
        return searchField;
    }

    public void setSearchField(WebElement searchField) {
        this.searchField = searchField;
    }

    public WebElement getChangeMyLocation() {
        return changeMyLocation;
    }

    public void setChangeMyLocation(WebElement changeMyLocation) {
        this.changeMyLocation = changeMyLocation;
    }

    public WebElement getChangeMyLocationSelect() {
        return changeMyLocationSelect;
    }

    public List<WebElement> getChangeMyLocationElementList() {
        return changeMyLocationElementList;
    }

    public WebElement getCategory() {
        return category;
    }

    public void setCategory(WebElement category) {
        this.category = category;
    }

    public WebElement getCategorySelect() {
        return categorySelect;
    }

    public void setCategorySelect(WebElement categorySelect) {
        this.categorySelect = categorySelect;
    }

    public List<WebElement> getCategoryElementList() {
        return categoryElementList;
    }

    public void setChangeMyLocationSelect(WebElement changeMyLocationSelect) {
        this.changeMyLocationSelect = changeMyLocationSelect;
    }

    public void setChangeMyLocationElementList(List<WebElement> changeMyLocationElementList) {
        this.changeMyLocationElementList = changeMyLocationElementList;
    }

    public void setCategoryElementList(List<WebElement> categoryElementList) {
        this.categoryElementList = categoryElementList;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(WebElement searchButton) {
        this.searchButton = searchButton;
    }
}
