package miu.cs545.goldendomonlinemarketing.domain;

import javax.persistence.Entity;

@Entity
public class BillingAddress extends Address {
    private int cardNo;
    private String cardProvider;

    public BillingAddress(int cardNo, String cardProvider) {
        this.cardNo = cardNo;
        this.cardProvider = cardProvider;
    }

    public BillingAddress(String country, String state, String city, String street, int zipCode, String phone, String email, int cardNo, String cardProvider) {
        super(country, state, city, street, zipCode, phone, email);
        this.cardNo = cardNo;
        this.cardProvider = cardProvider;
    }

    public BillingAddress() {
        super();
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardProvider() {
        return cardProvider;
    }

    public void setCardProvider(String cardProvider) {
        this.cardProvider = cardProvider;
    }
}
