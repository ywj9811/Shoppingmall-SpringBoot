package sb.shoppingmall.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class User {

    private Long user_code;
    private int user_status, user_total, user_class, user_gender;
    private String user_id, user_pw, user_name, user_tel, user_logdate;
    private String user_email, user_addr, user_daddr, user_regdate, user_nick, user_birth;

    public User(){

    }

    public User(String user_id, String user_pw, String user_name, String user_tel
    , String user_email, String user_addr, String user_daddr, int user_gender
    , String user_birth, String user_nick){
        this.user_gender = user_gender;
        this.user_birth = user_birth;
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
        this.user_tel = user_tel;
        this.user_email = user_email;
        this.user_addr = user_addr;
        this.user_daddr = user_daddr;
        this.user_nick = user_nick;
    }
}
