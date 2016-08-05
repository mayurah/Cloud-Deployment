package com.quantiphi.learnhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.quantiphi.learnhub.dao.LearnHubDao;
import com.quantiphi.learnhub.model.Course;

@Service
@Transactional
public class LearnHubServiceImpl implements LearnHubService{

	@Autowired
	LearnHubDao learnHubDao;

	@Override
	@Transactional(readOnly=true)
	public List<Course> findAllCourse(String StrPage, String sortColumn, String sortBy){
		int page = 0;
		if(! StringUtils.isEmpty(StrPage)){
			page= Integer.parseInt(StrPage);
		}
		return learnHubDao.findAllCourse(page, sortColumn, sortBy);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Course> findCourseByTitle(String title, String StrPage, String sortColumn,String sortBy){
		int page = 0;
		if(! StringUtils.isEmpty(StrPage)){
			page= Integer.parseInt(StrPage);
		}
		if(StringUtils.isEmpty(title)){
			return learnHubDao.findAllCourse(page, null, null);
		}else{
			title = title.trim();
		}
		return learnHubDao.findCourseByTitle(title, page, sortColumn, sortBy);
	}

	@Transactional(readOnly=true)
	public Integer totalCourseCount(){
		return  learnHubDao.totalCourseCount();
	}

	@Override
	public void clearCache() {
		learnHubDao.clearCacheAll();
	}

}
