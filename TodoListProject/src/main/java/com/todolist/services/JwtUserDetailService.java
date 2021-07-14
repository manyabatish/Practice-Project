package com.todolist.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface JwtUserDetailService {
	
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


}
