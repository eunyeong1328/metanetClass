package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/replies/")
public class ReplyController {

	@Autowired
	private ReplyService service;

	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		log.info("ReplyVo: " + vo);//url요청 확인용

		int insertCount = service.register(vo);
		log.info("Reply INSERT COUNT: " + insertCount);

		return insertCount == 1 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);// ok시 200전달
	}

	@GetMapping("/{rno}")
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
		log.info("get:" + rno);

		return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK);
	}

	@GetMapping("/pages/{bno}/{page}") // bno글하나 /
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {
		log.info("getList.....");
		Criteria cri = new Criteria(page, 10);
		return new ResponseEntity<List<ReplyVO>>(service.getList(cri, bno), HttpStatus.OK);
	}

	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH }, value = "/{rno}")
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno) {// vo댓글 내용만 있어서 rno추가,
																									// rno수정할 댓글
		vo.setRno(rno);
		return service.modify(vo) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		return service.remove(rno) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
