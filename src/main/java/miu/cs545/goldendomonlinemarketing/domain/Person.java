package miu.cs545.goldendomonlinemarketing.domain;

import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccount;

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
    /*  @OneToOne(cascade = CascadeType.ALL)
      private Address address;// = new ArrayList<>();*/
    @OneToOne
    @JoinColumn(name = "user_account_id")
    UserAccount userAccount;


    public Person() {
    }

    public Person(int personId, String firstName, String lastName, UserAccount userAccount) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        //this.address = address;
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


    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userAccount=" + userAccount +
                '}';
    }
}
