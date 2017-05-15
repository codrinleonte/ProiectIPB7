package bd;
import java.sql.Connection;

public class AccessSecretarBD extends AccessBD{

	AccessSecretarBD( Connection conexiune, UserBD user )
	{
		this.conexiune = conexiune;
		this.tip = "Access_Secretary";
		this.user = user;
	}
	
}
