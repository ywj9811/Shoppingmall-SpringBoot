package sb.shoppingmall.repository.mybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sb.shoppingmall.domain.Cart;
import sb.shoppingmall.repository.CartRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisCartRepository implements CartRepository {

    private final CartMapper cartMapper;

    @Override
    public List<Cart> cartList(Long user_code){
        return cartMapper.cartList(user_code);
    }

    @Override
    public Cart save(Cart cart) {
        cartMapper.save(cart);
        return cart;
    }

    @Override
    public int cart_plus(Cart cart) {
        return cartMapper.cart_plus(cart);
    }

    @Override
    public int cart_minus(Cart cart) {
        return cartMapper.cart_minus(cart);
    }

    @Override
    public int deleteOne(Cart cart) {
        return cartMapper.deleteOne(cart);
    }

    @Override
    public int deleteAll(Long user_code) {
        return cartMapper.deleteAll(user_code);
    }
}
