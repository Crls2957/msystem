package servlet;

import bean.DeptPageBean;
import daoimp.DeptDaoImp;
import entity.Dept;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * 接收管理员对于部门的管理请求
 */
public class ManagerDeptTable extends HttpServlet implements Serializable {

    private final static long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收管理员对于部门的管理请求");

        int pageNow=1; //默认加载第一页
        String _pageNow=req.getParameter("pageNow");
        if (_pageNow!=null){
            pageNow=Integer.parseInt(_pageNow);
        }
        DeptDaoImp deptDaoImp=new DeptDaoImp();
        DeptPageBean deptPageBean=new DeptPageBean();
        try{
            deptPageBean=deptDaoImp.getAllDeptByPage(pageNow);
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getSession().setAttribute("dept",deptPageBean);
        resp.sendRedirect("manager/dept_table.jsp");
    }
}
