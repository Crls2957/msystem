package entity;

import java.io.Serializable;

import java.util.Date;
/**
 * 消息实体类Message
 */
public class Message implements Serializable{

    private static final long serialVersionUID=1L;

    private int mid;//消息编号
    private String mtitle;//消息标题
    private String mcontent;//消息内容
    private Date mtime;//消息发布时间
    private String muser;//消息发布者
    private int mstatus;//消息状态

    //构造方法

    public Message() {
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getMuser() {
        return muser;
    }

    public void setMuser(String muser) {
        this.muser = muser;
    }

    public int getMstatus() {
        return mstatus;
    }

    public void setMstatus(int mstatus) {
        this.mstatus = mstatus;
    }

    //toString方法


    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", mtitle='" + mtitle + '\'' +
                ", mcontent='" + mcontent + '\'' +
                ", mtime=" + mtime +
                ", muser='" + muser + '\'' +
                ", mstatus=" + mstatus +
                '}';
    }
}
