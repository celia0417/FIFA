<%@ page import="beans.Player"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BrowseOnePlayer"%>
<% ArrayList<Player> list = (ArrayList<Player>)(request.getAttribute("list")); %>
<%@page import="Database.DB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="beans.UserBean"%>  

<html>
<head>

<style type="text/css">
td {
	width: 60px;
}
</style>

<script type="text/javascript">
	function show() {
		var value = document.myform.comment.value;
if(value!=null){
	alert("your comment has been submitted!" + value);
}else{
	alert("your comment cannot be null!");
	}	
	}
</script>
</head>

<body>
	<div id="main">
		<form name="form2" action="ServletViewPlayer" method="post">
			<table border="1" align="center" style="border-collapse: collapse;">
				<tr align="center">
				<tr>
					<td>Player Name</td>
					<td><%=list.get(0).getPname() %></td>
				</tr>
				<tr>
					<td>Player Image</td>
					<td><img
						src="http://cache.images.globalsportsmedia.com/soccer/players/150x150/21414.png"></td>
				</tr>
				<tr>
					<td>Team Name</td>
					<td><%=list.get(0).getTeam() %></td>
				</tr>
				<tr>
					<td>Goal Scored</td>
					<td><%=list.get(0).getGoalscored() %></td>
				</tr>
				<tr>
					<td>Rating</td>
					<td><%=list.get(0).getRate() %></td>
				</tr>
				<tr>
					<td>Birthday</td>
					<td><%=list.get(0).getDob() %></td>
				</tr>
				<tr>
					<td>Height</td>
					<td><%=list.get(0).getHeight() %></td>
				</tr>
				<tr>
					<td>Position</td>
					<td><%=list.get(0).getCategory() %></td>
				</tr>
				<tr>
					<td>Club</td>
					<td><%=list.get(0).getClubname()%></td>
				</tr>
				<tr>
					<td>Club Location</td>
					<td><%=list.get(0).getClubLocation() %></td>
				</tr>
				<%for(int i = 0 ; i<list.size();i++) {
                Player player = list.get(i);%>
				<tr align="center">
					<td>Comments</td>
					<td><%=player.getComment() %></td>
				</tr>
				<% 
            }
            %>

				<form action="" method="post" name="myform">
					Comment this player:<input type="text" name="comment"> 
					<input type="submit" value="submit" onclick="show()">
				</form>

			<%
				UserBean user=new UserBean();
				int pid=list.get(0).getPid();

				String str=request.getParameter("comment"); 
			    DB db=new DB();  
				ResultSet rs=null; 
				if(str!=null){
			    String sql="Insert into comments values(pid,'"+str+"',60001,10021)";   
			    db.doInsert(sql);
			    //db.close();
			    out.print(str);
			    
				}
			%>
				</tr>
				<div>
					<input type="submit" action="ServletPlayerReturn" value="Back" />
				</div>
			</table>
		</form>
	</div>
</body>
</html>