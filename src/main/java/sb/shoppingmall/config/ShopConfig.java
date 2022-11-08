package sb.shoppingmall.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sb.shoppingmall.repository.*;
import sb.shoppingmall.repository.mybatis.*;
import sb.shoppingmall.service.*;

@Configuration
@RequiredArgsConstructor
public class ShopConfig {

    private final UserMapper userMapper;
    private final CartMapper cartMapper;
    private final OrderMapper orderMapper;
    private final PaymentMapper paymentMapper;
    private final OrderListMapper orderListMapper;
    /**
     * 여기에 빈 등록과 매퍼 등록을 하자
     * 기술이 변하면 빠르게 변경할 수 있도록
     */

    @Bean
    public UserRepository userRepository(){
        return new MyBatisUserRepository(userMapper);
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public CartRepository cartRepository(){
        return new MyBatisCartRepository(cartMapper);
    }

    @Bean
    public CartService cartService(){
        return new CartService(cartRepository());
    }

    @Bean
    public OrderRepository orderRepository(){
        return new MyBatisOrderRepository(orderMapper);
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(orderRepository(), cartRepository());
    }

    @Bean
    public PaymentRepository paymentRepository(){
        return new MyBatisPaymentRepository(paymentMapper);
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(paymentRepository());
    }

    @Bean
    public OrderListRepository orderListRepository() {
        return new MyBatisOrderListRepository(orderListMapper);
    }

    @Bean
    public OrderListService orderListService() {
        return new OrderListService(orderListRepository());
    }
}
