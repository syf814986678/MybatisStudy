package com.shiyifan.dao;

import com.shiyifan.pojo.User;
import com.shiyifan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //获取sqlsession对象
       SqlSession sqlSession= MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            sqlSession.close();
        }
    }
    @Test
    public void testbyid(){
        //获取sqlsession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(1);
            System.out.println(user);
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            sqlSession.close();
        }
    }
    //增删改   必须需要提交事物
    @Test
    public void adduser(){
        //获取sqlsession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.addUser(new User(5,"施一帆","1234"));
            sqlSession.commit();//提交事务
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            sqlSession.close();
        }
    }
    @Test
    public void updateuser(){
        //获取sqlsession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(4,"血帆","4321"));
            sqlSession.commit();//提交事务
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            sqlSession.close();
        }
    }
    @Test
    public void deleteuser(){
        //获取sqlsession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try{
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUser(4);
            sqlSession.commit();//提交事务
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            sqlSession.close();
        }
    }
}
