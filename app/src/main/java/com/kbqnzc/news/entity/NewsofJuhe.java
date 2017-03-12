package com.kbqnzc.news.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */

public class NewsofJuhe {
    String reason;
    Result result;

    public Result getResult() {
        return result;
    }

    public String getReason() {
        return reason;
    }

    public class Result {
        int stat;
        List<Data> data;

        public int getStat() {
            return stat;
        }

        public List<Data> getData() {
            return data;
        }
    }

    public class Data {
        /**
         * "uniquekey": "aed11809b7efddd34165a2255512cc44",
         * "title": "燃！这群平凡的中国男人，征服了最挑剔的日本人",
         * "date": "2017-03-12 19:54",
         * "category": "头条",
         * "author_name": "环球网",
         * "url": "http://mini.eastday.com/mobile/170312195428613.html",
         * "thumbnail_pic_s": "http://05.imgmini.eastday.com/mobile/20170312/20170312195428_3453eb137ec1156829eec18118233071_2_mwpm_03200403.png",
         * "thumbnail_pic_s02": "http://05.imgmini.eastday.com/mobile/20170312/20170312195428_3453eb137ec1156829eec18118233071_2_mwpm_03200403.png",
         * "thumbnail_pic_s03": "http://05.imgmini.eastday.com/mobile/20170312/20170312195428_3453eb137ec1156829eec18118233071_3_mwpm_03200403.png"
         */
        String uniquekey;
        String title;
        String date;
        String category;
        String author_name;
        String url;
        String thumbnail_pic_s;
        String thumbnail_pic_s02;
        String thumbnail_pic_s03;

        public String getUniquekey() {
            return uniquekey;
        }

        public String getTitle() {
            return title;
        }

        public String getDate() {
            return date;
        }

        public String getCategory() {
            return category;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public String getUrl() {
            return url;
        }

        public String getThumbnail_pic_s() {
            return thumbnail_pic_s;
        }

        public String getThumbnail_pic_s02() {
            return thumbnail_pic_s02;
        }

        public String getThumbnail_pic_s03() {
            return thumbnail_pic_s03;
        }
    }
}
