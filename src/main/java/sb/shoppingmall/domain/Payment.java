package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class Payment {
    private Long payment_code, order_code, payment_regdate;
    private int payment_pay;
}
