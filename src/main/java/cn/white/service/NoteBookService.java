package cn.white.service;

import java.util.List;

import cn.white.entity.NoteBook;
import cn.white.util.NoteResult;

public interface NoteBookService {
    public NoteResult findNormalNoteBook(String user_id,String token);
    
    public NoteResult saveNoteBook(String user_id,String token,String notebook_name,String desc);

    public NoteResult updateNoteBook(String name,String desc,Integer type_id);

    public NoteResult deleteNoteBook(Integer notebook_id);

    public NoteResult findSpecialNoteBook(String user_id,String token);

}
