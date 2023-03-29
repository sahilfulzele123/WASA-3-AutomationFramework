package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
	    Connection con=null;
		
		try{Driver driver = new Driver();
		
		//STEP 1:Register the driver
		DriverManager.registerDriver(driver);
		
		//STEP 2:Get the connection from db
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//STEP 3:Issue a create statement
		Statement state = con.createStatement();
		
		//STEP 4:Execute a query
		String String = "insert into candiadateinfo values('Rakesh',14,'Delhi')";
		int result = state.executeUpdate(String);
		if(result==1)
		{
			System.out.println("data added");
		}
		ResultSet resul = state.executeQuery("select * from candiadateinfo;");
		while(resul.next())
		{
			System.out.println(resul.getString(1)+" "+resul.getInt(2)+" "+resul.getString(3));
		}}
		catch(Exception e){
			
		}
		
		finally {
		//STEP 5:close the db
		con.close();
		System.out.println("db closed");

	}}

}
