package com.xsk.entity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xsk.entity.User;

import java.util.List;

//@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserList();
}
