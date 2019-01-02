package entity;

import java.io.Serializable;

/**
 * 经理实体类Manager
 */
public class Manager implements Serializable{

     private static final long serialVersionUID=1L;

    private int mid;//经理编号
    private String mname;//经理姓名
    private String mpassword;//经理管理密码
    private int mpower;//经理权限
    private int mstatus;//经理状态

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public int getMpower() {
        return mpower;
    }

    public void setMpower(int mpower) {
        this.mpower = mpower;
    }

    public int getMstatus() {
        return mstatus;
    }

    public void setMstatus(int mstatus) {
        this.mstatus = mstatus;
    }

    //构造方法
    public Manager() {
    }

    //toString方法

    @Override
    public String toString() {
        return "Manager{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", mpassword='" + mpassword + '\'' +
                ", mpower=" + mpower +
                ", mstatus=" + mstatus +
                '}';
    }
}
