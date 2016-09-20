package Restaurant;

import GlobalMethods.GlobalMethods;
import Restaurant.SignUpClass.*;
import org.json.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dmitry on 15.06.16.
 */
public class MainScreenMyRestaurant {

    WebDriver driver;
    WebDriverWait waiting;
    SignInClass signInClass;
    SignUpStep1Class signUpStep1Class;
    SignUpStep2Class signUpStep2Class;
    SignUpStep3Class signUpStep3Class;
    SignUpStep4Class signUpStep4Class;
    SignUpStep5Class signUpStep5Class;
    MainScreenSidebar mainScreenSidebar;

    String name = "testName";
    String email = GlobalMethods.getEmail();
    String password = GlobalMethods.getPassword();
    String confirmPassword = GlobalMethods.getPassword();
    String nameRestaurant = "testRestaurant";
    String address = "testAddress";
    String searchAddress = "ulitsa Kommunarov, 26, Krasnodar, Krasnodar Krai, Russia";
    String city = "Krasnodar";
    String state = "Krasnodarskiy kray";
    String country = "Russia";
    String zipCode = "350000";
    HashMap<String,String> data;

    public MainScreenMyRestaurant(WebDriver driver) {
        this.driver = driver;
    }

    String pathWeb = "html/body/div[1]/div/div/form";
    String pathAndroid = "";
    String pathIOS = "";

    private WebElement banner;

    private WebElement logo;

    private WebElement myProfile;

    private WebElement restaurantName;

    private WebElement restaurantPhone;

    private WebElement restaurantDescription;

    private WebElement categoriesKosher;

    private WebElement categoriesNotKosher;

    private List<WebElement> categories;

    private WebElement addressCountry;

    private WebElement addressCity;

    private WebElement addressState;

    private WebElement addressStreet;

    private WebElement addressZipCode;

    private WebElement deliveryAreaMap;

    private WebElement deliveryAreaTittle;

    private WebElement addPhotoButton;

    private WebElement closePhoto;

    private WebElement photoSection;

    private WebElement addPhotoMenu;

    private WebElement closePhotoMenu;

    private WebElement photoMenuSection;

    private List<WebElement> workingHoursCheckboxs;

    private WebElement cancelButton;

    private WebElement submitButton;

