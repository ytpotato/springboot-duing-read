package com.duing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.entity.User;
import com.duing.entity.vo.GroupBean;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<GroupBean> groupByUser();
}
