package sb.shoppingmall.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sb.shoppingmall.domain.User;
import sb.shoppingmall.repository.UserRepository;
import sb.shoppingmall.service.UserService;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    void nothing(){
        User test = userRepository.idCheck(".!.");
        assertThat(test).isNull();
    }
    @Test
    void save(){
        User user = new User( "abc", "2443", "a", "123123123123", "123@123123",
                "as", "asv", 123456, "123456", "b");
        log.info("{}", user);
        User saveUser = userService.save(user);
        log.info("확인 = {}", saveUser);

        User findUser = userRepository.idCheck(user.getUser_id());
        assertThat(findUser.getUser_addr()).isEqualTo(saveUser.getUser_addr());
    }

    @Test
    void findId(){
        User user = new User( "abc", "2443", "a", "123123123123", "123@123123",
                "as", "asv", 123456, "123456", "b");
        User saveUser = userService.save(user);

        User findBI = userService.findById(user.getUser_id());
        User findIC = userService.idCheck(user.getUser_id());

        assertThat(findBI.getUser_pw()).isEqualTo(findIC.getUser_pw()).isEqualTo(saveUser.getUser_pw());
    }

    @Test
    void findByEmail(){
        User user = new User( "abc", "2443", "a", "123123123123", "123@123123",
                "as", "asv", 123456, "123456", "b");
        User saveUser = userService.save(user);

        User findBE = userService.findByEmail(user.getUser_email());

        assertThat(saveUser.getUser_id()).isEqualTo(findBE.getUser_id());
    }
}
