package TestClass.GlobalMethods.models;

import TestClass.GlobalMethods.GlobalMethods;

/**
 * Created by dmitry on 08.06.16.
 */
public class ValidationAddOrder {
    public Boolean key;
    public String restaurant;
    public String order;
    public String description;

    public ValidationAddOrder(Boolean key,String restaurant, String order, String description){
        this.key = key;
        this.restaurant = restaurant;
        this.order = order;
        this.description = description;
    }
}
