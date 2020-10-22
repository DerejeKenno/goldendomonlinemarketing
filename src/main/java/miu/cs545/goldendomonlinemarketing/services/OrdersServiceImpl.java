package miu.cs545.goldendomonlinemarketing.services;

import miu.cs545.goldendomonlinemarketing.domain.Orders;
import miu.cs545.goldendomonlinemarketing.repositoy.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    OrdersRepository ordersRepository;


    @Override
    public Orders saveNewOrders(Orders newOrder) {
        return null;
    }
}
