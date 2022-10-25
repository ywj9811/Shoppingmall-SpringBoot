package sb.shoppingmall.repository;

import sb.shoppingmall.domain.Payment;

public interface PaymentRepository {

    Payment save(Payment payment);

    Payment findByOrder(Long order_code);
}
