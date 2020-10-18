package miu.cs545.goldendomonlinemarketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @GetMapping("/addproduct")
    public String addproduct(){
        return "seller/addproduct";
    }

}
