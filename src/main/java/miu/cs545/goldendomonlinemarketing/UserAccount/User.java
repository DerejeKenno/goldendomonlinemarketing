package miu.cs545.goldendomonlinemarketing.UserAccount;

import miu.cs545.goldendomonlinemarketing.domain.Person;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int userid;
    private String username;
    private String password;
    public String role;
    private boolean enabled;
   /* @OneToOne(mappedBy="userAccount")
    private Person person;*/

    public User() {
    }

    public User(int userid, String username, String password, String role, boolean enabled) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public int getId() {
        return userid;
    }

    public void setId(int id) {
        this.userid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
