package com.duing.vo;

import lombok.Data;

@Data
public class BookDetailVO {
    // 书名
    private String name;
    //作者
    private String author;
    //作品介绍
    private String description;
    private String imgPath;
}
