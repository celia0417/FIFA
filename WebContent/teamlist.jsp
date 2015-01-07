<%@ page import ="beans.Teams" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.BrowseTeam" %>

<% BrowseTeam bt=new BrowseTeam();
ArrayList<Teams> list = bt.selectTeamList();  
%>
<html>
  <head>
    <style type = "text/css">
        td{
        
            width:60px;
        }
    </style>
  </head>
  
  <body>
    <div id = "main">
    <form name="form1" action ="servlet/Browseplayer" method = "post">
        <table border ="1" align = "center" style="border-collapse:collapse;">
            <tr align="center">
                <td colspan="6"></td>
            </tr>
            <tr align="center">
              	<td>Team Name</td>
                <td>Player Name</td>
         
            </tr>
            
            <%for(int i = 0 ; i<list.size();i++) {
            
                Teams team = list.get(i);%>
                <tr align="center" >
                <td><%=team.getTeamname() %></td>
                <td><%=team.getPname() %></td>
            </tr>
            <% 
            }
            %>
        </table>
    </form>
    </div>
  </body>
</html>