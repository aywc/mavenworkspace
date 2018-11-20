package com.aaa.mybatis.dao;

import com.aaa.mybatis.entity.News;

import java.util.List;

/**
 * className:NewsDoa
 * discriptoin:
 * author:zz
 * createTime:2018-11-06 16:01
 */
public interface NewsDoa {
    /**
     * 多对一
     * @return
     */
    List<News> manyToOne();
}
