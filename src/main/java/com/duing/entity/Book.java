package com.duing.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 存储书籍信息
 */
@Data
public class Book  implements Serializable {
    private static final long serialVersionUID = -648543921073573043L;

    //唯⼀id
    private Long id;
    // 书名
    private String name;
    //作者
    private String author;
    //作者id
    private Long authorid;
    //作品介绍
    private String description;
    //字数
    private Integer count;
    //状态（连载/完结）
    private Integer status;
    //类型（都市/玄幻）
    private Integer type;

}