<%@ page language="java" contentType="text/html; charset=GB18030"  
    pageEncoding="GB18030"%>  
 
<jsp:useBean id="user" class="beans.UserBean" scope="request"/>  
<jsp:setProperty name="user" property="*"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">  
<title>Welcome Page</title>  
</head>  
<body>  
<%   
    session.setAttribute("user",user);  
    String username=user.getUsername();  
 %>  
   
 <%=username %>,��ӭ������FUCK��!<br>  
 ����IP��:<%=request.getRemoteAddr() %><br>  
���������:<%=request.getRemoteHost() %><br>  
��ʹ�õ�Э����:<%=request.getProtocol() %><br>  
��Ŀǰ�ĵ�ַ��:<%=request.getRealPath("/") %>  
��������˿���:<%=request.getRemotePort() %>  
</body>  
</html>  