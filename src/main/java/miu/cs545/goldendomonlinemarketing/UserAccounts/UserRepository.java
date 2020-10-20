package miu.cs545.goldendomonlinemarketing.UserAccounts;

import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {

    @Query("select u from UserAccount u where u.username=:username")
    public UserAccount getUserByUsername(@Param("username") String username);
}
