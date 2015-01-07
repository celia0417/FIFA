package beans;
import java.util.Date;

public class Players {

		private int playerid;
		private String playername;
		private Date dob;
		private int height;
		private int goalscored;
		private String teamname;
		private String url;
		private double ratings;
		
		
		public Players(){
			this.setPname(null);
		}
		
		public int getPid(){
			return playerid;
		}
		public void setPid(int playerid){
			this.playerid=playerid;
		}
		
		public double getRate(){
			return playerid;
		}
		public void setRate(double ratings){
			this.ratings=ratings;
		}
		
		public String getUrl(){
			return url;
		}
		public void setUrl(String url){
			this.url=url;
		}
		
		
		public String getPname(){
			return playername;
		}
		public void setPname(String playername){
			this.playername=playername;
		}
		
		public void setTeam(String tname){
			this.teamname=tname;
		}
		
		public String getTeam(){
			return teamname;
		}
		public Date getDob(){
			return dob;
		}
		public void setDob(Date dob){
			this.dob=dob;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
		
		public int getGoalscored() {
			return goalscored;
		}

		public void setGoalscored(int goalscored) {
			this.goalscored = goalscored;
		}
	}
