package TestClass.GlobalMethods.models;

import TestClass.GlobalMethods.GlobalMethods;

/**
 * Created by dmitry on 08.06.16.
 */
public class ValidationAddAddress{
    public Boolean key;
    public String city;
    public String address;
    public String name;

    public ValidationAddAddress(Boolean key, String city, String address, String name){
        this.key = key;
        this.city = city;
        this.address = address;
        this.name = name;
    }
}
