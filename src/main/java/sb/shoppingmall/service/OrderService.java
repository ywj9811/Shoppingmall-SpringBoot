package sb.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sb.shoppingmall.domain.Cart;
import sb.shoppingmall.domain.CartView;
import sb.shoppingmall.domain.Order;
import sb.shoppingmall.domain.User;
import sb.shoppingmall.repository.CartRepository;
import sb.shoppingmall.repository.OrderRepository;
import sb.shoppingmall.repository.dto.OrderDto;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public Order save(User user) {
        List<CartView> cartViewList = cartRepository.cartViewList(user.getUser_code());

        int ordercnt = 0;
        int ordertotal = 0;

        for(int i = 0; i < cartViewList.size(); i++) {
            ordercnt += cartViewList.get(i).getCart_cnt();
            ordertotal += cartViewList.get(i).getP_info_price() * cartViewList.get(i).getCart_cnt();
            //carttbl에서 가격을 뽑아와서 곱해줘야 한다.
            log.info("size, i, 개수 = {} {} {}",cartViewList.size() ,i , cartViewList.get(i).getCart_cnt());
        }

        Order order = new Order(user.getUser_code(), System.currentTimeMillis(), ordercnt, ordertotal,
                user.getUser_name(), user.getUser_tel(), user.getUser_addr(),
                user.getUser_daddr());

        return orderRepository.save(order);
    }

    public Order find(Order order) {
        return orderRepository.find(order);
    }
}
