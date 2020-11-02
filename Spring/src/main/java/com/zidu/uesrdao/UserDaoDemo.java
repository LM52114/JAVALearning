package com.zidu.uesrdao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Li Hao
 * @Date 2020/10/25 13:47
 * @Version 1.0
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userDao = context.getBean("userDao");
        if(userDao instanceof UserDao){
            ((UserDao)userDao).run();
        }
    }
}
