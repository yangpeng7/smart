package com.democome.smart.controller.user;

import java.util.List;

import com.democome.smart.controller.common.PageResponse;
import com.democome.smart.model.user.User;

public class SearchUserResponse extends PageResponse {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
