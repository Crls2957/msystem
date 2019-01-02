package test;

import daoimp.DeptDaoImp;
import entity.Dept;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeptDaoImpTest extends DeptDaoImp {
    DeptDaoImp deptDaoImp=new DeptDaoImp();
    @Test
    public void getDeptById() {
        int id=1;
        try{
            System.out.println(deptDaoImp.getDeptById(id).toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*@Test
    public void getAllDept() {
    }*/

    @Test
    public void getAllDeptByPage() {
       /* ArrayList<Dept> arrayList=new ArrayList<>();
        try{
            arrayList=deptDaoImp.getAllDeptByPage(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Dept dept:arrayList){
            System.out.println(dept.toString());
        }*/
    }

    @Test
    public void insertDept() {
    }

    @Test
    public void updateDept() {
    }
}