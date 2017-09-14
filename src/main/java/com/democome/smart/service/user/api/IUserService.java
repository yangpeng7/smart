package com.democome.smart.service.user.api;

import java.util.List;

import com.democome.smart.model.filter.user.UserFilter;
import com.democome.smart.model.user.User;

public interface IUserService {

	public List<User> getAllUsers();

	public List<User> searchUsersByFilter(UserFilter filter);

	public User getUser(Integer id);

	public void createUser(User user);

	public void updateUser(User user);

	public void deleteUser(Integer id);
}
