package miu.cs545.goldendomonlinemarketing.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    private Date addedDate;
    private int itemQuality;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Product product;

    public ShoppingCart() {
    }

    public ShoppingCart(Date addedDate, int itemQuality, Customer customer, Product product) {
        this.addedDate = addedDate;
        this.itemQuality = itemQuality;
        this.customer = customer;
        this.product = product;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getItemQuality() {
        return itemQuality;
    }

    public void setItemQuality(int itemQuality) {
        this.itemQuality = itemQuality;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
