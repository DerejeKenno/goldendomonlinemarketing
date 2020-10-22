package miu.cs545.goldendomonlinemarketing.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private Date paymentDate;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "billing_address_id")
    private BillingAddress billingAddress;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    public Payment() {
    }

    public Payment(Date paymentDate, double amount, BillingAddress billingAddress, Orders order) {
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.billingAddress = billingAddress;
        this.order = order;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
