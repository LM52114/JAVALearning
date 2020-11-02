package com.zidu.uesrdao;

/**
 * @Author Li Hao
 * @Date 2020/10/25 14:08
 * @Version 1.0
 */
public class UserDaoFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
