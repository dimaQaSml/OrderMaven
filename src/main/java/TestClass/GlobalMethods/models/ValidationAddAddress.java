package TestClass.GlobalMethods.models;

import TestClass.GlobalMethods.GlobalMethods;

/**
 * Created by dmitry on 08.06.16.
 */
public class ValidationAddAddress{
    public Boolean key;
    public String city;
    public String address;
    public String home;

    public ValidationAddAddress(Boolean key, String city, String address, String home){
        this.key = key;
        this.city = city;
        this.address = address;
        this.home = home;
    }
}
