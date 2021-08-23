package com.example.ggpic;

public class Pics {

    private String Author;//图片类型
    private String Title;//作品标题
    private String Detail;
    private int PicUrl;//类型封面

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public int getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(int picUrl) {
        PicUrl = picUrl;
    }
}

