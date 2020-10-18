package miu.cs545.goldendomonlinemarketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

    @GetMapping("/accessdenied")
    public String accessdenied() {
        return "authentication/accessdenied";
    }


}
