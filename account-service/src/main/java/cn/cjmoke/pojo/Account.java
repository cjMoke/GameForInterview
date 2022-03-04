package cn.cjmoke.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Account {


    private int id;

    private String username;
    private String password;
    private String email;
    private int logoutstate;

}
