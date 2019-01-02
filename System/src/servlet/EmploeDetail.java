package servlet;

import daoimp.DeptDaoImp;
import daoimp.EmploeDaoImp;
import daoimp.PostDaoImp;
import entity.Dept;
import entity.Emploe;
import entity.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public class EmploeDetail extends HttpServlet implements Serializable {

    private static final long  serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String eid = req.getParameter("eid");
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        Emploe emploe=new Emploe();
        try{
             emploe = emploeDaoImp.getEmploeById(Integer.parseInt(eid));
        }catch (Exception e){
            e.printStackTrace();
        }
        DeptDaoImp deptDaoImp = new DeptDaoImp();
        Dept dept=new Dept();
        try{
            dept = deptDaoImp.getDeptById(emploe.getDid());
        }catch (Exception e){
            e.printStackTrace();
        }
        String dname =dept.getDname();
        req.getSession().setAttribute("dname",dname);
        PostDaoImp postDaoImp = new PostDaoImp();
        Post post=new Post();
        try{
            post = postDaoImp.getPostById(emploe.getPid());
        }catch (Exception e){
            e.printStackTrace();
        }
        String pname =post.getPname();
        req.getSession().setAttribute("pname",pname);
        req.getSession().setAttribute("emploe", emploe);
        resp.sendRedirect("manager/emploe_detail.jsp");
    }
}
