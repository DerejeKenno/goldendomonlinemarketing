package miu.cs545.goldendomonlinemarketing.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean status;
    private String role;

    @OneToMany
    private List<Address> addresses=new ArrayList<>();

    public User() {
    }

    public User(int userId, String firstName, String lastName, String userName, String password, boolean status, String role, Address address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.role = role;
        this.addresses.add(address);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(Address address) {
        this.addresses.add(address);
    }
}
