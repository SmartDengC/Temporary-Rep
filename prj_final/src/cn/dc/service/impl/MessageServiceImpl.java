package cn.dc.service.impl;
import cn.dc.bean.message;

import java.util.List;

public interface MessageServiceImpl {
    //增加一条留言记录
    int insert(message msg);
    //分页查询留言记录
    List<message> findByPage(int page,int pageSize);
    int getCount();
}
