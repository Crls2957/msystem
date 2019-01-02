package test;

import dao.PostDao;
import daoimp.DeptDaoImp;
import daoimp.PostDaoImp;
import entity.Post;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PostDaoImpTest extends DeptDaoImp {

    PostDaoImp postDaoImp=new PostDaoImp();
    @Test
    public void getAllPost() {
        ArrayList<Post> arrayList=new ArrayList<>();
        try{
            arrayList=postDaoImp.getAllPost();
        }catch (Exception e){
            e.printStackTrace();
        }
        for(Post post:arrayList){
            System.out.println(post.toString());
        }
    }

    @Test
    public void getPostById() {
        int id=2013;
        Post post=new Post();
        try{
            post=postDaoImp.getPostById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(post.toString());
    }
}