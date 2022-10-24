package sb.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sb.shoppingmall.domain.Order;
import sb.shoppingmall.repository.OrderRepository;
import sb.shoppingmall.repository.dto.OrderDto;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order find(Order order) {
        return orderRepository.find(order);
    }
}
