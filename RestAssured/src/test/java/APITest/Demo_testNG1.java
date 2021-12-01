package APITest;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo_testNG1 {

	@BeforeClass
	public void BC() {
		System.out.println("Second Class");
	}
	
	@BeforeMethod
	public void BM() {
		System.out.println("Before Method");
	}
	
	@Test
	public void testcase3() {
		System.out.println("Second Class");
		Assert.assertEquals("rudro", "rudro");
	}
	
	@AfterTest
	public void AT(){
		System.out.println("After Test");
	}
	
	@AfterSuite
	 public void AS() {
		System.out.println("After Suite");
	}
}
	