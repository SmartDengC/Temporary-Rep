package cn.dc.dao.impl;
import cn.dc.bean.message;

import java.util.List;

public interface messageImpl {
    public boolean addMessage(message msg);
    //增加一条留言记录
    public int insert(message msg);
    //分页查询留言记录
    public List<message> findByPage(int page, int pageSize);
    //获取表中所有留言的记录总数
    public int getCount();
}
