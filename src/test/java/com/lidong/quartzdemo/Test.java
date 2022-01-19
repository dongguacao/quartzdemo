package com.lidong.quartzdemo;

import com.lidong.quartzdemo.bo.User;
import com.lidong.quartzdemo.controller.UserController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author caolidong
 * @date 2022/1/10
 */
public class Test {
    private static final Map<Class<?>,Class<?>> map = new HashMap<Class<?>,Class<?>>(){
        {
            put(Byte.class,byte.class);
        }
    };
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());

    }


}
