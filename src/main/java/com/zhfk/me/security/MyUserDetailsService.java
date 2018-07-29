package com.zhfk.me.security;

import com.zhfk.me.entity.UserEntity;
import com.zhfk.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("用户名为空");
        }
        UserEntity userEntity = userService.findUserByName(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Arrays.stream(userEntity.getRoles().split(","))
                .allMatch(role -> authorities.add( new SimpleGrantedAuthority(role)));
        return new User(userEntity.getUsername(),userEntity.getPassword(),authorities);
    }
}
