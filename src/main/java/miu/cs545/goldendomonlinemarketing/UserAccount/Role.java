package miu.cs545.goldendomonlinemarketing.UserAccount;

import javax.persistence.*;


@Entity
//@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @Column(name = "role_id")
    private int role_id;
    //@Column(name = "role")
    private String role;

    public Role() {
    }

    public Role(int role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role='" + role + '\'' +
                '}';
    }
}
