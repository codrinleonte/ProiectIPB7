package bd;
import java.sql.Connection;
import model.users.User;

public class AccessAdminBD extends AccessBD {

	AccessAdminBD( Connection conexiune , User user )
	{
		this.conexiune = conexiune;
		this.tip = "Access_Admin";
		this.user = user;
	}
}
