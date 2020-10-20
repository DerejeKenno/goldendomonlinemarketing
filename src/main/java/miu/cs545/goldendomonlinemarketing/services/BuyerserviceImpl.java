package miu.cs545.goldendomonlinemarketing.services;

import miu.cs545.goldendomonlinemarketing.domain.Customer;
import miu.cs545.goldendomonlinemarketing.repositoy.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerserviceImpl implements Buyerservice{
    @Autowired
    private BuyerRepository buyerRepository;
    public Customer saveCustomer(Customer customer){
        return buyerRepository.save(customer);
    }
}
