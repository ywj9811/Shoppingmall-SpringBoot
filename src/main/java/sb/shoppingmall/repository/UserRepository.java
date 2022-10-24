package sb.shoppingmall.repository;

import sb.shoppingmall.domain.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();
    User save(User user);

    //회원가입에서 필요한 과정
    User idCheck(String user_id);
    //id중복
    User nickCheck(String user_nick);
    //닉네임 중복
    User findByEmail(String user_email);
    //아이디 찾기
    User findById(String user_id);
    //비밀번호 찾기
    /**
     * 이외의 부분 추후에
     */
}
