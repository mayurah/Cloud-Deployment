<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>LearnHub</title>
</head>
<body>
<h1>
	Welcome to LearnHub  
</h1>

<P>1 :  <a href="/learnhub/api/course">All course</a></P>
<P>2 : <a href="/learnhub/api/course/count">Total No of course</a></P>
<form action="/learnhub/api/course/search">
	3 : Search Courses  <input type="text" placeholder=" Search by title " name="title">
</form>

</body>
</html>
