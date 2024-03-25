package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.UserService;
import com.javaex.util.JwtUtil;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpServletResponse;

/*
 * @RequestMapping(value = "/test", method =
 * {RequestMethod.GET,RequestMethod.POST})
 * 
 * @Controller
 * @ResponseBody 
 * 01.vue.js기본문법 P-33
 */

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**************
	 * 로그인
	 ************/
	@PostMapping("api/users/login")
	public UserVo login(@RequestBody UserVo userVo, HttpServletResponse response) {
		System.out.println("UserController.login()");

		System.out.println(userVo);

		// no name 누구님 안녕하세요 id pw
		UserVo authUser = userService.exeLogin(userVo);
		System.out.println(authUser);
		
		if (authUser !=null) {// 로그인에 성공하면
			//토큰발급 에더에 실어 보낸다
			JwtUtil.createTokenAndSetHeader(response, ""+authUser.getNo());
		}
		


		return authUser;
	}

}
