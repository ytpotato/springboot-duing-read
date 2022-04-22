package com.duing.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duing.entity.Book;
import com.duing.service.BookService;
import com.duing.vo.BookDetailVO;
import com.duing.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 搜索功能
     * @param keyword string 关键字
     * @return String list.html
     */
    @RequestMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name",keyword);

        List<Book> books = bookService.list(wrapper);

        List<BookVO> voList = new ArrayList<>();
        for (Book book : books) {
            BookVO vo = new BookVO();
            vo.setId(book.getId());
            vo.setAuthor(book.getAuthor());
            vo.setDescription(book.getDescription());
            vo.setName(book.getName());
            voList.add(vo);
        }
        model.addAttribute("voList",voList);

        return "list";
    }

    /**
     * 书籍详情
     * @param id Long 书籍id（唯一标识） 查询对应的书籍
     * @return String detail.html
     */
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable Long id,Model model){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        Book book = bookService.getOne(wrapper);

        BookDetailVO vo = new BookDetailVO();
        vo.setAuthor(book.getAuthor());
        vo.setDescription(book.getDescription());
        vo.setImgPath(book.getId()+".jpg");
        vo.setName(book.getName());

        model.addAttribute("bookDetailVO",vo);
        return "detail";
    }

}
