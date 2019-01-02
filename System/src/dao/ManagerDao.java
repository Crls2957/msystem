package dao;

import entity.Manager;

/**
 * 经理数据库操作dao层接口
 */
public interface ManagerDao {

    //管理员账号mname和密码mpassword登录
    public int managerLogin(String mname,String mpassword)throws Exception;
    //通过mid更改管理员密码
    public boolean mupdatePassword(int mid,String newPsw)throws Exception;
    //通过账号获得管理员
    public Manager getMangerByName(String mname)throws Exception;
}
