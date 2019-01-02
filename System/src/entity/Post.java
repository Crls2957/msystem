package entity;

import java.io.Serializable;

/**
 * 职位实体类Post
 */
public class Post implements Serializable{

    private static final long serialVersionUID=1L;

    private int pid;//职位编号
    private String pname;//职位名称
    private int pstatus;//职位状态

    //构造方法
    public Post() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPstatus() {
        return pstatus;
    }

    public void setPstatus(int pstatus) {
        this.pstatus = pstatus;
    }

    //toString方法

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pstatus=" + pstatus +
                '}';
    }
}
