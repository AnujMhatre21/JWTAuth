package com.learn.JWTAuth.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.JWTAuth.Entity.JwtRequest;
import com.learn.JWTAuth.Entity.JwtResponse;
import com.learn.JWTAuth.jwt.JwtHelper;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtHelper helper;

	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		// authenticate
		this.doAuthenticate(request.getusername(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getusername());
		String token = this.helper.generateToken(userDetails);

		JwtResponse response = new JwtResponse(userDetails.getUsername(), token);

//	        JwtResponse response = JwtResponse.builder()
//	                .jwtToken(token)
//	                .username(userDetails.getUsername()).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String username, String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			manager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Credentials Invalid !!");
		}

	}
}
