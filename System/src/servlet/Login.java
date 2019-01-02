package servlet;

import daoimp.DeptDaoImp;
import daoimp.EmploeDaoImp;
import daoimp.PostDaoImp;
import entity.Dept;
import entity.Emploe;
import entity.Post;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 员工登陆的操作
 */
public class Login extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到了登陆请求");
        String eid=req.getParameter("username");
        String epasswd=req.getParameter("password");
        String cookie=req.getParameter("autologin");
        if (cookie.equals("auto")&&cookie!=null){

            Cookie cookie1=new Cookie("username",eid);
            Cookie cookie2=new Cookie("password",epasswd);
            cookie1.setMaxAge(60*60*24);
            cookie2.setMaxAge(60*60*24);

            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
        }
        int flag=0;
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        Emploe emploe=new Emploe();
        try{
            flag=emploeDaoImp.emploeLogin(Integer.parseInt(eid),epasswd);
            emploe=emploeDaoImp.getEmploeById(Integer.parseInt(eid));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag==1){
            req.getSession().setAttribute("emploe",emploe);
            resp.sendRedirect("emploe/show_self.jsp");
        }else {
           if(flag==2){
               req.getSession().setAttribute("message","账密错误！");
               resp.sendRedirect("login.jsp");
           }else if(flag==3){
               req.getSession().setAttribute("message","查无此人！");
               resp.sendRedirect("login.jsp");
           }
        }
    }
}
