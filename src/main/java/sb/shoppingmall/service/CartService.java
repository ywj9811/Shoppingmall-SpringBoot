package sb.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sb.shoppingmall.domain.Cart;
import sb.shoppingmall.repository.CartRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public List<Cart> cartList(Long user_code) {
        return cartRepository.cartList(user_code);
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public int cart_plus(Cart cart) {
        return cartRepository.cart_plus(cart);
    }

    public int cart_minus(Cart cart) {
        return cartRepository.cart_minus(cart);
    }

    public int deleteOne(Cart cart) {
        return cartRepository.deleteOne(cart);
    }

    public int deleteAll(Long user_code) {
        return cartRepository.deleteAll(user_code);
    }
}
