package com.kbqnzc.news.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2017/3/12.
 * 网络访问工具类
 */
public class HttpClientUtil {
    //接口回调
    public interface GetJsonListener{
        public void getJsonSuccess(String json);
        public void getJsonFail(int responseCode);
        public void getException(Exception e);
    }
    /**
     * @param targetUrl 获取网络数据
     */
    public static void getJson(URL targetUrl,GetJsonListener listener){
        HttpURLConnection httpURLConnection = null;
        StringBuffer json = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            httpURLConnection = (HttpURLConnection) targetUrl.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode() == 200){
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                String msg = null;
                while((msg = bufferedReader.readLine())!=null){
                   json.append(msg) ;
                }
                listener.getJsonSuccess(json.toString());
            }else {
                listener.getJsonFail(httpURLConnection.getResponseCode());
            }
        } catch (IOException e) {
            listener.getException(e);
        }finally {
            try {
                bufferedReader.close();
                inputStream.close();
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();
        }
    }
}
