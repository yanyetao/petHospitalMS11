package com.yyt.mapper;

import com.yyt.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 查询
     *
     * @param
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from tb_user where username = #{username}")
    User selectByName(String username);

    @Insert("insert into tb_user values (null,#{username},#{password})")
    void add(User user);

}
