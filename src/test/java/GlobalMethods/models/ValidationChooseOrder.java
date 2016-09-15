package GlobalMethods.models;

/**
 * Created by dmitry on 04.08.16.
 */
public class ValidationChooseOrder {
    public Boolean key;
    public String favoriteOrder;
    public String typeNewOrder;

    public ValidationChooseOrder(Boolean key,String favoriteOrder, String typeNewOrder){
        this.key = key;
        this.favoriteOrder = favoriteOrder;
        this.typeNewOrder = typeNewOrder;
    }
}
