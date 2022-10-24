package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class Payment {
    private Long payment_code, order_code;
    private int payment_pay;
    private String payment_regdate;
}
