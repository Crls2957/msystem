package servlet;

import daoimp.EmploeDaoImp;
import entity.Emploe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 收到管理员修改员工信息的请求
 */
public class ManagerEmploeUpdate extends HttpServlet implements Serializable  {

    private static final long sserialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("收到管理员修改员工信息的请求");

        String eid=req.getParameter("eid");
        String ename=req.getParameter("ename");
        String esalary=req.getParameter("esalary");
        String esex=req.getParameter("esex");
        String ebir=req.getParameter("ebir");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        try{
            date=simpleDateFormat.parse(ebir);
        }catch (Exception e){
            e.printStackTrace();
        }
        String emarry=req.getParameter("emarry");
        String eedu=req.getParameter("eedu");
        String did=req.getParameter("did");
        String pid=req.getParameter("pid");
        String ephone=req.getParameter("ephone");
        String eaddr=req.getParameter("eaddr");
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        Emploe emploe=new Emploe();
        try{
            emploe=emploeDaoImp.getEmploeById(Integer.parseInt(eid));
        }catch (Exception e){
            e.printStackTrace();
        }
        emploe.setEid(Integer.parseInt(eid));
        emploe.setEname(ename);
        emploe.setEsalary(esalary);
        emploe.setEsex(esex);
        emploe.setEbir(date);
        emploe.setEmarry(emarry);
        emploe.setEedu(eedu);
        emploe.setDid(Integer.parseInt(did));
        emploe.setPid(Integer.parseInt(pid));
        emploe.setEphoto(ephone);
        emploe.setEaddr(eaddr);
        Boolean flag=false;
        try{
            flag=emploeDaoImp.updateEmploe(Integer.parseInt(eid),emploe);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag){
            resp.sendRedirect("../System_war_exploded/ManagerShowSelf?eid="+eid);
        }
    }
}
