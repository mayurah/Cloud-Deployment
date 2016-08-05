package com.quantiphi.learnhub.dao;

import java.util.List;

import com.quantiphi.learnhub.model.Course;

/**
 * @author Chandra
 *
 */
public interface LearnHubDao {

	/**
	 * @return List<Course>
	 */
	public List<Course> findAllCourse(int page, String sort, String by);
	
	/**
	 * @param title
	 * @return List<Course>
	 */
	public List<Course>  findCourseByTitle(String title, int page, String sort, String by);
	
	/**
	 * @return Integer
	 */
	public Integer totalCourseCount();

	/**
	 * 
	 */
	public void clearCacheAll();
	
}
