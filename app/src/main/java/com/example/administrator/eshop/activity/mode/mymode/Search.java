package com.example.administrator.eshop.activity.mode.mymode;

import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 */
public class Search {

    /**
     * data : [{"goods_id":"332","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/332_thumb_G_1480562691685.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/332_G_1480562691248.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/332_G_1480562691779.jpg"},"market_price":"￥191元","name":"茵曼女装2016秋季长袖衬衫女棉麻衬衣立领绣花职业装女士衬衣中长款","promote_price":"","shop_price":"￥159元"},{"goods_id":"331","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/331_thumb_G_1480562638319.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/331_G_1480562638858.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/331_G_1480562638040.jpg"},"market_price":"￥155元","name":"依月衣长袖百搭白衬衫女韩版新款蝙蝠袖女装上衣中长款宽松大码棉衬衣","promote_price":"","shop_price":"￥129元"},{"goods_id":"330","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/330_thumb_G_1480562588146.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/330_G_1480562588788.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/330_G_1480562588814.jpg"},"market_price":"￥142元","name":"薇思倪2016秋冬装上新款韩版棉麻中长款休闲长袖保暖加绒衬衫女衬衣","promote_price":"","shop_price":"￥118元"},{"goods_id":"329","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/329_thumb_G_1480562300013.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/329_G_1480562300723.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/329_G_1480562300737.jpg"},"market_price":"￥238元","name":"晚烟衬衫女2016新款春秋装女长袖韩版中长款宽松休闲娃娃领加绒保暖衬衣","promote_price":"","shop_price":"￥198元"},{"goods_id":"328","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/328_thumb_G_1480562237152.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/328_G_1480562237359.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/328_G_1480562237642.jpg"},"market_price":"￥238元","name":"晚烟衬衫女2016秋冬中长款女士韩范文艺风长袖大码修身中长款加绒加厚衬衣女","promote_price":"","shop_price":"￥198元"},{"goods_id":"327","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/327_thumb_G_1480562157185.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/327_G_1480562157418.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/327_G_1480562157588.jpg"},"market_price":"￥335元","name":"圣迪奥 s.deer 女装复古抓皱长款设计衬衫","promote_price":"","shop_price":"￥279元"},{"goods_id":"326","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/326_thumb_G_1480562045756.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/326_G_1480562045190.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/326_G_1480562045726.jpg"},"market_price":"￥299元","name":"Vero Moda2016春季新款花朵印花弧形底摆直筒中长款衬衫","promote_price":"","shop_price":"￥250元"},{"goods_id":"325","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/325_thumb_G_1480561979656.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/325_G_1480561979400.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/325_G_1480561979040.jpg"},"market_price":"￥130元","name":"OLUNSI白衬衫女长袖中长款2016秋冬季新款女装加绒加厚保暖寸衫韩版宽松休闲纯棉衬衣","promote_price":"","shop_price":"￥108元"},{"goods_id":"324","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/324_thumb_G_1480561923912.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/324_G_1480561923989.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/324_G_1480561923239.jpg"},"market_price":"￥178元","name":"betu百图时尚中长款衬衫女长袖条纹衬衣潮2016秋装新款","promote_price":"","shop_price":"￥148元"},{"goods_id":"323","img":{"small":"http://106.14.32.204/eshop/images/201612/thumb_img/323_thumb_G_1480561858930.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/323_G_1480561858710.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/323_G_1480561858899.jpg"},"market_price":"￥166元","name":"Alex Len 白衬衫女长袖中长款 2016秋冬新款宽松纯棉百搭衬衣韩范打底衫","promote_price":"","shop_price":"￥138元"}]
     * paginated : {"count":10,"more":1,"total":260}
     * status : {"succeed":1}
     */

    private PaginatedBean paginated;
    private StatusBean status;
    private List<DataBean> data;

    public PaginatedBean getPaginated() {
        return paginated;
    }

    public void setPaginated(PaginatedBean paginated) {
        this.paginated = paginated;
    }

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

    public static class PaginatedBean {
        /**
         * count : 10
         * more : 1
         * total : 260
         */

        private int count;
        private int more;
        private int total;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getMore() {
            return more;
        }

        public void setMore(int more) {
            this.more = more;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
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
         * goods_id : 332
         * img : {"small":"http://106.14.32.204/eshop/images/201612/thumb_img/332_thumb_G_1480562691685.jpg","thumb":"http://106.14.32.204/eshop/images/201612/goods_img/332_G_1480562691248.jpg","url":"http://106.14.32.204/eshop/images/201612/source_img/332_G_1480562691779.jpg"}
         * market_price : ￥191元
         * name : 茵曼女装2016秋季长袖衬衫女棉麻衬衣立领绣花职业装女士衬衣中长款
         * promote_price :
         * shop_price : ￥159元
         */

        private String goods_id;
        private ImgBean img;
        private String market_price;
        private String name;
        private String promote_price;
        private String shop_price;

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public ImgBean getImg() {
            return img;
        }

        public void setImg(ImgBean img) {
            this.img = img;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPromote_price() {
            return promote_price;
        }

        public void setPromote_price(String promote_price) {
            this.promote_price = promote_price;
        }

        public String getShop_price() {
            return shop_price;
        }

        public void setShop_price(String shop_price) {
            this.shop_price = shop_price;
        }

        public static class ImgBean {
            /**
             * small : http://106.14.32.204/eshop/images/201612/thumb_img/332_thumb_G_1480562691685.jpg
             * thumb : http://106.14.32.204/eshop/images/201612/goods_img/332_G_1480562691248.jpg
             * url : http://106.14.32.204/eshop/images/201612/source_img/332_G_1480562691779.jpg
             */

            private String small;
            private String thumb;
            private String url;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
