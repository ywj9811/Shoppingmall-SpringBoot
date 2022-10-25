package sb.shoppingmall.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import sb.shoppingmall.domain.Payment;

@Mapper
public interface PaymentMapper {

    void save(Payment payment);

    Payment findByOrder(Long order_code);
}
