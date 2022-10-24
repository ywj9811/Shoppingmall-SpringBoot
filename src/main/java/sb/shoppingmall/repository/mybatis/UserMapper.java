package sb.shoppingmall.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sb.shoppingmall.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {
    void save(User user);
    List<User> findAll();
    User idCheck(@Param("user_id") String user_id);
    User nickCheck(@Param("user_nick") String user_nick);
    User findByEmail(@Param("user_email") String user_email);
}
