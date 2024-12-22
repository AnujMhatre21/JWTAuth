package com.learn.JWTAuth.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.JWTAuth.Entity.UserInfo;
import com.learn.JWTAuth.Service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

//	@Autowired
//	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@GetMapping("/welcome")
	public String welcome() {
		return "This endpoint is not secure";
	}

	@PostMapping("/signup")
	public void signup(@RequestBody UserInfo user) {
		
		userService.addNewUser(user);
		System.out.println("This is sign up page" + user);
	}

	@PostMapping("/login")
	public void login(@RequestBody UserInfo info) {

		try {
			System.out.println("This is the login page" + info);
//			authenticationManager
//					.authenticate(new UsernamePasswordAuthenticationToken(info.getUserName(), info.getPassword()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/all")
	public List<UserInfo> getAlluser(){
		return userService.getAllUsers();
	}

//	@GetMapping("/{id}")
//	public Product getProductById(@PathVariable int id) {
//		return service.getProduct(id);
//	}

}
