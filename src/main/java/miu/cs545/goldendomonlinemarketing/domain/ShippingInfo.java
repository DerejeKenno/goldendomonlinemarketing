package miu.cs545.goldendomonlinemarketing.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ShippingInfo {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date shipDate;
    @ManyToOne
    private Address shippingAddress;

    public ShippingInfo() {
    }

    public ShippingInfo(Date shipDate, Address shippingAddress) {
        this.shipDate = shipDate;
        this.shippingAddress = shippingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
