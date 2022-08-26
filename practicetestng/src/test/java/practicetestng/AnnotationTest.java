package practicetestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationTest {
  @Test
  public void TestMethod1() {
	  System.out.println("Test Method 1");
  }
  @Test
  public void TestMethod2() {
	  System.out.println("Test Method 2");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Test beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Test afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Test beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Test afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Test beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Test beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Test afterSuite");
  }

}
