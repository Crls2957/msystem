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
 * 接收管理员查看详情的请求
 */
public class ManagerShowSelf extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("接收管理员查看详情的请求");

        String eid=req.getParameter("eid");
        System.out.println("收到的员工编号："+eid);
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        Emploe emploe=new Emploe();
        try{
            emploe=emploeDaoImp.getEmploeById(Integer.parseInt(eid));
        }catch (Exception e){
            e.printStackTrace();
        }
        ArrayList<Dept> arrayList=new ArrayList<>();
        DeptDaoImp deptDaoImp=new DeptDaoImp();
        try{
            arrayList=deptDaoImp.getAllDept();
        }catch (Exception e){
            e.printStackTrace();
        }
        ArrayList<Post> arrayList1=new ArrayList<>();
        PostDaoImp postDaoImp=new PostDaoImp();
        try{
            arrayList1=postDaoImp.getAllPost();
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getSession().setAttribute("emploe",emploe);
        req.getSession().setAttribute("dept",arrayList);
        req.getSession().setAttribute("post",arrayList1);
        resp.sendRedirect("manager/emploe_update.jsp");
    }
}
