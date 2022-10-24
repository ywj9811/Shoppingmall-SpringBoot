package sb.shoppingmall.repository.dto;

import lombok.Data;

@Data
public class CartDto {

    private Long p_info_dcode, user_code;
    private int cart_cnt;

    public CartDto (Long p_info_dcode, Long user_code, int cart_cnt) {
        this.p_info_dcode = p_info_dcode;
        this.user_code = user_code;
        this.cart_cnt = cart_cnt;
    }
}
