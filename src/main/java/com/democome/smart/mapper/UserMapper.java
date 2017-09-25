package com.democome.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.democome.smart.model.filter.user.UserFilter;
import com.democome.smart.model.user.User;

public interface UserMapper {

	public List<User> selectAllUsers();

	public List<User> selectUsersByFilter(@Param("filter") UserFilter filter);

	public User selectUserById(@Param("id") Integer id);

	public User selectUserByUsername(@Param("username") String username);

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(@Param("id") Integer id);
}
