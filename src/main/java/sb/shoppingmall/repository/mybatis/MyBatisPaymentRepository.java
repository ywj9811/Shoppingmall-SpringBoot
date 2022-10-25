package sb.shoppingmall.repository.mybatis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sb.shoppingmall.domain.Payment;
import sb.shoppingmall.repository.PaymentRepository;

@Repository
@RequiredArgsConstructor
public class MyBatisPaymentRepository implements PaymentRepository {

    private final PaymentMapper paymentMapper;

    @Override
    public Payment save(Payment payment) {
        paymentMapper.save(payment);
        return payment;
    }

    @Override
    public Payment findByOrder(Long order_code) {
        return paymentMapper.findByOrder(order_code);
    }
}
