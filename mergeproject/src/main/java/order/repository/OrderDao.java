package order.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import order.model.Order;

@Mapper
@Repository
public interface OrderDao {
	public List<Order> getOrderList();
}
