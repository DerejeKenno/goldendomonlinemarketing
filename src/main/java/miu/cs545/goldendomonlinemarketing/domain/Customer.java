package miu.cs545.goldendomonlinemarketing.domain;

import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccount;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends Person {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateRegistered;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddresses;
    @ManyToMany
    @JoinTable(
            name = "customer_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productReviews = new ArrayList<>();
    @OneToMany//(mappedBy = "customer")
    @JoinTable(
            name = "customer_carts",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private List<ShoppingCart> carts = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "customer_follows",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "seller_id"))
    private List<Seller> follows = new ArrayList<>();
    @OneToMany
    @JoinTable(
            name = "customer_orders",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Orders> orders = new ArrayList<>();


    public Customer() {
        super();
    }

    public Customer(int personId, String firstName, String lastName, UserAccount userAccount, LocalDate dateRegistered, BillingAddress billingAddresses, List<Product> productReviews, List<ShoppingCart> carts, List<Seller> follows, List<Orders> orders) {
        super(personId, firstName, lastName, userAccount);
        this.dateRegistered = dateRegistered;
        this.billingAddresses = billingAddresses;
        this.productReviews = productReviews;
        this.carts = carts;
        this.follows = follows;
        this.orders = orders;
    }


    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public BillingAddress getBillingAddresses() {
        return billingAddresses;
    }

    public void setBillingAddresses(BillingAddress billingAddresses) {
        this.billingAddresses = billingAddresses;
    }

    public void setDateRegistered(LocalDate dateRegistered) {
        this.dateRegistered = dateRegistered;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "dateRegistered=" + dateRegistered +
                ", billingAddresses=" + billingAddresses +
                ", productReviews=" + productReviews +
                ", carts=" + carts +
                ", follows=" + follows +
                ", orders=" + orders +
                '}';
    }
}
