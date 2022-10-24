package sb.shoppingmall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import sb.shoppingmall.config.ShopConfig;

@Slf4j
@Import(ShopConfig.class)
@SpringBootApplication(scanBasePackages = "sb.shoppingmall.controller") //componentscan 범위 설정
public class ShoppingmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingmallApplication.class, args);
	}

}
