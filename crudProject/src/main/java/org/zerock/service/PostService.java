package org.zerock.service;

import java.util.List;

import org.zerock.domain.PostVO;

public interface PostService {
	public List<PostVO> getList();
	public PostVO read(int post_seq);
	public void insert(PostVO post);
	public boolean modify(PostVO post);
	public boolean remove(int post_seq);
}
