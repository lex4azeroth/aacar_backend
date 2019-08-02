package com.aawashcar.opsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.opsservice.entities.MiniAuthEntity;
import com.aawashcar.opsservice.service.MiniProgramAuthService;

@RequestMapping("miniauth/")
@ResponseBody
@Controller
public class MiniProgAuthController {

	@Autowired
	private MiniProgramAuthService service;

	@RequestMapping(value = "authpair/{name}", method = RequestMethod.GET)
	public MiniAuthEntity authpair(@PathVariable("name") String name) {
		return service.findMiniAuthByName(name);
	}
	
	@RequestMapping(value = "disable/{id}", method = RequestMethod.PUT)
	public void disableMiniProgram(@PathVariable("id") int id) {
		service.disableMiniAuthById(id);
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int newAuth (@RequestBody MiniAuthEntity miniAuth) {
		return service.addMiniProgramAuth(miniAuth);
	}

}
