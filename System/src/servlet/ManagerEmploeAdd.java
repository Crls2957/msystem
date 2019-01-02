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
 * 接收管理员添加员工信息请求
 */
public class ManagerEmploeAdd extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收管理员添加员工信息请求");

        String eid=req.getParameter("eid");
        String ename=req.getParameter("ename");
        String esalary=req.getParameter("esalary");
        String esex=req.getParameter("esex");
        String ebir=req.getParameter("ebir");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
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
        Emploe emploe=new Emploe();
        emploe.setEid(Integer.parseInt(eid));
        emploe.setEname(ename);
        emploe.setEsalary(esalary);
        emploe.setPid(Integer.parseInt(pid));
        emploe.setDid(Integer.parseInt(did));
        emploe.setEedu(eedu);
        emploe.setEaddr(eaddr);
        emploe.setEmarry(emarry);
        emploe.setEaddr(eaddr);
        emploe.setEphone(ephone);
        emploe.setEbir(date);
        emploe.setEsex(esex);
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        boolean flag=false;
        try{
            flag=emploeDaoImp.addEmploe(emploe);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag){
            resp.sendRedirect("EmploeTable");
        }else{
            resp.sendRedirect("manager/emploe_add.jsp");
        }
    }
}
