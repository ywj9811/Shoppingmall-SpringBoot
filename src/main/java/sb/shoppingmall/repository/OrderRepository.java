package sb.shoppingmall.repository;

import sb.shoppingmall.domain.Order;

public interface OrderRepository {
    Order save(Order order);

    Order find(Order order);
}
