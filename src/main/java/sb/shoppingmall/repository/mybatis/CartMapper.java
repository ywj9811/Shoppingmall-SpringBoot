package sb.shoppingmall.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import sb.shoppingmall.domain.Cart;

import java.util.List;

@Mapper
public interface CartMapper {

    List<Cart> cartList(Long user_code);

    void save(Cart cart);

    int cart_plus(Long cart_code);

    int cart_minus(Long cart_code);

    int deleteOne(Long cart_code);

    int deleteAll(Long user_code);
}
