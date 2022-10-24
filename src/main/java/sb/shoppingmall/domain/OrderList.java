package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class OrderList {
    private Long orderList_code, p_info_dcode, order_code, payment_code, user_code;
    private int orderList_cnt;
}
