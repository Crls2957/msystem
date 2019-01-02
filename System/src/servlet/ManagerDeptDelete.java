package servlet;

import daoimp.DeptDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 接收管理员删除部门信息的请求
 */
public class ManagerDeptDelete extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收管理员删除部门信息的请求");
        String did=req.getParameter("did");
        DeptDaoImp deptDaoImp=new DeptDaoImp();
        boolean flag=false;
        try{
            flag=deptDaoImp.deleteDept(Integer.parseInt(did));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag){
            resp.sendRedirect("ManagerDeptTable");
        }else {
            resp.sendRedirect("ManagerDeptTable");
        }
    }
}
