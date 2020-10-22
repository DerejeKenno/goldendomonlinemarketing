package miu.cs545.goldendomonlinemarketing.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private int quantity;
    private String orderStatus;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Customer buyer;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @OneToOne
    @JoinColumn(name = "shipping_id")
    private ShippingInfo shippingInfo;

    public Orders() {
    }

    public Orders(LocalDate orderDate, int quantity, String orderStatus, Product product) {
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
      //  this.buyer = buyer;
        this.product = product;
      //  this.shippingInfo = shippingInfo;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
