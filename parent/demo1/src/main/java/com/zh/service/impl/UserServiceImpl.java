package com.zh.service.impl;

import com.zh.bean.Users;
import com.zh.bean.UsersExample;
import com.zh.mapper.UsersMapper;
import com.zh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users getUser(Integer id) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria().andIdEqualTo(id);
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users.get(0);
    }
}
