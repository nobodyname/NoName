package me.unknow.noname.bean;

import java.util.List;

public class DailyListBean {

    /**
     * date : 20181017
     * stories : [{"images":["https://pic4.zhimg.com/v2-5efc3f85ba6d014f53a9c44b64b98f63.jpg"],"type":0,"id":9698691,"ga_prefix":"101722","title":"小事 · 出动吧，民间福尔摩斯"},{"images":["https://pic2.zhimg.com/v2-eca2e5225b935de37cfcc58eeca77cd9.jpg"],"type":0,"id":9698586,"ga_prefix":"101721","title":"今晚点映 · 为了励志，《嗝嗝老师》也是拼了"},{"images":["https://pic1.zhimg.com/v2-4ac1494010acd1182967af54a23d7608.jpg"],"type":0,"id":9698867,"ga_prefix":"101720","title":"数字晚年的父母们，「震惊！」「速看！」成了他们的最爱"},{"images":["https://pic1.zhimg.com/v2-c3c9adf60620321aad76c041d2752608.jpg"],"type":0,"id":9698862,"ga_prefix":"101719","title":"「56 个星座，56 支花」\u2026\u2026等等，不是 56 个民族吗？"},{"images":["https://pic4.zhimg.com/v2-20e745be18e7e02aed8f126119a9b557.jpg"],"type":0,"id":9698783,"ga_prefix":"101716","title":"造假十多年，撤稿 31 篇，哈佛大牛就这样骗了全世界"},{"images":["https://pic2.zhimg.com/v2-7c96c9f10192bfc8bbff14b847fce599.jpg"],"type":0,"id":9698566,"ga_prefix":"101715","title":"为什么地平线上的月亮大又亮？"},{"images":["https://pic2.zhimg.com/v2-3f078d208c0f42cac15a9a39d0abfd2d.jpg"],"type":0,"id":9698538,"ga_prefix":"101713","title":"议程设置想做好，热词洗脑很重要"},{"images":["https://pic1.zhimg.com/v2-8ec51ac47177e7190021481cbf19812c.jpg"],"type":0,"id":9698777,"ga_prefix":"101712","title":"大误 · 未成年人还是别看西游记了"},{"images":["https://pic4.zhimg.com/v2-284990b1f8c5559e0813f3b5c77ba9c7.jpg"],"type":0,"id":9698676,"ga_prefix":"101710","title":"楼市入冬，魔幻重生"},{"images":["https://pic4.zhimg.com/v2-ab37c52b31fec6b774c1cdcda56422b7.jpg"],"type":0,"id":9698678,"ga_prefix":"101709","title":"从这些开始，培养你作为「人」的格局"},{"images":["https://pic4.zhimg.com/v2-4d145ad2d75e6cfb69e26c082f36375b.jpg"],"type":0,"id":9698551,"ga_prefix":"101708","title":"丙烯酰胺，一种让人对红糖水和星巴克感到恐慌的物质"},{"images":["https://pic3.zhimg.com/v2-e6dacc5a8e0a5dcf8caeba15c8315d5a.jpg"],"type":0,"id":9698417,"ga_prefix":"101707","title":"买了漱口水，吨吨吨喝一口，好辣"},{"title":"浴霸三摄、秒变无线充电宝\u2026\u2026华为 Mate20 确实有点「香」","ga_prefix":"101707","images":["https://pic4.zhimg.com/v2-fe49e57aae8a15f1ebf24f37651de5f7.jpg"],"multipic":true,"type":0,"id":9698782},{"images":["https://pic1.zhimg.com/v2-5796e23e4a92defe1bc5aa98359704cc.jpg"],"type":0,"id":9698760,"ga_prefix":"101706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic4.zhimg.com/v2-e093102accf700073af6c3452293cd27.jpg","type":0,"id":9698862,"ga_prefix":"101719","title":"「56 个星座，56 支花」\u2026\u2026等等，不是 56 个民族吗？"},{"image":"https://pic2.zhimg.com/v2-2febc063b701eb36f0276250185a30fd.jpg","type":0,"id":9698783,"ga_prefix":"101716","title":"造假十多年，撤稿 31 篇，哈佛大牛就这样骗了全世界"},{"image":"https://pic4.zhimg.com/v2-ed3cbc41485dec20cf60c6fed3721a93.jpg","type":0,"id":9698782,"ga_prefix":"101707","title":"浴霸三摄、秒变无线充电宝\u2026\u2026华为 Mate20 确实有点「香」"},{"image":"https://pic4.zhimg.com/v2-5bdcc9c34e119a0b25358f5d2f9ae037.jpg","type":0,"id":9698676,"ga_prefix":"101710","title":"楼市入冬，魔幻重生"},{"image":"https://pic4.zhimg.com/v2-f707bbfcd393be777fd76f856da803bb.jpg","type":0,"id":9698731,"ga_prefix":"101620","title":"微软联合创始人去世，他的亿万人生是个有趣的传奇"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic4.zhimg.com/v2-5efc3f85ba6d014f53a9c44b64b98f63.jpg"]
         * type : 0
         * id : 9698691
         * ga_prefix : 101722
         * title : 小事 · 出动吧，民间福尔摩斯
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic4.zhimg.com/v2-e093102accf700073af6c3452293cd27.jpg
         * type : 0
         * id : 9698862
         * ga_prefix : 101719
         * title : 「56 个星座，56 支花」……等等，不是 56 个民族吗？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
