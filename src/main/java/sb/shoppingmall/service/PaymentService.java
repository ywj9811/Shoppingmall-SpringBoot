package sb.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sb.shoppingmall.domain.Payment;
import sb.shoppingmall.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment findByOrder(Long order_code) {
        return paymentRepository.findByOrder(order_code);
    }
}
