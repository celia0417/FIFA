package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import Database.DB;
import beans.Teams;

public class BrowseTeam {
	
	public ArrayList<Teams> selectTeamList() {
		
		ArrayList<Teams> teamlist = new ArrayList<Teams>();
		
		try{
			
		ResultSet rs=null;  
        DB db=new DB();  
        String sql="SELECT * FROM player,team, PlaysFor P where p.TeamID=Team.TeamID and p.PlayerID=Player.PlayerID";
        rs = db.doSelect(sql);
        System.out.println(rs);
        while (rs.next()) {

        	Teams team = new Teams();

            team.setTeamname(rs.getString("teamname"));
            team.setPname(rs.getString("playername"));
            
//             team.setGamedate(rs.getDate("gamedate"));
//            team.setGameresult(rs.getString("gameresult"));
//             team.setGamename(rs.getString("gamename"));
            
            teamlist.add(team);
            
        }
		}
		 catch (Exception e) {  
             e.printStackTrace();  
         }  
     
	
		
		return teamlist;
		
	}

}
