package model;

import java.sql.ResultSet;
import java.util.ArrayList;

import Database.DB;
import beans.Players;

public class BrowsePlayer {
	
	public ArrayList<Players> selectPlayerList() {
		
		ArrayList<Players> list = new ArrayList<Players>();
		try{
			
		ResultSet rs=null;  
        DB db=new DB();  
        String sql="SELECT * FROM player,Team, PlaysFor P where p.TeamID=Team.TeamID and p.PlayerID=Player.PlayerID";
        rs = db.doSelect(sql);
        
        while (rs.next()) {

        	Players player = new Players();

            player.setPid(rs.getInt("playerid"));
            player.setPname(rs.getString("playername"));
            player.setDob(rs.getDate("dob"));
            player.setHeight(rs.getInt("height"));
            player.setGoalscored(rs.getInt("goalscored"));
            player.setTeam(rs.getString("Teamname"));
            
            list.add(player);
            
        }
		}
		 catch (Exception e) {  
             e.printStackTrace();  
         }  
     
	
		
		return list;
		
	}

}
