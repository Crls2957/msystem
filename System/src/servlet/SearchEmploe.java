package servlet;

import bean.EmploePageBean;
import daoimp.EmploeDaoImp;
import entity.Emploe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 接收按条件查询员工的请求
 */
public class SearchEmploe extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收按条件查询员工的请求");

        String ename=req.getParameter("ename");
        System.out.println("需要查询人员名字："+ename);
        String eid=req.getParameter("eid");
        String dname=req.getParameter("dname");
        ArrayList<Emploe> arrayList=new ArrayList<>();
        Emploe emploe=new Emploe();
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        if(ename!=null&&!ename.equals("")){
            System.out.println("按名字查询进行了");
            try{
                emploe=emploeDaoImp.getEmploeByName(ename);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(eid!=null&&!eid.equals("")){
            try{
                emploe=emploeDaoImp.getEmploeById(Integer.parseInt(eid));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(dname!=null&&!dname.equals("")){
            try{
                arrayList=emploeDaoImp.getEmploeByDname(dname);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("查询到职员："+emploe.toString());
        req.getSession().setAttribute("semploe",emploe);
        req.getSession().setAttribute("semploelist",arrayList);
        resp.sendRedirect("manager/emploe_table.jsp");
    }
}
