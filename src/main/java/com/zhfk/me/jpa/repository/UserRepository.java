package com.zhfk.me.jpa.repository;

import com.zhfk.me.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findUserByUsername(String username);
}
