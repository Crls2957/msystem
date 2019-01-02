package servlet;

import daoimp.EmploeDaoImp;
import entity.Emploe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class EmploePasswordUpdate extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到修改密码的请求！");
        String eid=req.getParameter("eid");
        String epasswd=req.getParameter("epassword");
        String newpsw=req.getParameter("newpsw");
        System.out.println("获得新密码参数是："+newpsw);
        String compsw=req.getParameter("compsw");

        if (!newpsw.equals(compsw)){
            String wrong="请重新确认密码";
            req.getSession().setAttribute("info",wrong);
            resp.sendRedirect("emploe/password_update.jsp");
        }else if(newpsw.equals(compsw)){
            Emploe emploe=new Emploe();
            EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
            try{
                emploe=emploeDaoImp.getEmploeById(Integer.parseInt(eid));
            }catch (Exception e){
                e.printStackTrace();
            }
            emploe.setEpassword(newpsw);
            System.out.println("新的密码："+emploe.getEpassword());
            boolean flag=false;
            try{
                flag=emploeDaoImp.updateEmploe(Integer.parseInt(eid),emploe);
            }catch (Exception e){
                e.printStackTrace();
            }
            while (flag==true){
                String success="修改密码成功";
                req.getSession().setAttribute("info",success);
                req.getRequestDispatcher("emploe/password_update.jsp").forward(req,resp);
            }
        }
    }
}
