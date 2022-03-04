package cn.cjmoke.service.impl;

import cn.cjmoke.mapper.UserMapper;
import cn.cjmoke.pojo.Account;
import cn.cjmoke.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Account> implements UserService {


}
