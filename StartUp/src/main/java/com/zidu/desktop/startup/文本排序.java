package com.zidu.desktop.startup;

import java.io.*;
import java.util.HashMap;

/*
 * 练习：
 * 将文本内容自动排序
 * 按照1、2、3 自动排序
 *
 * 分析：
 * 1、创建一个hashMap集合，存储序号和value
 * 2、创建字符缓冲输入流
 * 3、创建字符缓冲输出流
 * 4、使用输入流的readLine()方法逐行读取
 * 5、对读取文本进行切割，得到序号和value
 * 6、切割得到的序号和value放入hashMap
 * 7、便利hashMap键值对
 * 8、把每一个键值对拼接为一个文本行
 * 9、把拼接好的文本使用输出流的write()方法写入到文件
 * 10、释放资源
 * */
public class 文本排序 {
    public static void main(String[] args) throws IOException {
//* 1、创建一个hashMap集合，存储序号和value
        HashMap<String,String> map = new HashMap<String, String>();
//                * 2、创建字符缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("in.txt"));
//                * 3、创建字符缓冲输出流
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("out.txt"));
//                * 4、使用输入流的readLine()方法逐行读取
        String line;
        while ((line=bufferedReader.readLine())!=null){
//                * 5、对读取文本进行切割，得到序号和value
            String[] array=line.split("\\.");

//                * 6、切割得到的序号和value放入hashMap
            map.put(array[0],array[1]);
        }
//                * 7、便利hashMap键值对
        for (String key:map.keySet()) {
            String value=map.get(key);
//                * 8、把每一个键值对拼接为一个文本行
            line=key+"."+value;
            //                * 9、把拼接好的文本使用输出流的write()方法写入到文件
            bufferedWriter.write(line);
            //换行
            bufferedWriter.newLine();
        }
//                * 10、释放资源
        bufferedReader.close();
        bufferedWriter.close();

    }
}
