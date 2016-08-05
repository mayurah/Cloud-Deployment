# RESTFul Java Webapp -  Cloud Deployment 🔮
**************************************************************

**Note:** Application is tested and can be deployed on Amazon EC2 Cloud server or any other listed platforms.


### Deliverables
* Deployment Instructions (how you carried out deployment on cloud platform)
* Live Demo URL
* Findings / Insights on technologies used.

### Technology Used
* Spring v3.2.4
* Hibrenet v4.1.4
* Deploy in Java web server (Tested on Apache Tomcat/7.0.65).
* Database: MySQL
  - DB Name : quantiphi_db
  - Username:	root
  - password:	admin

### RESTFul endpoints:

```
	- 	/learnhub/api/course
	
		params : 
		Result :  return all courses data

	
	/learnhub/api/course?page=2&sort=rating&by=desc
	result : return data

	
	- /learnhub/api/course/count
		return total number of count.
	
	
	/learnhub/api/course/search?title=web
	
	param : title
	result : return course data which match with title
	
	
	/learnhub/api/course/search?title=front&page=1&sort=rating&by=asc
	param : title,page,sort,by
	result: return course data with search by title, pagination, sort by column with asc order
```
	
Note : all the parameter combination can be used such as (page, sort and by ) with course in request url.
	
	

### Supported Cloud Platforms
- [Digital Ocean](https://m.do.co/c/cb7469160ee8) (PromoCode: DO10)
- [AWS](https://aws.amazon.com/free/)
- [Google Cloud](https://cloud.google.com/free-trial/)
- SAP [HAPA Cloud](https://hcp.sap.com/try.html)
- [Pivotal](https://run.pivotal.io/pricing/) — cloud foundry   [$87 of free trial credit.]
- [OpenShift](https://www.openshift.com/pricing/)
- [Heroku](https://www.heroku.com/pricing)

> For appearance, cloud server application [demo](http://cloud-deploy.0x10.info/learnhub/), your task is to understand the given java application and deploy it.


Keep shipping!

— Team HackerEarth
