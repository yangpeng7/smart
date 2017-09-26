package com.democome.smart.controller.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.democome.smart.model.filter.user.UserFilter;
import com.democome.smart.model.user.User;
import com.democome.smart.service.user.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService service;

	@RequestMapping("/all")
	public List<User> getUser() {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = userDetails.getUsername();
	
		logger.info("username: " + username);

		List<User> list = service.getAllUsers();
		logger.info(list.toString());

		return list;
	}

	@RequestMapping("/search/{page}/{pageSize}")
	public SearchUserResponse query(@PathVariable Integer page, @PathVariable Integer pageSize) {
		if (page != null && pageSize != null) {
			PageHelper.startPage(page, pageSize);
		}
		List<User> users = service.getAllUsers();
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		SearchUserResponse response = new SearchUserResponse();
		response.setUsers(users);
		response.setTotalNumber(pageInfo.getSize());

		return response;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public SearchUserResponse searchUser(@RequestBody SearchUserRequest request) {

		if (request.getPageNumber() != null && request.getPageSize() != null) {
			PageHelper.startPage(request.getPageNumber(), request.getPageSize());
		}

		UserFilter userFilter = new UserFilter();
		userFilter.setUsername(request.getUsername());
		List<User> users = service.searchUsersByFilter(userFilter);

		PageInfo<User> pageInfo = new PageInfo<User>(users);
		SearchUserResponse response = new SearchUserResponse();
		response.setUsers(users);
		response.setTotalNumber(pageInfo.getSize());

		return response;
	}

	@RequestMapping("/detail")
	public User getUsers(Integer id) {

		User user = service.getUser(id);
		return user;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(@RequestBody CreateUserRequest request) {

		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());

		service.createUser(user);
	}

	@RequestMapping("/delete")
	public void deleteUsers(Integer id) {

		service.deleteUser(id);
	}

}
