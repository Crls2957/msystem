package entity;

import java.io.Serializable;

/**
 * 部门实体类Dept
 */
public class Dept implements Serializable{

    private static final long serialVersionUID=1L;

    private int did;//部门编号
    private String dname;//部门名称
    private String daddr;//部门地址
    private int dnumber;//部门号码
    private int eid;//部门经理员工编号
    private int dstatus;//部门状态

    //构造方法


    public Dept() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDaddr() {
        return daddr;
    }

    public void setDaddr(String daddr) {
        this.daddr = daddr;
    }

    public int getDnumber() {
        return dnumber;
    }

    public void setDnumber(int dnumber) {
        this.dnumber = dnumber;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getDstatus() {
        return dstatus;
    }

    public void setDstatus(int dstatus) {
        this.dstatus = dstatus;
    }

    //toString方法


    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", daddr='" + daddr + '\'' +
                ", dnumber=" + dnumber +
                ", eid=" + eid +
                ", dstatus=" + dstatus +
                '}';
    }
}
