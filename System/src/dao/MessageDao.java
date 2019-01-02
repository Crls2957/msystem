package dao;

import bean.NewsPageBean;
import entity.Message;

import java.util.ArrayList;

/**
 * 消息的数据库操作dao层接口
 */
public interface MessageDao {

    //查看所有留言
    public ArrayList<Message> getALlMsg()throws Exception;
    //通过分页查看所有留言
    public NewsPageBean getALlMsgByPage(int n)throws Exception;
    //添加留言
    public boolean addMessage(Message msg)throws Exception;
    //通过muser查询留言详情
    public Message getMsgByUser(String muser)throws Exception;
    //通过mid删除留言信息
    public boolean deleteNews(int mid)throws Exception;
}
