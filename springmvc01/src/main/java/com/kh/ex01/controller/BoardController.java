package com.kh.ex01.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.ex01.service.BoardService;
import com.kh.ex01.util.MyFileUploader;
import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 글쓰기 폼
	@RequestMapping(value = "/createForm", method = RequestMethod.GET)
	public String createForm() {
		return "board/create_form";
	}

	// 글 등록
	@RequestMapping(value = "/createRun", method = RequestMethod.POST)
	public String createRun(BoardVo boardVo, RedirectAttributes rttr) {
		System.out.println("boardController createRun boardVo : " + boardVo);
		boolean result = boardService.create(boardVo);
		System.out.println("boardController createRun result : " + result);
		rttr.addFlashAttribute("create_result", result);
		return "redirect:/board/list";
	};

	// 조회
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(int bno, Model model, PagingDto pagingDto) {
		System.out.println("BoardController, read, bno : " + bno);
		System.out.println("BoardController, read, pagingDto : " + pagingDto);
		BoardVo boardVo = boardService.read(bno);
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("pagingDto", pagingDto);
		return "board/read";
	};

	// 수정폼
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm() {
		return "board/update_form";
	}
	
	// 수정 처리
	@RequestMapping(value = "/updateRun", method = RequestMethod.POST)
	public String updateRun(BoardVo boardVo, RedirectAttributes rttr, PagingDto pagingDto) {
		System.out.println("BoardController, updateRun, boardVo : " + boardVo);
		System.out.println("BoardController, updateRun, pagingDto : " + pagingDto);
		boolean result = boardService.update(boardVo);
		rttr.addFlashAttribute("update_result", result);
		rttr.addAttribute("page", pagingDto.getPage());
		rttr.addAttribute("perPage", pagingDto.getPerPage());
		rttr.addAttribute("bno", boardVo.getBno());
		rttr.addAttribute("keyword", pagingDto.getKeyword());
		rttr.addAttribute("searchType", pagingDto.getSearchType());
		return "redirect:/board/read";
	};

	// 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int bno, RedirectAttributes rttr, PagingDto pagingDto) {
		boolean result = boardService.delete(bno);
		rttr.addFlashAttribute("delete_result", result);
		rttr.addAttribute("page", pagingDto.getPage());
		rttr.addAttribute("perPage", pagingDto.getPerPage());
		rttr.addAttribute("searchType", pagingDto.getSearchType());
		rttr.addAttribute("keyword", pagingDto.getKeyword());
		return "redirect:/board/list";
	};

	// 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, PagingDto pagingDto) {
		pagingDto.setCount(boardService.getCount(pagingDto));
		pagingDto.setPage(pagingDto.getPage());
		List<BoardVo> boardList = boardService.list(pagingDto);
		model.addAttribute("boardList", boardList);
		model.addAttribute("pagingDto", pagingDto);
		return "board/list";
	};
	
	// 답글
	@RequestMapping(value = "/replyForm", method = RequestMethod.GET)
	public String replyForm(int bno, Model model) {
		BoardVo boardVo = boardService.read(bno);
		model.addAttribute("boardVo", boardVo);
		return "board/reply_form";
	}
	
	// 답글
	@RequestMapping(value = "/replyRun", method = RequestMethod.POST)
	public String replyRun(BoardVo boardVo, RedirectAttributes rttr) {
		boolean result = boardService.insertReply(boardVo);
		rttr.addFlashAttribute("reply_result", result);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(MultipartFile file) throws Exception {
		System.out.println("file : " + file);
		String originalFilename = file.getOriginalFilename();
		byte[] fileData = file.getBytes();
		String saveFilename = MyFileUploader.uploadFile("C:/boardattach", originalFilename, fileData);
		System.out.println("saveFilename : " + saveFilename);
		return saveFilename;
	}
}
