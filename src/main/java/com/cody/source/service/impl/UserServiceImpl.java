package com.cody.source.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cody.source.dao.UserDao;
import com.cody.source.entity.User;
import com.cody.source.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author wql
 * @since 2021-05-14 23:10:14
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
