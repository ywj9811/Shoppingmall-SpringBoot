package sb.shoppingmall.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sb.shoppingmall.repository.CartRepository;
import sb.shoppingmall.repository.UserRepository;
import sb.shoppingmall.repository.mybatis.CartMapper;
import sb.shoppingmall.repository.mybatis.MyBatisCartRepository;
import sb.shoppingmall.repository.mybatis.MyBatisUserRepository;
import sb.shoppingmall.repository.mybatis.UserMapper;
import sb.shoppingmall.service.CartService;
import sb.shoppingmall.service.UserService;

@Configuration
@RequiredArgsConstructor
public class ShopConfig {

    private final UserMapper userMapper;
    private final CartMapper cartMapper;

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
}
