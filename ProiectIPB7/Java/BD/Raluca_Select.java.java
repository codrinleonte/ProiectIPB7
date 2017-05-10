package functii_ip;
import java.sql.*;

public class Functii {

    public static void selectStudenti() throws Exception{
        
        String query;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "conct", "STUDENT");
        
        Statement st= connection.createStatement();
        
        query="select * from studenti";
        boolean flag=st.execute(query);
        int i=1;
         if (flag==true){
               ResultSet rs=st.getResultSet();
                while(rs.next()){  
                   int results;
                        
                        System.out.println(rs.getInt(1));
			        System.out.println(rs.getInt(2));
                        System.out.println(rs.getInt(3));
                        System.out.println(rs.getString(4));
                        System.out.println(rs.getString(5));
                        System.out.println(rs.getString(6)+"\n");                        
			}
		
                rs.close();
            }
            connection.close();
            st.close();
            
        
        
        
    }
        public static void selectComisii() throws Exception{
        
        String query;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "conct", "STUDENT");
        
        Statement st= connection.createStatement();
        
        query="select * from Comisii";
        boolean flag=st.execute(query);
        int i=1;
         if (flag==true){
               ResultSet rs=st.getResultSet();
                while(rs.next()){  
                   int results;
                        
                        System.out.println(rs.getInt(1));
			        System.out.println(rs.getInt(2));
                        System.out.println(rs.getInt(3));
                        System.out.println(rs.getInt(4));
				  System.out.println(rs.getInt(5));
				  System.out.println(rs.getInt(6));
				  System.out.println(rs.getString(7));
				  System.out.println(rs.getInt(8)+"\n");

			}
		
                rs.close();
            }
            connection.close();
            st.close();
                    
    }
    
        
    public static void selectListaLicente() throws Exception{
        
        String query;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "conct", "STUDENT");
        
        Statement st= connection.createStatement();
        
        query="select * from lista_licente";
        boolean flag=st.execute(query);
        int i=1;
         if (flag==true){
               ResultSet rs=st.getResultSet();
                while(rs.next()){  
                   int results;
                        
                        System.out.println(rs.getInt(1));
                        System.out.println(rs.getInt(2));
				  System.out.println(rs.getInt(3));
                        System.out.println(rs.getInt(4)+"\n");
			}
		
                rs.close();
            }
            connection.close();
            st.close();
                    
    }


}
