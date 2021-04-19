package com.zhidu.myBatis.quick;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Li Hao
 * @Date 2021/2/18 15:53
 * @Version 1.0
 */
public class test {
    @Test
    public void testSelect() throws IOException {
        //获得核心配置文件
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        List<Object> userList = sqlSession.selectList("userMapper.findAll");
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
        //模拟User对象
        User user=new User();
        user.setUserName("lihao");
        user.setPassWord("lihao");

        //获得核心配置文件
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        sqlSession.insert("userMapper.insert",user);
        //mybatis 如果需要更新操作，需要提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //模拟User对象
        User user=new User();
        user.setId(1);
        user.setUserName("lihao");
        user.setPassWord("lihao");

        //获得核心配置文件
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        sqlSession.update("userMapper.insert",user);
        //mybatis 如果需要更新操作，需要提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {

        //获得核心配置文件
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        sqlSession.delete("userMapper.insert",1);
        //mybatis 如果需要更新操作，需要提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

}
