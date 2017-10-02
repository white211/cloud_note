package cn.white.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.white.entity.NoteBook;
import cn.white.entity.User;
import cn.white.service.NoteBookService;
import cn.white.util.NoteResult;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notebook")
public class NoteBookController {
    
	@Resource(name = "notebookService")
	private NoteBookService notebookService;

	@RequestMapping("/findNormal.do")
	public NoteResult findNormal(String userId,String token) {
		NoteResult noteResult = new NoteResult();
		noteResult = notebookService.findNormalNoteBook(userId,token);
		return noteResult;
	}

	@RequestMapping("/findSpecial.do")
	public NoteResult findSpecial(String user_id,String token) {
		NoteResult noteResult = new NoteResult();
		noteResult = notebookService.findSpecialNoteBook(user_id,token);
		return noteResult;
	}

	@RequestMapping("/saveNoteBook.do")
	public NoteResult saveNoteBook(String user_id,String token, String name, String desc) {
		NoteResult noteResult = new NoteResult();
		noteResult = notebookService.saveNoteBook(user_id,token, name, desc);
		return noteResult;
	}

	@RequestMapping("/updateNoteBook.do")
	public NoteResult updateNoteBook(String name, String desc, Integer type_id){
		NoteResult noteResult = new NoteResult();
		noteResult = notebookService.updateNoteBook(name, desc, type_id);
		return noteResult;
	}

	@RequestMapping("/deleteNoteBook.do")
    public NoteResult deleteNoteBook(Integer notebook_id){
		NoteResult noteResult = new NoteResult();
		noteResult = notebookService.deleteNoteBook(notebook_id);
		return noteResult;
	}


}
























