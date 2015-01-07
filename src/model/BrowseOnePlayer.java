package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.DB;
import beans.Player;
import beans.Players;

public class BrowseOnePlayer {
	
	public ArrayList<Player> selectOnePlayerList(int PlayerId) {
		
		ArrayList<Player> list = new ArrayList<Player>();
		try{
			
		int pid = PlayerId;	
		
		ResultSet rs=null;
		
        DB db=new DB();  
        String sql="SELECT * FROM player,Team, PlaysFor P, comments, rate, PlayerPic, position, playsat, Club, belongsto where p.TeamID=Team.TeamID and p.PlayerID=Player.PlayerID and playerpic.playerid=Player.PlayerID and comments.playerid = Player.PlayerID and rate.playerid=Player.PlayerID and playsat.playerid=Player.PlayerID and playsat.positionid=position.positionid and belongsto.playerid=Player.PlayerID and belongsto.clubid=club.clubid and player.playerid=" + pid;
        rs = db.doSelect(sql);
    	Player player = new Player();
        
        while (rs.next()) {

        
        	player.setComment(rs.getString("Comments"));
            player.setRate(rs.getDouble("ratings"));
            player.setPname(rs.getString("playername"));
            player.setDob(rs.getDate("dob"));
            player.setHeight(rs.getInt("height"));
            player.setGoalscored(rs.getInt("goalscored"));
            player.setTeam(rs.getString("Teamname"));
            player.setCategory(rs.getString("category"));
            player.setUrl(rs.getString("PICURL"));
//            player.setGameName(rs.getString("GameName"));
//            player.setGameResult(rs.getString("GameResult"));
//            player.setGameDate(rs.getDate("GameDate"));
            player.setClubname(rs.getString("ClubName"));
            player.setClubLocation(rs.getString("Location"));
            list.add(player);
            System.out.println(list.size());
            
        }
        
        db.close();
		}
		 catch (Exception e) {  
             e.printStackTrace();  
         }  

		
		return list;
		
	}

}
