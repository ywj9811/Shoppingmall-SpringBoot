package sb.shoppingmall.repository;

import sb.shoppingmall.domain.Cart;
import sb.shoppingmall.domain.CartView;

import java.util.List;

public interface CartRepository {
    List<CartView> cartViewList(Long user_code);

    List<Cart> cartList(Long user_code);
    Cart save(Cart cart);

    int cart_plus(Long cart_code);

    int cart_minus(Long cart_code);

    int deleteOne(Long cart_code);

    int deleteAll(Long user_code);
    /**
     * 추후에 추가
     */
}
