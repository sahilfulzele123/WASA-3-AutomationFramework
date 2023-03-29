package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	
	public void sample1()
	{
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(true, false);
		
		System.out.println("step3");
		System.out.println("step4");
	}
	
	@Test
	public void sample2()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("test1");
		System.out.println("test2");
		sa.assertEquals(true, false);
		
		System.out.println("test3");
		sa.assertTrue(false);
		
		System.out.println("test4");
		sa.assertAll(); //log all the assertions failure
	}


}
