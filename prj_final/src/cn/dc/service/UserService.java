package cn.dc.service;
import cn.dc.bean.users;
import cn.dc.service.impl.UserServiceImpl;

public class UserService implements UserServiceImpl{

    @Override
    public boolean checkLogin(String name, String pwd) {
        return false;
    }

    @Override
    public boolean reg(users user) {
        return false;
    }

    @Override
    public boolean add(users user) {
        return false;
    }

    @Override
    public boolean mod(users user) {
        return false;
    }

    @Override
    public boolean del(users user) {
        return false;
    }

    @Override
    public boolean del(int id) {
        return false;
    }
}
