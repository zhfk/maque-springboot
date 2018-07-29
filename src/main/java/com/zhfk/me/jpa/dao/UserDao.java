package com.zhfk.me.jpa.dao;

import com.zhfk.me.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserEntity getUserById(int id) {
        String sql = "select * from user where id = ?";
        RowMapper<UserEntity> rowMapper = new BeanPropertyRowMapper<UserEntity>(UserEntity.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
