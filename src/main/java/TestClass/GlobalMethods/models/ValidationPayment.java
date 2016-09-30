package TestClass.GlobalMethods.models;

import TestClass.GlobalMethods.GlobalMethods;

/**
 * Created by dmitry on 08.06.16.
 */
public class ValidationPayment {
    public Boolean key;
    public String number1;
    public String number2;
    public String number3;
    public String number4;
    public String dateMonth;
    public String dateYear;
    public String cvv;

    public ValidationPayment(Boolean key, String number1, String number2, String number3, String number4, String dateMonth, String dateYear, String cvv){
        this.key = key;
        this.number1 = number1;
        this.number2=number2;
        this.number3 = number3;
        this.number4 = number4;
        this.dateMonth = dateMonth;
        this.dateYear = dateYear;
        this.cvv = cvv;
    }
}
