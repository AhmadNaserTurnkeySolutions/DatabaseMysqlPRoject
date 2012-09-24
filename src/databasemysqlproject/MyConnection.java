/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasemysqlproject;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class MyConnection {
    public Connection connection = null;
    
    public Connection getConnection()
    {
        
          
 
            // 
 
		System.out.println("-------- Mysql Connection Testing ------");
 
		try {
 
			Class.forName("com.mysql.jdbc.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is MySQL Driver?");
			e.printStackTrace();
			//return;
 
		}
 
		System.out.println("Mysql Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			//return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                return connection ;
	
    }
}
