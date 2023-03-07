package org.zerock.mapper;

import java.util.List;
import org.zerock.domain.PostVO;

public interface PostMapper {
	
	public List<PostVO> getList();
	public void insert(PostVO board);
	public PostVO read(int post_seq);
	public int delete(int post_seq);
	public int update(PostVO board);
}
