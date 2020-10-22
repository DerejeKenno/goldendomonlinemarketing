package miu.cs545.goldendomonlinemarketing.services;

import miu.cs545.goldendomonlinemarketing.domain.Seller;
import miu.cs545.goldendomonlinemarketing.repositoy.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerRepository sellerRepository;
    @Override
    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
}
