package miu.cs545.goldendomonlinemarketing.repositoy;

import miu.cs545.goldendomonlinemarketing.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findProductByProductName(String keyword);
}
