package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class OrderList {
    private Long orderlist_code, p_info_dcode, order_code, payment_code, user_code;
    private int orderlist_cnt;
    private String orderlist_date;

    public OrderList(Long p_info_dcode, Long order_code, Long payment_code, Long user_code, int orderlist_cnt) {
        this.p_info_dcode = p_info_dcode;
        this.order_code = order_code;
        this.payment_code = payment_code;
        this.user_code = user_code;
        this.orderlist_cnt = orderlist_cnt;
    }
}
