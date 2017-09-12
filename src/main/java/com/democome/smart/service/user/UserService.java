package com.democome.smart.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.democome.smart.mapper.UserMapper;
import com.democome.smart.model.user.User;
import com.democome.smart.service.user.api.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
    private UserMapper mapper;

    @Override
    public List<User> getAllUsers() {
        return mapper.selectAllUsers();
    }

    @Override
    public User getUser(Integer id) {
        return mapper.selectUserById(id);
    }

    @Override
    public void createUser(User user) {
        mapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        mapper.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        mapper.deleteUser(id);
    }


}
