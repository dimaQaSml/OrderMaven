package GlobalMethods.models;

import GlobalMethods.GlobalMethods;

/**
 * Created by dmitry on 08.06.16.
 */
public class ValidationSignUpRestaurantStep3 {
    public Boolean key;
    public String address;
    public String city;
    public String state;
    public String country;
    public String zipCode;

    public ValidationSignUpRestaurantStep3(Boolean key,String address, String city, String state, String country, String zipCode){
        this.key = key;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
