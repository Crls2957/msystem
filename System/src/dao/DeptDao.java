package dao;
import bean.DeptPageBean;
import entity.Dept;

import java.util.ArrayList;

/**
 * 部门的数据库操作dao层接口
 */
public interface DeptDao {

    //查看部门
    public Dept getDeptById(int did) throws Exception;
    //查找所有部门
    public ArrayList<Dept> getAllDept()throws Exception;
    //通过分页查找所有部门
    public DeptPageBean getAllDeptByPage(int n)throws Exception;
    //添加部门
    public boolean insertDept(Dept dept)throws Exception;
    //更新部门
    public boolean updateDept(int did,Dept dept)throws Exception;
    //删除部门
    public boolean deleteDept(int did) throws Exception;

}
