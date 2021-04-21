package com.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.service.dto.LoginDTO;
import com.service.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public String login(LoginDTO loginDTO) {
		if(loginDTO.getUserId().equalsIgnoreCase("123") && loginDTO.getPassword().equalsIgnoreCase("123")) {
			return "Valid User";
		}
		return "Invalid User";
	}

}
