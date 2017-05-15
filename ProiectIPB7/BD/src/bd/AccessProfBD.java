package bd;
import java.sql.Connection;
import model.users.User;

public class AccessProfBD extends AccessBD{
	
	AccessProfBD( Connection conexiune , User user )
	{
		this.conexiune = conexiune;
		this.tip = "Access_Teacher";
		this.user = user;
	}

}
