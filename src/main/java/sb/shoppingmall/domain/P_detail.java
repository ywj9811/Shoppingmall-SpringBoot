package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class P_detail {
    private Long p_info_dcode, p_info_code, user_code;
    private int p_detail_cell, p_info_price;
}
