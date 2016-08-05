package com.quantiphi.learnhub.service;

import java.util.List;

import com.quantiphi.learnhub.model.Course;

public interface LearnHubService {
	
	/**
	 * @return List<Course>
	 */
	public List<Course> findAllCourse(String page, String sort, String by);
	
	/**
	 * @param title
	 * @return List<Course>
	 */
	public List<Course> findCourseByTitle(String title,String page, String sort, String by);

	/**
	 * @return Integer
	 */
	public Integer totalCourseCount();
	
	/**
	 * 
	 */
	public void clearCache();
	
}
