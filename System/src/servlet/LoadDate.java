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
import java.util.ArrayList;

/**
 * 默认加载数据请求
 */
public class LoadDate extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("获得了默认加载数据请求！");
        String id=req.getParameter("eid");
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        Emploe emploe=new Emploe();
        try{
            emploe=emploeDaoImp.getEmploeById(Integer.parseInt(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        DeptDaoImp deptDaoImp=new DeptDaoImp();
        ArrayList<Dept> arrayList=new ArrayList<>();
        try{
            arrayList=deptDaoImp.getAllDept();
        }catch (Exception e){
            e.printStackTrace();
        }
        PostDaoImp postDaoImp=new PostDaoImp();
        ArrayList<Post> arrayList1=new ArrayList<>();
        try{
            arrayList1=postDaoImp.getAllPost();
        }catch (Exception e){
            e.printStackTrace();
        }

        req.getSession().setAttribute("emploe",emploe);
        req.getSession().setAttribute("dept",arrayList);
        req.getSession().setAttribute("post",arrayList1);
        resp.sendRedirect("emploe/update_self.jsp");
    }
}
