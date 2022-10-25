package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class Payment {
    private Long payment_code, order_code, payment_regdate;
    private int payment_pay;

    public Payment() {
    }

    public Payment(Long order_code, Long payment_regdate, int payment_pay) {
        this.order_code = order_code;
        this.payment_regdate = payment_regdate;
        this.payment_pay = payment_pay;
    }
}
