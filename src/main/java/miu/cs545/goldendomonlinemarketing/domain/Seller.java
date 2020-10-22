package miu.cs545.goldendomonlinemarketing.domain;

import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccount;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Seller extends Person {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
    @OneToMany
    @JoinTable(
            name = "seller_products",
            joinColumns = @JoinColumn(name = "seller_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productPosts=new ArrayList<>();
    @ManyToMany(mappedBy = "follows")
    private List<Customer> followers=new ArrayList<>();

    public Seller() {
        super();
    }

    public Seller(LocalDate hireDate, List<Product> productPosts, List<Customer> followers) {
        this.hireDate = hireDate;
        this.productPosts = productPosts;
        this.followers = followers;
    }

    public Seller(int personId, String firstName, String lastName,  UserAccount userAccount, LocalDate hireDate, List<Product> productPosts, List<Customer> followers) {
        super(personId, firstName, lastName, userAccount);
        this.hireDate = hireDate;
        this.productPosts = productPosts;
        this.followers = followers;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}
