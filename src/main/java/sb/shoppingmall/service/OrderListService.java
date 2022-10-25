package sb.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sb.shoppingmall.domain.OrderList;
import sb.shoppingmall.repository.OrderListRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderListService {

    private final OrderListRepository orderListRepository;

    public OrderList save(OrderList orderList) {
        return orderListRepository.save(orderList);
    }

    public List<OrderList> findByUser(Long user_code) {
        return orderListRepository.findByUser(user_code);
    }

    public List<OrderList> findByOrder(Long order_code) {
        return orderListRepository.findByOrder(order_code);
    }
}
