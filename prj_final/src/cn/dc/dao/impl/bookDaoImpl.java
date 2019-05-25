package cn.dc.dao.impl;
import cn.dc.bean.books;

import java.util.List;

public interface bookDaoImpl {
    public List<books> findAllBook(int page);
    public int findAllBookCount();
}
