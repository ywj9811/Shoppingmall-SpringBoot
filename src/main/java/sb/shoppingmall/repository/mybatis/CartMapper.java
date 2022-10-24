package sb.shoppingmall.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import sb.shoppingmall.domain.Cart;

import java.util.List;

@Mapper
public interface CartMapper {

    List<Cart> cartList(Long user_code);

    void save(Cart cart);

    int cart_plus(Cart cart);

    int cart_minus(Cart cart);

    int deleteOne(Cart cart);

    int deleteAll(Long user_code);
}
