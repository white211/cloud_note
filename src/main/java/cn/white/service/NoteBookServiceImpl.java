package cn.white.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import cn.white.dao.UserDao;
import cn.white.entity.User;
import cn.white.util.NoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.white.dao.NoteBookDao;
import cn.white.entity.NoteBook;
import cn.white.util.NoteResult;

@Service(value = "notebookService")
public class NoteBookServiceImpl implements NoteBookService {

    @Autowired
    private NoteBookDao notebookDao;

    @Autowired
    private UserDao userDao;

    public NoteResult findNormalNoteBook(String user_id, String token) {
        NoteResult noteResult = NoteUtil.validateToken(user_id, token);
        if (noteResult.getStatus() != 0) {
            return noteResult;
        } else {
            List<NoteBook> list = notebookDao.findNormalNoteBook(Integer.parseInt(user_id));
            noteResult.setStatus(0);
            noteResult.setMsg("查询成功");
            noteResult.setData(list);
            return noteResult;
        }
    }

    public NoteResult saveNoteBook(String user_id, String token, String notebook_name, String desc) {
        NoteResult noteResult = NoteUtil.validateToken(user_id, token);
        if (noteResult.getStatus() != 0) return noteResult;
        try {
            NoteBook noteBook = new NoteBook();
            if (notebook_name == null) {
                noteResult.setStatus(1);
                noteResult.setMsg("笔记本名称不能为空");
            } else {
                Timestamp createtime = new Timestamp(System.currentTimeMillis());
                noteBook.setCn_notebook_createtime(createtime);
                noteBook.setCn_user_id(Integer.parseInt(user_id));
                noteBook.setCn_notebook_name(notebook_name);
                noteBook.setCn_notebook_desc(desc);
                noteBook.setCn_notebook_type_id(4);
                notebookDao.saveNoteBook(noteBook);
                noteResult.setStatus(0);
                noteResult.setMsg("添加笔记本成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            noteResult.setStatus(1);
            noteResult.setMsg("信息：" + e.getMessage());
        }
        return noteResult;

    }

    public NoteResult updateNoteBook(String name, String desc, Integer type_id) {
        NoteResult noteResult = new NoteResult();
        NoteBook noteBook = new NoteBook();

        if (name == null) {
            noteResult.setStatus(1);
            noteResult.setMsg("笔记本名称不能为空");
        } else {
            noteResult.setStatus(0);
            noteResult.setMsg("修改成功");
            Timestamp updatetime = new Timestamp(System.currentTimeMillis());
            noteBook.setCn_notebook_name(name);
            noteBook.setCn_notebook_desc(desc);
            noteBook.setCn_notebook_type_id(type_id);
            noteBook.setCn_notebook_createtime(updatetime);
            notebookDao.updateNoteBook(noteBook);
            noteResult.setData(noteBook);
        }
        return noteResult;
    }

    public NoteResult deleteNoteBook(Integer notebook_id) {
        NoteResult noteResult = new NoteResult();
        return noteResult;
    }

    public NoteResult findSpecialNoteBook(String user_id, String token) {
        NoteResult noteResult = NoteUtil.validateToken(user_id, token);
        if (noteResult.getStatus() != 0) {
            return noteResult;
        } else {
            List<NoteBook> list = notebookDao.findSpecialNoteBook(Integer.parseInt(user_id));
            noteResult.setStatus(0);
            noteResult.setMsg("查询成功");
            noteResult.setData(list);
            return noteResult;
        }
    }
}
