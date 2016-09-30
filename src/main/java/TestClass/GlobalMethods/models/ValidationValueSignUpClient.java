package TestClass.GlobalMethods.models;

import TestClass.GlobalMethods.GlobalMethods;

/**
 * Created by dmitry on 08.06.16.
 */
public class ValidationValueSignUpClient {
    public Boolean key;
    public String country;
    public String phone;
    public String password;
    public String confirmPassword;

    public ValidationValueSignUpClient(Boolean key,String country, String phone, String password, String confirmPassword){
        this.key = key;
        this.country = country;
        this.phone = phone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
