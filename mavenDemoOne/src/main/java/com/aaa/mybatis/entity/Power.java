package com.aaa.mybatis.entity;

/**
 * className:Power
 * discriptoin:
 * author:邢博
 * createTime:2018-11-06 16:55
 */
public class Power {
    private int id;
    private String name;
    private String url;
    private int pid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
