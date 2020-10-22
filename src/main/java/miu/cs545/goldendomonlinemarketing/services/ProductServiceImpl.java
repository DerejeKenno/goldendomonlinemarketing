package miu.cs545.goldendomonlinemarketing.services;

import miu.cs545.goldendomonlinemarketing.domain.Product;
import miu.cs545.goldendomonlinemarketing.repositoy.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        System.out.println("product listt serv..");
        return productRepository.findAll();

    }

    @Override
    public Product saveProduct(Product product) {
        Product product1 = productRepository.save(product);
        return product1;
    }

    @Override
    public Product getProductByName(String keyword) {
        Product product=productRepository.findProductByProductName(keyword);
        return product;
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }


}
