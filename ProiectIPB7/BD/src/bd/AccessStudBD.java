package bd;

import java.sql.Connection;
import model.users.User;

public class AccessStudBD extends  AccessBD{
	
	AccessStudBD( Connection conexiune, User user )
	{
		this.conexiune = conexiune;
		this.tip  = "Access_Student";
		this.user = user;
	}
	
	

}
