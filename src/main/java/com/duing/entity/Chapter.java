package com.duing.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 书籍⽬录（章节列表）
 */
@Data
public class Chapter implements Serializable {

    private static final long serialVersionUID = 6064223328601671920L;

    // 章节id
    private Long id;
    //书籍id
    private Long bookId;
    //章节名
    private String name;
    //章节内容id
    private Long contentId;
    //类型（免费或付费等）
    private String type;

}