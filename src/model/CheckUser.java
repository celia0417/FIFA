package model;  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
import Database.DB;
import beans.UserBean;  
  
public class CheckUser {  
      
    public boolean checkUsre(UserBean user){  
        if(user.username.equals("")||user.username!=null){  
            ResultSet rs=null;  
            DB db=new DB();  
            rs=db.doSelect("select * from users where account='"+user.getUsername()+"'");  
            try {  
                if(rs.next()){  
                    if(user.password.equals("")||user.password!=null){  
                        rs=db.doSelect("select * from users where password="+user.password);  
                        return true;  
                    }  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
          
        return false;  
          
    }  
  
}  