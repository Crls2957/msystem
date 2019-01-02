package servlet;

import daoimp.EmploeDaoImp;
import entity.Emploe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

/**
 *
 * 接受员工修改资料的请求
 */
public class EmploeUpdateSelf extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到员工修改资料的请求！");
        String eid=req.getParameter("eid");
        String ename=req.getParameter("ename");
        String esalary=req.getParameter("esalary");
        String esex=req.getParameter("esex");
        /*System.out.println("获取的性别是："+esex);*/
        String ebir=req.getParameter("ebir");
        String emarry=req.getParameter("emarry");
        String eedu=req.getParameter("eedu");
        String did=req.getParameter("did");
        String pid=req.getParameter("pid");
        String ephone=req.getParameter("ephone");
        String eaddr=req.getParameter("eaddr");
        String equestion=req.getParameter("equestion");
        String eanswer=req.getParameter("eanswer");

        Emploe emploe=new Emploe();
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        try{
            emploe=emploeDaoImp.getEmploeById(Integer.parseInt(eid));
        }catch (Exception e){
            e.printStackTrace();
        }
        emploe.setEid(Integer.parseInt(eid));
        emploe.setEname(ename);
        emploe.setEsalary(esalary);
        emploe.setEsex(esex);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try{
            emploe.setEbir(simpleDateFormat.parse(ebir));
        }catch (Exception e){
            e.printStackTrace();
        }
        emploe.setEmarry(emarry);
        emploe.setEedu(eedu);
        emploe.setDid(Integer.parseInt(did));
        emploe.setPid(Integer.parseInt(pid));
        emploe.setEphone(ephone);
        emploe.setEaddr(eaddr);
        emploe.setEquestion(equestion);
        emploe.setEanswer(eanswer);

        Boolean flag=false;
        try{
            flag=emploeDaoImp.updateEmploe(Integer.parseInt(eid),emploe);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag){
            req.getSession().setAttribute("emploe",emploe);
            resp.sendRedirect("emploe/show_self.jsp");
        }
    }
}
