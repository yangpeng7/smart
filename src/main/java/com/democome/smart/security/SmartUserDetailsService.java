package com.democome.smart.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.democome.smart.mapper.UserMapper;
import com.democome.smart.model.user.User;

public class SmartUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.selectUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("not found");
		}

		logger.info(user.getUsername());

		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		// authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
		// System.err.println("username is " + username + ", " +
		// user.getRole().name());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);
	}

}