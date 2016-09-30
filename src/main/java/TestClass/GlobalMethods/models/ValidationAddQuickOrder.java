package TestClass.GlobalMethods.models;

import TestClass.GlobalMethods.GlobalMethods;

/**
 * Created by dmitry on 08.06.16.
 */
public class ValidationAddQuickOrder{
    public Boolean key;
    public String restaurant;
    public String address;
    public String payment;

    public ValidationAddQuickOrder(Boolean key,String restaurant, String address, String payment){
        this.key = key;
        this.restaurant = restaurant;
        this.address = address;
        this.payment = payment;
    }
}
