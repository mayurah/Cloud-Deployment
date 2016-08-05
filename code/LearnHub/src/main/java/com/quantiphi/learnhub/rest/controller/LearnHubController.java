package com.quantiphi.learnhub.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quantiphi.learnhub.model.Course;
import com.quantiphi.learnhub.service.LearnHubService;


@Controller
@RequestMapping("api/course")
public class LearnHubController {

	@Autowired
	LearnHubService learnHubService;
	
	/**
	 * @return ResponseEntity<List<Course>>
	 */
	@ResponseBody
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> getAllCourses(@RequestParam(required = false) String page,
			@RequestParam(required = false) String sort, @RequestParam(required = false) String by) {
		
		List<Course> courseList = learnHubService.findAllCourse(page, sort,by);

		if (courseList.isEmpty()) {
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}
	
	
	/**
	 * @param title
	 * @return ResponseEntity<List<Course>>
	 */
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Course>> findCourseByTitle(@RequestParam(required = false) String title,
			@RequestParam(required = false) String page, @RequestParam(required = false) String sort,
			@RequestParam(required = false) String by) {
		
		List<Course> courseList = learnHubService.findCourseByTitle(title, page, sort, by);

		if (courseList.isEmpty()) {
			return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<Integer>
	 */
	@ResponseBody 
	@RequestMapping(value = "/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> getTotalPlacesCount() {

		Integer courseCount = learnHubService.totalCourseCount();

		if(courseCount == 0 ){
			return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(courseCount, HttpStatus.OK);
	}

	/**
	 * @param cacheType
	 * @return ResponseEntity<String>
	 */
	@ResponseBody
	@RequestMapping(value = "/clearcache", method = RequestMethod.GET)
	public ResponseEntity<String> clearCache() {
		learnHubService.clearCache();
		String msg = "Cached Cleared !";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	/**
	 * @param e
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorHandler(Exception e) {
		System.out.println("In exception handler..");
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
