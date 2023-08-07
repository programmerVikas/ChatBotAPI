package com.technojade.allybot.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.technojade.allybot.exception.AuthenticationException;
import com.technojade.allybot.service.AuthService;

//@Component
//public class AuthFilter extends OncePerRequestFilter {
	public class AuthFilter {
	/*
	 * @Autowired AuthService authService;
	 * 
	 * @Override protected void doFilterInternal(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain filterChain) throws
	 * ServletException, IOException { String clientId =
	 * request.getHeader("Client-Id"); String authHeadder =
	 * request.getHeader("Authorization"); boolean authHeadderValidationFailed =
	 * false; boolean isclientIdValidationFailed = false; try { if (authHeadder !=
	 * null && authHeadder != "" && authHeadder.startsWith("Bearer ") && clientId !=
	 * null && clientId != "") { HttpHeaders headers = new HttpHeaders();
	 * 
	 * String authorization = request.getHeader("Authorization");
	 * headers.add("Authorization", authorization); headers.add("Client-Id",
	 * clientId); headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * HttpEntity<String> requestValue = new HttpEntity<String>(headers);
	 * ResponseEntity<String> responseEntity = null; responseEntity =
	 * authService.veryFyLogin(requestValue); filterChain.doFilter(request,
	 * response); } else { if (authHeadder == null || authHeadder == "" ||
	 * !authHeadder.startsWith("Bearer ")) { authHeadderValidationFailed = true;
	 * 
	 * } if (clientId == null || clientId == "") { isclientIdValidationFailed =
	 * true;
	 * 
	 * }
	 * 
	 * } } catch (Exception e) {
	 * 
	 * 
	 * 
	 * response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage()); }
	 * 
	 * if (isclientIdValidationFailed) {
	 * 
	 * response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
	 * "Client Id is Invalid Or  Empty");
	 * 
	 * } else if (authHeadderValidationFailed) {
	 * response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
	 * "Authorization is Invalid Or  Empty"); } filterChain.doFilter(request,
	 * response);
	 * 
	 * }
	 */
}
