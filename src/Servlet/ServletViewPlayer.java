package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BrowseOnePlayer;
import model.BrowsePlayer;
import beans.Player;
import beans.Players;

/**
 * Servlet implementation class ServletViewPlayer
 */
@WebServlet("/ServletViewPlayer")
public class ServletViewPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletViewPlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//return one player's info
		
		int Pid = Integer.parseInt(request.getParameter("PlayerId"));      
        BrowseOnePlayer bop=new BrowseOnePlayer();
    	ArrayList<Player> list = bop.selectOnePlayerList(Pid);
        request.setAttribute("list", list);
        System.out.println(list.size());
        //request.getRequestDispatcher("/playerlist.jsp").forward(request,response);
        String forward = "playerinfo.jsp"; 
        RequestDispatcher rd=request.getRequestDispatcher(forward);  
        rd.forward(request,response);  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
