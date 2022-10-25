package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class Order {
    private Long order_code, user_code, order_date;
    private int order_cnt, order_total;
    private String order_name, order_tel, order_addr, order_daddr;

    public Order() {}
    public Order(Long user_code, Long order_date, int order_cnt, int order_total, String order_name, String order_tel, String order_addr, String order_daddr) {
        this.user_code = user_code;
        this.order_date = order_date;
        this.order_cnt = order_cnt;
        this.order_total = order_total;
        this.order_name = order_name;
        this.order_tel = order_tel;
        this.order_addr = order_addr;
        this.order_daddr = order_daddr;
    }
}
