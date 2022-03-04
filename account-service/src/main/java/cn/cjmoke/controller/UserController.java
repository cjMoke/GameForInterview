package cn.cjmoke.controller;

import cn.cjmoke.pojo.Result;
import cn.cjmoke.pojo.User;
import cn.cjmoke.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 增
     * @return
     */
    @PostMapping
    public Result createUser(User user){
        Result<Object> objectResult = new Result<>();
        return objectResult;
    }


    public Result updateUser(){
        Result<Object> objectResult = new Result<>();
        return objectResult;
    }

    @GetMapping()
    public Result getUser(){
        List<User> list = userService.list();
        Result<Object> objectResult = new Result<>();

        objectResult.setT(list);
        objectResult.setCode(200);
        // return objectResult;
        return null;
    }

    /**
     * 登录用，输入username和password，如果正确，生成一个token，返回。
     * token用md5加密
     * @return
     */
    @GetMapping("{username}/{password}")
    public Result login(User user){

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.eq("username",user.getUsername());
        userQueryWrapper.eq("password",user.getPassword());
        User one = userService.getOne(userQueryWrapper);
        System.out.println(one);
        Result<Object> objectResult = new Result<>();

        if (one == null){
            objectResult.setCode(404);
            objectResult.setMsg("账号密码输入错误");
        } else {
            objectResult.setCode(200);
            objectResult.setMsg("登入成功");
            objectResult.setT(one);
            String tokenStr = user.getUsername()+"---"+new Date();
            String token = DigestUtils.md5DigestAsHex(tokenStr.getBytes());
            System.out.println(token);
        }

        return objectResult;
    }
}
