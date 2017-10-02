package cn.white.dao;

import java.util.List;
import cn.white.entity.NoteBook;

public interface NoteBookDao {
      public List<NoteBook> findNormalNoteBook(Integer userId);//查找普通笔记本
       
      public void saveNoteBook(NoteBook notebook);//新建笔记本

      public void updateNoteBook(NoteBook notebook);//更新笔记本

      public void deleteNoteBookById(Integer cn_notebook_id);//删除笔记本

      public List<NoteBook> findSpecialNoteBook(Integer userId);//查找特殊笔记本

}
