package com.aawashcar.promservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.promservice.entities.Points;
import com.aawashcar.promservice.service.PointsService;

@RequestMapping("points/")
@Controller
@ResponseBody
public class PointsController {
	
	@Autowired
	private PointsService pointsService;
	
	@RequestMapping(value="new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int findPointIdByUserId(@RequestBody Points points) {
		return pointsService.addUserPoints(points);
	}
	
	@RequestMapping(value="pointid/{userid}", method = RequestMethod.GET)
	public int findPointIdByUserId(@PathVariable("userid") int userId) {
		return pointsService.findPointIdByUserId(userId);
	}
	
	@RequestMapping(value="pluspoints/{userid}/{points}", method = RequestMethod.PUT)
	public int disableUserPoints(@PathVariable("userid") int userId, @PathVariable("points") double points) {
		return pointsService.plusPoints(userId, points);
	}
	
	@RequestMapping(value="disableuserpoints/{userid}", method = RequestMethod.PUT)
	public int disableUserPoints(@PathVariable("userid") int userId) {
		return pointsService.disableUserPoints(userId);
	}

}
