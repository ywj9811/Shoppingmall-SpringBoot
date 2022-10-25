package sb.shoppingmall.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sb.shoppingmall.service.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
public class Orde_Payment_OrderListrTest {

    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    CartService cartService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    OrderListService orderListService;

    @BeforeEach
    void insertCart() {
        User testUser = userService.findById("test");

        Cart cart = new Cart(1L, testUser.getUser_code(), 1);
        Cart cart1 = new Cart(2L, testUser.getUser_code(), 2);
        Cart cart2 = new Cart(3L, testUser.getUser_code(), 3);
        Cart cart3 = new Cart(4L, testUser.getUser_code(), 1);

        cartService.save(cart);
        cartService.save(cart1);
        cartService.save(cart2);
        cartService.save(cart3);
    }

    @Test
    void OrderSave() {
        User testUser = userService.findById("test");

        List<Cart> cartList = cartService.cartList(testUser.getUser_code());

        log.info("List !! {}", cartList);

        int ordercnt = 0;
        int ordertotal = 0;
        for(int i = 0; i < cartList.size(); i++) {
            ordercnt += cartList.get(i).getCart_cnt();
            ordertotal += 1000 * cartList.get(i).getCart_cnt();
        }

        Order order = new Order(testUser.getUser_code(), System.currentTimeMillis(), ordercnt, ordertotal,
                testUser.getUser_name(), testUser.getUser_tel(), testUser.getUser_addr(),
                testUser.getUser_daddr());

        Order rs = orderService.save(order);
        log.info("cnt, ms = {} {}", rs.getOrder_cnt(), rs.getOrder_date());
        assertThat(rs.getOrder_cnt()).isEqualTo(7);
        assertThat(rs.getOrder_total()).isEqualTo(7000);
    }

    @Test
    void OrderFind() {
        User testUser = userService.findById("test");
        List<Cart> cartList = cartService.cartList(testUser.getUser_code());

        log.info("List !! {}", cartList);

        log.info("user_code {}", testUser.getUser_code());

        int ordercnt = 0;
        int ordertotal = 0;
        for(int i = 0; i < cartList.size(); i++) {
            ordercnt += cartList.get(i).getCart_cnt();
            ordertotal += 1000 * cartList.get(i).getCart_cnt();
        }

        Order order = new Order(testUser.getUser_code(), System.currentTimeMillis(), ordercnt, ordertotal,
                testUser.getUser_name(), testUser.getUser_tel(), testUser.getUser_addr(),
                testUser.getUser_daddr());

        log.info("order의 user_code {}", order.getUser_code());
        log.info("order = {}", order);

        orderService.save(order);

        Order rs = orderService.find(order);
        log.info("rs OrderCode = {}", rs.getOrder_code());

        assertThat(rs.getUser_code()).isEqualTo(testUser.getUser_code());
    }

    @Test
    void PaymentSave() {
        User testUser = userService.findById("test");
        List<Cart> cartList = cartService.cartList(testUser.getUser_code());

        log.info("List !! {}", cartList);

        int ordercnt = 0;
        int ordertotal = 0;
        for(int i = 0; i < cartList.size(); i++) {
            ordercnt += cartList.get(i).getCart_cnt();
            ordertotal += 1000 * cartList.get(i).getCart_cnt();
        }

        Order order = new Order(testUser.getUser_code(), System.currentTimeMillis(), ordercnt, ordertotal,
                testUser.getUser_name(), testUser.getUser_tel(), testUser.getUser_addr(),
                testUser.getUser_daddr());

        orderService.save(order);
        Order rs = orderService.find(order);

        Payment payment = new Payment(rs.getOrder_code(), System.currentTimeMillis(), rs.getOrder_total());
        paymentService.save(payment);

        Payment payRs = paymentService.findByOrder(rs.getOrder_code());

        assertThat(payRs.getPayment_pay()).isEqualTo(rs.getOrder_total());
    }

    @Test
    void OrderListSaveAndFind() {
        User testUser = userService.findById("test");
        List<Cart> cartList = cartService.cartList(testUser.getUser_code());

        log.info("List !! {}", cartList);

        int ordercnt = 0;
        int ordertotal = 0;
        for(int i = 0; i < cartList.size(); i++) {
            ordercnt += cartList.get(i).getCart_cnt();
            ordertotal += 1000 * cartList.get(i).getCart_cnt();
        }

        Order order = new Order(testUser.getUser_code(), System.currentTimeMillis(), ordercnt, ordertotal,
                testUser.getUser_name(), testUser.getUser_tel(), testUser.getUser_addr(),
                testUser.getUser_daddr());

        orderService.save(order);
        Order rs = orderService.find(order);

        Payment payment = new Payment(rs.getOrder_code(), System.currentTimeMillis(), rs.getOrder_total());
        paymentService.save(payment);
        Payment payRs = paymentService.findByOrder(rs.getOrder_code());

        for (int i = 0; i < cartList.size(); i++) {
            OrderList orderList = new OrderList(cartList.get(i).getP_info_dcode(), rs.getOrder_code(),
                    payRs.getPayment_code(), testUser.getUser_code(), cartList.get(i).getCart_cnt());
            log.info("{}번째 저장 = {}", i, orderListService.save(orderList));
        }



        List<OrderList> orderLists1 = orderListService.findByOrder(rs.getOrder_code());
        List<OrderList> orderLists2 = orderListService.findByUser(testUser.getUser_code());

        assertThat(orderLists1).isEqualTo(orderLists2);
    }
}
