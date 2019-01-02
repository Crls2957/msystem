package servlet;

import daoimp.EmploeDaoImp;
import entity.Emploe;
import sun.java2d.pipe.AAShapePipe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 接收管理员添加部门的请求
 */
public class ManagerDeptTable_add extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收管理员添加部门的请求");
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        ArrayList<Emploe> arrayList=new ArrayList<>();
        try{
            arrayList=emploeDaoImp.getAllEmploe();
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getSession().setAttribute("emploe",arrayList);
        resp.sendRedirect("manager/dept_add.jsp");
    }
}
