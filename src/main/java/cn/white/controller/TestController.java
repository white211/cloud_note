package cn.white.controller;

import cn.white.util.NoteResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test.do")
    public NoteResult test(@RequestParam int id) {
        NoteResult noteResult = new NoteResult();
        if (id == 1) {
            noteResult.setStatus(404);
            noteResult.setMsg("获取不到表单数据");
        } else {
            noteResult.setStatus(0);
            noteResult.setMsg("获取成功"+id);
            noteResult.setData(id);
        }
        return noteResult;
    }
}
