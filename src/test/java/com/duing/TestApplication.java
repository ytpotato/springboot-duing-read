package com.duing;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.entity.Author;
import com.duing.entity.vo.GroupBean;
import com.duing.mapper.UserMapper;
import com.duing.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
public class TestApplication {

    @Autowired
    private AuthorService authorService;

    @Test
    public void authorList(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name","说话");
        List<Author> authors = authorService.list(wrapper);
        System.out.println(authors);
        System.out.println(authors.size());

        QueryWrapper wrapper2 = new QueryWrapper();
        wrapper2.like("name","不");
        List<Author> authors2 = authorService.list(wrapper2);
        System.out.println(authors2);
        System.out.println(authors2.size());

        QueryWrapper wrapper3 = new QueryWrapper();
        wrapper3.likeRight("name","肘子");
        List<Author> authors3 = authorService.list(wrapper3);
        System.out.println(authors3);
        System.out.println(authors3.size());

        QueryWrapper wrapper4 = new QueryWrapper();
        wrapper4.likeLeft("name","肘子");
        List<Author> authors4 = authorService.list(wrapper4);
        System.out.println(authors4);
        System.out.println(authors4.size());
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
       List<GroupBean> list = userMapper.groupByUser();
        System.out.println(list);
    }

}
