package HttpClient;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author Li Hao
 * @Date 2021/1/5 16:21
 * @Version 1.0
 */
public class HttpPutTest {

    public static void main(String[] args) throws IOException {
        String urlSymbol = "https://www.supermapol.com/web/datas/2137528831/download?token=";
        String urlColor = "https://www.supermapol.com/web/mycontent/datas/4470/download?token=";

        String urlUpload = "https://www.supermapol.com/web/mycontent/datas/1716475012/sharesetting.rjson?token=";

        String cookie = "JSESSIONID=34426F0747F189A33829B608E97465B5-n1";
        String cookieMy = "JSESSIONID=B2BA7402AA3A38992F9101A115C41FFE-n2";
        //创建client
        CloseableHttpClient client = HttpClients.createDefault();
        //get方法
        HttpPut httpPut = new HttpPut(urlUpload);
        httpPut.setHeader("Cookie", cookieMy);

//        String params="[{entityName：GUEST,entityType:USER,dataPermissionType:DOWNLOAD}]";

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("entityName", "GUEST");
        jsonParam.put("entityType", "USER");
        jsonParam.put("dataPermissionType", "DOWNLOAD");

        HttpEntity httpEntity = new StringEntity(jsonParam.toString(), ContentType.APPLICATION_JSON);
        httpPut.setEntity(httpEntity);
        //执行请求
        CloseableHttpResponse response = client.execute(httpPut);
        String string = EntityUtils.toString(response.getEntity(), "utf-8");


        //获取打印结果
        //查看状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(string);
        //打印内容
        //获取响应实体
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "utf-8");

        System.out.println(str);
        response.close();
        client.close();
    }

}
