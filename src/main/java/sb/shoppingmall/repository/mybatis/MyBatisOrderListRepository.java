package sb.shoppingmall.repository.mybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sb.shoppingmall.domain.OrderList;
import sb.shoppingmall.repository.OrderListRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisOrderListRepository implements OrderListRepository {

    private final OrderListMapper orderListMapper;

    @Override
    public OrderList save(OrderList orderList) {
        orderListMapper.save(orderList);
        return orderList;
    }

    @Override
    public List<OrderList> findByUser(Long user_code) {
        return orderListMapper.findByUser(user_code);
    }

    @Override
    public List<OrderList> findByOrder(Long order_code) {
        return orderListMapper.findByOrder(order_code);
    }
}
