package servlet;

import daoimp.EmploeDaoImp;
import entity.Emploe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 接收找回密码的请求
 */
public class FindPassword extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到找回密码的请求");
        String eid=req.getParameter("eid");
        System.out.println("修改密码的员工编号是："+eid);
        String equestion=req.getParameter("equestion");
        String eanswer=req.getParameter("eanswer");

        Emploe emploe=new Emploe();
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        try{
            emploe=emploeDaoImp.getEmploeById(Integer.parseInt(eid));
        }catch (Exception e){
            e.printStackTrace();
        }
        if (emploe.getEquestion().equals(equestion)&&emploe.getEanswer().equals(eanswer)){
            req.getSession().setAttribute("emploe",emploe);
            resp.sendRedirect("failure.jsp?log=epassword");
        }else{
            req.getSession().setAttribute("message","修改失败！请核对信息");
            resp.sendRedirect("findpassword.jsp");
        }
    }
}
