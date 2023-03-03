package kosa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosa.model.Board;
import kosa.model.BoardDao;
import kosa.model.Search;

@Controller//��ü ����
public class BoardController {
		@Autowired
		private BoardDao dao;
		
		
	//@RequestMapping(value = "/board_insert", method = RequestMethod.GET)
		@GetMapping("/board_insert")//� ����?<-spring�����̳ʰ� ������ ���� <- ��� ��ü�� ���� ������ ��� ����
		public String board_form(@ModelAttribute("boardCommand") Board board) {
			return "insert_form";
		}
		
		//@RequestMapping(value = "/board_insert", method = RequestMethod.POST)
//		@PostMapping("/board_insert")
//		public String board_insert(@ModelAttribute("boardCommand") @Valid Board board, BindingResult errors) {
//			if(errors.hasErrors()) {//����üũ
//				System.out.println("�����߻�");
//				return "insert_form";
//			}
//			
//			dao.insertBoard(board);
//			return "redirect:board_list";
//		}
		
		@PostMapping("/board_insert")
		public String board_insert(Board board, BindingResult errors) {
			if(errors.hasErrors()) {//����üũ
				System.out.println("�����߻�");
				return "insert_form";
			}
			
			dao.insertBoard(board);
			return "redirect:board_list";
		}
		
		@GetMapping("/board_list")
		public String board_list(Model model, Search search){
			System.out.println(search);
//			System.out.println(dao.listBoard());
			search.setSearchKey("%" + search.getSearchKey() + "%");
			model.addAttribute("list", dao.listBoard(search));
			return "list";
		}
		
		//board_detail
//		@RequestMapping("/board_detail")
//		public String board_detail(@RequestParam("seq") int seq, Model model) {
//			//dao.detailBoard(seq);
//			System.out.println("�� Ȯ�� "  +  seq);
//			model.addAttribute("board",dao.detailBoard(seq));
//			return "detail";
//		}
		
		@RequestMapping("/board_detail{seq}")
		public String board_detail(@RequestParam("seq") int seq, Model model) {
			//dao.detailBoard(seq);
			System.out.println("�� Ȯ�� "  +  seq);
			model.addAttribute("board",dao.detailBoard(seq));
			return "detail";
		}
		
//		�Խñ� �ϳ� ����
		@RequestMapping("/delete_detail")
		public void delete_detail() {
			
		}
		
		
		
}
