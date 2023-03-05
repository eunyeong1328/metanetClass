package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.PostVO;
import org.zerock.mapper.PostMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostMapper mapper;

	@Override
	public List<PostVO> getList() {
		return mapper.getList();
	}

	@Override
	public PostVO read(int post_seq) {
		return mapper.read(post_seq);
	}


	@Override
	public void insert(PostVO post) {
		mapper.insert(post);
	}

	@Override
	public boolean modify(PostVO post) {
		return mapper.update(post)==1;
	}

	@Override
	public boolean remove(int post_seq) {
		return mapper.delete(post_seq)==1;
	}



}
