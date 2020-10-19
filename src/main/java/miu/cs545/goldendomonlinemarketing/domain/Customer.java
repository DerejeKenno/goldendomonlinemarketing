package miu.cs545.goldendomonlinemarketing.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends User{
    private Date dateRegistered;

    @OneToOne
    private BillingAddress billingAddresses;
   @ManyToMany
     private List<Product>productReviews=new ArrayList<>();
    @OneToMany(mappedBy = "customer")
    private List<ShoppingCart>carts=new ArrayList<>();
    @ManyToMany
    private List<Seller>follows=new ArrayList<>();
    @OneToMany
    private List<Orders> orders=new ArrayList<>();




    public Customer(int userId, String firstName, String lastName, String userName, String password, boolean status, String role, Address address, Date dateRegistered) {
        super(userId, firstName, lastName, userName, password, status, role, address);
        this.dateRegistered = dateRegistered;
    }

    public Customer() {
        super();
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
