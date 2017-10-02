package cn.white.controller;

import cn.white.util.NoteResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/note")
public class NoteController {

    @RequestMapping("saveNote.do")
    public NoteResult saveNote(){

        return null;
    }
}
