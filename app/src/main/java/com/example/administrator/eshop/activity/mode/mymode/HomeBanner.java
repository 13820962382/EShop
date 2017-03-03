package com.example.administrator.eshop.activity.mode.mymode;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

public class HomeBanner {

    /**
     * data : {"player":[{"action":"","action_id":0,"description":"","photo":{"small":"http://106.14.32.204/eshop/data/afficheimg/20161201pyadkl.jpg","thumb":"http://106.14.32.204/eshop/data/afficheimg/20161201pyadkl.jpg","url":"http://106.14.32.204/eshop/data/afficheimg/20161201pyadkl.jpg"},"url":"http://"},{"action":"","action_id":0,"description":"","photo":{"small":"http://106.14.32.204/eshop/data/afficheimg/20161201ansxot.jpg","thumb":"http://106.14.32.204/eshop/data/afficheimg/20161201ansxot.jpg","url":"http://106.14.32.204/eshop/data/afficheimg/20161201ansxot.jpg"},"url":"http://"},{"action":"","action_id":0,"description":"","photo":{"small":"http://106.14.32.204/eshop/data/afficheimg/20161201ecmcps.jpg","thumb":"http://106.14.32.204/eshop/data/afficheimg/20161201ecmcps.jpg","url":"http://106.14.32.204/eshop/data/afficheimg/20161201ecmcps.jpg"},"url":"http://"},{"action":"","action_id":0,"description":"","photo":{"small":"http://106.14.32.204/eshop/data/afficheimg/20161201seisfo.jpg","thumb":"http://106.14.32.204/eshop/data/afficheimg/20161201seisfo.jpg","url":"http://106.14.32.204/eshop/data/afficheimg/20161201seisfo.jpg"},"url":"http://"},{"action":"","action_id":0,"description":"","photo":{"small":"http://106.14.32.204/eshop/data/afficheimg/20161201qifytg.jpg","thumb":"http://106.14.32.204/eshop/data/afficheimg/20161201qifytg.jpg","url":"http://106.14.32.204/eshop/data/afficheimg/20161201qifytg.jpg"},"url":"http://"}],"promote_goods":[{"brief":"","id":"77","img":{"small":"http://106.14.32.204/eshop/images/201611/thumb_img/77_thumb_G_1480507560317.jpg","thumb":"http://106.14.32.204/eshop/images/201611/goods_img/77_G_1480507560205.jpg","url":"http://106.14.32.204/eshop/images/201611/source_img/77_G_1479972580628.jpg"},"market_price":"￥175元","name":"静曼儿新款连衣裙针织衫两件套长袖套头半高领毛衣+百褶","promote_price":"￥100元","shop_price":"￥146元"},{"brief":"","id":"76","img":{"small":"http://106.14.32.204/eshop/images/201611/thumb_img/76_thumb_G_1480507560730.jpg","thumb":"http://106.14.32.204/eshop/images/201611/goods_img/76_G_1480507560603.jpg","url":"http://106.14.32.204/eshop/images/201611/source_img/76_G_1479971999537.jpg"},"market_price":"￥247元","name":"cachecache 韩版时尚V领百褶连衣裙","promote_price":"￥158元","shop_price":"￥206元"},{"brief":"","id":"74","img":{"small":"http://106.14.32.204/eshop/images/201611/thumb_img/74_thumb_G_1480507560932.jpg","thumb":"http://106.14.32.204/eshop/images/201611/goods_img/74_G_1480507560471.jpg","url":"http://106.14.32.204/eshop/images/201611/source_img/74_G_1479971689464.jpg"},"market_price":"￥190元","name":"betu百图修身显瘦百褶裙 背心裙 圆领无袖连衣裙","promote_price":"￥120元","shop_price":"￥158元"},{"brief":"","id":"75","img":{"small":"http://106.14.32.204/eshop/images/201611/thumb_img/75_thumb_G_1480507560948.jpg","thumb":"http://106.14.32.204/eshop/images/201611/goods_img/75_G_1480507560921.jpg","url":"http://106.14.32.204/eshop/images/201611/source_img/75_G_1479971816944.jpg"},"market_price":"￥202元","name":"betu百图百褶格子短裙 七分袖荷叶领连衣裙","promote_price":"￥148元","shop_price":"￥168元"}]}
     * status : {"succeed":1}
     */

    private DataBean data;
    private StatusBean status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public static class DataBean {
        private List<PlayerBean> player;
        private List<PromoteGoodsBean> promote_goods;

        public List<PlayerBean> getPlayer() {
            return player;
        }

        public void setPlayer(List<PlayerBean> player) {
            this.player = player;
        }

        public List<PromoteGoodsBean> getPromote_goods() {
            return promote_goods;
        }

        public void setPromote_goods(List<PromoteGoodsBean> promote_goods) {
            this.promote_goods = promote_goods;
        }

        public static class PlayerBean {
            /**
             * action :
             * action_id : 0
             * description :
             * photo : {"small":"http://106.14.32.204/eshop/data/afficheimg/20161201pyadkl.jpg","thumb":"http://106.14.32.204/eshop/data/afficheimg/20161201pyadkl.jpg","url":"http://106.14.32.204/eshop/data/afficheimg/20161201pyadkl.jpg"}
             * url : http://
             */

            private String action;
            private int action_id;
            private String description;
            private PhotoBean photo;
            private String url;

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public int getAction_id() {
                return action_id;
            }

            public void setAction_id(int action_id) {
                this.action_id = action_id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public PhotoBean getPhoto() {
                return photo;
            }

            public void setPhoto(PhotoBean photo) {
                this.photo = photo;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public static class PhotoBean {
                /**
                 * small : http://106.14.32.204/eshop/data/afficheimg/20161201pyadkl.jpg
                 * thumb : http://106.14.32.204/eshop/data/afficheimg/20161201pyadkl.jpg
                 * url : http://106.14.32.204/eshop/data/afficheimg/20161201pyadkl.jpg
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

        public static class PromoteGoodsBean {
            /**
             * brief :
             * id : 77
             * img : {"small":"http://106.14.32.204/eshop/images/201611/thumb_img/77_thumb_G_1480507560317.jpg","thumb":"http://106.14.32.204/eshop/images/201611/goods_img/77_G_1480507560205.jpg","url":"http://106.14.32.204/eshop/images/201611/source_img/77_G_1479972580628.jpg"}
             * market_price : ￥175元
             * name : 静曼儿新款连衣裙针织衫两件套长袖套头半高领毛衣+百褶
             * promote_price : ￥100元
             * shop_price : ￥146元
             */

            private String brief;
            private String id;
            private ImgBean img;
            private String market_price;
            private String name;
            private String promote_price;
            private String shop_price;

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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
                 * small : http://106.14.32.204/eshop/images/201611/thumb_img/77_thumb_G_1480507560317.jpg
                 * thumb : http://106.14.32.204/eshop/images/201611/goods_img/77_G_1480507560205.jpg
                 * url : http://106.14.32.204/eshop/images/201611/source_img/77_G_1479972580628.jpg
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
}
