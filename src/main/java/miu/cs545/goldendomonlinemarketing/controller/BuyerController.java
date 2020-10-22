package miu.cs545.goldendomonlinemarketing.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccountService;
import miu.cs545.goldendomonlinemarketing.domain.Orders;
import miu.cs545.goldendomonlinemarketing.domain.Person;
import miu.cs545.goldendomonlinemarketing.domain.Product;
import miu.cs545.goldendomonlinemarketing.domain.Seller;
import miu.cs545.goldendomonlinemarketing.repositoy.PersonRepository;
import miu.cs545.goldendomonlinemarketing.services.Buyerservice;
import miu.cs545.goldendomonlinemarketing.services.OrdersService;
import miu.cs545.goldendomonlinemarketing.services.PersonService;
import miu.cs545.goldendomonlinemarketing.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.*;


@Controller
@RequestMapping("/buyer")
@SessionAttributes("newOrder")
public class BuyerController {


    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private Buyerservice buyerservice;
    @Autowired
    ProductService productService;
    @Autowired
    PersonService personService;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    OrdersService ordersService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private Map<String, String> roles;

    @GetMapping("/orders")
    public String manageOrders() {
        return "/buyer/ordersView";
    }

    @GetMapping("/placeorder")
    public String showProductList(Model model) {

        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList", productList);
        // return "productlist";

        return "/buyer/productSearchForm";
    }

    @PostMapping("/searchproduct")
    public String searchProduct(@RequestParam(name = "keyword") String keyword, Model model) {
        Product product = productService.getProductByName(keyword);
        model.addAttribute("foundproduct", product);
        return "productDetails";

    }

    @GetMapping("/addOrder/")
    public String placeAnOrder(@RequestParam("id") int id, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        System.out.println("uname" + username);
        Person p = personService.getPersonByPersonUsername(username);
        Product product1 = new Product();
        Optional<Product> product = productService.getProductById(id);
        Integer pid = null;
        if (product.isPresent()) {
            product1 = product.get();
        }
        Orders newOrder = new Orders(LocalDate.now(), 1, "not approved", product1);
        model.addAttribute("newOrder", newOrder);
        return "forward:orderDetails";
    }

    @PostMapping("/orderDetails")
    public String orderDetails(@ModelAttribute("newOrder") Orders orders, Model model) {
             Orders savedOrder=(Orders)model.asMap().get("newOrder");
             ordersService.saveNewOrders(savedOrder);
             model.addAttribute(savedOrder);

             System.out.println("Saved Sucessfully!");
        return "orderSuccess";
    }


}
