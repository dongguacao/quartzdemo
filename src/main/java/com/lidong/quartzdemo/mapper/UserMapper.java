package com.lidong.quartzdemo.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author caolidong
 * @date 2021/12/24
 */
@Mapper
public interface UserMapper {
    String selectid();
}
