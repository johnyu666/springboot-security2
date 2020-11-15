package cn.johnyu.mapper;

import cn.johnyu.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
}
