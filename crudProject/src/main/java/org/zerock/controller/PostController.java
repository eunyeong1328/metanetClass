package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.PostVO;
import org.zerock.service.PostService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/post/*")
@AllArgsConstructor
public class PostController {

	private PostService service;
	
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list",service.getList());
	}
	
	@GetMapping("/read")
	public void read(@RequestParam("post_seq") int post_seq,  Model model) {
		model.addAttribute("post",service.read(post_seq));
	}
	

	
	@PostMapping("insert")
	public String register(PostVO post, RedirectAttributes rttr) {
		service.insert(post);
		rttr.addFlashAttribute("result",post.getPost_seq());
		
		return "redirect:/board/list";
	}
	
	
	
	@PostMapping("/modify")
	public String modify(PostVO post,  RedirectAttributes rttr) {
		
		if(service.modify(post)) {
			rttr.addFlashAttribute("result","success");
		}
		
		rttr.addAttribute("post_title",post.getPost_title());
		rttr.addAttribute("post_job",post.getPost_job());
		rttr.addAttribute("post_career",post.getPost_career());
		rttr.addAttribute("post_emptype",post.getPost_emptype());
		rttr.addAttribute("post_add",post.getPost_add());
		
		return "redirect:/post/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("post_seq") int post_seq, RedirectAttributes rttr) {
		log.info("remove:" + post_seq);
		
		if(service.remove(post_seq)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
}
