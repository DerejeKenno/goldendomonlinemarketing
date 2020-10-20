package miu.cs545.goldendomonlinemarketing.domain;

import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccount;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends Person {
    private Date dateRegistered;

    @OneToOne
    private BillingAddress billingAddresses;
   @ManyToMany
     private List<Product>productReviews=new ArrayList<>();
    @OneToMany//(mappedBy = "customer")
    private List<ShoppingCart>carts=new ArrayList<>();
    @ManyToMany
    private List<Seller>follows=new ArrayList<>();
    @OneToMany
    private List<Orders> orders=new ArrayList<>();


    public Customer() {
        super();
    }

    public Customer(int personId, String firstName, String lastName, Address address, UserAccount userAccount, Date dateRegistered, BillingAddress billingAddresses, List<Product> productReviews, List<ShoppingCart> carts, List<Seller> follows, List<Orders> orders) {
        super(personId, firstName, lastName, address, userAccount);
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

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;

        //Customer c=new Customer();

    }
}
