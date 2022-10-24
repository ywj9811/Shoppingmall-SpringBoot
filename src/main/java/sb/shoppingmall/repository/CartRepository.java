package sb.shoppingmall.repository;

import sb.shoppingmall.domain.Cart;

import java.util.List;

public interface CartRepository {

    List<Cart> cartList(Long user_code);
    Cart save(Cart cart);

    int cart_plus(Cart cart);

    int cart_minus(Cart cart);

    int deleteOne(Cart cart);

    int deleteAll(Long user_code);
    /**
     * 추후에 추가
     */
}
