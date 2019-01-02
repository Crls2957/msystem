package dao;

import bean.EmploePageBean;
import entity.Emploe;

import java.util.ArrayList;

/**
 * 职员数据库操作dao层接口
 */
public interface EmploeDao {

    //员工注册（包含问题及问题答案）
    public boolean registerEmploe(Emploe emploe)throws Exception;
    //员工注册（不包含问题及问题答案）
    public boolean registerEmploe2(Emploe emploe)throws Exception;
    //管理员添加员工
    public boolean addEmploe(Emploe emploe)throws Exception;
    //注销账户
    public	boolean remove(int eid)throws Exception;

    //更新员工
    public boolean updateEmploe(int eid,Emploe emploe)throws Exception;
    //通过名字查询员工
    public Emploe getEmploeByName(String ename)throws Exception;

    //通过编号查询员工
    public Emploe getEmploeById(int eid)throws Exception;

    //通过部门查员工
    public ArrayList<Emploe> getEmploeByDname(String dname)throws Exception;
    //通过pname获得所有员工
    public ArrayList<Emploe> getEmploeByPname(String pname)throws Exception;
    //通过eid更改pid
    public boolean updatePidByEid(int eid,int pid)throws Exception;
    //查看所有员工
    public ArrayList<Emploe> getAllEmploe()throws Exception;
    //通过分页查看所有员工
    public EmploePageBean getAllEmploeByPage(int pageNow)throws Exception;
    //登录
    public int emploeLogin(int eid, String epassword)throws Exception;
}
