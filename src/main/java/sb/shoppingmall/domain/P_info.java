package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class P_info {
    private Long p_info_code;
    private int p_info_price, p_info_hit;
    private String p_info_name, p_info_img1, p_info_img2, p_info_img3,
            p_info_detail, p_info_mdate, p_info_regdate, p_info_lType,
            p_info_mType, p_info_sType, search;
}
