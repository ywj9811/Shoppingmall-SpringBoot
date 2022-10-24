package sb.shoppingmall.domain;

import lombok.Data;

@Data
public class ReplyView {
    private String p_info_name, user_nick, p_detail_size,
            p_detail_color, reply_content, reply_regdate, reply_ip;
}
