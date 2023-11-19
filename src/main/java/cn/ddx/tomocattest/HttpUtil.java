package cn.ddx.tomocattest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class HttpUtil {

    private static HttpClient httpClient;

    public HttpUtil() {
    }

    /**
     * 发送 HTTP GET 请求
     *
     * @param url 请求的 URL
     * @throws IOException 发生 I/O 异常
     */
    public static void get(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpClient = HttpClients.createDefault();

        try {
            // 执行 GET 请求
            HttpResponse response = httpClient.execute(httpGet);

            // 获取响应实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 将实体内容转换为字符串
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            // 释放资源
            httpGet.releaseConnection();
        }
    }

    public static void main(String[] args) throws Exception {

        // 示例用法
        HttpUtil.get("http://127.0.0.1:8080/get?num=1");
//        System.out.println(response);

    }
}
