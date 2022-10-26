package sb.shoppingmall.repository;

import sb.shoppingmall.domain.Reply;

import java.util.List;

public interface ReplyRepository {

    Reply save(Reply reply);

    List<Reply> list(int p_info_dcode);


}
