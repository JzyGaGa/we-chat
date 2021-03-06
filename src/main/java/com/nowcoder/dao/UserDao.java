package com.nowcoder.dao;

import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
       String TABLE_NAME=" user ";
       String INSERT_FILEDS=" name, password,salt,head_url";
       String SELECT_FILEDS=" id, "+INSERT_FILEDS;

    @Insert({" insert into ",TABLE_NAME,"(",INSERT_FILEDS,") " +
            "values(#{name},#{password},#{salt},#{headUrl})"})
    int addUser(User user);

    @Select({"select ",SELECT_FILEDS," from ",TABLE_NAME," where id =#{id}"})
    User selectById(int id);

    @Update({"update ",TABLE_NAME," set password=#{password} where id=#{id}"})
    void updatePasword(User user);

    @Delete({"delete from ",TABLE_NAME," where id=#{id}"})
    void deleteUserById(User user);
    @Select({"select * from ",TABLE_NAME," where name=#{username}"})
    User findUserByName(String username);
}
