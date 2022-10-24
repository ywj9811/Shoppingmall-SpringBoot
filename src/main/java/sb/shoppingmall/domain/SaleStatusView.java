package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class SaleStatusView {
    private Long p_info_code, view_cell, profit;
    //상품코드 판매량 수익금액
    private String p_info_name, p_info_ltype, p_info_mtype, p_info_stype, view_profit;
    //마지막은 판매금액 회계형
}
