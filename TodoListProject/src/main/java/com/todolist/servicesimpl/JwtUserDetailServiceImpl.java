package com.todolist.servicesimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todolist.services.JwtUserDetailService;
import com.todolist.services.UserService;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService, JwtUserDetailService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			com.todolist.models.User user = userService.getUserByEmail(username);
			if (user == null) {
				throw new UsernameNotFoundException("Username " + username + " not found");
			} else {
				return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
			}
	}
}
