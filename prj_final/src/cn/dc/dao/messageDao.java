package cn.dc.dao;

import cn.dc.dao.impl.messageImpl;
import cn.dc.bean.message;

import java.util.List;

public class messageDao implements  messageImpl{
    @Override
    public boolean addMessage(message msg) {
        return false;
    }

    @Override
    public int insert(message msg) {
        return 0;
    }

    @Override
    public List<message> findByPage(int page, int pageSize) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
