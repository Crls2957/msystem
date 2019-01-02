package servlet;

import daoimp.DeptDaoImp;
import entity.Dept;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 接收管理员添加部门数据的请求
 */
public class ManagerDeptAdd extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收管理员添加部门数据的请求");
        String did=req.getParameter("did");
        String dname=req.getParameter("dname");
        String dnumber=req.getParameter("dnumber");
        String daddr=req.getParameter("daddr");
        String eid=req.getParameter("eid");

        Dept dept=new Dept();
        dept.setEid(Integer.parseInt(eid));
        dept.setDid(Integer.parseInt(did));
        dept.setDname(dname);
        dept.setDaddr(daddr);
        dept.setDnumber(Integer.parseInt(dnumber));

        DeptDaoImp deptDaoImp=new DeptDaoImp();
        boolean flag=false;
        try{
            flag=deptDaoImp.insertDept(dept);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (flag){
            resp.sendRedirect("ManagerDeptTable");
        }else {
            resp.sendRedirect("manager/dept_add.jsp");
        }
    }
}
