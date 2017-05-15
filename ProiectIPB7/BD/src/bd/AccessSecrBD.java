package bd;
import java.sql.Connection;
import model.users.User;

public class AccessSecrBD extends AccessBD{

	AccessSecrBD( Connection conexiune, User user )
	{
		this.conexiune = conexiune;
		this.tip = "Access_Secretary";
		this.user = user;
	}
	
}
