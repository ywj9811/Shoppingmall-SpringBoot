package sb.shoppingmall.repository;

import sb.shoppingmall.domain.OrderList;

import java.util.List;

public interface OrderListRepository {

    OrderList save(OrderList orderList);
    List<OrderList> findByUser(Long user_code);
    List<OrderList> findByOrder(Long order_code);

}
