package dao;

import entity.Post;

import java.util.ArrayList;

/**
 * 职位数据库操作dao层接口
 */
public interface PostDao {

    //查找所有职位
    public ArrayList<Post> getAllPost()throws Exception;
    //查看职位
    public Post getPostById(int pid)throws Exception;
}
