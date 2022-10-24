package sb.shoppingmall.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sb.shoppingmall.service.CartService;
import sb.shoppingmall.service.UserService;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
public class CartTest {

    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;

    @Test
    void save() {
        User test = userService.findById("test");
        Cart cart = new Cart(1L, test.getUser_code(), 1);
        Cart save = cartService.save(cart);
        log.info("cartSave = {} ", save);
        assertThat(save).isEqualTo(cartService.cartList(test.getUser_code()).get(0));
    }

    @Test
    void cart_plus() {
        User test = userService.findById("test");
        Cart cart = new Cart(1L, test.getUser_code(), 1);
        cartService.save(cart);

        cartService.cart_plus(cart);
        assertThat(cartService.cartList(test.getUser_code()).get(0).getCart_cnt()).isEqualTo(2);
    }

    @Test
    void cart_minus_no() {
        User test = userService.findById("test");
        Cart cart = new Cart(1L, test.getUser_code(), 1);
        cartService.save(cart);

        int rs = cartService.cart_minus(cart);
        assertThat(rs).isEqualTo(1);
    }

    @Test
    void cart_minus_yes() {
        User test = userService.findById("test");
        Cart cart = new Cart(1L, test.getUser_code(), 2);
        cartService.save(cart);

        int rs = cartService.cart_minus(cart);
        assertThat(rs).isEqualTo(1);
    }

    @Test
    void delOne() {
        User test = userService.findById("test");
        Cart cart = new Cart(1L, test.getUser_code(), 1);
        Cart cart2 = new Cart(2L, test.getUser_code(), 1);
        cartService.save(cart);
        cartService.save(cart2);

        cartService.deleteOne(cart);

        List<Cart> list = cartService.cartList(test.getUser_code());
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void delAll() {
        User test = userService.findById("test");
        Cart cart = new Cart(1L, test.getUser_code(), 1);
        Cart cart2 = new Cart(2L, test.getUser_code(), 1);
        cartService.save(cart);
        cartService.save(cart2);

        cartService.deleteAll(test.getUser_code());

        List<Cart> list = cartService.cartList(test.getUser_code());
        assertThat(list.size()).isEqualTo(0);
    }

}
