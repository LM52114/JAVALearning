package Online.src.main.java.HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author Li Hao
 * @Date 2020/12/26 23:21
 * @Version 1.0
 */
public class HttpGetTest {
    public static void main(String[] args) throws IOException {
        String urlSymbol = "https://www.supermapol.com/web/datas/2137528831/download?token=";
        String urlColor = "https://www.supermapol.com/web/mycontent/datas/4470/download?token=";
        String cookie = "JSESSIONID=34426F0747F189A33829B608E97465B5-n1";
        //创建client
        CloseableHttpClient client = HttpClients.createDefault();
        //get方法
        HttpGet httpGet = new HttpGet(urlSymbol);
        httpGet.setHeader("Cookie", cookie);
        //执行请求
        CloseableHttpResponse response = client.execute(httpGet);
        //获取打印结果
        //查看状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        //打印内容
        //获取响应实体
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "utf-8");

        System.out.println(str);
        response.close();
        client.close();
    }

}
