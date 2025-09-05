package com.hit.mapper.user;

import com.hit.model.user.UserLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLogMapper {

    Integer insertUserLog(UserLog userLog);

}