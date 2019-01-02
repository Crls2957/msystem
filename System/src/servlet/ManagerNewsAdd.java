package servlet;

import daoimp.MessageDaoImp;
import entity.Manager;
import entity.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 接收管理员添加消息的请求
 */
public class ManagerNewsAdd extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收管理员添加消息的请求");
        Message message=new Message();
        String mtitle=req.getParameter("mtitle");
        String muser=req.getParameter("muser");
        String mcontent=req.getParameter("mcontent");
        Date date=new Date();
        String time=date.toLocaleString();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try{
            message.setMtime(simpleDateFormat.parse(time));
        }catch (Exception e){
            e.printStackTrace();
        }
        message.setMtitle(mtitle);
        message.setMcontent(mcontent);
        message.setMuser(muser);
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        boolean flag=false;
        try{
            flag=messageDaoImp.addMessage(message);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag){
            resp.sendRedirect("NewsTable");
        }else {
            resp.sendRedirect("NewsTable");
        }
    }
}
