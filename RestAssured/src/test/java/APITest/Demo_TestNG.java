package APITest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_TestNG {
    @BeforeSuite
    public void BS()
    {
    	System.out.println("Going to execute before any test");
    }
    
    @BeforeMethod
    public void BM()
    {
    	System.out.println("Before Method");
    }
    
    @AfterMethod
    public void AM() {
    	System.out.println("After Method");
    }
    
   @BeforeTest
   public void BT()
   {
	   System.out.println("Will run before test suite");
   }
   
   @Test
   public void testcase1()
   {
	System.out.println("First Test");   
   }
   
   @BeforeClass
   public void BC()
   {
	   System.out.println("Will execute before class");
   }
   
   @AfterTest
   public void AT()
   {
	   System.out.println("Run after Test");
   }
   
   @AfterSuite
   public void AS()
   {
	   System.out.println("Run after suite");
   }
}


   
   