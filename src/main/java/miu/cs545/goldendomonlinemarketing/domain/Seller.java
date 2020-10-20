package miu.cs545.goldendomonlinemarketing.domain;

import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccount;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Seller extends Person {
    private Date hireDate;
    @OneToMany
    private List<Product> productPosts=new ArrayList<>();
    @ManyToMany(mappedBy = "follows")
    private List<Customer> followers=new ArrayList<>();

    public Seller() {
        super();
    }

    public Seller(Date hireDate, List<Product> productPosts, List<Customer> followers) {
        this.hireDate = hireDate;
        this.productPosts = productPosts;
        this.followers = followers;
    }

    public Seller(int personId, String firstName, String lastName, Address address, UserAccount userAccount, Date hireDate, List<Product> productPosts, List<Customer> followers) {
        super(personId, firstName, lastName, address, userAccount);
        this.hireDate = hireDate;
        this.productPosts = productPosts;
        this.followers = followers;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
