<%@ page import ="beans.Players" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.BrowsePlayer" %>

<% /* ArrayList<Players> list = (ArrayList<Players>)(request.getAttribute("list")); */
BrowsePlayer bt=new BrowsePlayer();
ArrayList<Players> list = bt.selectPlayerList();  %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>FIFA Favoriate Player</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-titillium-250.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>

</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="index.html"><span>Home Page</span></a></li>
          <li><a href="support.html"><span>Support</span></a></li>
          <li><a href="about.html"><span>About Us</span></a></li>
          <li><a href="blog.html"><span>Blog</span></a></li>
          <li><a href="contact.html"><span>Contact Us</span></a></li>
        </ul>
      </div>
      <div class="logo">
        <h1><a href="index.html">Sky<span>Dream</span> <small>Company Slogan Here</small></a></h1>
      </div>
   
      <div class="slider">

     
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">

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
                <td>Rating</td>
            </tr>
            
            <%for(int i = 0 ; i<list.size();i++) {
            
                Players player = list.get(i);%>
                <tr align="center" >
                <td><img src="http://cache.images.globalsportsmedia.com/soccer/players/150x150/21414.png"></td> 
                <td><a href="Servlet/ServletViewPlayer?PlayerId=<%=player.getPid() %>"><%=player.getPname()%></a></td>
                <td><%=player.getTeam() %></td>
                <td><%=player.getGoalscored() %></td>
                <td><%=player.getRate() %></td>
            </tr>
            <% 
            }
            %>
           
  
        </table>
    </form>
    </div> 

  </div>
  <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2><span>Image</span> Gallery</h2>
        <a href="#"><img src="images/gal1.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal2.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal3.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal4.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal5.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal6.jpg" width="75" height="75" alt="" class="gal" /></a> </div>
      <div class="col c2">
        <h2><span>Services</span> Overview</h2>
        <p>Curabitur sed urna id nunc pulvinar semper. Nunc sit amet tortor sit amet lacus sagittis posuere cursus vitae nunc.Etiam venenatis, turpis at eleifend porta, nisl nulla bibendum justo.</p>
        <ul class="fbg_ul">
          <li><a href="#">Lorem ipsum dolor labore et dolore.</a></li>
          <li><a href="#">Excepteur officia deserunt.</a></li>
          <li><a href="#">Integer tellus ipsum tempor sed.</a></li>
        </ul>
      </div>
      <div class="col c3">
        <h2><span>Contact</span> Us</h2>
        <p>Nullam quam lorem, tristique non vestibulum nec, consectetur in risus. Aliquam a quam vel leo gravida gravida eu porttitor dui.</p>
        <p class="contact_info"> <span>Address:</span> 1458 TemplateAccess, USA<br />
          <span>Telephone:</span> +123-1234-5678<br />
          <span>FAX:</span> +458-4578<br />
          <span>Others:</span> +301 - 0125 - 01258<br />
          <span>E-mail:</span> <a href="#">mail@yoursitename.com</a> </p>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">Copyright &copy; <a href="#">Domain Name</a>. All Rights Reserved</p>
      <p class="rf">Design by <a target="_blank" href="http://www.dreamtemplate.com/">DreamTemplate</a></p>
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
</body>
</html>
