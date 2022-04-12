package com.duing.util.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 存储文档解析后的信息
 * name：章节名字
 * link：章节内容链接
 */
@Data
public class ChapterBean implements Serializable {
    private static final long serialVersionUID = -2596415338738119601L;
    private String name;
    private String link;
}
