package miu.cs545.goldendomonlinemarketing.repositoy;

import miu.cs545.goldendomonlinemarketing.domain.Customer;
import miu.cs545.goldendomonlinemarketing.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Customer,Integer> {
}
