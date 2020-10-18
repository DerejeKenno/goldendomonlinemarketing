package miu.cs545.goldendomonlinemarketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buyer")
public class BuyerController {


    @GetMapping("/cart")
    public String cart(){
        return "buyer/cart";
    }

    @GetMapping("/checkout")
    public String checkout(){
        return "buyer/checkout";
    }

    @GetMapping("/orders")
    public String orders(){
        return "buyer/orders";
    }
}
