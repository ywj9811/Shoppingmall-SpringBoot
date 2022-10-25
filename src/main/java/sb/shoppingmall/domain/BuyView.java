package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class BuyView {
    private String p_info_name, p_info_img1, p_detail_size, p_detail_color;
    private Long payment_code, p_info_dcode, p_info_code;
    private int p_info_price, reply_ok;
}
