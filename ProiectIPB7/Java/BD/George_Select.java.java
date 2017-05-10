/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiect;

import java.sql.*;

/**
 *
 * @author George
 */
public class Test {
    
    
    
    
    public static void selectDetaliiLicenta() throws Exception{
        
        String qry;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "licente", "ADMIN");
        
        Statement st= connection.createStatement();
        
        qry="select * from detalii_licente";
        boolean flag=st.execute(qry);
        int i=1;
         if (flag==true){
               ResultSet rs=st.getResultSet();
                while(rs.next()){  
                   int results;
                        
                        System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
                        System.out.println(rs.getString(3));
                        System.out.println(rs.getInt(4));
                        System.out.println(rs.getInt(5));
                        System.out.println(rs.getInt(6));
                        System.out.println(rs.getInt(7));
                        System.out.println(rs.getInt(8));
                        System.out.println(rs.getInt(9));
                        System.out.println(rs.getInt(10));
                        System.out.println(rs.getInt(11));
                        System.out.println(rs.getInt(12));
                        System.out.println(rs.getFloat(13));
                        System.out.println(rs.getFloat(14));
                        System.out.println(rs.getFloat(15));
                        System.out.println(rs.getDate(16));
                        System.out.println(rs.getString(17)+"\n");
			}
		
                rs.close();
            }
            connection.close();
            st.close();
            
        
        
        
    }
        public static void selectIntervalEvaluare() throws Exception{
        
        String qry;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "licente", "ADMIN");
        
        Statement st= connection.createStatement();
        
        qry="select * from interval_evaluare";
        boolean flag=st.execute(qry);
        int i=1;
         if (flag==true){
               ResultSet rs=st.getResultSet();
                while(rs.next()){  
                   int results;
                        
                        System.out.println(rs.getInt(1));
			System.out.println(rs.getInt(2));
                        System.out.println(rs.getInt(3));
                        System.out.println(rs.getDate(4));
                        System.out.println(rs.getDate(5)+"\n");
			}
		
                rs.close();
            }
            connection.close();
            st.close();
                    
    }
    
        
    public static void selectSesiune() throws Exception{
        
        String qry;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "licente", "ADMIN");
        
        Statement st= connection.createStatement();
        
        qry="select * from sesiuni";
        boolean flag=st.execute(qry);
        int i=1;
         if (flag==true){
               ResultSet rs=st.getResultSet();
                while(rs.next()){  
                   int results;
                        
                        System.out.println(rs.getInt(1));
                        System.out.println(rs.getDate(2));
                        System.out.println(rs.getDate(3)+"\n");
			}
                rs.close();
            }
            connection.close();
            st.close();
                    
    }
}
