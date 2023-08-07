package com.technojade.allybot.jwt;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.technojade.allybot.entity.Employee;
import com.technojade.allybot.service.EmployeeService;
import com.technojade.allybot.service.UserService;

@Service
public class JWTUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		Employee byEmailId = empService.findByEmailId(username);
		com.technojade.allybot.entity.User numberOrEmailId = userService.findByMobileNumberOrEmailId(username, "");

		if (request.getHeader("x-login-type") != null && request.getHeader("x-login-type").equals("user")) {
			if (numberOrEmailId != null) {
				return new org.springframework.security.core.userdetails.User(numberOrEmailId.getEmailId(),
						numberOrEmailId.getPassword(), new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		} else {

			if (byEmailId != null) {
				return new org.springframework.security.core.userdetails.User(byEmailId.getEmail(),
						byEmailId.getPassword(), new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		}
	}

}