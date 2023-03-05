package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	BoardMapper mapper;
	
//	@Test
//	public void testSearch() {
//		Criteria cri = new Criteria();
//		cri.setType("TC");
//		
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		list.forEach(board->log.info(board));
//	}
//	
//	@Test
//	public void testpaging() {
//		Criteria cri = new Criteria();
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		list.forEach(board->log.info(board));
//	}
//	
//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새내용");
//		board.setContent("내용");
//		board.setWriter("작성자");
//		
//		mapper.insert(board);
//		
//		log.info(board);
//	}
//	
//	
	@Test
	public void getList() {
		List<BoardVO> list = mapper.getList();
		list.forEach(board->log.info(board));
		
	}
//	
//	@Test
//	public void detailList() {
//		BoardVO board = mapper.read(1L);
//		log.info(board);
//	}
//
//	
//	@Test
//	public void delete() {
//		int board = mapper.delete(3L);
//		log.info("삭제성공: " + board);
//	}
//	
//	@Test
//	public void update() {
//		BoardVO board = new BoardVO();
//		board.setTitle("수정제목");
//		board.setContent("수정한 내용들");
//		board.setWriter("수정작성자");
//		board.setBno(2L);
//		
//		int confirm = mapper.update(board);
//		log.info("수정성공: " + confirm);
//	}
//	

}
