package sb.shoppingmall.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import sb.shoppingmall.domain.OrderList;

import java.util.List;

@Mapper
public interface OrderListMapper {
    void save(OrderList orderList);

    List<OrderList> findByOrder(Long order_code);

    List<OrderList> findByUser(Long user_code);
}
