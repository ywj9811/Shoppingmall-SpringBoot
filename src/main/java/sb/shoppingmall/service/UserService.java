package sb.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sb.shoppingmall.domain.User;
import sb.shoppingmall.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User save(User user) {
        return userRepository.save(user);
    }

    public User idCheck(String user_id) {
        return userRepository.idCheck(user_id);
    }

    public User nickCheck(String user_nick) {
        return userRepository.nickCheck(user_nick);
    }

    public User findByEmail(String user_email) {
        return userRepository.findByEmail(user_email);
    }

    public User findById(String user_id) {
        return userRepository.findById(user_id);
    }
}
