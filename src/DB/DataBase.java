package DB;

import qwe.Basket;
import qwe.Customer;
import qwe.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface DataBase {
    List<Customer> customers = Collections.synchronizedList(new ArrayList<>());
    List<Product> products = Collections.synchronizedList(new ArrayList<>());
    List<Basket> baskets = Collections.synchronizedList(new ArrayList<>());


}
