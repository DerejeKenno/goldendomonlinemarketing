package miu.cs545.goldendomonlinemarketing.controller;

import miu.cs545.goldendomonlinemarketing.UserAccounts.Role;
import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccount;
import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccountService;
import miu.cs545.goldendomonlinemarketing.domain.Customer;
import miu.cs545.goldendomonlinemarketing.domain.Seller;
import miu.cs545.goldendomonlinemarketing.services.Buyerservice;
import miu.cs545.goldendomonlinemarketing.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/")
@SessionAttributes("savedUser")
public class HomeController {
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private Buyerservice buyerservice;
    @Autowired
    private SellerService sellerService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private Map<String, String> roles;


    @RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @GetMapping("/signup")
    public String signUpForm(@ModelAttribute("newUser") UserAccount user) {
        return "signupform";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUserAccount(@ModelAttribute("newUser") UserAccount user, Model model) {
        user.setUserRole(new Role(1, "ROLE_BUYER"));
        user.setActive(true);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        encodedPassword = encodedPassword;
        user.setPassword(encodedPassword);

        UserAccount savedUser = userAccountService.saveUserAccount(user);
        model.addAttribute("savedUser", savedUser);

        // rd.addFlashAttribute("savedUser",savedUser);
System.out.println("1."+savedUser.getUsername());
        return "redirect:customerForm";

    }


    @RequestMapping(value = "/customerForm", method = RequestMethod.GET)
    public String customerRegisterForm(@ModelAttribute("newCustomer") Customer customer, Model model) {

        return "customerFormView";
    }

    @PostMapping("/processCustomerForm")
    public String processCustomerForm(@ModelAttribute("newCustomer") Customer customer, Model model, RedirectAttributes rd) {

        UserAccount customerAccount = (UserAccount) model.asMap().get("savedUser");

        customer.setUserAccount(customerAccount);

        customer.setPersonId(customerAccount.getUserid());
        customer.setDateRegistered(LocalDate.now());

        Customer savedCustomer = buyerservice.saveCustomer(customer);
        rd.addFlashAttribute("newCustomer", savedCustomer);
        return "redirect:customerDetails";
    }

    @RequestMapping(value = "/customerDetails", method = RequestMethod.GET)
    public String customerDetails(@ModelAttribute("newCustomer") Customer customer) {

        return "customerDetailsView";
    }


    //============================seller============================================
@GetMapping("/Sellersignup")
public String ssignUpForm(@ModelAttribute("newUser") UserAccount user) {
    return "sellersignupform";
}

    @RequestMapping(value = "/saveSeller", method = RequestMethod.POST)
    public String saveSellerAccount(@ModelAttribute("newUser") UserAccount user, Model model) {
        user.setUserRole(new Role(1, "ROLE_SELLER"));
        user.setActive(true);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        encodedPassword = encodedPassword;
        user.setPassword(encodedPassword);

        UserAccount savedUser = userAccountService.saveUserAccount(user);
        model.addAttribute("savedUser", user);

        // rd.addFlashAttribute("savedUser",savedUser);

        return "redirect:sellerForm";

    }

    @RequestMapping(value = "/sellerForm", method = RequestMethod.GET)
    public String SellerRegisterForm(@ModelAttribute("newSeller") Seller Seller, Model model) {

        return "sellerFormView";
    }

    @PostMapping("/processSellerForm")
    public String processSellerForm(Seller seller, Model model, RedirectAttributes rd) {
        UserAccount customerAccount = (UserAccount) model.asMap().get("savedUser");
        seller.setUserAccount(customerAccount);
        seller.setPersonId(customerAccount.getUserid());
        seller.setHireDate(LocalDate.now());

        Seller savedSeller = sellerService.saveSeller(seller);
        rd.addFlashAttribute("newSeller", savedSeller);
        return "redirect:sellerDetails";
    }

    @RequestMapping(value = "/sellerDetails", method = RequestMethod.GET)
    public String SellerDetails(@ModelAttribute("newSeller") Seller Seller) {

        return "sellerDetailsView";
    }



}
