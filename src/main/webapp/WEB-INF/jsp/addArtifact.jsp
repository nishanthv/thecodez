<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring mvc Hello World example</title>
</head>
<body>
	<%=request.getAttribute("message")%>	
</body>

<body>
<form name="frm" method="post" action="addArtifact.html">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="22%">&nbsp;</td>
    <td width="78%">&nbsp;</td>
    </tr>
  <tr>
    <td>GroupId </td>
    <td><input type="text" name="groupId"></td>
  </tr>  
  <tr>
    <td>ArtifactId </td>
    <td><input type="text" name="artifactId"></td>
  </tr>
  <tr>
    <td>Version </td>
    <td><input type="text" name="version"></td>
  </tr>
  <tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="submit" value="Submit"></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    </tr>
</table>
</form>
</body>
</html>