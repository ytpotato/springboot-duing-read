package com.duing.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 存储章节内容信息
 */
@Data
public class ChapterContent  implements Serializable {

    private static final long serialVersionUID = -7004429064196961860L;

    //章节内容id
    private Long id;
    //内容
    private String content;

}