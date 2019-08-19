package com.xsk.cart.service;

import com.xsk.cart.dao.UserDao;
import com.xsk.cart.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Optional<UserEntity> FindUserById(Long id) {

        for (int index = 0; index < 10; index++) {
            UserEntity entity = new UserEntity();
            entity.setId((long) index);
            entity.setName("姓名是：" + index);
            entity.setPwd("pwd"+index);
            userDao.save(entity);
        }
        return userDao.findById(id);
    }
}
