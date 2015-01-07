package beans;

import java.sql.Date;


public class Teams {

		private String teamname;
		private String playername;
		private Date gamedate;
		private String gameresult;
		private String gamename;
	
		public Teams(){
			this.setTeamname(null);
			this.setPname(null);

		}
		
		public String getPname(){
			return playername;
		}
		public void setPname(String playername){
			this.playername=playername;
		}
		
		public String getTeamname(){
			return teamname;
		}
		public void setTeamname(String teamname){
			this.teamname=teamname;
		}
		
		public Date getGamedate(){
			return gamedate;
		}
		public void setGamedate(Date gamedate){
			this.gamedate=gamedate;
		}
		
		public String getGameresult(){
			return gameresult;
		}
		public void setGameresult(String gameresult){
			this.gameresult=gameresult;
		}
		
		public String getGamename(){
			return gamename;
		}
		public void setGamename(String gamename){
			this.gamename=gamename;
		}

	}
