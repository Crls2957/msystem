package servlet;

import bean.EmploePageBean;
import daoimp.DeptDaoImp;
import daoimp.EmploeDaoImp;
import daoimp.PostDaoImp;
import entity.Dept;
import entity.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 接收展示员工信息的请求
 */
public class EmploeTable extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到展示员工信息的请求");
        int pageNow=1;
        String _pageNow=req.getParameter("pageNow");
        if(_pageNow!=null){
            pageNow=Integer.parseInt(_pageNow);
            System.out.println("当前页页数是"+pageNow);
        }
        EmploePageBean emploePageBean=new EmploePageBean();
        EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
        DeptDaoImp deptDaoImp=new DeptDaoImp();
        ArrayList<Dept> arrayList=new ArrayList<>();
        PostDaoImp postDaoImp=new PostDaoImp();
        ArrayList<Post> arrayList1=new ArrayList<>();
        try{
            arrayList=deptDaoImp.getAllDept();
            arrayList1=postDaoImp.getAllPost();
            emploePageBean=emploeDaoImp.getAllEmploeByPage(pageNow);
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getSession().setAttribute("dept",arrayList);
        req.getSession().setAttribute("post",arrayList1);
        req.getSession().setAttribute("emploePageBean",emploePageBean);
        resp.sendRedirect("manager/emploe_table.jsp");
    }
}
