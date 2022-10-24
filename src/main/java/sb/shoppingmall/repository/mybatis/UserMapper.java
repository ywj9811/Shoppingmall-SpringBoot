package sb.shoppingmall.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sb.shoppingmall.domain.User;
import sb.shoppingmall.repository.dto.UserDto;

import java.util.List;

@Mapper
public interface UserMapper {
    void save(User user);
    List<User> findAll();
    User idCheck(@Param("user_id") String user_id);
    User nickCheck(@Param("user_nick") String user_nick);
    User findByEmail(@Param("user_email") String user_email);
    int changeNick(@Param("user_code") Long user_code, @Param("userDto") UserDto userDto);
    int changePw(@Param("user_code") Long user_code, @Param("userDto") UserDto userDto);
    int changeAddr(@Param("user_code") Long user_code, @Param("userDto") UserDto userDto);
}
