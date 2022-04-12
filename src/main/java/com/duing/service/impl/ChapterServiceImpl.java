package com.duing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.entity.Chapter;
import com.duing.entity.User;
import com.duing.mapper.ChapterMapper;
import com.duing.mapper.UserMapper;
import com.duing.service.ChapterService;
import com.duing.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper,Chapter> implements ChapterService {
}
