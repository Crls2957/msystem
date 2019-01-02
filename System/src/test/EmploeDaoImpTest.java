package test;

import com.sun.xml.internal.bind.v2.model.core.EnumConstant;
import daoimp.DeptDaoImp;
import daoimp.EmploeDaoImp;
import entity.Emploe;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmploeDaoImpTest extends DeptDaoImp {

    EmploeDaoImp emploeDaoImp=new EmploeDaoImp();
    ArrayList<Emploe> arrayList=new ArrayList<>();
    Emploe emploe=new Emploe();
    @Test
    public void registerEmploe() {
    }

    @Test
    public void registerEmploe2() {
    }

    @Test
    public void addEmploe() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void updateEmploe() {
    }

    @Test
    public void getEmploeByName() {
        try{
            emploe=emploeDaoImp.getEmploeByName("张三");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(emploe.toString());
    }

    @Test
    public void getEmploeById() {
        Emploe emploe=new Emploe();
        try{
            emploe=emploeDaoImp.getEmploeById(1101);
            System.out.println(emploe.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        emploe.setEpassword("1103");
        try{
            emploeDaoImp.updateEmploe(1101,emploe);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            emploe=emploeDaoImp.getEmploeById(1101);
            System.out.println(emploe.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getEmploeByDname() {

    }

    @Test
    public void getEmploeByPname() {
    }

    @Test
    public void updatePidByEid() {
    }

    @Test
    public void getAllEmploe() {
        try{
            arrayList=emploeDaoImp.getAllEmploe();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Emploe emploe:arrayList){
            System.out.println(emploe.toString());
        }
    }

    @Test
    public void getAllEmploeByPage() {
    }

    @Test
    public void emploeLogin() {
    }
}