package miu.cs545.goldendomonlinemarketing.repositoy;

import miu.cs545.goldendomonlinemarketing.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}
