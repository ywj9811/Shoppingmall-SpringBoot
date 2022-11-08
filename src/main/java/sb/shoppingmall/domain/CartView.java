package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class CartView {
    private Long cart_code, p_info_dcode, user_code;
    private int cart_cnt, p_info_price;
}
