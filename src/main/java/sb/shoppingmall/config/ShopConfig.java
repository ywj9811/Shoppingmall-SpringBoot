package sb.shoppingmall.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sb.shoppingmall.repository.UserRepository;
import sb.shoppingmall.repository.mybatis.MyBatisUserRepository;
import sb.shoppingmall.repository.mybatis.UserMapper;
import sb.shoppingmall.service.UserService;

@Configuration
@RequiredArgsConstructor
public class ShopConfig {

    private final UserMapper userMapper;

    /**
     * 여기에 빈 등록과 매퍼 등록을 하자
     */

    @Bean
    public UserRepository userRepository(){
        return new MyBatisUserRepository(userMapper);
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }
}
