package servlet;

import daoimp.MessageDaoImp;
import entity.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EmploeNewsAdd extends HttpServlet implements Serializable {

    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到员工添加消息请求");

        String mtitle=req.getParameter("mtitle");
        String muser=req.getParameter("muser");
        String mcontent=req.getParameter("mcontent");
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String time=simpleDateFormat.format(calendar.getTime());
        Date date=null;
        try{
            date=simpleDateFormat.parse(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        MessageDaoImp messageDaoImp=new MessageDaoImp();
        Message message=new Message();
        message.setMtitle(mtitle);
        message.setMuser(muser);
        message.setMcontent(mcontent);
        message.setMtime(date);
        Boolean flag=false;
        try{
           flag=messageDaoImp.addMessage(message);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag){
            resp.sendRedirect("failure.jsp?log=addsuccess");
        }else{
            resp.sendRedirect("failure.jsp?log=addfail");
        }
    }
}
