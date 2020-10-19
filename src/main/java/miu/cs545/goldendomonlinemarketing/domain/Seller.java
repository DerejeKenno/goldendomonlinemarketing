package miu.cs545.goldendomonlinemarketing.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Seller extends User {
    private Date hireDate;
    @OneToMany
    private List<Product> productPosts=new ArrayList<>();
    @ManyToMany(mappedBy = "follows")
    private List<Customer> followers=new ArrayList<>();

    public Seller() {
        super();
    }

    public Seller(int userId, String firstName, String lastName, String userName, String password, boolean status, String role, Address address, Date hireDate) {
        super(userId, firstName, lastName, userName, password, status, role, address);
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
