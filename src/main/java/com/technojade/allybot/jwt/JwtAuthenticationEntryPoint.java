package com.technojade.allybot.jwt;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		ResponseBody responseBody = new ResponseBody();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime currentLocalDateTime = LocalDateTime.now();
		String currentDateTimeStr = formatter.format(currentLocalDateTime);
		responseBody.setTimestamp(currentDateTimeStr);

		String key = response.getHeader("key") != null ? response.getHeader("key") : "";
		boolean isError = false;
		if (key != "") {
			responseBody.setMessage(key);
			isError = true;
		}
		if (isError) {
			responseBody.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		} else {
			responseBody.setStatus(HttpServletResponse.SC_OK);
			response.setStatus(HttpServletResponse.SC_OK);
		}
		ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
		response.getWriter().println(mapper.writeValueAsString(responseBody));
	}
}