package TestClass.GlobalMethods.models;

import TestClass.GlobalMethods.GlobalMethods;

/**
 * Created by dmitry on 08.06.16.
 */
public class ValidationValueSignUpRestaurant{
    public Boolean key;
    public String name;
    public String email;
    public String password;
    public String confirmPassword;

    public ValidationValueSignUpRestaurant(Boolean key,String name, String email, String password, String confirmPassword){
        this.key = key;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
