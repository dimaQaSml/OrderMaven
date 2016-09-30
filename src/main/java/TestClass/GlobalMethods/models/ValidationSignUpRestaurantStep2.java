package TestClass.GlobalMethods.models;

import TestClass.GlobalMethods.GlobalMethods;

/**
 * Created by dmitry on 08.06.16.
 */
public class ValidationSignUpRestaurantStep2{
    public Boolean key;
    public String logo;
    public String name;
    public String restoImage;
    public String restoMenu;

    public ValidationSignUpRestaurantStep2(Boolean key, String logo, String name, String restoImage, String restoMenu) {
        this.key = key;
        this.logo = logo;
        this.name = name;
        this.restoImage = restoImage;
        this.restoMenu = restoMenu;
    }
}
