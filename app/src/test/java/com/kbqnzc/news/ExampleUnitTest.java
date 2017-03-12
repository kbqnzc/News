package com.kbqnzc.news;

import com.google.gson.Gson;
import com.kbqnzc.news.entity.NewsofJuhe;
import com.kbqnzc.news.utils.HttpClientUtil;

import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void getJson(){
        try {
            URL targetUrl = new URL("http://v.juhe.cn/toutiao/index?type=top&key=d728ab4e75e137c4f23aec12ed3ee6cd");
            HttpClientUtil.getJson(targetUrl, new HttpClientUtil.GetJsonListener() {
                @Override
                public void getJsonSuccess(String json) {
//                    System.out.print(json);
                    Gson gson = new Gson();
                    NewsofJuhe newsData = gson.fromJson(json,NewsofJuhe.class);
                    List<NewsofJuhe.Data> dataList = newsData.getResult().getData();
                    for(NewsofJuhe.Data data : dataList){
                        System.out.println(data.getAuthor_name()+"--"+data.getTitle());
                    }
                }

                @Override
                public void getJsonFail(int responseCode) {
                    System.out.print("响应码"+responseCode);
                }

                @Override
                public void getException(Exception e) {
                    System.out.print("错误为"+e.toString());
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}