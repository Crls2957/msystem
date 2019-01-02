package bean;

import entity.Dept;

import java.util.ArrayList;

/**
 * 封装部门分页对象
 */
public class DeptPageBean {

    private int pageNow; //当前页码
    private int lineCount; //总的数据条数
    private int totalPage; //总的页数
    private ArrayList<Dept> arrayList=new ArrayList<>(); //部门对象集合

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public ArrayList<Dept> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Dept> arrayList) {
        this.arrayList = arrayList;
    }
}
