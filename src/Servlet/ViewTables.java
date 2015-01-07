package Servlet;
import java.io.*;

import javax.servlet.http.*;
import javax.servlet.*;

import Database.DB;

import java.sql.*;

import oracle.jdbc.*;
import oracle.jdbc.pool.*;

public class ViewTables extends HttpServlet {

        public void doGet (HttpServletRequest request,
                        HttpServletResponse response)
        throws ServletException, IOException {

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();


                try {	DB db=new DB();
                		Connection conn = db.getConnection();
                        String query = new String();
                        Statement s = conn.createStatement();

                        query = "select * from player";

                        ResultSet r = s.executeQuery(query);
                         while(r.next()){
                           out.println("Playername: "+r.getString("playerid")+" ");
                         }
                        r.close();
                        s.close();
                        conn.close();

                }
                catch (Exception e) {
                        out.println("The database could not be accessed.<br>");
                        out.println("More information is available as follows:<br>");
                        e.printStackTrace(out);
                }

        }  // end doGet method

}  // end DatabaseServlet class

