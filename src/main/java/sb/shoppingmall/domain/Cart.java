package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class Cart {
    private Long cart_code, p_info_dcode, user_code, cart_cnt;
}
