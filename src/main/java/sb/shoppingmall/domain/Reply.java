package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class Reply {
    private Long reply_code, p_info_dcode, user_code, payment_code;

    public Reply() {}
    public Reply(Long p_info_dcode, Long user_code, Long payment_code) {
        this.p_info_dcode = p_info_dcode;
        this.user_code = user_code;
        this.payment_code = payment_code;
    }
}
