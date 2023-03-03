package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {

	@Autowired
	private BoardService service;
	
	@Test
	public void getList() {
		List<BoardVO> list = service.getList();
		list.forEach(BoardVO->log.info(BoardVO));
	}
	
	@Test
	public void register() {
		BoardVO b = new BoardVO();
		b.setTitle("제목등록");
		b.setContent("내용등록");
		b.setWriter("내용등록");
		
		service.register(b);
		log.info(b);
	}
	
	@Test
	public void get() {
		BoardVO b = service.get(8L);
		log.info(b);
	}
	
	@Test
	public void modify() {
		BoardVO b = new BoardVO();
		b.setBno(8L);
		b.setTitle("modify제목등록");
		b.setContent("modify내용등록");
		b.setWriter("modify내용등록");
		
		boolean tf = service.modify(b);
		log.info("modify 수정완료 :" + tf);
	}
	
	@Test
	public void remove() {
		boolean tf = service.remove(8L);
		log.info("remove 삭제완료 : " + tf);
	}
	
}
