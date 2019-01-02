package servlet;

import daoimp.ManagerDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 接收管理员修改管理员密码的请求
 */
public class ManagerMpasswordUpdate extends HttpServlet implements Serializable{

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收管理员修改管理员密码的请求");
        String mid=req.getParameter("mid");
        String newPsw=req.getParameter("newPsw");
        String reNewPsw=req.getParameter("reNewPsw");
        if (newPsw.equals(reNewPsw)){
            ManagerDaoImp managerDaoImp=new ManagerDaoImp();
            boolean flag=false;
            try{
                flag=managerDaoImp.mupdatePassword(Integer.parseInt(mid),newPsw);
            }catch (Exception e){
                e.printStackTrace();
            }
            if (flag){
                resp.sendRedirect("manager_login.jsp");
            }else{
                resp.sendRedirect("manager/mpassword_update.jsp");
            }

        }else {
            req.getSession().setAttribute("message","新密码不一致");
            resp.sendRedirect("manager/mpassword_update.jsp");
        }
    }
}
