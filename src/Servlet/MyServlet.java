package Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.services.simpledb.model.Item;

import twitter.UserApplication;
import Database.DB;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DB database=new DB();
       ArrayList<String> filterList;
       String currentKey;
       List<Item> wholeList=null;
       public static UserApplication ua;
       DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date(); 
       String timeline=dateFormat.format(date);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        try {
        	database.connect();
        	ua = new UserApplication(database);
        } catch( Exception e){
        	e.printStackTrace();
        }
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.service(request, response);
			processRequest(request,response);
			/*System.out.println(request.getParameter("sub"));*/
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String requestName;
		String keys = request.getParameter("keys");
		filterList = new ArrayList<String>();
		filterList.add("Columbia");
		filterList.add("University");
		filterList.add("Snow");
		filterList.add("Baseball");
		filterList.add("Computer");
	//	filterList = database.filterList(numberInFilterList, ua.getStream());
		String filter = request.getParameter("filter");
		//String startStream = request.getParameter("inputKey");
	//	String limit = request.getParameter("limit");
	//	String act = request.getParameter("act");
//		if(act!=null&&act.equals("delete")&&filter!=null){
//			currentKey=null;
//			database.delete(filter);
//		}
//		if(limit!=null){
//			database.setLimit(Integer.parseInt(limit));
//			currentLimit=Integer.parseInt(limit);
//		}
//		if(keys!=null){
//			ua.endStream(keys);
//		}
//		/*if(startStream!=null){
//			ua.startStream(startStream);
//		}*/
		if(filter!=null){
			currentKey = filter;
		}
//		wholeList.clear();
		wholeList = database.read(currentKey,timeline);
		request.setAttribute("wholeList",wholeList);
		request.setAttribute("filterKey",currentKey);
		request.setAttribute("filterList",filterList);
		request.setAttribute("keys",ua.getStream());
		request.setAttribute("filtertime",timeline);
	
		try {
			request.getRequestDispatcher("realtime.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
