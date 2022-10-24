package sb.shoppingmall.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import sb.shoppingmall.domain.Order;

@Mapper
public interface OrderMapper {

    void save(Order order);

    Order find(Order order);
}
