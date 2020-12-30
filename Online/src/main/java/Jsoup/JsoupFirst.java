package Jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

/**
 * @Author Li Hao
 * @Date 2020/12/27 12:02
 * @Version 1.0
 */
public class JsoupFirst {
    public static void main(String[] args) throws IOException {
        testUrl();
        testFile();
        testString();
    }

    private static void testUrl() throws IOException {
        //解析URL地址
        //参数1：访问的url,参数2:访问的超时时间
        Document document = Jsoup.parse(new URL("http://www.itcast.com/"), 1000);

        //获取title
        Element title=document.getElementsByTag("title").first();
        System.out.println(title.text());
    }

    private static void testString() throws IOException {
        //使用工具类读取文件，获取字符串
        String content= FileUtils.readFileToString(new File(""),"utf-8");
        //解析字符串
        Document document = Jsoup.parse(content);
        //.....

    }

    private static void testFile() throws IOException {
        //解析文件
        Document document = Jsoup.parse(new File(""), "utf-8");
        //....
    }

    private static void testDOM() throws IOException {
        //解析文件
        Document document = Jsoup.parse(new File(""), "utf-8");
        //获取元素
        //1、根据id查询元素getElementById
        Element elementById = document.getElementById("city_bj");
        //2、根据标签查询元素getElementByTag
        Element elementByTag = document.getElementsByTag("span").first();
        //3、根据class查询元素getElementByClass
        Element class_a = document.getElementsByClass("class_a").first();
        //4、根据属性查询元素getElementByAttribute
        Element first = document.getElementsByAttribute("").first();
        //
    }

    private static void testData() throws IOException {
        //解析文件
        Document document = Jsoup.parse(new File(""), "utf-8");
        //获取元素
        //1、根据id查询元素getElementById
        Element element = document.getElementById("test");
        //查询ID
        String id=element.id();
        //查询className
        String className=element.className();
        Set<String> strings = element.classNames();
        //获取属性值
        String attr = element.attr("id");
        Attributes attributes = element.attributes();
        //获取文本内容text
        String text=element.text();

    }

    /**
     * 选择器获取数据
     * @throws IOException
     */
    private static void testSelector() throws IOException {
        //解析文件
        Document document = Jsoup.parse(new File(""), "utf-8");
        //通过标签获取元素：span
        Elements elements = document.select("span");
        //1、根据id查询元素getElementById
        Element first = document.select("#city_bj").first();//#
        //class
        Element element = document.select(".class_a").first();//.
        //属性
        Elements select = document.select("[abc]");//[]
        Element element1 = document.select("[class=s_name]").first();

    }
}
