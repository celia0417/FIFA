<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Database.DB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="beans.Players"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String str = request.getParameter("search");
	out.println(str);

		DB db = new DB();
		ResultSet rs = null;
		/*   String sql="select * from player p, team t, playsfor pl where pl.teamid=t.teamid and pl.playerid=p.playerid and playername like '%"+str+"%'";*/ 
		String sql = "select distinct playerid, playername from player, team where playername like '"+ str +"%' or teamname like '"+ str +"%'";
 
		rs = db.doSelect(sql);
		out.println(rs);
 		//db.close();
		ArrayList<Players> list = new ArrayList<Players>();
		
		
		while (rs.next()) {

			Players player = new Players();

			player.setPid(rs.getInt("playerid"));
			player.setPname(rs.getString("playername"));

			list.add(player);

		}
		for (int i = 0; i < list.size(); i++) {

			Players player = list.get(i);
	%>

	<div id="result"><a href="Servlet/ServletViewPlayer?PlayerId=<%=player.getPid()%>"><%=player.getPname()%></a>
	<br></div>

	<%
		}
	%>
  <form action="playerlist.jsp" method="post" name="form2">
  <input type="submit" value="return">
</form>
</body>
</html>