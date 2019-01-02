package servlet;

import daoimp.EmploeDaoImp;
import entity.Emploe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class EmploeUpdatePhoto extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到修改头像的请求");
        String eid=req.getParameter("eid");
        System.out.println(eid);
        String img=req.getParameter("img");

        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        Emploe emploe=new Emploe();
        try{
            emploe=emploeDaoImp.getEmploeById(Integer.parseInt(eid));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(emploe.toString());
        emploe.setEphoto(img);
        Boolean flag=false;
        try{
            flag=emploeDaoImp.updateEmploe(Integer.parseInt(eid),emploe);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag){
            resp.sendRedirect("failure.jsp?log=updatesuccess&eid="+Integer.parseInt(eid));
        }else{
            resp.sendRedirect("failure.jsp?log=updatefail");
        }
    }
}
