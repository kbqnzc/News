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
    /**
     *
     * @param targetUrl 获取网络数据
     * @return
     */
    public static String getJson(URL targetUrl){
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
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        return json.toString();
    }
}
