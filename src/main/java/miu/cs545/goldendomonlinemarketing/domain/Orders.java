package miu.cs545.goldendomonlinemarketing.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private Date orderDate;
    private int quantity;
    private String orderStatus;
    @ManyToOne
    private Customer buyer;
    @ManyToOne
    private Product product;
    @OneToOne
    private ShippingInfo shippingInfo;

    public Orders() {
    }

    public Orders(Date orderDate, int quantity, String orderStatus, Customer buyer, Product product, ShippingInfo shippingInfo) {
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.buyer = buyer;
        this.product = product;
        this.shippingInfo = shippingInfo;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
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
