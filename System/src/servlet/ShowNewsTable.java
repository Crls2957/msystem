package servlet;

import bean.NewsPageBean;
import daoimp.MessageDaoImp;
import entity.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 接收展示员工留言消息请求
 */

public class ShowNewsTable extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到展示消息的请求");

        int pageNum=1;//默认加载第一页

        String _pageNum=req.getParameter("pageNow");
        if(_pageNum!=null){
            pageNum=Integer.parseInt(_pageNum);
        }
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        NewsPageBean newsPageBean=new NewsPageBean();
        try{
            newsPageBean=messageDaoImp.getALlMsgByPage(pageNum);
        }catch (Exception e){
            e.printStackTrace();
        }
        req.getSession().setAttribute("newspagebean",newsPageBean);
        resp.sendRedirect("emploe/news_table.jsp");
    }
}
