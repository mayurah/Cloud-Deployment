package com.quantiphi.learnhub.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.quantiphi.learnhub.model.Course;

/**
 * @author Chandra
 *
 */
@Repository
public class LearnHubDaoImpl extends HibernateSessionDao implements LearnHubDao {

	/* (non-Javadoc)
	 * @see com.quantiphi.learnhub.dao.LearnHubDao#findAllCourse()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findAllCourse(int page, String sortColmName, String sortby) {
		Criteria crt = getSession().createCriteria(Course.class);
		if(page > 0){
			crt.setMaxResults(5);
			crt.setFirstResult(5* (page-1));
		}
		if(! StringUtils.isEmpty(sortColmName) &&  ! StringUtils.isEmpty(sortby)){
			if("desc".equalsIgnoreCase(sortby)){
				crt.addOrder(Order.desc(sortColmName));
			}else{
				crt.addOrder(Order.asc(sortColmName));
			}
		}

		return crt.list();
	}

	/* (non-Javadoc)
	 * @see com.quantiphi.learnhub.dao.LearnHubDao#findCourseByTitle(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	//@Cacheable(value = { "course" },key="#title")
	public List<Course> findCourseByTitle(String title, int page, String sortColmName, String sortby) {
		Criteria crt = getSession().createCriteria(Course.class);
		crt.add(Restrictions.like("title",  title, MatchMode.ANYWHERE));
		if(page > 0){
			crt.setMaxResults(5);
			crt.setFirstResult(5* (page-1));
		}
		if(! StringUtils.isEmpty(sortColmName) &&  ! StringUtils.isEmpty(sortby)){
			if("desc".equalsIgnoreCase(sortby)){
				crt.addOrder(Order.desc(sortColmName));
			}else{
				crt.addOrder(Order.asc(sortColmName));
			}
		}

		List<Course> courses = crt.list();
		return courses;
	}

	/* (non-Javadoc)
	 * @see com.quantiphi.learnhub.dao.LearnHubDao#totalCourseCount()
	 */
	public Integer totalCourseCount() {
		Object countObj =  getSession().createCriteria(Course.class).setProjection(Projections.rowCount()).uniqueResult();

		if(countObj != null ){
			return	((Long)countObj).intValue();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.quantiphi.learnhub.dao.LearnHubDao#clearCacheAll()
	 */
	@Caching(evict={@CacheEvict(value="course",allEntries=true)})
	public void clearCacheAll(){
		// clear all cached data
	}

}
