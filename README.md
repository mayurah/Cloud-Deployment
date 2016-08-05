# RESTFul Java Webapp -  Cloud Deployment 🔮
**************************************************************

**Note:** Application is tested and can be deployed on Amazon EC2 Cloud server or any other listed platforms.

[![java build](https://img.shields.io/badge/build-Java-blue.svg?style=plastic)](#)  [![download repo](https://img.shields.io/badge/download-repo-green.svg?style=plastic)](https://github.com/mayurah/Cloud-Deployment/archive/master.zip)     [![demo-url](https://img.shields.io/badge/Demo_URL-AWS-brightgreen.svg?style=plastic)](http://cloud-deploy.0x10.info/learnhub/)


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

> To have a look at sample deployment, here's the [demo](http://cloud-deploy.0x10.info/learnhub/) link; your task is to download this repository, understand the given java application and deploy it on your choice of cloud provider.


Keep shipping!

— Team HackerEarth

[![MIT License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat-square)](https://github.com/mayurah/Cloud-Deployment/blob/master/LICENSE)
