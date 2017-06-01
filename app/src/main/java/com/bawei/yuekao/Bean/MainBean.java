package com.bawei.yuekao.Bean;

import java.util.List;

/**
 * Created by chengqianlang on 2017/5/31.
 */

public class MainBean {

    /**
     * date : 20170531
     * stories : [{"images":["https://pic4.zhimg.com/v2-a2024ab5370ac29dd1870499b0de33bb.jpg"],"type":0,"id":9448998,"ga_prefix":"053118","title":"注意到了吗，乔布斯和罗永浩演讲都会用这种「渐变背景」"},{"title":"违和感中透着搞笑，历史上每一幅烂画都是一个表情包","ga_prefix":"053117","images":["https://pic4.zhimg.com/v2-f7c7da93b081d5de75926c792168615b.jpg"],"multipic":true,"type":0,"id":9446836},{"images":["https://pic2.zhimg.com/v2-b7a7f8a2790b2120b907ebfb2b96194d.jpg"],"type":0,"id":9447232,"ga_prefix":"053116","title":"围棋史上最会创新的棋手，应该就是阿尔法狗了"},{"images":["https://pic3.zhimg.com/v2-c0022dacd2d1c5affc55212450b56f9e.jpg"],"type":0,"id":9449047,"ga_prefix":"053115","title":"明明工作这么努力，怎么还不给我升职加薪？"},{"images":["https://pic2.zhimg.com/v2-ad4f7646e7c48f50e6916a932b3d4649.jpg"],"type":0,"id":9449464,"ga_prefix":"053112","title":"大误 · 呀，我手机怎么碎了"},{"title":"太低不行太大也不行，选眼镜除了好看还需要考虑什么？","ga_prefix":"053111","images":["https://pic1.zhimg.com/v2-60b3f1f9960ed51985aca441ef3fe0a0.jpg"],"multipic":true,"type":0,"id":9448983},{"images":["https://pic4.zhimg.com/v2-5ab36a9f94ddfb164f96a545e7cc4adf.jpg"],"type":0,"id":9448918,"ga_prefix":"053110","title":"刻板印象能有多荒谬，让这部「善恶颠倒」的音乐剧告诉你"},{"images":["https://pic2.zhimg.com/v2-c868907914c8a642cc4453a160c5de69.jpg"],"type":0,"id":9449645,"ga_prefix":"053109","title":"我们擅长的，AI 还有一些办不到；\r\nAI 擅长的，我们永远也办不到"},{"images":["https://pic1.zhimg.com/v2-0ed36680b360f9279c1246f1719d1df0.jpg"],"type":0,"id":9449025,"ga_prefix":"053108","title":"想考注册会计师，首先你得知道它难在哪"},{"images":["https://pic3.zhimg.com/v2-8f8a1f9368d860f3b69d72c7ce9ffa96.jpg"],"type":0,"id":9442796,"ga_prefix":"053107","title":"学了七年的茶，现在来告诉你学茶的正确步骤"},{"images":["https://pic4.zhimg.com/v2-d100270b55a965faf1458be491b69957.jpg"],"type":0,"id":9449394,"ga_prefix":"053107","title":"传说中像天堂一样的北欧，真的比别的地方更平等吗？"},{"images":["https://pic4.zhimg.com/v2-0a1fdc948e11898be740773bcd2678f3.jpg"],"type":0,"id":9449109,"ga_prefix":"053107","title":"当你说「我有一个朋友\u2026\u2026」，我意味深长地笑了"},{"images":["https://pic4.zhimg.com/v2-afca8f815a640712f0171283fb7ba183.jpg"],"type":0,"id":9449303,"ga_prefix":"053106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic3.zhimg.com/v2-21c57ed85ecbf27badb24917fbcd888e.jpg","type":0,"id":9449645,"ga_prefix":"053109","title":"我们擅长的，AI 还有一些办不到；\r\nAI 擅长的，我们永远也办不到"},{"image":"https://pic3.zhimg.com/v2-84b8ca90609b83cbf77d74a1accdd6ce.jpg","type":0,"id":9449109,"ga_prefix":"053107","title":"当你说「我有一个朋友\u2026\u2026」，我意味深长地笑了"},{"image":"https://pic2.zhimg.com/v2-4c708d0ebb43bd5dcf81358668cf7825.jpg","type":0,"id":9441460,"ga_prefix":"053007","title":"原来淘金的人真能捡到实打实的金子（但是你不用想了）"},{"image":"https://pic2.zhimg.com/v2-9937576dc406cd42634a34c9a8886ce1.jpg","type":0,"id":9442721,"ga_prefix":"053009","title":"她把小脑运动神经受损的儿子送进哈佛，单亲家庭不一定只有伤害"},{"image":"https://pic3.zhimg.com/v2-3ca039fbd140d846c37bede07a768cc6.jpg","type":0,"id":9448272,"ga_prefix":"053007","title":"美国电影赚劳动人民的钱，法国电影赚艺术人士的钱，看看戛纳你就懂了"}]
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
         * images : ["https://pic4.zhimg.com/v2-a2024ab5370ac29dd1870499b0de33bb.jpg"]
         * type : 0
         * id : 9448998
         * ga_prefix : 053118
         * title : 注意到了吗，乔布斯和罗永浩演讲都会用这种「渐变背景」
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
         * image : https://pic3.zhimg.com/v2-21c57ed85ecbf27badb24917fbcd888e.jpg
         * type : 0
         * id : 9449645
         * ga_prefix : 053109
         * title : 我们擅长的，AI 还有一些办不到；
         AI 擅长的，我们永远也办不到
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
