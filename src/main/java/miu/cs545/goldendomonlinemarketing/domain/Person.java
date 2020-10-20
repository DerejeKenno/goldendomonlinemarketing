package miu.cs545.goldendomonlinemarketing.domain;

import miu.cs545.goldendomonlinemarketing.UserAccount.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    private int personId;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Address> addresses = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_account_id")
    User userAccount;

    /*private String username;
    private String password;
    private String role;
    private boolean enabled;*/


    public Person() {
    }

    public Person(int personId, String firstName, String lastName, List<Address> addresses, User userAccount) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
        this.userAccount = userAccount;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public User getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(User userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addresses=" + addresses +
                ", userAccount=" + userAccount +
                '}';
    }
}
