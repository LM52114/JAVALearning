//package Online.src.main.java.HttpClient;
//
//import com.alibaba.fastjson.JSONObject;
//import com.supermap.desktop.online.shareDatas.SharedDataUtilities;
//import com.supermap.desktop.online.taskManager.event.TransmitSteppedEvent;
//import org.apache.http.Header;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//import javax.net.ssl.HttpsURLConnection;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.Charset;
//import java.text.MessageFormat;
//import java.util.Date;
//
///**
// * @Author Li Hao
// * @Date 2020/12/26 23:20
// * @Version 1.0
// */
//public class HttpPostTest {
//    private final static String URL = "http://localhost:8190/iportal/web/mycontent/datas/{0}/update.rjson?token={1}";
//    private final static String COOKIE = "testCookie";
//    private final static String PATH = ".../test.zip";
//
//
//    private Boolean a(long uploadSequence, byte[] buffer, UserInfo user) {
//        try {
//
//            CloseableHttpClient httpClient = HttpClients.createDefault();//1、创建实例
//            String uploadUrl = MessageFormat.format(SharedDataUtilities.getAvaliableUrl(user.getHost()) + "web/mycontent/datas/{0,number,#}/upload.json?token={1}", 12345, user.getToken());
//            HttpPost post = new HttpPost(uploadUrl);
//            post.setHeader("Cookie", COOKIE);
//
//
//            HttpEntity reqEntity = MultipartEntityBuilder.create().addBinaryBody("file", buffer).build();
//            post.setEntity(reqEntity);
//            CloseableHttpResponse response = httpClient.execute(post);
//            if (response.getStatusLine().getStatusCode() == 200) {
//                String objectString = EntityUtils.toString(response.getEntity(), "utf-8");
//                if (!StringUtilities.isNullOrEmpty(objectString)) {
//                    JSONObject jsonObject = JSONObject.parseObject(objectString);
//                    return jsonObject.get("childID") != null;
//                }
//            }
//        } catch (Exception var12) {
////            Application.getActiveApplication().getOutput().output(var12);
//        }
//
//        return false;
//    }
//
//
//
//    public static void main(String[] args) throws IOException {
//
//        long allSize=new File(PATH).length();
//
//        double timeSpanSeconds = 0.0D;
//        long uploadRange = 0L;
//
//        Date startTime = new Date();
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(PATH));
//        byte[] buffer = new byte[524288];
//        int realWriteSize = 1;
//        Boolean uploadSucceed = true;
//
//        while(uploadRange < allSize && uploadSucceed && realWriteSize > 0) {
//            try {
//                realWriteSize = bufferedInputStream.read(buffer, 0, 524288);
//                if (realWriteSize <= 0 || this.d >= this.b) {
//                    break;
//                }
//
//                long seq = this.c;
//                byte[] bufferUpload = new byte[realWriteSize];
//                int j = 0;
//
//                while(true) {
//                    if (j >= realWriteSize) {
//                        a(seq, bufferUpload,);
//                        Date currentDate = new Date();
//                        long timeSpan = currentDate.getTime() - ((Date)startTime).getTime();
//                        timeSpanSeconds += (double)timeSpan;
//                        FileSize uploadRangeSize;
//                        if (timeSpanSeconds > 1000.0D) {
//                            uploadRangeSize = new FileSize((double)uploadRange, FileSizeType.BYTE);
//                            if (speed.getSize() != uploadRangeSize.getSize() * 1000.0D / timeSpanSeconds) {
//                                speed = new FileSize(uploadRangeSize.getSize() * 1000.0D / timeSpanSeconds, FileSizeType.BYTE);
//                            }
//
//                            timeSpanSeconds = 0.0D;
//                            uploadRange = 0L;
//                            startTime = DateTime.now();
//                        }
//
//                        this.d += (long)realWriteSize;
//                        uploadRange += 524288L;
//                        ++this.c;
//                        uploadRangeSize = new FileSize((double)this.d, FileSizeType.BYTE);
//                        FileSize totalFileSize = new FileSize((double)this.b, FileSizeType.BYTE);
//                        TransmitSteppedEvent e = new TransmitSteppedEvent((long)uploadRangeSize.getSize(), (long)totalFileSize.getSize(), speed);
//                        this.a(e);
//                        this.l = this.d;
//                        break;
//                    }
//
//                    bufferUpload[j] = buffer[j];
//                    ++j;
//                }
//            } catch (Exception var23) {
//            }
//
//            if (this.d >= this.b) {
//                boolean result = this.a(userInfo);
//                return result;
//            }
//
//            if (this.k) {
//                break;
//            }
//        }
//
//
//        CloseableHttpClient httpClient = HttpClients.createDefault();//1、创建实例
//        HttpPost httpPost = new HttpPost(URL);//2、创建请求
//
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
////        builder.addTextBody("token", "111", ContentType.TEXT_PLAIN);//传参
//        builder.setCharset(Charset.forName("utf8"));//设置请求的编码格式
//        //builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//设置浏览器兼容模式
//
//        // 把文件加到HTTP的post请求中
//        File file = new File(PATH);
//        builder.addBinaryBody(
//                "test",
//                new FileInputStream(file),
//                ContentType.APPLICATION_OCTET_STREAM,
//                file.getName()
//        );
//
//        HttpEntity httpEntity = builder.build();
//        httpPost.setHeader("Cookie", COOKIE);
//        httpPost.setEntity(httpEntity);//对于HttpPost对象而言，可调用setEntity(HttpEntity entity)方法来设置请求参数。
//        CloseableHttpResponse response = httpClient.execute(httpPost);//3、执行
//        HttpEntity responseEntity = response.getEntity();//4、获取实体
//
//        Header header = responseEntity.getContentType();
//        //打印内容
//        String sResponse = EntityUtils.toString(responseEntity, "UTF-8");//5、获取网页内容，并且指定编码
//        System.out.println("Post 返回结果" + sResponse);
//        httpClient.close();
//        response.close();
//    }
//
//    public String post(File file) {
//        String result = "";
//        FileInputStream fileInputStream = null;
//
//        try {
//            long totalSize = file.length();
//
//            String lineSeparator = "\r\n";
//            StringBuilder prePostData = new StringBuilder();
//            prePostData.append("--" + this.boundary);
//            prePostData.append(lineSeparator);
//            prePostData.append("Content-Disposition:form-data;name=\"file\";filename=\"");
//            prePostData.append(this.fileName + ".zip\"");
//            prePostData.append(lineSeparator);
//            prePostData.append("Content-Type:application/octet-stream");
//            prePostData.append(lineSeparator);
//            prePostData.append(lineSeparator);
//            String endBoundary = lineSeparator + "--" + this.boundary + "--" + lineSeparator;
//            java.net.URL url = new URL(this.url);
//            HttpURLConnection connection = this.proxy == null ? (HttpURLConnection)url.openConnection() : (HttpURLConnection)url.openConnection(this.proxy);
//            if (connection instanceof HttpsURLConnection) {
//                HttpUtilties.httpsSslProblem((HttpsURLConnection)connection);
//            }
//
//            connection.setDoOutput(true);
//            connection.setDoInput(true);
//            connection.setChunkedStreamingMode(1024);
//            connection.setRequestMethod("POST");
//            connection.setConnectTimeout(300000);
//            connection.setUseCaches(false);
//            connection.setReadTimeout(300000);
//            connection.setRequestProperty("Connection", "Keep-Alive");
//            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.boundary);
//            connection.setRequestProperty("Content-Length", String.valueOf(totalSize + (long)prePostData.length() + (long)endBoundary.length()));
//            if (!StringUtilities.isNullOrEmpty(this.cookie)) {
//                connection.setRequestProperty("Cookie", this.cookie);
//            }
//
//            fileInputStream = new FileInputStream(file);
//            connection.connect();
//            OutputStream outputStream = connection.getOutputStream();
//            long uploadOffset = 0L;
//            byte[] buffer = new byte[5120];
//            outputStream.write(prePostData.toString().getBytes());
//            FileSize totalFileSize = new FileSize((double)totalSize, FileSizeType.BYTE);
//            Date startTime = new Date();
//            long segment = 0L;
//
//            int responseCode;
//            while(uploadOffset < totalSize && !this.isCancel) {
//                responseCode = fileInputStream.read(buffer, 0, 5120);
//                outputStream.write(buffer, 0, responseCode);
//                uploadOffset += (long)responseCode;
//                segment += (long)responseCode;
//                outputStream.flush();
//                Date currentDate = new Date();
//                if (currentDate.getTime() - startTime.getTime() > 1000L) {
//                    try {
//                        FileSize uploadedFileSize = new FileSize((double)uploadOffset, FileSizeType.BYTE);
//                        FileSize restFileSize = new FileSize((double)(totalSize - uploadOffset), FileSizeType.BYTE);
//                        FileSize segmentFileSize = new FileSize((double)segment, FileSizeType.BYTE);
//                        FileSize speed = FileSize.divide(segmentFileSize, (double)(currentDate.getTime() - startTime.getTime()) / 1000.0D);
//                        int remainTime = (new Double(FileSize.divide(restFileSize, speed))).intValue();
//                        HttpPostEvent event = new HttpPostEvent(this, totalFileSize, uploadedFileSize, speed, remainTime);
//                        this.fireHttpPost(event);
//                        if (event.isCancel()) {
//                            this.isCancel = true;
//                        }
//                    } finally {
//                        segment = 0L;
//                        startTime = new Date();
//                    }
//                }
//            }
//
//            outputStream.write(endBoundary.getBytes());
//            outputStream.flush();
//            outputStream.close();
//            this.fireHttpPost(new HttpPostEvent(this, totalFileSize, totalFileSize, FileSize.ZERO, 0));
//            responseCode = connection.getResponseCode();
//            String line;
//            if (responseCode == 200 || responseCode == 201 || responseCode == 202) {
//                for(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)); (line = reader.readLine()) != null; result = result + System.lineSeparator()) {
//                    result = result + line;
//                }
//            }
//        } catch (Exception var42) {
////            Application.getActiveApplication().getOutput().output(var42);
//        } finally {
//            try {
//                if (fileInputStream != null) {
//                    fileInputStream.close();
//                }
//            } catch (IOException var40) {
////                Application.getActiveApplication().getOutput().output(var40);
//            }
//
//        }
//
//        return result;
//    }
//
//
//}
