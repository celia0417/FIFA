<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Database.DB"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function show() {
		var value = document.myform.comment.value;
<%String str = request.getParameter("comment"); 

			out.print(str);
			if (str != null) {
				DB db = new DB();
				ResultSet rs = null;
				String sql = "Insert into comments values(200009,'" + str
						+ "',60001,10021)";

				db.doInsert(sql);%>
	alert("your comment has been submitted!" + value);
<%} else {%>
	alert("your comment cannot be null!");
<%}%>
	}
</script>

</head>
<body>
	<form action="" method="post" name="myform">
		Comment this player:<input type="text" name="comment"> 
		<input type="submit" value="submit" onclick="show()">


	</form>
	


</body>
</html>