package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.dto.LoginDTO;
import com.service.service.LoginService;

@CrossOrigin("*")
@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO loginDTO) {
		String result = null;
		try {
			result = loginService.login(loginDTO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
