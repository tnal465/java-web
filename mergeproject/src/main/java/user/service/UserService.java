package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import order.model.Order;
import order.repository.OrderDao;

@Service
public class UserService {

    @Autowired
    private OrderDao orderDao;

    /*
    public List<Order> getOrderList() {
        return orderDao.getOrderList(); 
    }
    */
}