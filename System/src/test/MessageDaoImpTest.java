package test;

import daoimp.DeptDaoImp;
import daoimp.MessageDaoImp;
import entity.Message;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MessageDaoImpTest extends DeptDaoImp {
    MessageDaoImp messageDaoImp=new MessageDaoImp();

    @Test
    public void getALlMsg() {
        ArrayList<Message> arrayList=new ArrayList<>();
        try{
            arrayList=messageDaoImp.getALlMsg();
        }catch (Exception e){
            e.printStackTrace();
        }
        for(Message message:arrayList){
            System.out.println(message.toString());
        }
    }

    @Test
    public void getALlMsgByPage() {
    }

    @Test
    public void addMessage() {
    }

    @Test
    public void getMsgByUser() {
    }

    @Test
    public void deleteNews() {
    }
}