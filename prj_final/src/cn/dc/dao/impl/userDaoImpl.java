package cn.dc.dao.impl;

import cn.dc.bean.users;

import java.util.List;

public interface userDaoImpl {

    /**
     * 用来查询指定页数的商品
     * @param page 指定的页面
     * @return 一个含有信息的list
     */
    public List<users> findAllUser(int page);

    /**
     * 用来查询总记录数
     * @return 记录数
     */
    public int findAllUsersCount();

    /**
     * 添加用户信息
     * @param user 用户对象
     * @return 是否添加成功
     */
    public Boolean addUser(users user);

    /**
     * 删除用户信息
     * @param id 用户对象
     * @return 是否删除成功
     */
    public Boolean deleteUser(int id);

    //增加一条用户数据
    public int insert(users user);
    // 修改一条用户数据
    public int update(users user);
    //根据id删除一条数据
    public int delete(int id);
    //分页查询用户记录
    public List<users> findByPage(int page, int pageSize);
    //根据id查询一条用户记录
    public users find(int id);
    //根据用户名，密码查询一条用户记录
    public users find(String name, String password);
    //获取表中所有用户记录总数
    public int getCount();
}
