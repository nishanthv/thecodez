<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Codez add Artifact</title>
<script>
function validateForm()
{
    if(document.frm.groupId.value=="")
    {
      alert("GroupId should not be left blank");
      document.frm.groupId.focus();
      return false;
    }
    else if(document.frm.artifactId.value=="")
    {
      alert("ArtifactId should not be left blank");
      document.frm.artifactId.focus();
      return false;
    }
    else if(document.frm.version.value=="")
    {
      alert("Version should not be left blank");
      document.frm.version.focus();
      return false;
    }
}
</script>

</head>
<body>
    <b><font size="20" color="#333399"></font></b>
    <%=request.getAttribute("message")%>	
</body>

<body>
<form name="frm" method="post" action="artifactAdded.html" onSubmit="return validateForm()">
<table width="100%" height="47" bordercolor="#000080" bgcolor="#E0EDFD" cellspacing="3" cellpadding="1">
  <tr>
    <td><b><font size="5" color="#333399"></font></b></td>
    <td width="22%">&nbsp;</td>
    <td width="78%">&nbsp;</td>
    </tr>
  <tr>
    <td>GroupId</td>
    <td><input type="text" name="groupId" ></td>
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