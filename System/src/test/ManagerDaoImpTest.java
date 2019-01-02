package test;

import daoimp.DeptDaoImp;
import daoimp.ManagerDaoImp;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerDaoImpTest extends DeptDaoImp {

    ManagerDaoImp managerDaoImp=new ManagerDaoImp();
    @Test
    public void managerLogin() {
        try{
            System.out.println(managerDaoImp.managerLogin("admin","110"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void mupdatePassword() {
    }

    @Test
    public void getMangerByName() {
        try{
            System.out.println(managerDaoImp.getMangerByName("admin").toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}