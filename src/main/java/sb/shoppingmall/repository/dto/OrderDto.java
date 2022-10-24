package sb.shoppingmall.repository.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long user_code, order_date;
    private int order_cnt, order_total;
    private String order_name, order_tel, order_addr, order_daddr;

}
