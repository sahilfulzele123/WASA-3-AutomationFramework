package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScriptTestNgPractice {
	
	@Test(priority = 1 )
	public void createUser()
	{
		System.out.println("Create");
	//Assert.fail();
	}
	
	@Test(dependsOnMethods = "createUser")
	public void updateUser() {
		System.out.println("update");
		//Assert.fail();
	}
	
	@Test(dependsOnMethods = "updateUser")
	public void deleteUser()
	{
		System.out.println("delete");
	}

}
