package miu.cs545.goldendomonlinemarketing.domain;

import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccount;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends Person {

   // @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date dateRegistered;

    @OneToOne(cascade = CascadeType.ALL)
    private BillingAddress billingAddresses;
    @ManyToMany
    private List<Product> productReviews = new ArrayList<>();
    @OneToMany//(mappedBy = "customer")
    private List<ShoppingCart> carts = new ArrayList<>();
    @ManyToMany
    private List<Seller> follows = new ArrayList<>();
    @OneToMany
    private List<Orders> orders = new ArrayList<>();


    public Customer() {
        super();
    }

    public Customer(int personId, String firstName, String lastName, UserAccount userAccount, Date dateRegistered, BillingAddress billingAddresses, List<Product> productReviews, List<ShoppingCart> carts, List<Seller> follows, List<Orders> orders) {
        super(personId, firstName, lastName, userAccount);
        this.dateRegistered = dateRegistered;
        this.billingAddresses = billingAddresses;
        this.productReviews = productReviews;
        this.carts = carts;
        this.follows = follows;
        this.orders = orders;
    }


    public Date getDateRegistered() {
        return dateRegistered;
    }

    public BillingAddress getBillingAddresses() {
        return billingAddresses;
    }

    public void setBillingAddresses(BillingAddress billingAddresses) {
        this.billingAddresses = billingAddresses;
    }

    public void setDateRegistered(Date dateRegistered) {
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
