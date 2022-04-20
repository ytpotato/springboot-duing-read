package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.entity.Author;
import com.duing.entity.Book;
import com.duing.mapper.AuthorMapper;
import com.duing.mapper.BookMapper;
import com.duing.service.AuthorService;
import com.duing.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper,Author> implements AuthorService {
}
