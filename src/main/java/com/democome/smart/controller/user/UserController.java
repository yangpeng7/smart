package com.democome.smart.controller.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.democome.smart.model.user.User;
import com.democome.smart.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService service;

	@RequestMapping("/all")
	public List<User> getUser() {

		List<User> list = service.getAllUsers();
		logger.info(list.toString());

		return list;
	}

	@RequestMapping("/detail")
	public User getUsers(Integer id) {

		User user = service.getUser(id);
		return user;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(@RequestBody CreateUserRequest request) {

		User user = new User();
		user.setName(request.getName());
		user.setAccount(request.getAccount());

		service.createUser(user);
	}

	@RequestMapping("/delete")
	public void deleteUsers(Integer id) {

		service.deleteUser(id);
	}

}
