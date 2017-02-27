package com.example.administrator.eshop.activity.mode;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class Category {

    /**
     * data : [{"id":"36","name":"温婉淑女","children":[{"id":"57","name":"长袖连衣裙"},{"id":"58","name":"百褶裙"},{"id":"59","name":"荷叶边上衣"}]},{"id":"37","name":"青春时尚","children":[{"id":"51","name":"睡衣风吊带裙"},{"id":"52","name":"连帽卫衣"},{"id":"53","name":"毛衣外套"},{"id":"54","name":"皮衣"},{"id":"55","name":"长袖T恤"},{"id":"56","name":"韩版衬衫"},{"id":"61","name":"学院风"},{"id":"62","name":"羽绒服"},{"id":"63","name":"牛仔长裤"}]},{"id":"38","name":"优雅格调","children":[{"id":"45","name":"一字领"},{"id":"46","name":"针织裙"},{"id":"47","name":"套装"},{"id":"48","name":"条纹针织衫"},{"id":"49","name":"小西装"},{"id":"50","name":"风衣"}]},{"id":"39","name":"原创设计","children":[{"id":"40","name":"印花连衣裙"},{"id":"41","name":"长款衬衫"},{"id":"42","name":"不规则美裙"},{"id":"43","name":"破洞牛仔裤"},{"id":"44","name":"背带裤"}]},{"id":"60","name":"品牌潮流","children":[{"id":"33","name":"潮流穿搭"},{"id":"34","name":"国际大牌"},{"id":"35","name":"商场大牌"}]}]
     * status : {"succeed":1}
     */

    private StatusBean status;
    private List<DataBean> data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class StatusBean {
        /**
         * succeed : 1
         */

        private int succeed;

        public int getSucceed() {
            return succeed;
        }

        public void setSucceed(int succeed) {
            this.succeed = succeed;
        }
    }

    public static class DataBean {
        /**
         * id : 36
         * name : 温婉淑女
         * children : [{"id":"57","name":"长袖连衣裙"},{"id":"58","name":"百褶裙"},{"id":"59","name":"荷叶边上衣"}]
         */

        private String id;
        private String name;
        private List<ChildrenBean> children;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * id : 57
             * name : 长袖连衣裙
             */

            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
