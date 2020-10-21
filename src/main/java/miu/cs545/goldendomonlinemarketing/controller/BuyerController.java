package miu.cs545.goldendomonlinemarketing.controller;

import miu.cs545.goldendomonlinemarketing.UserAccounts.Role;
import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccount;
import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccountService;
import miu.cs545.goldendomonlinemarketing.domain.Customer;
import miu.cs545.goldendomonlinemarketing.services.Buyerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/buyer")
@SessionAttributes("savedUser")
public class BuyerController {

    /* @Autowired
     private UserDetailsManager userDetailsManager;*/
    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private Buyerservice buyerservice;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private Map<String, String> roles;



   /* @PostConstruct
    protected void loadRoles() {
        roles = new LinkedHashMap<String, String>();
        roles.put("ROLE_BUYER", "Buyer");
        roles.put("ROLE_SELLER", "Seller");
        roles.put("ROLE_ADMIN", "Admin");
    }*/

    @RequestMapping(value = "/registerbuyer", method = RequestMethod.GET)
    public String signUpForm(@ModelAttribute("newUser") UserAccount user) {
        return "signupform";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUserAccount(@ModelAttribute("newUser") UserAccount user, Model model) {
        user.setUserRole(new Role(1, "ROLE_BUYER"));
        user.setActive(true);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        encodedPassword = "{bcrypt}" + encodedPassword;
        user.setPassword(encodedPassword);

        UserAccount savedUser = userAccountService.saveUserAccount(user);
        model.addAttribute("savedUser", user);

        // rd.addFlashAttribute("savedUser",savedUser);

        return "redirect:customerForm";

    }

    @RequestMapping(value = "/customerForm", method = RequestMethod.GET)
    public String customerRegisterForm(@ModelAttribute("newCustomer") Customer customer, Model model) {

        return "buyer/customerFormView";
    }

    @PostMapping("/processCustomerForm")
    public String processCustomerForm(Customer customer, Model model, RedirectAttributes rd) {
        UserAccount customerAccount = (UserAccount) model.asMap().get("savedUser");
        customer.setUserAccount(customerAccount);
        customer.setPersonId(customerAccount.getUserid());
        customer.setDateRegistered(new java.util.Date());

        Customer savedCustomer = buyerservice.saveCustomer(customer);
        rd.addFlashAttribute("customer", savedCustomer);
        return "redirect:customerDetails";
    }


    @RequestMapping(value = "/customerDetails", method = RequestMethod.GET)
    public String customerDetails(Model model) {

        return "customerDetailsView";
    }







   /* @GetMapping("/entries")
    public String success(@ModelAttribute Entry entry, Model model){
        List<Entry> entryList = entryService.getAllEntry();
        model.addAttribute(entryList);
        return "admin/entrylist";
    }


    @GetMapping("/editentry/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {

        Entry entry = entryService.getEntryByEntryID(id);
        //.orElseThrow(()-> new IllegalArgumentException("Invalid Entry Id:" + id));
        model.addAttribute("entry",entry);
        return "admin/update-entry";
    }

    @PostMapping("/updateentry/{id}")
    public String updateentry(@PathVariable("id") long id, @Valid Entry entry, BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            entry.setEntryID(id);
            return "admin/update-entry";
        }
        entry.setEntryID(id);
        entryService.save(entry);
        model.addAttribute("entry", entryService.getAllEntry());
        return "redirect:/admin/entries";
    }
    @GetMapping("deleteentry/{id}")
    public String deleteentry(@PathVariable("id") long id, Model model) {
        Entry entry = entryService.getEntryByEntryID(id);
        //.orElseThrow(()-> new IllegalArgumentException("Invalid student Id:" + id));

        entryService.delete(entry);
        model.addAttribute("entry",entryService.getEntryByEntryID(id));
        return "redirect:/admin/entries";
    }*/
}
