package com.allwe.vv.bean;

import java.util.List;

/**
 * Created by taotao on 16-6-7.
 */

public class PostItem extends BaseBean {
    private int id;
    private String icon_url;
    private String nickname;
    private String title;
    private String topic;
    private String img_url;
    private String content;
    private String publish_time;
    private int commnet_count;
    private int praise_count;
    private List<Comment> commentList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public int getCommnet_count() {
        return commnet_count;
    }

    public void setCommnet_count(int commnet_count) {
        this.commnet_count = commnet_count;
    }

    public int getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
