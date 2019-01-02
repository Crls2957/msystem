package servlet;

import bean.NewsPageBean;
import daoimp.MessageDaoImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 接收管理员展示消息的请求
 */
public class NewsTable extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收管理员展示消息的请求");
        int pageNow=1;
        String _pageNow=req.getParameter("pageNow");
        if(_pageNow!=null){
            pageNow=Integer.parseInt(_pageNow);
        }
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        NewsPageBean newsPageBean=new NewsPageBean();
        try{
            newsPageBean=messageDaoImp.getALlMsgByPage(pageNow);
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getSession().setAttribute("news",newsPageBean);
        resp.sendRedirect("manager/news_table.jsp");
    }
}
