package bean;

import entity.Message;

import java.util.ArrayList;

public class NewsPageBean {

    private int crruntPage; //当前页
    private int totalPage; //总页数
    private int lineCount; //本页数据条数
    private ArrayList<Message> arrayList=new ArrayList<>();  //消息集合

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

    public ArrayList<Message> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Message> arrayList) {
        this.arrayList = arrayList;
    }
}
