package com.duing.controller;

import com.duing.entity.Book;
import com.duing.entity.User;
import com.duing.service.BookService;
import com.duing.service.UserService;
import com.duing.service.impl.UserServiceImpl;
import com.duing.util.JsoupUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/thyme")
    public String tyhme(){
        return "hello";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public List<User> list(){
        return userService.list();
    }


    @Autowired
    private BookService bookService;

    @RequestMapping("/addBook")
    @ResponseBody
    public boolean addBook(){
        Book book = new Book();
        book.setName("明克街13号");
        book.setAuthor("纯洁滴小龙");
        book.setAuthorid(null);
        book.setCount(1794200);
        book.setDescription("我喜欢坐在夜晚空无一人的大街上，听着“他们”的窃窃私语，享受着“他们”的喧嚣。");
        book.setStatus(1);
        book.setType(0);
        return bookService.save(book);
    }


    private static final String ye = "https://book.qidian.com/info/1021617576/#Catalog";
    private static final String ming = "https://book.qidian.com/info/1030870265/#Catalog";

    @Autowired
    private JsoupUtil jsoupUtil;

    @RequestMapping("/addInfo")
    @ResponseBody
    public String addInfo(){
        Book book = bookService.list().get(1);
        jsoupUtil.handler1(ming,book.getId());
        return "Success";
    }
}
