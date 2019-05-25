package cn.dc.service.impl;
import cn.dc.bean.users;

public interface UserServiceImpl {
    //处理用户登录的业务逻辑
    public boolean checkLogin(String name,String pwd);
    //处理用户注册的业务逻辑
    public boolean reg(users user);
    public boolean add(users user);
    public boolean mod(users user);
    public boolean del(users user);
    public boolean del(int id);

}
