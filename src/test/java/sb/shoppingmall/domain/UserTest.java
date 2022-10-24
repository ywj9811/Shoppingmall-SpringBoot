package sb.shoppingmall.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sb.shoppingmall.domain.User;
import sb.shoppingmall.repository.UserRepository;
import sb.shoppingmall.repository.dto.UserDto;
import sb.shoppingmall.service.UserService;

import java.util.List;

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

    @Test
    void nickCheck(){
        User user = new User( "abc", "2443", "a", "123123123123", "123@123123",
                "as", "asv", 123456, "123456", "b");
        User saveUser = userService.save(user);

        User nick = userService.nickCheck(user.getUser_nick());

        log.info("saveUser {}", saveUser.getUser_nick());
        log.info("change {}", nick.getUser_nick());

        assertThat(nick.getUser_nick()).isEqualTo(saveUser.getUser_nick());
    }

    @Test
    void findAll(){
        User user = new User( "abc", "2443", "a", "123123123123", "123@123123",
                "as", "asv", 123456, "123456", "b");
        userService.save(user);

        List<User> list = userService.findAll();

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void changePw(){
        User user = new User( "abc", "2443", "a", "123123123123", "123@123123",
                "as", "asv", 123456, "123456", "b");
        User saveUser = userService.save(user);
        String original = saveUser.getUser_pw();

        UserDto userDto = new UserDto( "abc", "2443", "a", "123123123123", "123@123123",
                "as", "asv", 123456, "123456", "b");
        userDto.setUser_pw("test");
        userService.changePw(saveUser.getUser_code(), userDto);

        User change = userService.findById(userDto.getUser_id());
        assertThat(change.getUser_pw()).isNotEqualTo(original);
    }

    @Test
    void changeNick(){
        User user = new User( "abc", "2443", "a", "123123123123", "123@123123",
                "as", "asv", 123456, "123456", "b");
        User saveUser = userService.save(user);
        String original = saveUser.getUser_nick();

        UserDto userDto = new UserDto();

        userDto.setUser_nick("test");
        userService.changeNick(saveUser.getUser_code(), userDto);

        User change = userService.findById(saveUser.getUser_id());

        assertThat(change.getUser_nick()).isNotEqualTo(original);
    }

    @Test
    void changeAddr() {
        User user = new User( "abc", "2443", "a", "123123123123", "123@123123",
                "as", "asv", 123456, "123456", "b");
        User saveUser = userService.save(user);

        String originalAddr = saveUser.getUser_addr();
        String originalDaddr = saveUser.getUser_daddr();

        UserDto userDto = new UserDto();

        userDto.setUser_addr("경기");
        userDto.setUser_daddr("501");

        log.info("code {}" , user.getUser_code());
        log.info("addr {}" , userDto.getUser_addr());
        log.info("daddr {}" , userDto.getUser_daddr());

        userService.changeAddr(user.getUser_code(), userDto);

        User change = userService.findById(saveUser.getUser_id());

        assertThat(change.getUser_addr()).isNotEqualTo(originalAddr);
        assertThat(change.getUser_daddr()).isNotEqualTo(originalDaddr);

    }

}
