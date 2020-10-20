package miu.cs545.goldendomonlinemarketing.UserAccounts;

import miu.cs545.goldendomonlinemarketing.UserAccounts.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
