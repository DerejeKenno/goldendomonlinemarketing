package miu.cs545.goldendomonlinemarketing.repositoy;

import miu.cs545.goldendomonlinemarketing.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer> {

}
