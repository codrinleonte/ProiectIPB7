package bd;

import java.sql.Connection;

public class AccessStudentBD extends  AccessBD{
	
	AccessStudentBD( Connection conexiune, UserBD user )
	{
		this.conexiune = conexiune;
		this.tip  = "Access_Student";
		this.user = user;
	}
	
	

}
