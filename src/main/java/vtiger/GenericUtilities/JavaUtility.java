package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public String getSystemDate()
	{
		Date d = new Date();
		return d.toString();
	}
	
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String date[] = d.toString().split(" ");
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		
		String finalDate = date1+" "+month+" "+year+" "+time;
		return finalDate;
		
	}
	
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(1000);
		
	}

}
