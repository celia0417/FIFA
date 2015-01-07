<%@ page import="beans.Player"%>
<%@ page import="beans.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.BrowseOnePlayer"%>
<%@ page import="beans.Player"%>
<%@ page import="Database.DB"%>
<%@ page import="java.sql.ResultSet"%>



<% ArrayList<Player> list = (ArrayList<Player>)(request.getAttribute("list")); %>
<html>
  <head>
    <style type = "text/css">
        td{
        
            width:60px;
        }
    </style>
  </head>
  
  <body>
  <div id="search">
  <form action="result.jsp" method="post" name="form1">
  search:<input type="text" name="search"> 
  <input type="submit" value="submit">
  </form>
  
  </div>
    <div id = "main">
    <form name="form1" action ="servlet/Browseplayer" method = "post">
        <table border ="1" align = "center" style="border-collapse:collapse;">
            <tr align="center">
                <td colspan="6"></td>
            </tr>
            <tr align="center">
                <td>Profile Picture</td>
                <td>Player Name</td>
                <td>Team Name</td>
                <td>Goal Scored</td>
            </tr>
            
            <%for(int i = 0 ; i<list.size();i++) {
            
                Players player = list.get(i);%>
                <tr align="center" >
                <td><img src="http://cache.images.globalsportsmedia.com/soccer/players/150x150/21414.png"></td> 
                <td><a href="Servlet/ServletViewPlayer?PlayerId=<%=player.getPid() %>"><%=player.getPname()%></a></td>
                <td><%=player.getTeam() %></td>
                <td><%=player.getGoalscored() %></td>
            </tr>
            <% 
            }
            %>
           
	
        </table>
    </form>
    </div>
  </body>
</html>