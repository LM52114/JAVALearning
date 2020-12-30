package Online.src.main.java.HttpClient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Author Li Hao
 * @Date 2020/12/26 23:20
 * @Version 1.0
 */
public class HttpPostTest {
    private final static String URL = "http://localhost:8190/iportal/web/mycontent/datas/{0}/update.rjson?token={1}";
    private final static String COOKIE = "testCookie";
    private final static String PATH = ".../test.zip";

    public static void main(String[] args) throws IOException {
        //CloseableHttpClient意思是：可关闭的
        CloseableHttpClient httpClient = HttpClients.createDefault();//1、创建实例
        HttpPost httpPost = new HttpPost(URL);//2、创建请求

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addTextBody("token", "111", ContentType.TEXT_PLAIN);//传参
        builder.setCharset(Charset.forName("utf8"));//设置请求的编码格式
        //builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//设置浏览器兼容模式

        // 把文件加到HTTP的post请求中
        File file = new File(PATH);
        builder.addBinaryBody(
                "test",
                new FileInputStream(file),
                ContentType.APPLICATION_OCTET_STREAM,
                file.getName()
        );

        HttpEntity httpEntity = builder.build();
        httpPost.setHeader("Cookie", COOKIE);
        httpPost.setEntity(httpEntity);//对于HttpPost对象而言，可调用setEntity(HttpEntity entity)方法来设置请求参数。
        CloseableHttpResponse response = httpClient.execute(httpPost);//3、执行
        HttpEntity responseEntity = response.getEntity();//4、获取实体

        Header header = responseEntity.getContentType();
        //打印内容
        String sResponse = EntityUtils.toString(responseEntity, "UTF-8");//5、获取网页内容，并且指定编码
        System.out.println("Post 返回结果" + sResponse);
        httpClient.close();
        response.close();
    }


}
