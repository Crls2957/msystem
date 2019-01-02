package servlet;

import daoimp.ManagerDaoImp;
import daoimp.MessageDaoImp;
import entity.Manager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * 接收管理员登陆请求
 */
public class ManagerLogin extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到管理员登陆请求");
        PrintWriter printWriter=resp.getWriter();
        String mname=req.getParameter("mname");
        String mpassword=req.getParameter("mpassword");
        ManagerDaoImp managerDaoImp=new ManagerDaoImp();
        int flag=0;
        try{
                flag=managerDaoImp.managerLogin(mname,mpassword);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("flag是"+flag);
            if (flag==1){
                try{
                    Manager manager=managerDaoImp.getMangerByName(mname);
                    req.getSession().setAttribute("mname",mname);
                    req.getSession().setAttribute("manager",manager);
                    resp.sendRedirect("EmploeTable");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if (flag==2){
                resp.sendRedirect("manager_login.jsp");
            }else if(flag==3){
                resp.sendRedirect("manager_login.jsp");
            }
     }
}
