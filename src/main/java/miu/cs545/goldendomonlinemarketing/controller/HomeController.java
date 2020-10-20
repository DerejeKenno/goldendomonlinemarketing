package miu.cs545.goldendomonlinemarketing.controller;

import miu.cs545.goldendomonlinemarketing.domain.Product;
import miu.cs545.goldendomonlinemarketing.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @RequestMapping("/home")
    public String products(Model model) {
        System.out.println("product listt..");
        List<Product> productList = productService.getAllProducts();

        for (Product p : productList) {
            System.out.println(p);
        }

        model.addAttribute("productList", productList);
        return "home.html";
    }
}
