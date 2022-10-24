package sb.shoppingmall.repository.mybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sb.shoppingmall.domain.Order;
import sb.shoppingmall.repository.OrderRepository;

@Repository
@RequiredArgsConstructor
public class MyBatisOrderRepository implements OrderRepository {

    private final OrderMapper orderMapper;
    @Override
    public Order save(Order order) {
        orderMapper.save(order);
        return order;
    }

    @Override
    public Order find(Order order) {
        return orderMapper.find(order);
    }
}
