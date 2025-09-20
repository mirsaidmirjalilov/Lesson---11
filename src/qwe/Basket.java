package qwe;

import java.util.Date;
import java.util.List;

public class Basket {
    private Integer id;
    private Customer customer;
    private List<Product> productList;
    private Date time;

    public Basket(Integer id, Customer customer, List<Product> productList, Date time) {
        this.id = id;
        this.customer = customer;
        this.productList = productList;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "qwe.Basket{" +
                "id=" + id +
                ", customer=" + customer +
                ", productList=" + productList +
                ", time=" + time +
                '}';
    }
}
