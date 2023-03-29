package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		//Driver for Mysql Database 
		Driver driverRef= new Driver();
		
	    //step1: Register the driver
		DriverManager.registerDriver(driverRef);
		
        //step2: Get the connection from Database-database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//step3: issue the create statement
		Statement state = con.createStatement();
		
		//step4: Execute a query-table name
		ResultSet result = state.executeQuery("select * from candiadateinfo;");
		while(result.next()) 
		{
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
		}
		
		//step5: Close the database
		con.close();
		System.out.println("db closed");
		
	}

}