    public void chooseDevice() throws InterruptedException {
        waiting = new WebDriverWait(driver, 20);
        switch (GlobalMethods.chooseDevice()) {
            case "web":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathWeb + "/section[1]/div[3]/div[1]/div[2]/div[2]")));
                //setBanner(driver.findElement(By.id("loadProfileImg")));
                //setLogo(driver.findElement(By.xpath("html/body/div[1]/div/div/form/section[1]/div[2]/div/div/label/img")));
                setMyProfile(driver.findElement(By.xpath(pathWeb + "/section[1]/div[3]/div[1]/div[2]/div[2]")));
                setRestaurantName(driver.findElement(By.id("restoName")));
                setRestaurantDescription(driver.findElement(By.id("description")));
                setRestaurantPhone(driver.findElement(By.id("restoPhone")));
                setCategoriesKosher(driver.findElement(By.xpath(pathWeb + "/section[2]/div[2]/div[1]/div[2]/div/div[1]")));
                setCategoriesNotKosher(driver.findElement(By.xpath(pathWeb + "/section[2]/div[2]/div[1]/div[2]/div/div[2]")));
                setCategories(driver.findElements(By.xpath("html/body/div[1]/div/div/form/section[2]/div[2]/div[2]/div[2]/div/label/label")));
                setAddressCountry(driver.findElement(By.xpath(pathWeb + "/section[3]/div[2]/div[1]/div[1]/autocomplete/div/input")));
                setAddressState(driver.findElement(By.id("state")));
                setAddressStreet(driver.findElement(By.id("street")));
                setAddressZipCode(driver.findElement(By.id("zip")));
                setAddressCity(driver.findElement(By.id("city")));
                setDeliveryAreaMap(driver.findElement(By.xpath(pathWeb + "/section[3]/div[4]/div[1]/div[2]/div[2]")));
                setDeliveryAreaTittle(driver.findElement(By.id("areaTitle")));
                setAddPhotoButton(driver.findElement(By.id("addPhoto")));
                setAddPhotoMenu(driver.findElement(By.id("addMenu")));
                setWorkingHoursCheckboxs(driver.findElements(By.xpath("html/body/div[1]/div/div/form/section[6]/div/label/input")));
                setCancelButton(driver.findElement(By.id("cancel")));
                setSubmitButton(driver.findElement(By.id("updateResto")));
                break;
            case "ios":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathWeb + "")));
                //setBanner(driver.findElement(By.id("loadProfileImg")));
                //setLogo(driver.findElement(By.xpath("html/body/div[1]/div/div/form/section[1]/div[2]/div/div/label/img")));
                setMyProfile(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantName(driver.findElement(By.id("")));
                setRestaurantDescription(driver.findElement(By.id("")));
                setRestaurantPhone(driver.findElement(By.id("")));
                setCategoriesKosher(driver.findElement(By.xpath(pathWeb + "")));
                setCategoriesNotKosher(driver.findElement(By.xpath(pathWeb + "")));
                setCategories(driver.findElements(By.xpath("")));
                setAddressCountry(driver.findElement(By.xpath(pathWeb + "")));
                setAddressState(driver.findElement(By.id("")));
                setAddressStreet(driver.findElement(By.id("")));
                setAddressZipCode(driver.findElement(By.id("")));
                setAddressCity(driver.findElement(By.id("")));
                setDeliveryAreaMap(driver.findElement(By.xpath(pathWeb + "")));
                setDeliveryAreaTittle(driver.findElement(By.id("")));
                setAddPhotoButton(driver.findElement(By.id("")));
                setAddPhotoMenu(driver.findElement(By.id("")));
                setWorkingHoursCheckboxs(driver.findElements(By.xpath("")));
                setCancelButton(driver.findElement(By.id("")));
                setSubmitButton(driver.findElement(By.id("")));
                break;
            case "android":
                waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathWeb + "")));
                //setBanner(driver.findElement(By.id("loadProfileImg")));
                //setLogo(driver.findElement(By.xpath("html/body/div[1]/div/div/form/section[1]/div[2]/div/div/label/img")));
                setMyProfile(driver.findElement(By.xpath(pathWeb + "")));
                setRestaurantName(driver.findElement(By.id("")));
                setRestaurantDescription(driver.findElement(By.id("")));
                setRestaurantPhone(driver.findElement(By.id("")));
                setCategoriesKosher(driver.findElement(By.xpath(pathWeb + "")));
                setCategoriesNotKosher(driver.findElement(By.xpath(pathWeb + "")));
                setCategories(driver.findElements(By.xpath("")));
                setAddressCountry(driver.findElement(By.xpath(pathWeb + "")));
                setAddressState(driver.findElement(By.id("")));
                setAddressStreet(driver.findElement(By.id("")));
                setAddressZipCode(driver.findElement(By.id("")));
                setAddressCity(driver.findElement(By.id("")));
                setDeliveryAreaMap(driver.findElement(By.xpath(pathWeb + "")));
                setDeliveryAreaTittle(driver.findElement(By.id("")));
                setAddPhotoButton(driver.findElement(By.id("")));
                setAddPhotoMenu(driver.findElement(By.id("")));
                setWorkingHoursCheckboxs(driver.findElements(By.xpath("")));
                setCancelButton(driver.findElement(By.id("")));
                setSubmitButton(driver.findElement(By.id("")));
                break;
        }
    }

    public boolean comparerWorkingCheckbox(WebElement first) {
        if (first.getAttribute("class").contains("ng-empty")) {
            return false;
        }
        return true;
    }

    public String parser(URLConnection connection) throws IOException {
        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int rc;
        StringBuilder sb = new StringBuilder();
        while ((rc = reader.read(buffer)) != -1)
            sb.append(buffer, 0, rc);
        reader.close();
        String result = sb.toString();
        return result;
    }

    public String getResponceCountRestaurant() throws IOException, JSONException {
        URLConnection connection = new URL("http://api.dev.orderapp.com:8080/api/v1/restaurants/count").openConnection();
        JSONObject obj = new JSONObject(parser(connection));
        String countStr = obj.getString("count");
        return countStr;
    }

    public HashMap<String,String> getResponceRestaurantData() throws IOException, JSONException {
        URLConnection connection = new URL("http://api.dev.orderapp.com:8080/api/v1/restaurants/" + getResponceCountRestaurant()).openConnection();
        JSONObject obj = new JSONObject(parser(connection));
        data = new HashMap<>();
        data.put("name",obj.getString("name"));
        data.put("description",obj.getString("description"));
        data.put("phone",obj.getString("phone"));
        data.put("rating",obj.getString("rating"));
        data.put("isOnline",obj.getString("isOnline"));
        data.put("isOpen",obj.getString("isOpen"));
        data.put("isDelivery",obj.getString("isDelivery"));
        data.put("lat",obj.getJSONObject("coordinate").getString("lat"));
        data.put("lng",obj.getJSONObject("coordinate").getString("lng"));

        connection = new URL("http://api.dev.orderapp.com:8080/api/v1/restaurants/" + getResponceCountRestaurant() + "/address").openConnection();
        obj = new JSONObject(parser(connection));

        data.put("country",obj.getString("country"));
        data.put("state",obj.getString("state"));
        data.put("city",obj.getString("city"));
        data.put("street",obj.getString("street"));
        data.put("houseNumber",obj.getString("houseNumber"));
        data.put("zip",obj.getString("zip"));
        data.put("deliveryAreaName",obj.getString("deliveryAreaName"));

        connection = new URL("http://api.dev.orderapp.com:8080/api/v1/restaurants/" + getResponceCountRestaurant() + "/categories").openConnection();
        JSONArray arr = new JSONArray(parser(connection));
        for (int i=0;i<arr.length();i++){
            if(arr.getJSONObject(i).getString("name") != null) {
                data.put("categories" + i, arr.getJSONObject(i).getString("name"));
            }
        }

        connection = new URL("http://api.dev.orderapp.com:8080/api/v1/restaurants/" + getResponceCountRestaurant() + "/schedule").openConnection();
        arr = new JSONArray(parser(connection));
        for (int i=0;i<arr.length();i++){
            if(arr.getJSONObject(i).getString("day") != null || arr.getJSONObject(i).getString("opening") != null || arr.getJSONObject(i).getString("closing") != null) {
                data.put("day" + i, arr.getJSONObject(i).getString("day"));
                data.put("opening" + i, String.valueOf((Integer.parseInt(arr.getJSONObject(i).getString("opening"))) / 3600));
                data.put("closing" + i, String.valueOf((Integer.parseInt(arr.getJSONObject(i).getString("closing"))) / 3600));
            }
        }

        return data;
    }

    public void editRestaurantDetails(){
        getRestaurantName().sendKeys("Edit");
        getRestaurantPhone().sendKeys("111");
        getRestaurantDescription().sendKeys("Edit");
        getCategoriesKosher().click();
        getCategories().get(0).click();
        while (!getAddressCountry().getAttribute("value").isEmpty()) {
            getAddressCountry().sendKeys(Keys.BACK_SPACE);
        }
        getAddressCity().sendKeys("Edit");
        getAddressState().sendKeys("Edit");
        getAddressZipCode().sendKeys("Edit");
        getAddressStreet().sendKeys("Edit");
        getAddPhotoButton().sendKeys("/Users/dmitry/Desktop/йцу.jpg");
        getAddPhotoMenu().sendKeys("/Users/dmitry/Desktop/йцу.jpg");
        getSubmitButton().click();
    }

