package bd;
import java.sql.Connection;

public class AccessProfesorBD extends AccessBD{
	
	AccessProfesorBD( Connection conexiune , UserBD user )
	{
		this.conexiune = conexiune;
		this.tip = "Access_Teacher";
		this.user = user;
	}

}
