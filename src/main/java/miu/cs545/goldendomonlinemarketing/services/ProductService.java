package miu.cs545.goldendomonlinemarketing.services;

import miu.cs545.goldendomonlinemarketing.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product saveProduct(Product product);

    Product getProductByName(String keyword);
    Optional<Product> getProductById(int id);

}
