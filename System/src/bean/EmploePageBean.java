package bean;

import entity.Emploe;

import java.util.ArrayList;

public class EmploePageBean {

    private int crruntPage;  //当前页
    private int totalPage;  //总页数
    private int lineCount;  //总记录条数
    private ArrayList<Emploe> arrayList=new ArrayList<>(); //职员对象集合

    public int getCrruntPage() {
        return crruntPage;
    }

    public void setCrruntPage(int crruntPage) {
        this.crruntPage = crruntPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public ArrayList<Emploe> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Emploe> arrayList) {
        this.arrayList = arrayList;
    }
}
