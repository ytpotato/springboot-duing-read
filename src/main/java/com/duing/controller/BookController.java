package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.entity.Book;
import com.duing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/search")
    @ResponseBody
    public String search(@RequestParam("keyword") String keyword){
        System.out.println(keyword);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name",keyword);

        List<Book> books = bookService.list(wrapper);
        System.out.println(books);
        return "list";
    }



}
