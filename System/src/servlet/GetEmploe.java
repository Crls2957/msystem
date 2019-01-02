package servlet;

import daoimp.EmploeDaoImp;
import entity.Emploe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class GetEmploe extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到获取员工信息的请求");
        String id=req.getParameter("id");
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        Emploe emploe=new Emploe();
        try{
            emploe=emploeDaoImp.getEmploeById(Integer.parseInt(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getSession().setAttribute("emploe",emploe);
        resp.sendRedirect("emploe/show_self.jsp");
    }
}
