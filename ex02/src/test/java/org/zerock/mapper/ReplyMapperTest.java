package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTest {
	
	@Autowired
	private ReplyMapper mapper;
	
	private Long[] bnoArr = {10L, 11L, 12L, 13L, 14L};
	
//	@Test
//	public void testCode() {
//		IntStream.range(10, 15).forEach(i->{
//			ReplyVO vo = new ReplyVO();
//			
//			vo.setBno(bnoArr[i%10]);
//			vo.setReply("댓글 메세지");
//			vo.setReplyer("replyer" + i);
//			
//			mapper.insert(vo);
//		});
//		
//	}
//	
//	@Test
//	public void testDelete() {
//		mapper.delete(5L);
//	}
//	
//	@Test
//	public void testUpDate() {
//		ReplyVO vo = mapper.read(4L);
//		vo.setReply("Update Reply");
//		
//		int count = mapper.update(vo);
//		log.info("update count" + count);
//		
//	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri,13L);
		replies.forEach(reply->log.info(reply));
	}
}
