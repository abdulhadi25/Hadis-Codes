package Assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory {
	
	private static String dbURL="jdbc:mysql://localhost/quiz";
	private static String dbUser="admin";
	private static String dbPassword="admin";
	
	public static Connection createConnection()
	{
		 Connection con=null;
		try{
			try {
				   Class.forName("com.mysql.jdbc.Driver");
				}
				catch(ClassNotFoundException ex) {
				   System.out.println("Error: unable to load driver class!");
				   System.exit(1);
				}			
		     con = DriverManager.getConnection(dbURL,dbUser,dbPassword);
		   }
		  catch(SQLException sqe){ System.out.println("Error establishing connection to database!!");sqe.printStackTrace();}
		return con;
	}

}


