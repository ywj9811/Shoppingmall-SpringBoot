package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class Admin {
    private Long admin_code;
    private String admin_id, admin_pw, admin_name;
}