/*    public HashMap<String,String> getResponceRestaurantInfo(HashMap<String,String> data) throws IOException, JSONException {
        URLConnection connection = new URL("http://maps.google.com/maps/api/geocode/json?latlng=" + data.get("lat") + "," + data.get("lng")).openConnection();
        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int rc;
        StringBuilder sb = new StringBuilder();
        while ((rc = reader.read(buffer)) != -1)
            sb.append(buffer, 0, rc);
        reader.close();
        String result = sb.toString();

        JSONObject obj = new JSONObject(result);
        JSONObject res = obj.getJSONArray("results").getJSONObject(0);
        JSONArray loc = res.getJSONArray("address_components");
        for (int i = 0; i < loc.length(); i++) {
            if (!loc.getJSONObject(i).getString("types").equals(null)) {
                System.out.println("1111 " + loc.getJSONObject(i).getString("types"));
                switch (loc.getJSONObject(i).getString("types")) {
                    case "[\"locality\"]":
                        data.put("city",loc.getJSONObject(i).getString("long_name"));
                        break;
                    *//*case "[\"administrative_area_level_1\"]":
                        data.put("state",loc.getJSONObject(i).getString("long_name"));
                        break;*//*
                    case "[\"administrative_area_level_1\",\"political\"]":
                        data.put("state",loc.getJSONObject(i).getString("long_name"));
                        break;
                    case "[\"country\",\"political\"]":
                        data.put("country",loc.getJSONObject(i).getString("long_name"));
                        break;
                    case "[\"postal_code\"]":
                        data.put("zip",loc.getJSONObject(i).getString("long_name"));
                        break;
                    case "[\"street_number\"]":
                        data.put("house_number",loc.getJSONObject(i).getString("long_name"));
                        break;
                    case "[\"route\"]":
                        data.put("street",loc.getJSONObject(i).getString("long_name"));
                        break;
                }
            }
        }

        System.out.println(data);
        return data;
    }*/


    public boolean testCase70() throws InterruptedException, IOException, JSONException {

        signInClass = PageFactory.initElements(driver, SignInClass.class);
        signUpStep1Class = PageFactory.initElements(driver, SignUpStep1Class.class);
        signUpStep2Class = PageFactory.initElements(driver, SignUpStep2Class.class);
        signUpStep3Class = PageFactory.initElements(driver, SignUpStep3Class.class);
        signUpStep4Class = PageFactory.initElements(driver, SignUpStep4Class.class);
        signUpStep5Class = PageFactory.initElements(driver, SignUpStep5Class.class);
        mainScreenSidebar = PageFactory.initElements(driver, MainScreenSidebar.class);

        //Регистрация нового ресторана (заполнены только обязательные поля)
        signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();
        signUpStep1Class.signUpClick(name, "sample111345@extremail.ru", password, confirmPassword);
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpEmptyClick(nameRestaurant);
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpClick(address, city, state, country, zipCode);
        signUpStep4Class.chooseDevice();
        signUpStep4Class.getSignUpButton().click();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();

        //Авторизация под новым рестораном
        signInClass.chooseDevice();
        JOptionPane.showConfirmDialog(null,"Верифицируй email","EMAIL",JOptionPane.ERROR_MESSAGE);
        signInClass.signInClick("sample111345@extremail.ru", password);

        //Проверка соответствия полей страницы MyRestaurant данным, введенным при регистрации, а также проверка на пустоту тех полей которые не заполнялись
        mainScreenSidebar.chooseDevice();
        mainScreenSidebar.getResto().click();

        //Инициализация элементов MyRestaurant
        chooseDevice();

        if (getLogo().getAttribute("ng-src").equals(null)) {
            return false;
        }

        //Берем с сервака всю инфу о последнем созданном ресторане
        HashMap<String,String> data = getResponceRestaurantData();

        //Сравниваем всю инфу
        if(!data.get("name").equals(nameRestaurant)){
            return false;
        }
        if(!data.get("phone").equals("null")){
            return false;
        }
        if(!data.get("description").equals("null")){
            return false;
        }
        if(data.containsKey("categories")) {
            if (!data.get(data.containsKey("categories")).equals("null")) {
                return false;
            }
        }

        if(!data.get("country").equals(country) || !data.get("state").equals(state) || !data.get("city").equals(city) || !data.get("street").equals(address) || !data.get("zip").equals(zipCode)){
            return false;
        }

        for(int i=0;i<getWorkingHoursCheckboxs().size();i++){
            if(getWorkingHoursCheckboxs().get(i).getAttribute("class").contains("ng-not-empty")){
                return false;
            }
        }
        return true;
    }


    public boolean testCase71() throws InterruptedException, IOException, JSONException {

        signInClass = PageFactory.initElements(driver, SignInClass.class);
        signUpStep1Class = PageFactory.initElements(driver, SignUpStep1Class.class);
        signUpStep2Class = PageFactory.initElements(driver, SignUpStep2Class.class);
        signUpStep3Class = PageFactory.initElements(driver, SignUpStep3Class.class);
        signUpStep4Class = PageFactory.initElements(driver, SignUpStep4Class.class);
        signUpStep5Class = PageFactory.initElements(driver, SignUpStep5Class.class);
        mainScreenSidebar = PageFactory.initElements(driver, MainScreenSidebar.class);

        //Регистрация нового ресторана (заполнены только обязательные поля)
        /*signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();
        signUpStep1Class.signUpClick(name, "sample1113456@extremail.ru", password, confirmPassword);
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpFullClick(nameRestaurant,"qwer.jpg","wert.jpeg");
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpFullClick(address, city, state, country, zipCode);
        signUpStep4Class.chooseDevice();
        signUpStep4Class.getSignUpButton().click();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();*/

        //Авторизация под новым рестораном
        signInClass.chooseDevice();
        JOptionPane.showConfirmDialog(null,"Верифицируйте email","EMAIL",JOptionPane.ERROR_MESSAGE);
        signInClass.signInClick("sample1113455@extremail.ru", "111111");

        //Проверка соответствия полей страницы MyRestaurant данным, введенным при регистрации, а также проверка на пустоту тех полей которые не заполнялись
        mainScreenSidebar.chooseDevice();
        mainScreenSidebar.getResto().click();

        //Инициализация элементов MyRestaurant
        chooseDevice();
        setClosePhoto(driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/div/div/div/span")));
        setPhotoSection(driver.findElement(By.id(".//*[@id='mCSB_3_container']/div")));
        setClosePhotoMenu(driver.findElement(By.xpath(".//*[@id='mCSB_4_container']/div/div[1]/div/span")));
        setPhotoMenuSection(driver.findElement(By.xpath(".//*[@id='mCSB_4_container']/div")));



        //Берем с сервака всю инфу о последнем созданном ресторане
        HashMap<String,String> data = getResponceRestaurantData();

        //Сравниваем всю инфу
        if (getLogo().getAttribute("ng-src").equals(null)) {
            return false;
        }
        if(!data.get("name").equals(nameRestaurant)){
            return false;
        }
        if(!data.get("phone").equals("null")){
            return false;
        }
        if(!data.get("description").equals("null")){
            return false;
        }
        if(data.containsKey("categories")) {
            if (!data.get(data.containsKey("categories")).equalsIgnoreCase("Kosher")) {
                return false;
            }
            //if()
        }

        if(!data.get("country").equals(country) || !data.get("state").equals(state) || !data.get("city").equals(city) || !data.get("street").equals(address) || !data.get("zip").equals(zipCode)){
            return false;
        }

        for(int i=0;i<getWorkingHoursCheckboxs().size();i++){
            if(getWorkingHoursCheckboxs().get(i).getAttribute("class").contains("ng-not-empty")){
                return false;
            }
        }
        return true;
    }


    public boolean testCase72() throws InterruptedException {

        signInClass = PageFactory.initElements(driver, SignInClass.class);
        signUpStep1Class = PageFactory.initElements(driver, SignUpStep1Class.class);
        signUpStep2Class = PageFactory.initElements(driver, SignUpStep2Class.class);
        signUpStep3Class = PageFactory.initElements(driver, SignUpStep3Class.class);
        signUpStep4Class = PageFactory.initElements(driver, SignUpStep4Class.class);
        signUpStep5Class = PageFactory.initElements(driver, SignUpStep5Class.class);
        mainScreenSidebar = PageFactory.initElements(driver, MainScreenSidebar.class);

        //Регистрация нового ресторана (заполнены только обязательные поля)
        signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();
        signUpStep1Class.signUpClick(name, email, password, confirmPassword);
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpClick(nameRestaurant,"qwer.jpg","wert.jpeg");
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpFullClick(address, city, state, country, zipCode);
        signUpStep4Class.chooseDevice();
        signUpStep4Class.getSignUpButton().click();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();

        //Авторизация под новым рестораном
        signInClass.chooseDevice();
        signInClass.signInClick(email, password);

        //Проверка соответствия полей страницы MyRestaurant данным, введенным при регистрации, а также проверка на пустоту тех полей которые не заполнялись
        mainScreenSidebar.chooseDevice();
        mainScreenSidebar.getResto().click();

        //Инициализация элементов MyRestaurant
        chooseDevice();

        if (getLogo().getAttribute("ng-src").equals(null)) {
            return false;
        }
       /* if(!comparerNotNull(getRestaurantName()) || !comparerNull(getRestaurantDescription()) || !comparerNull(getRestaurantDescription()) || !comparerAddress(getAddressCountry()) ||
                !comparerAddress(getAddressCity()) || !comparerAddress(getAddressState()) || !comparerAddress(getAddressStreet()) || !comparerAddress(getAddressZipCode()) ||
                !comparerAddress(getDeliveryAreaTittle())){
            return false;
        }*/

        for(int i=0;i<getCategories().size();i++){
            if(getCategories().get(i).getAttribute("class").contains("ng-not-empty")){
                return false;
            }
        }

        if (getPhotoSection() != null) {
            return false;
        }
        if (getPhotoMenuSection() != null) {
            return false;
        }

        for(int i=0;i<getWorkingHoursCheckboxs().size();i++){
            if(getWorkingHoursCheckboxs().get(i).getAttribute("class").contains("ng-not-empty")){
                return false;
            }
        }
        return true;
    }


    public boolean testCase73() throws InterruptedException {

        signInClass = PageFactory.initElements(driver, SignInClass.class);
        signUpStep1Class = PageFactory.initElements(driver, SignUpStep1Class.class);
        signUpStep2Class = PageFactory.initElements(driver, SignUpStep2Class.class);
        signUpStep3Class = PageFactory.initElements(driver, SignUpStep3Class.class);
        signUpStep4Class = PageFactory.initElements(driver, SignUpStep4Class.class);
        signUpStep5Class = PageFactory.initElements(driver, SignUpStep5Class.class);
        mainScreenSidebar = PageFactory.initElements(driver, MainScreenSidebar.class);

        //Регистрация нового ресторана (заполнены только обязательные поля)
        signInClass.chooseDevice();
        signInClass.signUpClick();
        signUpStep1Class.chooseDevice();
        signUpStep1Class.signUpClick(name, email, password, confirmPassword);
        signUpStep2Class.chooseDevice();
        signUpStep2Class.signUpClick(nameRestaurant,"qwer.jpg","wert.jpeg");
        signUpStep3Class.chooseDevice();
        signUpStep3Class.signUpFullClick(address, city, state, country, zipCode);
        signUpStep4Class.chooseDevice();
        signUpStep4Class.getSignUpButton().click();
        signUpStep5Class.chooseDevice();
        signUpStep5Class.signUpClick();

        //Авторизация под новым рестораном
        signInClass.chooseDevice();
        signInClass.signInClick(email, password);

        //Проверка соответствия полей страницы MyRestaurant данным, введенным при регистрации, а также проверка на пустоту тех полей которые не заполнялись
        mainScreenSidebar.chooseDevice();
        mainScreenSidebar.getResto().click();

        //Инициализация элементов MyRestaurant
        chooseDevice();

        if (getLogo().getAttribute("ng-src").equals(null)) {
            return false;
        }
        /*if(!comparerNotNull(getRestaurantName()) || !comparerNull(getRestaurantDescription()) || !comparerNull(getRestaurantDescription()) || !comparerAddress(getAddressCountry()) ||
                !comparerAddress(getAddressCity()) || !comparerAddress(getAddressState()) || !comparerAddress(getAddressStreet()) || !comparerAddress(getAddressZipCode()) ||
                !comparerAddress(getDeliveryAreaTittle())){
            return false;
        }*/

        for(int i=0;i<getCategories().size();i++){
            if(getCategories().get(i).getAttribute("class").contains("ng-not-empty")){
                return false;
            }
        }

        if (getPhotoSection() != null) {
            return false;
        }
        if (getPhotoMenuSection() != null) {
            return false;
        }

        for(int i=0;i<getWorkingHoursCheckboxs().size();i++){
            if(getWorkingHoursCheckboxs().get(i).getAttribute("class").contains("ng-not-empty")){
                return false;
            }
        }
        return true;
    }


    public WebElement getBanner() {
        return banner;
    }

    public void setBanner(WebElement banner) {
        this.banner = banner;
    }

    public WebElement getMyProfile() {
        return myProfile;
    }

    public void setMyProfile(WebElement myProfile) {
        this.myProfile = myProfile;
    }

    public WebElement getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(WebElement restaurantName) {
        this.restaurantName = restaurantName;
    }

    public WebElement getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(WebElement restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public WebElement getRestaurantDescription() {
        return restaurantDescription;
    }

    public void setRestaurantDescription(WebElement restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }

    public List<WebElement> getCategories() {
        return categories;
    }

    public void setCategories(List<WebElement> categories) {
        this.categories = categories;
    }

    public WebElement getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(WebElement addressCountry) {
        this.addressCountry = addressCountry;
    }

    public WebElement getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(WebElement addressCity) {
        this.addressCity = addressCity;
    }

    public WebElement getAddressState() {
        return addressState;
    }

    public void setAddressState(WebElement addressState) {
        this.addressState = addressState;
    }

    public WebElement getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(WebElement addressStreet) {
        this.addressStreet = addressStreet;
    }

    public WebElement getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(WebElement addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public WebElement getDeliveryAreaMap() {
        return deliveryAreaMap;
    }

    public void setDeliveryAreaMap(WebElement deliveryAreaMap) {
        this.deliveryAreaMap = deliveryAreaMap;
    }

    public WebElement getDeliveryAreaTittle() {
        return deliveryAreaTittle;
    }

    public void setDeliveryAreaTittle(WebElement deliveryAreaTittle) {
        this.deliveryAreaTittle = deliveryAreaTittle;
    }

    public WebElement getAddPhotoButton() {
        return addPhotoButton;
    }

    public void setAddPhotoButton(WebElement addPhotoButton) {
        this.addPhotoButton = addPhotoButton;
    }

    public WebElement getClosePhoto() {
        return closePhoto;
    }

    public void setClosePhoto(WebElement closePhoto) {
        this.closePhoto = closePhoto;
    }

    public WebElement getPhotoSection() {
        return photoSection;
    }

    public void setPhotoSection(WebElement photoSection) {
        this.photoSection = photoSection;
    }

    public WebElement getAddPhotoMenu() {
        return addPhotoMenu;
    }

    public void setAddPhotoMenu(WebElement addPhotoMenu) {
        this.addPhotoMenu = addPhotoMenu;
    }

    public WebElement getClosePhotoMenu() {
        return closePhotoMenu;
    }

    public void setClosePhotoMenu(WebElement closePhotoMenu) {
        this.closePhotoMenu = closePhotoMenu;
    }

    public WebElement getPhotoMenuSection() {
        return photoMenuSection;
    }

    public void setPhotoMenuSection(WebElement photoMenuSection) {
        this.photoMenuSection = photoMenuSection;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(WebElement cancelButton) {
        this.cancelButton = cancelButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(WebElement submitButton) {
        this.submitButton = submitButton;
    }
    public WebElement getLogo() {
        return logo;
    }
    public void setLogo(WebElement logo) {
        this.logo = logo;
    }
    public List<WebElement> getWorkingHoursCheckboxs() {
        return workingHoursCheckboxs;
    }
    public void setWorkingHoursCheckboxs(List<WebElement> workingHoursCheckboxs) {
        this.workingHoursCheckboxs = workingHoursCheckboxs;
    }

    public WebElement getCategoriesKosher() {
        return categoriesKosher;
    }

    public void setCategoriesKosher(WebElement categoriesKosher) {
        this.categoriesKosher = categoriesKosher;
    }

    public WebElement getCategoriesNotKosher() {
        return categoriesNotKosher;
    }

    public void setCategoriesNotKosher(WebElement categoriesNotKosher) {
        this.categoriesNotKosher = categoriesNotKosher;
    }
}


