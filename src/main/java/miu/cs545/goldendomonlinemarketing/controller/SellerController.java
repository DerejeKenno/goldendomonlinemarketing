package miu.cs545.goldendomonlinemarketing.controller;

import miu.cs545.goldendomonlinemarketing.UserAccounts.UserAccountService;
import miu.cs545.goldendomonlinemarketing.domain.Product;

import miu.cs545.goldendomonlinemarketing.services.ProductService;

import miu.cs545.goldendomonlinemarketing.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Optional;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserAccountService userAccountService;


    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @RequestMapping(value = {"/addproductForm"}, method = RequestMethod.GET)
    public String addProduct(@ModelAttribute("product") Product product) {
        return "seller/addproductForm";
    }


    @RequestMapping(value = {"/addproduct"}, method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct,
                                           BindingResult result, Model model, HttpServletRequest request, RedirectAttributes ra) {

        MultipartFile productImage = newProduct.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(
                        new File(rootDirectory + "resources\\images\\" + newProduct.getProductId() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }
        Product product1 = productService.saveProduct(newProduct);

        ra.addFlashAttribute("product", product1);

        return "redirect:/productlist";
    }



}
