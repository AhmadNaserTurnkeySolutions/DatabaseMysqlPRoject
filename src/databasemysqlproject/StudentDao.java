/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databasemysqlproject;




import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class StudentDao {
    

  
             public Statement statement = null;
      public Connection dbConnection=null;
    
    public List<Student> getAllStudents() throws SQLException{
   List<Student> mylist= new ArrayList();  
        try {
            MyConnection mc=new   MyConnection();
           dbConnection=mc.getConnection();
           statement = dbConnection.createStatement();
                 
                 String selectTableSQL = "SELECT * FROM school.student";
                 ResultSet rs = statement.executeQuery(selectTableSQL);
 
               
                 while (rs.next()) {
                     Integer sId=rs.getInt("id");
                     String sName=rs.getString("name");
                     String sAddress=rs.getString("address");
                    // Date hireDate=rs.getDate("HIRE_DATE");
              
                     
 Student e=new Student(sId,sName,sAddress);

 
				System.out.println("Student ID : " + sId);
				System.out.println("Student NAME : " + sName);
                              
mylist.add(e);
			}
                 
        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
        finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
        return mylist;
}
   
    	public  void insertStudent(String Name,String Address) throws SQLException {
  
		
		

		String insertTableSQL = "INSERT INTO school.student "
				+ "(name, address) " + "VALUES"
				+ "('"+Name+"','"+Address+"')";
 
		try {
			MyConnection mc=new   MyConnection();
           dbConnection=mc.getConnection();
			statement = dbConnection.createStatement();
 
			//System.err.println(insertTableSQL);
 
			// execute insert SQL stetement
			statement.executeUpdate(insertTableSQL);
 
			System.out.println("Record is inserted into Student table!");
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (statement != null) {
				statement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	}

    
  
}
