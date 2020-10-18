package miu.cs545.goldendomonlinemarketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

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
}
