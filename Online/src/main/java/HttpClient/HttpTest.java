package HttpClient;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Li Hao
 * @Date 2020/12/30 20:42
 * @Version 1.0
 */
public class HttpTest {
    public static void main(String[] args) {
        /**
         * 测试下载文件 异步下载
         */
//        HttpClientUtils.getInstance().download(
//                "http://newbbs.qiniudn.com/phone.png", "test.png",
//                new HttpClientUtils.HttpClientDownLoadProgress() {
//                    public void onProgress(int progress) {
//                        System.out.println("download progress = " + progress);
//                    }
//                });
//
//        // POST 同步方法
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("username", "admin");
//        params.put("password", "admin");
//        HttpClientUtils.getInstance().httpPost(
//                "http://192.168.31.183:8080/SSHMySql/register", params);
//
//        // GET 同步方法
//        HttpClientUtils.getInstance().httpGet(
//                "http://wthrcdn.etouch.cn/weather_mini?city=北京");

        // 上传文件 POST 同步方法
        try {
            Map<String,String> uploadParams = new LinkedHashMap<String, String>();
            uploadParams.put("userImageContentType", "image");
            uploadParams.put("userImageFileName", "testaa.png");
            HttpClientUtils.getInstance().uploadFileImpl(
                    "http://192.168.31.183:8080/SSHMySql/upload", "android_bug_1.png",
                    "userImage", uploadParams);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
