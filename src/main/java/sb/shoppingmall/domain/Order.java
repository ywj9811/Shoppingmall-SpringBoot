package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class Order {
    private Long order_code, user_code, order_date;
    private int order_cnt, order_total;
    private String order_name, order_tel, order_addr, order_daddr;
}
