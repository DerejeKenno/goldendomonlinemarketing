package miu.cs545.goldendomonlinemarketing.services;

import miu.cs545.goldendomonlinemarketing.domain.Product;
import miu.cs545.goldendomonlinemarketing.repositoy.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        System.out.println("product listt serv..");
        return productRepository.findAll();

    }
}
