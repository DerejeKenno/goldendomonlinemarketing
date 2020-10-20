package miu.cs545.goldendomonlinemarketing.controller;


import miu.cs545.goldendomonlinemarketing.domain.Product;
import miu.cs545.goldendomonlinemarketing.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ProductService productService;

    @GetMapping("/adminhome")
    public String adminhome(){
        return "admin/adminhome";
    }

    @GetMapping("/productreviews")
    public String productReviews(){
        return "admin/creatreviews";
    }

    @GetMapping("/approvesaler")
    public String approvesaler(){
        return "admin/approvesaler";
    }

    @GetMapping("/pendingsalers")
    public String pendingsalers(){
        return "admin/pendingsalers";
    }

    @GetMapping("/productmanagement")
    public String productmanagement(){
        return "admin/productmanagement";
    }




    @RequestMapping("/productlist")
    public String products(Model model) {
        System.out.println("product listt..");
        List<Product> productList = productService.getAllProducts();

        for (Product p:productList) {
            System.out.println(p);
        }

        model.addAttribute("productList", productList);
        return "admin/productsview";
    }

}
