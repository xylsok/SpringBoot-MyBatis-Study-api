package net.gddata.Dao;

import net.gddata.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhangzf on 17/10/25.
 */
public interface UserDao {
    @Select("select  * from User where id=#{id}")
    User findById(@Param("id") int id);

    @Select("select * from user")
    List<User> queryAll() ;
    //
    @Insert("insert into user(Username,Level) values(#{username},#{level})")
    @Options(useGeneratedKeys=true,keyColumn="ID",keyProperty="ID")//设置id自增长
    public void save(User user);

    @Delete("delete from user where id=#{id}")
    void delById(int id);
}
