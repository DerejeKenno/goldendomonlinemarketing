package miu.cs545.goldendomonlinemarketing.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import miu.cs545.goldendomonlinemarketing.UserAccount.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username=:username")
    public User getUserByUsername(@Param("username") String username);
}
