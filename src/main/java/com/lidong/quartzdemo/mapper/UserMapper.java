package com.lidong.quartzdemo.mapper;

import com.lidong.quartzdemo.bo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author caolidong
 * @date 2021/12/24
 */
@Mapper
public interface UserMapper {
    User selectid();
}
