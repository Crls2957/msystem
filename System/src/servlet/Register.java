package servlet;

import com.mchange.lang.StringUtils;
import daoimp.EmploeDaoImp;
import entity.Emploe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 接收注册请求
 */
public class Register extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到员工注册请求");

        String eid=req.getParameter("eid");
        String epassword=req.getParameter("epassword");
        String trueName=req.getParameter("trueName");
        String question=req.getParameter("question");
        String result=req.getParameter("result");

        Emploe emploe=new Emploe();
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        emploe.setEid(Integer.parseInt(eid));
        emploe.setEpassword(epassword);
        emploe.setEname(trueName);
        Boolean flag=false;
        if(question!=null&&!question.equals("")&&result!=null&&!result.equals("")){
            emploe.setEquestion(question);
            emploe.setEanswer(result);
            System.out.println("测试注册不为空");
            try{
                flag=emploeDaoImp.registerEmploe(emploe);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(flag==true){
                resp.sendRedirect("failure.jsp?log=success");
            }else {
                resp.sendRedirect("failure.jsp?log=fail");
            }
        }else if (question==null||question.equals("")&&result==null||result.equals("")){
            System.out.println("测试注册不为空");
            try{
                flag=emploeDaoImp.registerEmploe2(emploe);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(flag==true){
                resp.sendRedirect("failure.jsp?log=success");
            }else {
                resp.sendRedirect("failure.jsp?log=fail");
            }
        }
    }
}
