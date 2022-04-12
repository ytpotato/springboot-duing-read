package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.entity.Book;
import com.duing.entity.User;
import com.duing.mapper.BookMapper;
import com.duing.mapper.UserMapper;
import com.duing.service.BookService;
import com.duing.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper,Book> implements BookService {
}
