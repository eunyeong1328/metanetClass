package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Service //mvc와 관련되 내용이 아니고 그냥 객체만 생성한 것
//dispatcher는 controller만 보이고 service는 보이지 않았다.
@Log4j
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	@Override
	public void register(BoardVO board) {//등록
		log.info("register...." + board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get...." + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..." + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("delete..." + bno);
		return mapper.delete(bno) == 1;
	}
	
	@Override
	public List<BoardVO> getList(){
		log.info("getList......");
		return mapper.getList();
	}
}




