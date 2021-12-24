package com.lidong.quartzdemo.controller;

import com.lidong.quartzdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caolidong
 * @date 2021/12/24
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper usermapper;
    @ResponseBody
    @RequestMapping("get")
    public String test(){
        String selectid = usermapper.selectid();
        return selectid;
    }
}
