package com.sp.dao;

import com.sp.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    int addUser(User user);




    @Select("select * from is_user where user_id = #{id}")
        User findUser(@Param("id") int id);

    @Insert("insert into is_user values(#{userId},#{userName},#{password},#{gender},sysdate,#{birthday})")
    @SelectKey(before = true ,keyProperty = "userId" , keyColumn = "user_id",resultType = Integer.class,statement = "select is_user_sql.nextval as user_id from dual")
        int insertUser(User user);
}
