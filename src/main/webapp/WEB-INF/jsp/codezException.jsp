<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Codez exception</title>
</head>
<body>
	<%
		Exception e = (Exception) request.getAttribute("exception");
	%>
	<%=e.getMessage()%>
</body>
<br></br>
<body>
	<a>To Add more Artifacts </a>
	<a href="addArtifact.html"> Click Here</a>
</body>
</html>