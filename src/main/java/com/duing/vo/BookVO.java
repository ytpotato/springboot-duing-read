package com.duing.vo;

import lombok.Data;

/**
 * vo类作用：是将数据库中查询出来的数据，将需要的数据进一步提取出来，用vo保存，在返回给view；
 *          保护数据的安全，用户就不会直接看到我们数据库的存储结构，可以提高安全性
 *
 */
@Data
public class BookVO {
    //唯⼀id 用来保存书籍的封面图
    private Long id;
    // 书名
    private String name;
    //作者
    private String author;
    //作品介绍
    private String description;
}
