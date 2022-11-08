package sb.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sb.shoppingmall.domain.Cart;
import sb.shoppingmall.domain.CartView;
import sb.shoppingmall.repository.CartRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public List<CartView> cartViewList(Long user_code) {
        return cartRepository.cartViewList(user_code);
    }

    public List<Cart> cartList(Long user_code) {
        return cartRepository.cartList(user_code);
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public int cart_plus(Long cart_code) {
        return cartRepository.cart_plus(cart_code);
    }

    public int cart_minus(Long cart_code) {
        return cartRepository.cart_minus(cart_code);
    }

    public int deleteOne(Long cart_code) {
        return cartRepository.deleteOne(cart_code);
    }

    public int deleteAll(Long user_code) {
        return cartRepository.deleteAll(user_code);
    }
}
