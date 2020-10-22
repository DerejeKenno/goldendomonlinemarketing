package miu.cs545.goldendomonlinemarketing.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String description;
    private double unitPrice;
    private String category;
    @JsonIgnore
   private CommonsMultipartFile productImage;
    @ManyToMany(mappedBy = "productReviews")
    private List<Customer> reviewers=new ArrayList<>();


    public Product() {
    }

    public Product(String productName, String description, double unitPrice, String category, CommonsMultipartFile productImage, List<Customer> reviewers) {
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.category = category;
        this.productImage = productImage;
        this.reviewers = reviewers;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CommonsMultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(CommonsMultipartFile productImage) {
        this.productImage = productImage;
    }

    public List<Customer> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Customer> reviewers) {
        this.reviewers = reviewers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", category='" + category + '\'' +
                ", productImage='" + productImage + '\'' +
                ", reviewers=" + reviewers +
                '}';
    }
}
