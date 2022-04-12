package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.entity.Chapter;
import com.duing.entity.ChapterContent;
import com.duing.entity.User;
import com.duing.mapper.ChapterContentMapper;
import com.duing.mapper.ChapterMapper;
import com.duing.mapper.UserMapper;
import com.duing.service.ChapterContentService;
import com.duing.service.ChapterService;
import com.duing.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class ChapterContentServiceImpl extends ServiceImpl<ChapterContentMapper,ChapterContent> implements ChapterContentService {
}
