package sb.shoppingmall.repository.mybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sb.shoppingmall.domain.User;
import sb.shoppingmall.repository.UserRepository;
import sb.shoppingmall.repository.dto.UserDto;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisUserRepository implements UserRepository {

    private final UserMapper userMapper;

    @Override
    public void changePw(Long user_code, UserDto userDto) {
        userMapper.changePw(user_code, userDto);
    }

    @Override
    public void changeAddr(Long user_code, UserDto userDto) {
        userMapper.changeAddr(user_code, userDto);
    }

    @Override
    public void changeNick(Long user_code, UserDto userDto) {
        userMapper.changeNick(user_code, userDto);
    }

    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @Override
    public User save(User user) {
        userMapper.save(user);
        return user;
    }

    @Override
    public User idCheck(String user_id) {
        return userMapper.idCheck(user_id);
    }

    @Override
    public User nickCheck(String user_nick) {
        return userMapper.nickCheck(user_nick);
    }

    @Override
    public User findByEmail(String user_email) {
        return userMapper.findByEmail(user_email);
    }

    @Override
    public User findById(String user_id) {
        return userMapper.idCheck(user_id);
    }
}
