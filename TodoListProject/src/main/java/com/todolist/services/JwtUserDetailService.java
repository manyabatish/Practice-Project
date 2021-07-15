package com.todolist.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


public interface JwtUserDetailService {
	
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;


}
