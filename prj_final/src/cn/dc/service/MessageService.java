package cn.dc.service;
import cn.dc.bean.message;
import cn.dc.service.impl.MessageServiceImpl;

import java.util.List;

public class MessageService implements MessageServiceImpl{
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
