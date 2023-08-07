package com.technojade.allybot.enpoint;

import com.technojade.allybot.enpoint.response.AllyBotResponseDto;
import com.technojade.allybot.enpoint.response.ServiceStatus;
import com.technojade.allybot.entity.Employee;
import com.technojade.allybot.entity.OtpEntity;
import com.technojade.allybot.entity.User;
import com.technojade.allybot.jwt.JWTUserDetailsService;
import com.technojade.allybot.jwt.JwtRequest;
import com.technojade.allybot.jwt.JwtResponse;
import com.technojade.allybot.jwt.JwtTokenUtil;
import com.technojade.allybot.service.EmployeeService;
import com.technojade.allybot.service.OtpService;
import com.technojade.allybot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JWTUserDetailsService userDetailsService;

	@Autowired
	private OtpService otpService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployeeService empService;

	@PostMapping("/token")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		AllyBotResponseDto<JwtResponse> jwtRes = new AllyBotResponseDto<>();

		if (authenticationRequest.getOtp() != null) {

			OtpEntity validate = otpService.validate(authenticationRequest.getOtp());

			if (validate == null) {
				AllyBotResponseDto<User> otpRes = new AllyBotResponseDto<>();
				otpRes.setData(null);
				otpRes.setServiceStatus(ServiceStatus.SUCCESS);
				otpRes.setMsg("OTP is invalid");
				otpRes.setTraceId(Long.MAX_VALUE);
				otpRes.setTimestamp(Timestamp.from(Instant.now()));
				return ResponseEntity.status(HttpStatus.OK).body(otpRes);
			}
			User user = userService.loginByMobileNumber(validate.getMobileNumber());
			authenticate(user.getEmailId(), user.getPassword());
			final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmailId());
			final String token = jwtTokenUtil.generateToken(userDetails);
					
			jwtRes.setData(new JwtResponse(token));
			jwtRes.setServiceStatus(ServiceStatus.SUCCESS);
			jwtRes.setTimestamp(new Timestamp(System.currentTimeMillis()));
			jwtRes.setTraceId(Long.MAX_VALUE);
			
			return ResponseEntity.ok(jwtRes);
		}

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		jwtRes.setData(new JwtResponse(token));
		jwtRes.setServiceStatus(ServiceStatus.SUCCESS);
		jwtRes.setTimestamp(new Timestamp(System.currentTimeMillis()));
		jwtRes.setTraceId(Long.MAX_VALUE);
		
		Employee byEmailId = empService.findByEmailId(authenticationRequest.getUsername());
		byEmailId.setIsLoggedIn(1);
		
		empService.saveEmployee(byEmailId);
		
		return ResponseEntity.ok(jwtRes);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}