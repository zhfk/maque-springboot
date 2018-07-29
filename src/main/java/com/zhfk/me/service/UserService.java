package com.zhfk.me.service;

import com.zhfk.me.entity.UserEntity;
import com.zhfk.me.constant.RoleConstant;
import com.zhfk.me.jpa.dao.UserDao;
import com.zhfk.me.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    @Transactional
    public int saveUser(UserEntity userEntity){
        if(userEntity == null) return -1;
        if(findUserByName(userEntity.getUsername()) == null){
            userEntity.setRoles(RoleConstant.ROLE_USER);
            userRepository.save(userEntity);
            return 0;
        }else {
            return 1;
        }
    }

    public UserEntity findUserById(int id){
        return userDao.getUserById(id);
    }

    public UserEntity findUserByName(String name){
        return userRepository.findUserByUsername(name);
    }

    public Iterable<UserEntity> findAllUser() {
       return userRepository.findAll();
    }

}
