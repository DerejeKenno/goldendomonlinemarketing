package miu.cs545.goldendomonlinemarketing.UserAccounts;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    private String username;
    private String password;
    //public String role;
    @ManyToOne
    @JoinColumn(name = "role")
    private Role userRole;
    private Boolean active;

    public UserAccount() {
    }

    public UserAccount(int userid, String username, String password, Role userRole, Boolean active) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.active = active;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", active=" + active +
                '}';
    }
}
