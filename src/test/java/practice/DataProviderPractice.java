package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "electronics")
	public void dataProviderPractice(String phone, int price,String electronics) 
	{
		System.out.println(phone+ "------- "+price+"-------"+electronics);
	}
	
	@DataProvider(name="phone")
	public Object[][] getData()
	{                              //row //column
		Object[][] data = new Object[3][2];//3 sets of data each consists of 2 info
		
		data[0][0]="Samsung";
		data[0][1]=2000;
		
		data[1][0]="iPhone";
		data[1][1]=3000;
		
		data[2][0]="Mi";
		data[2][1]=1000;
		
		return data;
	}
	
	@DataProvider(name ="electronics")
	public Object[][]getData1()
	{
		Object[][] data = new Object[3][1];
		
		data[0][0]="Samsung";
		
		data[1][0]="iPhone";
		
		data[2][0]="Mi";
		
		return data;
	}
	
	
	
	
	
	
	

}
 