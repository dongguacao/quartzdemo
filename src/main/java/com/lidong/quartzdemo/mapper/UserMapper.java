package com.lidong.quartzdemo.mapper;

import com.lidong.quartzdemo.bo.Order;
import com.lidong.quartzdemo.bo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author caolidong
 * @date 2021/12/24
 */
@Mapper
public interface UserMapper {
    User selectid();
    List<Order> typehandler();
    default String test(){
        return "1";
    }
}
