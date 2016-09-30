package TestClass.Client.Restaurant;

import TestClass.GlobalMethods.GlobalMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by dmitry on 03.08.16.
 */
public class RestaurantModalClass {

    WebDriver driver;
    WebDriverWait waiting;

    public RestaurantModalClass(WebDriver driver){
        this.driver = driver;
    }

    String pathWeb = "";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement closeButton;

    private WebElement nameRestaurant;

    private WebElement ratingRestaurant;

    private WebElement workingHours;

    private WebElement orderNowButton;

    private WebElement chatNowButton;

    private List<WebElement> categories;

    private WebElement rateReviewsButton;

    private List<WebElement> reviews;

    private WebElement description;

    private WebElement restaurantPhotosArea;

    private List<WebElement> restaurantPhotos;

    private WebElement restaurantMenuPhotosArea;

    private List<WebElement> restaurantMenuPhotos;

    private WebElement reportButton;

    private WebElement addressRestaurant;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver,20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
                setCloseButton(driver.findElement(By.xpath(pathWeb + "")));
                setNameRestaurant(driver.findElement(By.xpath(pathWeb + "")));
                setRatingRestaurant(driver.findElement(By.xpath(pathWeb + "")));
                setWorkingHours(driver.findElement(By.xpath(pathWeb + "")));
                setOrderNowButton(driver.findElement(By.xpath(pathWeb + "")));
                setCategories(driver.findElements(By.xpath(pathWeb + "")));
                setRateReviewsButton(driver.findElement(By.xpath(pathWeb + "")));
                setReviews(driver.findElements(By.xpath(pathWeb + "")));
                setDescription(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantPhotosArea(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantPhotos(driver.findElements(By.xpath(pathWeb + "")));
                setRestaurantMenuPhotosArea(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantMenuPhotos(driver.findElements(By.xpath(pathWeb + "")));
                setReportButton(driver.findElement(By.xpath(pathWeb + "")));
                break;
        }
    }





    public WebElement getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(WebElement closeButton) {
        this.closeButton = closeButton;
    }

    public WebElement getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(WebElement nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public WebElement getRatingRestaurant() {
        return ratingRestaurant;
    }

    public void setRatingRestaurant(WebElement ratingRestaurant) {
        this.ratingRestaurant = ratingRestaurant;
    }

    public WebElement getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WebElement workingHours) {
        this.workingHours = workingHours;
    }

    public WebElement getOrderNowButton() {
        return orderNowButton;
    }

    public void setOrderNowButton(WebElement orderNowButton) {
        this.orderNowButton = orderNowButton;
    }

    public WebElement getChatNowButton() {
        return chatNowButton;
    }

    public void setChatNowButton(WebElement chatNowButton) {
        this.chatNowButton = chatNowButton;
    }

    public List<WebElement> getCategories() {
        return categories;
    }

    public void setCategories(List<WebElement> categories) {
        this.categories = categories;
    }

    public WebElement getRateReviewsButton() {
        return rateReviewsButton;
    }

    public void setRateReviewsButton(WebElement rateReviewsButton) {
        this.rateReviewsButton = rateReviewsButton;
    }

    public List<WebElement> getReviews() {
        return reviews;
    }

    public void setReviews(List<WebElement> reviews) {
        this.reviews = reviews;
    }

    public WebElement getDescription() {
        return description;
    }

    public void setDescription(WebElement description) {
        this.description = description;
    }

    public WebElement getRestaurantPhotosArea() {
        return restaurantPhotosArea;
    }

    public void setRestaurantPhotosArea(WebElement restaurantPhotosArea) {
        this.restaurantPhotosArea = restaurantPhotosArea;
    }

    public List<WebElement> getRestaurantPhotos() {
        return restaurantPhotos;
    }

    public void setRestaurantPhotos(List<WebElement> restaurantPhotos) {
        this.restaurantPhotos = restaurantPhotos;
    }

    public WebElement getRestaurantMenuPhotosArea() {
        return restaurantMenuPhotosArea;
    }

    public void setRestaurantMenuPhotosArea(WebElement restaurantMenuPhotosArea) {
        this.restaurantMenuPhotosArea = restaurantMenuPhotosArea;
    }

    public List<WebElement> getRestaurantMenuPhotos() {
        return restaurantMenuPhotos;
    }

    public void setRestaurantMenuPhotos(List<WebElement> restaurantMenuPhotos) {
        this.restaurantMenuPhotos = restaurantMenuPhotos;
    }

    public WebElement getReportButton() {
        return reportButton;
    }

    public void setReportButton(WebElement reportButton) {
        this.reportButton = reportButton;
    }

    public WebElement getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(WebElement addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }
}
